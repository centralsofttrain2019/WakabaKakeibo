var navigation = "<nav class=\"navbar navbar-expand-lg navbar-dark bg-success\">"
                   + "<a class=\"navbar-brand\" href=\"#\">わかばカケイボ</a>"
                   +  "<button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"ナビゲーションの切替\">"
                   +     "<span class=\"navbar-toggler-icon\"></span>"
                   + "</button>"
                   + "<div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">"
                   +    "<div class=\"navbar-nav\">"
                   +     "<a class=\"nav-item nav-link\" id=\"indexNav\" href=\"#\">チャット<span class=\"sr-only\">(現位置)</span></a>"
                   +     "<a class=\"nav-item nav-link\" id=\"reconstructNav\" href=\"ReconstructServlet\">復元確認</a>"
                   +     "<a class=\"nav-item nav-link\" id=\"settingNav\" href=\"\">設定</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"mBListNav\" href=\"MBListServlet\">ミニブログ一覧</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"mBListEditNav\" href=\"#\">ミニブログ編集</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"simulationNav\" href=\"simulation.html\">シミュレーション</a>"
                   +     "<a class=\"nav-link nav-link\" id=\"historyNav\" href=\"history.html\">グラフ・履歴</a>"
                   +     "</div>"
                   + "</div>"
                   + "</nav>";

var blogModal = "";

var commentCard = "<div class=\"card my-3\">"
					+	"<div class=\"card-body\">"
					+		"<small>by tarou</small><br>"
					+		"コンテンツ"
					+	"</div>"
					+	"<div class=\"card-footer\">フッタ</div>"
					+"</div>";



function header(id){
		var h = document.getElementById("header");
		h.innerHTML += navigation;
        var navElement = document.getElementById(id);
        navElement.classList.add("active");
	}

function innerReply(replyUser, blogId){
	var replyModal = "<div class=\"modal fade\" id=\"myModal\" tabinex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">"
	    + "<div class=\"modal-dialog\" role=\"document\">"
		+   "<div class=\"modal-content\">"
		+		"<div class=\"modal-header\">"
		+			"<h5 class=\"modal-title\" id=\"exampleModalLabel\">返信先：" + replyUser + "</h5>"
		+			"<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"閉じる\">"
		+				"<span aria-hidden=\"true\">&times;</span>"
		+			"</button>"
		+			"</div>"
		+			"<div class=\"modal-body\">"
		+				"<form>"
		+					"<div class=\"form-group\">"
		+						"<textarea class=\"form-control\" id=\"FormControlTextarea1\" placeholder=\"返信を書き込む\"></textarea>"
		+					"</div>"
		+				"</form>"
		+			"</div>"
		+			"<div class=\"modal-footer\">"
		+				"<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">閉じる</button>"
		+				"<button type=\"button\" class=\"btn btn-primary\">返信</button>"
		+			"</div>"
		+		"</div>"
		+	"</div>"
		+"</div>";


	var h = document.getElementById("commentModal");
	h.innerHTML += replyModal;
}

function innerComment(){
	var c = document.getElementById("commentBlog");
	c.innerHTML += commentCard;
//    var navElement = document.getElementById(id);
//    navElement.classList.add("active");
}
