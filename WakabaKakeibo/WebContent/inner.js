var navigation = "<nav class=\"navbar navbar-expand-lg navbar-dark bg-success fixed-top container \">"
                   + "<a class=\"navbar-brand\" href=\"#\">わかばカケイボ</a>"
                   +  "<button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"ナビゲーションの切替\">"
                   +     "<span class=\"navbar-toggler-icon\"></span>"
                   + "</button>"
                   + "<div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">"
                   +    "<div class=\"navbar-nav\">"
                   +     "<a class=\"nav-item nav-link\" id=\"indexNav\" href=\"ChatServlet\">チャット<span class=\"sr-only\">(現位置)</span></a>"
                   +     "<a class=\"nav-item nav-link\" id=\"reconstructNav\" href=\"ReconstructListServlet\">復元確認</a>"
//                   +     "<a class=\"nav-item nav-link\" id=\"settingNav\" href=\"#\">設定</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"mBListNav\" href=\"CommentServlet\">ミニブログ一覧</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"mBListEditNav\" href=\"MBEditServlet\">ミニブログ作成・新規</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"simulationNav\" href=\"SimulationListServlet\">シミュレーション</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"historyNav\" href=\"HistoryListServlet\">グラフ・履歴</a>"
                   +     "</div>"
                   + "</div>"
                   + "</nav>";

var tab = "<ul class=\"nav nav-tabs my-3\">"
			  + "<li class=\"nav-item\"><a id=\"allTab\" href=\"#\" class=\"nav-link \">全員</a></li>"
			  + "<li class=\"nav-item\"><a id=\"myTab\" href=\"#\" class=\"nav-link \">自分</a></li>"
			  + "<li class=\"nav-item\"><a id=\"allTab\" href=\"#\" class=\"nav-link \">お気に入り</a></li>"
			  + "<li class=\"nav-item\"><a id=\"travelTab\" href=\"#\" class=\"nav-link \">旅行</a></li>"
			  + "<li class=\"nav-item\"><a id=\"politicsTab\" href=\"#\" class=\"nav-link \">政治</a></li>"
			  + "<li class=\"nav-item\"><a id=\"cookTab\" href=\"#\" class=\"nav-link \">料理</a></li>"
			+ "</ul>";

function makeTab(id){
	var h = document.getElementById("tab");
	h.innerHTML += tab;
    var navElement = document.getElementById(id);
    navElement.classList.add("active");
}

function header(id){
		var h = document.getElementById("header");
		h.innerHTML += navigation;
        var navElement = document.getElementById(id);
        navElement.classList.add("active");
	}

function innerReply(replyUser, blogId, thisModalId, replyModalTagId, replySubmitId, replyFormId){
	var replyModal = "<div class=\"modal fade\" id=" + thisModalId + " tabinex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">"
	    + "<div class=\"modal-dialog\" role=\"document\">"
		+   "<div class=\"modal-content\">"
		+		"<div class=\"modal-header\">"
		+			"<h5 class=\"modal-title\" id=\"exampleModalLabel\">コメント先：" + replyUser + "</h5>"
		+			"<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"閉じる\">"
		+				"<span aria-hidden=\"true\">&times;</span>"
		+			"</button>"
		+			"</div>"
		+			"<div class=\"modal-body\">"
		+				"<form action=\"CommentServlet\" id=\"" + replyFormId +"\">"
		+					"<div class=\"form-group\">"
		+						"<textarea class=\"form-control\" name=\"formControlTextarea\" placeholder=\"返信を書き込む\"></textarea>"
		+						"<input type=\"hidden\" name=\"blogID\" value=\"" + blogId + "\">"
		+					"</div>"
		+				"</form>"
		+			"</div>"
		+			"<div class=\"modal-footer\">"
		+				"<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">閉じる</button>"
		+				"<button type=\"submit\" class=\"btn btn-primary\" id=\"" + replySubmitId + "\">コメント</button>"
		+			"</div>"
		+		"</div>"
		+	"</div>"
		+"</div>";


	var h = document.getElementById(replyModalTagId);
	h.innerHTML += replyModal;
}

function innerComment(user, content, commentBlogTagId){
	var commentCard = "<div class=\"card my-3\">"
		+   "<h5 class=\"card-header\">"
		+   user + "<br>"
		+   "</h5>"
		+	"<div class=\"card-body\">"
		+		content
		+	"</div>";

	var c = document.getElementById(commentBlogTagId);
	c.innerHTML += commentCard;
}

