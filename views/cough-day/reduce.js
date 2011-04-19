function(keys, values){
	var count = 0;
	var stime = null;
	values.forEach(function(val){
		count += val.count;
		stime = val.stime;
	});
	return {"stime":stime,"count":count};
}