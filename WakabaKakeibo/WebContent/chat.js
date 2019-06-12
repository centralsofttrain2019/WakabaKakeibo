var button = "<a class=\"btn btn-primary  mx-3 \" href=\"RestoreConfirmation.jsp\">はい</a>" +
				"<a class=\"btn btn-danger  mx-3 \" onclick=\" clearData() \" style=\" color:white; \">いいえ</a>";
var strArray = [];
var conversationList = [];
var wakabaChat =  "わかば：";
var conversation = wakabaChat + "";
var count = 0;
var arrayIndex = 0;

var communicate = function(array){
    //function communicate(s){
    var chatDiv = document.getElementById("chat");
    //var chatSelectDiv = document.getElementById("select");

    conversation += array[arrayIndex].charAt(count);
    chatDiv.innerHTML = conversation;
    count++;

    //復元メッセージの場合はボタンをinnerする
    // 	if(count == conversation.length){
    // if(result == "入力漏れがあるよ　復元する？"){
   // 		var chatSelectDiv = document.getElementById("select");
    //     chatDiv.innerHTML = conversation + button;
    //     clearInterval(chat);
    // }


    //conversationが終わったら
    if(count == (array[arrayIndex].length)){
        //chatDiv.innerHTML +="<br>";
        count = 0;
        conversationList.push(conversation);
        conversation += "<br>わかば：";
        arrayIndex++;
        console.log(conversationList);

        if(arrayIndex == array.length - 1){
            clearInterval(chat);
        }
    }

}


function clearData(){
	result = "";
	chatDiv.innerHTML = result;
}


//chatRestore = setInterval(communicate, 200, sentence);