var stompClient = null;

var img = new Image();
var plane = new Image();

img.src = 'backend.jpg';
plane.src = 'plane.png';
var game = false;
var allPositions = [];

function Position(x,y,name) {
    this.x = x;
    this.y = y;
    this.name = name;
}

window.onload = function() {
    example = document.getElementById("example");
    ctx = example.getContext('2d');
    curUserX = example.width/2;
    curUserY = example.height/2;
    VelX = 2;
    VelY = 2;
    setInterval(update, 1000/30);
};


function update() {
    if (game) {
        curUserX = curUserX + VelX;
        if (curUserX > example.width + 96/2) {
            curUserX = 0 - 96/2;
        }
        sendPosition(curUserX,curUserY,  $("#name").val() );

        ctx.drawImage(img,0,0, example.width, example.height);
        let curAllPositions = allPositions;
        console.log("Frame with array:");
        console.log(curAllPositions);
        for (let i = 0; i < curAllPositions.length; i++) {
            console.log("draw at " + curAllPositions[i].x + " ; " + curAllPositions[i].y + " ;" );
            ctx.drawImage(plane, curAllPositions[i].x, curAllPositions[i].y , 96, 50);
            ctx.strokeStyle = "#F00";
            ctx.font = "italic 14pt Arial";
            ctx.fillText(curAllPositions[i].name, curAllPositions[i].x, curAllPositions[i].y + 40);
        }
        allPositions = [];
    } else {
        ctx.fillRect(0, 0, example.width, example.height);
        return;
    }
}

function reset(){
}

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    if (game == false) {
        game = true;
    }
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        stompClient.subscribe('/topic/plane/position', function (positions) {
            var jsonData = JSON.parse(positions.body);
            for (let i=0; i < jsonData.length; i++) {
                var counter = jsonData[i];
                allPositions.push(new Position(counter.positionX, counter.positionY, counter.nickname));
            }
        });
    });
}

function disconnect() {
    if (game == true) {
        game = false;
    }
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendPosition(x,y,nickname) {
    stompClient.send("/app/airplane", {}, JSON.stringify({'positionX': x, 'positionY': y, 'nickname': nickname}));
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'message': $("#message").val(),'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr style='border-bottom: 1px solid #cccccc;'><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

