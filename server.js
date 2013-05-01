//
//	server.js
//

var express = require('express');

// Create the express app
var app = express();

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
	res.render('error/404.jade', {title: "404 - Page Not Found", showFullNav: false, status: 404, url: req.url });
});

// Render the index page
app.get('/', function(req, res){
	res.render('index', { user: req.user });
});

app.listen(3000);