//	
//	Ocelot
//	server.js
//	

var express = require('express');
var fs = require('fs');

var PORT = 3000;
var PATH = '/Users/lukevers/Desktop/m/plugins/Ocelot/config.yml';

// Configure Express 
var app = express();
app.configure(function() {
	app.set('views', __dirname + '/public');
	app.set('view engine', 'jade');
	app.use(express.logger('dev'));
	app.use(express.static(__dirname + '/public'));
	app.use(app.router);
});

var server = require('http').Server(app);
var io = require('socket.io').listen(server);

fs.watchFile(PATH, function() {
	var FILE = fs.readFileSync(PATH, 'utf8');	
	socket.send(String(FILE));
});

io.sockets.on('connection', function(socket){
	var FILE = fs.readFileSync(PATH, 'utf8');	
	socket.send(String(FILE));
});

app.get('/', function(req, res){
	res.render('index');
});

server.listen(PORT);