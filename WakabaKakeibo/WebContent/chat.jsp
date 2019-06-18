<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean
  		id="bean"
  		class="bean.ChatBean"
  		scope="request" />

<%@ page import="bean.MessageBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<!-- javascriptの読み込み -->
<script type="text/javascript" src="chat.js"></script>
<script type="text/javascript" src="inner.js"></script>
</head>
<body>
<div class="container" style="padding-top:4.5rem;padding-bottom:4.5rem; height:70vh">

<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("indexNav");</script>

<!-- 動画画面 -->
<div class="embed-responsive embed-responsive-16by9">
	<video autoplay class="h-100" loop>
		<source src="logIn1.mp4">
	</video>
</div>


<!-- チャット画面 -->
<div class="fixed-bottom container">
	<div class="mt-5" id="chat" style="height:10vh;background: rgba(230,200,200,0.5); font-weight:bold;">
	</div>
	<div id="select"></div>
	 <!-- class="mt-5 h-10"></div> -->

	<div class="input-group mb-3">
	<input type="text" class="form-control" placeholder="..." aria-label="..." aria-describedby="button-addon2">
	<div class="input-group-append">
		<button type="button" id="button-addon2" class="btn btn-success">送信</button>
	</div>
	</div>
</div>






</div>

<% for(MessageBean b : bean.getMessageListBean().getmBeanList() ){ %>
		<script>
<%-- 			setInterval(communicate, 200, '<%= b.getMessageContent() %>'); --%>
		</script>
		<script>
			strArray.push('<%= b.getMessageContent() %>');
		</script>
<% } %>

<script>setInterval(communicate, 200, strArray); </script>

<!-- bootstrapのためのjqueryの読み込み -->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>

<!-- <script type="text/javascript">header("index");</script> -->
</body>
</html>
