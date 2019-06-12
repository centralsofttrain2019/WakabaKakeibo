<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean
  		id="bean"
  		class="bean.ReconstructListBean"
  		scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>家計簿予想</title>

<!-- javascript読み込み -->
<script type="text/javascript" src="inner.js"></script>
</head>
<body>
<div class="container">

<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("reconstructNav");</script>

<!-- <img src="mark_arrow_down.png" class="mx-auto" style="width: 200px;"> -->

<h2>予想される今週の家計簿</h2>

    予想される家計簿
     <table class="table table-bordered">
<!--   <caption>テーブルの表題</caption> -->
		  <thead>
		    <tr>
		      <th whidth="400" scope="col">日</th>
		      <th whidth="400" scope="col">月</th>
		      <th whidth="400" scope="col">火</th>
		      <th whidth="400" scope="col">水</th>
		      <th whidth="400" scope="col">木</th>
		      <th whidth="400" scope="col">金</th>
		      <th whidth="400" scope="col">日</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<tr>
		      <td>	</td>
		      <td>おにぎり	</td>
		      <td>	</td>
		      <td>卵	</td>
		      <td>	</td>
		      <td>	</td>
		      <td>	</td>
		    </tr>
		    <tr>
		      <td>	</td>
		      <td>	</td>
		      <td>	</td>
		      <td>卵<br>トイレットペーパー	</td>
		      <td>	</td>
		      <td>	</td>
		      <td>	</td>
		      </tr>
		    <tr>
		      <td>	</td>
		      <td>	</td>
		      <td>	</td>
		      <td>卵	</td>
		      <td>	</td>
		      <td>	</td>
		      <td>	</td>
		    </tr>
		    <tr>
		      <td>おにぎり	</td>
		      <td>	</td>
		      <td>	</td>
		      <td style="color:red">卵<br>トイレットペーパー	</td>
		      <td>	</td>
		      <td>	</td>
		      <td>	</td>
		    </tr>
		  </tbody>
		</table>
    </div>
    <div class="col">
     総合
     <table class="table table-bordered">
		<!--   <caption>テーブルの表題</caption> -->
		  <thead>
		    <tr>
		      <th style="width:100px" scope="col">品名</th>
		      <th style="width:30px" scope="col">個数</th>
		      <th style="width:30px" scope="col">金額</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>卵</td>
		      <td>1</td>
		      <td>180</td>
		    </tr>
		    <tr>
		      <td>卵</td>
		      <td>1</td>
		      <td>180</td>
		    </tr>
		    <tr>
		      <td>トイレットペーパー</td>
		      <td>1</td>
		      <td>450</td>
		    </tr>
		    <tr>
		      <td>卵</td>
		      <td>1</td>
		      <td>180</td>
		    </tr>
		    <tr>
		      <td style="color:red">卵</td>
		      <td style="color:red">1</td>
		      <td style="color:red">180</td>
		    </tr>
		    <tr>
		      <td style="color:red">トイレットペーパー</td>
		      <td style="color:red">1</td>
		      <td style="color:red">450</td>
		    </tr>

		  </tbody>
		</table>


<div class="text-center my-5">
	変更を適用しますか？<br>
	<button type="button" class="btn btn-primary mx-5">はい</button>
	<button type="button" class="btn btn-danger mx-5">いいえ</button>

</div>

</div>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
</body>
</html>