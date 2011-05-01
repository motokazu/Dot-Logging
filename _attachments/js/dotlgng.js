/**
 * Dot Logging Application
 */
$(function () {
	// plot graph
	$.jqplot.config.enablePlugins = true;
	
	$("#graph-all").bind('pageshow', function(){
		plot_GraphAll();
	});
	$("#graph-today").bind('pageshow', function(){
		plot_GraphToday();
	});

	// bind post function to dot
	$("#postdot").click(function(){
		var json = {"stime":null, "type":"cough"};
		var d = new Date();
		json.stime = d.getTime();
		$.ajax({
			type: 'POST',
			dataType: 'json',
			url: "/dots/",
			contentType: 'application/json',
			data: JSON.stringify(json),
			processData: false,		
			success: function(data, dataType){
				$("#dotmsg").text("post ok("+data.ok+") dot as "+data.id+" at "+d.toString());
			},
			error: function(msg){
				alert("Failed.");
			}
		});
	});
	
	// replot button
	$("#jqplot-all").click(function(){
		plot_GraphAll();
	});
	$("#replot-today").click(function(){
		plot_GraphToday();
	});
});

function plot_GraphAll(){
	jqplot_Graph("all",4,"chartdiv-all");
}

function plot_GraphToday(){
	var d = new Date();
	var daybase = "["+d.getFullYear()+","+(d.getMonth()+1)+","+d.getDate();
	var startkeystr = daybase + ",0]";
	var endkeystr = daybase + ",23]";
	jqplot_Graph("all",4,"chartdiv-today",startkeystr, endkeystr );
}

function jqplot_Graph(type,level,plotto,startkey,endkey){
	var datasets = [];
	var tempd = {};
	
	// set default params
	var _type = "all";
	var _level = 5;
	var _plotto = "placeholder";
	var _startkey = "";
	var _endkey = "";

	if ( null !== type && undefined !== type ) {
		_type = type;
	}
	if ( null !== level && undefined !== level ) {
		_level = level;
	}
	if ( null !== plotto && undefined !== plotto ) {
		_plotto = plotto;
	}
	if ( null !== startkey && undefined !== startkey ) {
		_startkey = "&startkey="+startkey;
	}
	if ( null !== endkey && undefined !== endkey ) {
		_endkey = "&endkey="+endkey;
	}
	
	// generate uri
	var uri = "/dots/_design/dotlgng/_view/"+_type+"?group=true&group_level="+_level+_startkey+_endkey;
	
	$.ajax({
		type: 'GET',
		dataType: 'json',
		url: uri,
		success: function(data){
			$.each(data.rows, function(id, val){
				var stime = val.value.stime;
				stime = stime + 32400000; //fix to JST , this is temporary code.
				var count = val.value.count;
				var d = new Date();
				d.setTime(stime); // fix to JST
				//var timekey = d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDate()+" "+d.getHours()+":"+d.getMinutes();
				var timekey = d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDate();
				// create array for dataset
				if ( !tempd[_type] ) {
					tempd[_type] = [];
				}
				tempd[_type].push([timekey,count]);
			});
			
			// push all data
			var datasets = [];
			var serieslabels = [];
			$.each(tempd, function(type, dataset){
				datasets.push(dataset);
				serieslabels.push({'label':type});
			});
			
			var options = {
            	legend: { show:true, position: 'sw' },
				seriesDefaults:{
					renderer: $.jqplot.BarRenderer,
					rendererOptions : {
						barPadding: 0,
						barMargin: 1,
						barWidth: 1
					}
				},
				series: serieslabels,
				axes:{
					xaxis : { renderer: $.jqplot.DateAxisRenderer,
							tickOptions:{formatString:'%b %#d, %y'}
						},
					yaxis : { min:0 }
				}
		    };

			$.jqplot(_plotto, datasets, options );			
		}
	});
}
