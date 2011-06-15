function(doc){
	if(doc.stime && doc.type == "dot" ) {
		var d = new Date();
		d.setTime(doc.stime);
		var key = [d.getFullYear(),(d.getMonth()+1),d.getDate(),d.getHours(),d.getMinutes()];
		
		emit(key, {"stime":doc.stime,"count":1} );
	}
}