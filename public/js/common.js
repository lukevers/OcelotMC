//
//	Ocelot
//	common.js
//

function update(yaml) {
	var config = jsyaml.load(yaml);	
	$('.users').empty();
	
	for (var user in config) {	
		if (config[user].online == true) {
			$('.users').append(
			'<div class="user ' + user + '">' +
				'<div class="name">' + user + '</div>' +
				'<div class="health">' + makeLove(config[user].health) + '</div>' +
				'<div class="food">' + makeNomNoms(config[user].foodlevel) + '</div>' +
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

function makeLove(hearts) {
	var love = '';
	hearts = hearts/2;
	while(hearts > 0) {
		if (hearts == .5) {
			love += '<div class="heart_half"></div>&nbsp;';
			hearts -= .5;
		}
		else {
			love += '<div class="heart_full"></div>&nbsp;';
			hearts--;
		}
	}
	return love;
}

function makeNomNoms(food) {
	var nomnom = '';
	food = food/2;
	while(food > 0) {
		if (food == .5) {
			nomnom += '<div class="food_half"></div>&nbsp;';
			food -= .5;
		}
		else {
			nomnom += '<div class="food_full"></div>&nbsp;';
			food--;
		}
	}
	return love;
}