var count = 0;
var chatDiv = document.getElementById("chat");
var chatSelectDiv = document.getElementById("select");
var sentence = "入力漏れがあるよ　復元する？";
var greetingMorning = "おはよう";
var greetingNoon = "こんにちは";
var greetingNight = "こんばんわ";

var button = "<a class=\"btn btn-primary  mx-3 \" href=\"RestoreConfirmation.jsp\">はい</a>" +
				"<a class=\"btn btn-danger  mx-3 \" onclick=\" clearData() \" style=\" color:white; \">いいえ</a>";
var result = "";
var chat ;

var communicate = function(str){
//function communicate(s){

	result += str.charAt(count);
	chatDiv.innerHTML =result;
	count++;

//	if(count == (str.length - 1)){
	if(result == "入力漏れがあるよ　復元する？"){
		chatDiv.innerHTML = result + button;
		clearInterval(chat);
	}
}

function clearData(){
	result = "";
	chatDiv.innerHTML = result;
}

//chatRestore = setInterval(communicate, 200, sentence);

//chatGreeting = setInterval(communicate, 200, <%= bean.getStr() %>);
