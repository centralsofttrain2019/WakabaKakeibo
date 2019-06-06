<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- <%@ page import="bean.MessageBean" %> --%>
<jsp:useBean
  		id="bean"
  		class="bean.MessageBean"
  		scope="request" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="height: 500px">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">わかばカケイボ</a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="ナビゲーションの切替">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="#">チャット<span class="sr-only">(現位置)</span></a>
      <a class="nav-item nav-link" href="#">復元確認</a>
      <a class="nav-item nav-link" href="#">設定</a>
      <a class="nav-link nav-link" href="#">ミニブログ一覧</a>
      <a class="nav-link nav-link" href="#">ミニブログ編集</a>
      <a class="nav-link nav-link" href="#">シミュレーション</a>
      <a class="nav-link nav-link" href="#">グラフ・履歴</a>
    </div>
  </div>
</nav>

<div class="bg-light my-5 h-50 text-center">
	<video src="normal.mp4" autoplay style="height: 50vh;"></video>
<!-- 	<div class="embed-responsive embed-responsive-16by9"> -->
<!--   <iframe class="embed-responsive-item" src="normal.mp4" allowfullscreen></iframe> -->
<!-- 	</div> -->
</div>

<%-- <%= bean.say() %> --%>

<div class="bg-light mt-5 h-25" id="chat" >チャット
</div>
<div id="select" class="mt-5 h-10"></div>

</div>
<script type="text/javascript" src="chat.js"></script>
<script>chatGreeting = setInterval(communicate, 200, '<%= bean.say() %>');</script>

<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
</body>
</html>