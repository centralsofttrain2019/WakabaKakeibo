var count = 0;
var chatDiv = document.getElementById("chat");
var chatSelectDiv = document.getElementById("select");
var sentence = "入力漏れがあるよ　復元する？";
var button = "<a class=\"btn btn-primary  mx-3 \" href=\"RestoreConfirmation.jsp\">はい</a>" +
				"<a class=\"btn btn-danger  mx-3 \" onclick=\" clearData() \" style=\" color:white; \">いいえ</a>";
var result = "";
var chat;

var comunicate = function(){

	result += sentence.charAt(count);
	chatDiv.innerHTML =result;
	count++;

	if(count == (sentence.length - 1)){
		chatDiv.innerHTML = result + button;
		clearInterval(chat);
	}
}

function clearData(){
	result = "";
	chatDiv.innerHTML = result;
}

chat = setInterval(comunicate, 200);

