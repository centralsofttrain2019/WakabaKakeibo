<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<script type="text/javascript" src="inner.js"></script>
</head>
<body>
<div class="container" style="padding-top:4.5rem;">

<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("mBListEditNav");</script>

<h1>ミニグログ編集画面</h1>


<form>
  <div class="form-group">
    <label for="exampleInputEmail1">タイトル</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="タイトルを入力してください">
<!--     <small class="text-muted">あなたのメールは他の誰とも共有しません。</small> -->
  </div>

	<div class="form-grop my-3">
		コンテンツ
  		<textarea class="form-control py-5" name="formControlTextarea" placeholder="内容を書いてください"></textarea>
	</div>

	<div class="form-row w-50" style="position: relative;">
		<div class="col-md-3 mb-3">
		  	<label for="validationDefault04">カテゴリ</label>
		     <select class="custom-select" id="validationDefault04" required>
		       <option selected disabled value="">選択...</option>
		       <option>FOODS</option>
				<option>BUSINESS</option>
				<option>OUTDOOR</option>
		     </select>
		</div>

		<div style="position: absolute; bottom: 0; width:10px;">
			<div class="form-group">
			    <input type="file">
			</div>
		</div>


	  	<div class="col-md-3 mb-3 align-middle " >
	  		<button type="submit" class="btn btn-primary" style="position: absolute; bottom: 0; left: 80% ">new</button>
		</div>

	</div>
</form>

</div>
</body>

<!-- bootstrapのためのjqueryの読み込み -->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
</html>