function innerMainBlog(title, userName, category, date, content, likeNum, isChecked, thisId, replyId, mainBlogTagId, thumsUpIconID, likeFormName, blogID, editButtonID){
	var mainBlogCard = "<div class=\"card my-3\">"
		+	"<h5 class=\"card-header\">"
		+		title
		+		"<div class=\"float-right\">"
		+			"<small class=\"text-muted\">" + date + "</small><br>"
		+			"<a type=\"button\" href=\"MBEditServlet\" class=\"btn btn-info mt-1 \">リブログ</a>"
		+		"</div>"
		+		"<br>"
		+		"<small>by" + userName + "</small>"
		+		"<span class=\"badge badge-secondary mx-3\">" + category + "</span>"
		+		"</h5>"
		+	"<div class=\"card-body\" >"
		+		content
		+	"</div>"
		+	"<div class=\"card-footer\">"
		+		"<div class=\"row align-items-center\" >"
		+			"<button class=\"btn btn-primary col-3 \" data-toggle=\"modal\" data-target=\"#" + replyId + "\">コメント</button>"
//		likeForm
		+			"<form action=\"CommentServlet\" name=\"" + likeFormName + "\" >"
		+			"<input type=\"hidden\" name=\"blogID\" value=\"" + blogID + "\">"
		+ 			"<div class=\"col-1 \" id=\"" + thumsUpIconID + "\"></div>"
    	+			"</form>"
//		+			"<div class=\"col-1 \" id=\"" + thumsUpIconID + "\"><i class=\"far fa-thumbs-up fa-2x \" style=\"color:skyblue\"></i></div>"
		+   	    "<b class=\"col-1 \" style=\"color: skyblue; font-size: 2rem\">" + likeNum + "</b>"
		+			"<form id=\""+editButtonID+"\" action=\"MBEditEditServlet\" class=\"col-sm-3 offset-sm-3\" method=\"POST\">"
		+				"<input type=\"hidden\" name=\"userName\" value=\"" + userName + "\">"
		+				"<input type=\"hidden\" name=\"title\" value=\"" + title + "\">"
		+				"<input type=\"hidden\" name=\"category\" value=\"" + category + "\">"
		+				"<input type=\"hidden\" name=\"content\" value=\"" + content + "\">"
		+				"<input type=\"hidden\" name=\"blogID\" value=\"" + blogID + "\">"
		+			"</form>"
		+		"</div>"
		+	"</div>"
		+"</div>";

	var thumsUpOn = "<i class=\"fas fa-thumbs-up fa-2x\" style=\"color:skyblue\"></i>";
	var thumsUpOff = "<i class=\"far fa-thumbs-up fa-2x \" style=\"color:skyblue\"></i>";

	var c = document.getElementById(mainBlogTagId);
	c.innerHTML += mainBlogCard;
//	var icon = document.getElementById(thumsUpIconID);
//
//	if(Boolean(isChecked)){
//		icon.innerHTML = thumsUpOn;
//	}else{
//		icon.innerHTML = thumsUpOff;
//	}
}

function isCheckThumsUp(isChecked, thumsUpIconID){
	var thumsUpOn = "<input name=\"like\" value=\"dislike\" type=\"hidden\">"
					+ "<i class=\"fas fa-thumbs-up fa-2x faa-bounce animated-hover\" style=\"color:skyblue; cursor:pointer;\"></i>";
	var thumsUpOff = "<input name=\"like\" value=\"like\" type=\"hidden\">"
					+ "<i class=\"far fa-thumbs-up fa-2x faa-bounce animated-hover\" style=\"color:skyblue; cursor:pointer;\"></i>";

	var icon = document.getElementById(thumsUpIconID);

	if(isChecked == "true"){
		icon.innerHTML = thumsUpOn;
	}else{
		icon.innerHTML = thumsUpOff;
	}
}

function insertEditButton(blogWrittenUser, loginUser, editButtonID){

	if(blogWrittenUser == loginUser){
		var editButton = document.getElementById(editButtonID);
		editButton.innerHTML += "<input type=\"submit\" class=\"btn btn-secondary \" value=\"編集\">"
	}
}
