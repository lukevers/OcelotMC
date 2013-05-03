//
//	Ocelot
//	common.js
//


// The function update refreshes the divs
// on the page in real-time with the help
// of sockets.io. First, the yaml file is
// parsed and the user's div is replaced.
function update(yaml) {
	var config = jsyaml.load(yaml);	
	$('.users').empty();
	for (var user in config) {	
		if (config[user].online == true) {
			$('.users').append(
			'<div class="user ' + user + '">' +
				'<div class="name">' + user + '</div>' +
				'<div class="health">' + makeIcons(config[user].health, 'heart') + '</div>' +
				'<div class="food">' + makeIcons(config[user].foodlevel, 'food') + '</div>' +
				'<div class="location">' +
					'<div class="x">' + config[user].location.x + '</div>' +
					'<div class="y">' + config[user].location.y + '</div>' +
					'<div class="z">' + config[user].location.z + '</div>' +
				'</div>' +
			'</div>'
			);
		}
	} 
} 

function makeIcons(icon, type) {
	var divs = '';
	icon = icon/2;
	while(icon > 0) {
		if (icon == .5) {
			divs += '<div class="'+type+'_half"></div>&nbsp;';
			icon -= .5;
		}
		else {
			divs += '<div class="'+type+'_full"></div>&nbsp;';
			icon--;
		}
	}
	return divs;
}
