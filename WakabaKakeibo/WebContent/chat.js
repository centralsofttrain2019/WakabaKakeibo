var count = 0;
var chatDiv = document.getElementById("chat");
var sentence = "ああああああああああああああああああああ";
var result = "";

var comunicate = function(){

	result += sentence.charAt(count);
	chatDiv.innerHTML =result;
	count++;
}

setInterval(comunicate, 200);
