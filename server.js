//	Ocelot
//	
//	server.js
//

var fs = require('fs');
var express = require('express');
var yaml = require('js-yaml');
require('js-yaml');

// Create the express app
var app = express();

// Just for the time being
var path = '/Users/lukevers/Desktop/m/plugins/Ocelot/config.yml';

var config = require(path);

// Watch the config file
fs.watchFile(path, function() {
	var file = fs.readFileSync(path, 'utf8');	
	newconfig = yaml.load(file);
	Render(newconfig);
});

// Configure Express
app.configure(function() {
	app.set('views', __dirname + '/public');
	app.set('view engine', 'jade');
	app.use(express.logger('dev'));
	app.use(express.static(__dirname + '/public'));
	app.use(app.router);
});

// 404 Page
app.use(function(req, res, next){
	res.render('error/404.jade', {title: '404 - Page Not Found', showFullNav: false, status: 404, url: req.url });
});

// Listen port
app.listen(3000);
Render(config);

// Render
function Render (newconf) {
	console.log(newconf);
	app.get('/', function(req, res){
		res.render('index', { pageData: newconf });
	});
} // close render