var count = 0;
var chatDiv = document.getElementById("chat");
var chatSelectDiv = document.getElementById("select");
var sentence = "入力漏れがあるよ　復元する？";
var result = "";

var comunicate = function(){

	result += sentence.charAt(count);
	chatDiv.innerHTML =result;
	count++;

	if(count == sentence.length){
		chatSelectDiv.innerHTML = "<button type=\"button\">ボタン</button>";
	}
}

setInterval(comunicate, 200);
