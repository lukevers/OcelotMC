//
//	Ocelot
//	common.js
//

function create(yaml) {
	var config = jsyaml.load(yaml);	
	
	for (var user in config) {
		var health = config[user].health;
		var online = config[user].online;
		var x = config[user].location.x;
		var y = config[user].location.y;
		var z = config[user].location.x;
		var foodlevel = config[user].foodlevel;
	}

}