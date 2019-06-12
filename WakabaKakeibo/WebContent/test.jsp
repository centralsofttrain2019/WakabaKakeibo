<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<!-- inner.jsの読み込み -->
<script type="text/javascript" src="./test.js"></script>

</head>
<body>
takayamatest
<div class="container" style="height: 500px">

	<div id="header"></div>
	<script type="text/javascript">header("mBListNav");</script>

<div class="my-3" style="display: flex; align-items: center;">
	<h3 class="my-3">ミニブログ一覧</h3>
	<div>
		<button type="button" class="btn btn-primary mx-5">追加</button>
	</div>
</div>

<button type="button" class="btn" data-toggle="modal" data-target="#blog1">ユーザ名　タイトル</button>

<div id="commentModal"></div>
<script type="text/javascript">innerReply('太郎',1);</script>

<!--ブログモーダル-->
 <div class="modal fade" id="blog1" tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div class="card my-3" data-toggle="modal" data-target="#blog1">
								<h5 class="card-header">
									最近の家計簿について
									<div class="float-right">
										<small class="text-muted">11月12日11:22</small><br>
									</div>
									<br>
									<small>by tarou</small>
									<span class="badge badge-secondary mx-3">国</span>
									</h5>
								<div class="card-body" >
									コンテンツコンテンツコンテンツコンテンツコンテンツコンテンツコンテンツ
								</div>
								<div class="card-footer">
									<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">返信</button>
									<i class="far fa-thumbs-up fa-2x align-middle mx-4" style="color:skyblue"></i>
								</div>
							</div>

							<!--返信ブログ-->
							<div id="commentBlog">
							<script type="text/javascript">innerComment();</script>
							<div class="card my-3">
								<!--<h5 class="card-header">
									最近の家計簿について <br>

									<span class="badge badge-secondary mx-3">国</span>
									</h5>-->
								<div class="card-body">
									<small>by tarou</small><br>
									コンテンツ
								</div>
								<div class="card-footer">フッタ</div>
							</div>
							<div class="card my-3">
								<h5 class="card-header">
									最近の家計簿について <br>
									<small>by tarou</small>
									<span class="badge badge-secondary mx-3">国</span>
									</h5>
								<div class="card-body">
									コンテンツ
								</div>
								<div class="card-footer">フッタ</div>
							</div>

							</div>
						</div>
						<div class="modal-footer">



						</div>
					</div>
				</div>
			</div>

</div>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
</body>
</html>