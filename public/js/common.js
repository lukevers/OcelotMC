//
//	Ocelot
//	common.js
//

function update(yaml) {
	var config = jsyaml.load(yaml);	
	$('.users').empty();
	
	for (var user in config) {	
		$('.users').append(
		'<div class="user ' + user + '">' +
			'<div class="name">' + user + '</div>' +
			'<div class="health">' + config[user].health + '</div>' +
			'<div class="food">' + config[user].foodlevel + '</div>' +
			'<div class="location">' +
				'<div class="x">' + config[user].location.x + '</div>' +
				'<div class="y">' + config[user].location.y + '</div>' +
				'<div class="z">' + config[user].location.z + '</div>' +
			'</div>' +
		'</div>'
		);
	} // close for loop
} // close create
