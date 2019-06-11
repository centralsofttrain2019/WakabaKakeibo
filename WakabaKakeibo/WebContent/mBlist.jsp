<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<!-- inner.jsの読み込み -->
<script type="text/javascript" src="./inner.js"></script>


</head>
<body>
<div class="container" style="height: 500px">

	<div id="header"></div>
	<script type="text/javascript">header("mBListNav");</script>

<div class="my-3" style="display: flex; align-items: center;">
	<h3 class="my-3">ミニブログ一覧</h3>
	<div>
		<button type="button" class="btn btn-primary mx-5">追加</button>
	</div>
</div>

<div id="tab"></div>
<script>makeTab();</script>
<!-- <ul class="nav nav-tabs my-3"> -->
<!--   <li class="nav-item"><a href="#" class="nav-link active">全員</a></li> -->
<!--   <li class="nav-item"><a href="#" class="nav-link">自分</a></li> -->
<!--   <li class="nav-item"><a href="#" class="nav-link">お気に入り</a></li> -->
<!--   <li class="nav-item"><a href="#" class="nav-link">旅行</a></li> -->
<!--   <li class="nav-item"><a href="#" class="nav-link">政治</a></li> -->
<!--   <li class="nav-item"><a href="#" class="nav-link">料理</a></li> -->
<!-- </ul> -->

<button type="button" class="btn" data-toggle="modal" data-target="#blogModal1">ユーザ名　タイトル</button>


<!--ブログモーダル-->
 <div class="modal fade" id="blogModal1" tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div id="mainBlog"></div>

<!-- 							メインのブログカードの生成 -->
<!-- 							innerMainBlog() -->
<!-- 					使い方：innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', month, day, hour, day, '楽しい旅行でした', likeNum, このBlogId, "replyModal1") -->
							<script type="text/javascript">innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', 7, 12, 11, 29, '楽しい旅行でした', 3, "mainBlog1", "replyModal1")</script>

							<!--コメントブログ-->
							<div id="commentBlog">
<!-- 							JavaScriptによる挿入 -->
<!-- 							innerComment('コメントするユーザ名', '内容') -->
							<script type="text/javascript">innerComment('tarou','hello');</script>
							<script type="text/javascript">innerComment('tarou','hello');</script>
							<script type="text/javascript">innerComment('tarou','hello');</script>

							</div>
						</div>
						<div class="modal-footer">

						</div>
					</div>
				</div>
			</div>

<!-- 返信用モーダルの作成 -->
<!-- 使い方：innerReplay(コメントするユーザー名、コメント先のブログID, 'このモーダルのID') -->
<div id="replyModal"></div>
<script type="text/javascript">innerReply('太郎',1,'replyModal1');</script>


</div>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>


</body>
</html>