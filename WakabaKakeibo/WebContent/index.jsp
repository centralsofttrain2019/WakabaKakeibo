<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- <%@ page import="bean.MessageBean" %> --%>
<jsp:useBean
  		id="bean"
  		class="bean.MessageListBean"
  		scope="request" />

<%@ page import="bean.MessageBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<<<<<<< HEAD
<!-- javascriptの読み込み -->
<script type="text/javascript" src="chat.js"></script>
<script type="text/javascript" src="inner.js"></script>
</head>
<body>
<div class="container" style="height: 500px">

<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("indexNav");</script>

<!-- 動画画面 -->
<div class="bg-light my-5 h-50 text-center">
<!-- 	<video autoplay style="height: 50vh;"> -->
<!-- 		<source src="logIn.mp4"> -->
<!-- 	</video> -->
	<div class="embed-responsive embed-responsive-16by9">
  		<video autoplay style="height: 50vh;" loop>
			<source src="logIn.mp4">
		</video>
	</div>

<!-- 	<div class="embed-responsive embed-responsive-16by9"> -->
<!--   		<iframe class="embed-responsive-item" src="normal.mp4" allowfullscreen></iframe> -->
<!-- 	</div> -->
</div>


<!-- チャット画面 -->
<div class="bg-light mt-5 h-25" id="chat" ></div>
<div id="select" class="mt-5 h-10"></div>

<!-- <div class="embed-responsive embed-responsive-16by9"> -->
<!--   <iframe class="embed-responsive-item" src="normal.mp4" allowfullscreen></iframe> -->
<!-- </div> -->

</div>


<% for(MessageBean b : bean.getmBeanList()){ %>
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
