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
      <a class="nav-item nav-link" href="#">チャット<span class="sr-only">(現位置)</span></a>
      <a class="nav-item nav-link" href="#">復元確認</a>
      <a class="nav-item nav-link" href="#">設定</a>
      <a class="nav-link nav-link active" href="#">ミニブログ一覧</a>
      <a class="nav-link nav-link" href="#">ミニブログ編集</a>
      <a class="nav-link nav-link" href="#">シミュレーション</a>
      <a class="nav-link nav-link" href="#">グラフ・履歴</a>
    </div>
  </div>
</nav>

<div class="my-3" style="display: flex; align-items: center;">
	<h3 class="my-3">ミニブログ一覧</h3>
	<div>
		<button type="button" class="btn btn-primary mx-5">追加</button>
	</div>
</div>

<div class="row">
  <div class="col-4">
    <div class="list-group" id="list-tab" role="tablist">
      <a class="list-group-item list-group-item-action active" id="list-0-list" data-toggle="list" href="#list0" role="tab" aria-controls="list0">ユーザー0</a>
      <a class="list-group-item list-group-item-action" id="list-1-list" data-toggle="list" href="#list1" role="tab" aria-controls="list1">ユーザー1</a>
      <a class="list-group-item list-group-item-action" id="list-2-list" data-toggle="list" href="#list2" role="tab" aria-controls="list2">ユーザー2</a>
      <a class="list-group-item list-group-item-action" id="list-3-list" data-toggle="list" href="#list3" role="tab" aria-controls="list3">ユーザー3</a>
    </div>
  </div>
  <div class="col-8">
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="list0" role="tabpanel" aria-labelledby="list-0-list">
      	<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">カード0のタイトル</h5>
		    <p class="card-text">以下のテキストを追加のコンテンツへの自然な導入としてサポート。 カードのコンテンツ カードのコンテンツ</p>
		    <a href="#" class="btn btn-success">編集</a>
		    <a href="#" class="btn btn-info">コメント</a>
		    <i class="far fa-thumbs-up fa-lg mx-2" style="color: skyblue;"></i>
		    <span class="badge badge-primary">1</span>
		  </div>
		</div>
      </div>
      <div class="tab-pane fade" id="list1" role="tabpanel" aria-labelledby="list-1-list">
      	<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">カード1のタイトル</h5>
		    <p class="card-text">以下のテキストを追加のコンテンツへの自然な導入としてサポート。 カードのコンテンツ カードのコンテンツ</p>
		    <a href="#" class="btn btn-success">編集</a>
		    <a href="#" class="btn btn-info">コメント</a>
		    <i class="far fa-thumbs-up fa-lg mx-2" style="color: skyblue;"></i>
		    <span class="badge badge-primary">1</span>
		  </div>
		</div>
      </div>
      <div class="tab-pane fade" id="list2" role="tabpanel" aria-labelledby="list-2-list">
      	<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">カード2のタイトル</h5>
		    <p class="card-text">以下のテキストを追加のコンテンツへの自然な導入としてサポート。 カードのコンテンツ カードのコンテンツ</p>
		    <a href="#" class="btn btn-success">編集</a>
		    <a href="#" class="btn btn-info">コメント</a>
		    <i class="far fa-thumbs-up fa-lg mx-2" style="color: skyblue;"></i>
		    <span class="badge badge-primary">1</span>
		  </div>
		</div>
      </div>
      <div class="tab-pane fade" id="list3" role="tabpanel" aria-labelledby="list-3-list">
      	<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">カード3のタイトル</h5>
		    <p class="card-text">以下のテキストを追加のコンテンツへの自然な導入としてサポート。 カードのコンテンツ カードのコンテンツ</p>
		    <a href="#" class="btn btn-success">編集</a>
		    <a href="#" class="btn btn-info">コメント</a>
		    <i class="far fa-thumbs-up fa-lg mx-2" style="color: skyblue;"></i>
		    <span class="badge badge-primary">1</span>
		  </div>
		</div>
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