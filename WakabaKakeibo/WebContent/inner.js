var navigation = "<nav class=\"navbar navbar-expand-lg navbar-dark bg-success fixed-top container \">"
                   + "<a class=\"navbar-brand\" href=\"#\">わかばカケイボ</a>"
                   +  "<button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"ナビゲーションの切替\">"
                   +     "<span class=\"navbar-toggler-icon\"></span>"
                   + "</button>"
                   + "<div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">"
                   +    "<div class=\"navbar-nav\">"
                   +     "<a class=\"nav-item nav-link\" id=\"indexNav\" href=\"IndexServlet\">チャット<span class=\"sr-only\">(現位置)</span></a>"
                   +     "<a class=\"nav-item nav-link\" id=\"reconstructNav\" href=\"ReconstructListServlet\">復元確認</a>"
                   +     "<a class=\"nav-item nav-link\" id=\"settingNav\" href=\"\">設定</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"mBListNav\" href=\"CommentServlet\">ミニブログ一覧</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"mBListEditNav\" href=\"#\">ミニブログ編集</a>"
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
		+				"<form action=\"Test\" id=\"" + replyFormId +"\">"
		+					"<div class=\"form-group\">"
		+						"<textarea class=\"form-control\" name=\"formControlTextarea\" placeholder=\"返信を書き込む\">" + replySubmitId + "</textarea>"
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

function innerMainBlog(title, userName, category, month, day, hour, minute, content, likeNum, thisId, replyId, mainBlogTagId){
	var mainBlogCard = "<div class=\"card my-3\">"
		+	"<h5 class=\"card-header\">"
		+		title
		+		"<div class=\"float-right\">"
		+			"<small class=\"text-muted\">" + month + "月" + day + "日" + hour + ":" + day + "</small><br>"
		+		"</div>"
		+		"<br>"
		+		"<small>by" + userName + "</small>"
		+		"<span class=\"badge badge-secondary mx-3\">" + category + "</span>"
		+		"</h5>"
		+	"<div class=\"card-body\" >"
		+		content
		+	"</div>"
		+	"<div class=\"card-footer\">"
		+		"<button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#" + replyId + "\">コメント</button>"
		+		"<i class=\"far fa-thumbs-up fa-2x align-middle mx-4\" style=\"color:skyblue\"></i>"
		+       "<b style=\"color: skyblue;\">" + likeNum + "</b>"
		+	"</div>"
		+"</div>";

	var c = document.getElementById(mainBlogTagId);
	c.innerHTML += mainBlogCard;
}
