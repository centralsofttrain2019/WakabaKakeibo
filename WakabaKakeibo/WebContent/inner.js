// var navigation = "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">"
//                       + "<a class=\"navbar-brand\" href=\"#\">ブランド</a>"
//                       + "  <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"ナビゲーションの切替\">"
//                       + "    <span class=\"navbar-toggler-icon\"></span>"
//                       + "  </button>"
//                       + "  <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">"
//                       + "    <div class=\"navbar-nav\">"
//                       + "      <a class=\"nav-item nav-link active\" href=\"#\">ホーム <span class=\"sr-only\">(現位置)</span></a>"
//                       + "      <a class=\"nav-item nav-link\" href=\"#\">リンク1</a>"
//                       + "      <a class=\"nav-item nav-link\" href=\"#\">リンク1</a>"
//                       + "    </div>"
//                       + "  </div>"
//                       + "</nav>";

  var navigation1 = "<nav class=\"navbar navbar-expand-lg navbar-dark bg-success mb-3\">"
			+ "<a class=\"navbar-brand\" href=\"#\">わかばカケイボ</a>"
			+ "<button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"ナビゲーションの切替\">"
			+   "<span class=\"navbar-toggler-icon\"></span>"
			+ "</button>"
			+ "<div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">"
			+   "<div class=\"navbar-nav\">"
			+     "<a class=\"nav-item nav-link\" id=\"indexNav\" href=\"#\">チャット<span class=\"sr-only\">(現位置)</span></a>"
			+     "<a class=\"nav-item nav-link\" id=\"reconstructNav\" href=\"ReconstructServlet\">復元確認</a>"
			+     "<a class=\"nav-item nav-link\" id=\"settingNav\" href=\"\">設定</a>"
			+     "<a class=\"nav-link nav-link\" id=\"mBListNav\" href=\"MBListServlet\">ミニブログ一覧</a>"
			+     "<a class=\"nav-link nav-link\" id=\"modifyNav\" href=\"#\">ミニブログ編集</a>"
			+     "<a class=\"nav-link nav-link\" id=\"simulationNav\" href=\"simulation.jsp\">シミュレーション</a>"
			+     "<a class=\"nav-link nav-link\" id=\"historyNav\" href=\"history.jsp\">グラフ・履歴</a>"
			+   "</div>"
			+ "</div>"
			+"</nav>";

  function header(activeId){
	  var inner = document.getElementById('header');
      inner.innerHTML += navigation1;
      var activeNavItem = document.getElementById(activeId);
//      クラスに値を追加
      activeNavItem.classList.add("active")
  }