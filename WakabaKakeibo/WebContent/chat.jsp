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
			<button type="button" id="button-addon2" class="btn btn-primary">送信</button>
		</div>
		<div class="input-group-append">
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModalScrollable2">
			 定型文
		</button>

		</div>
		<div class="input-group-append">
		<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalScrollable1">
			 家計簿データの追加
		</button>

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

<!-- 家計簿データ登録モーダルの設定 -->
<div class="modal fade" id="exampleModalScrollable1" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
    <div class="modal-content">
    <form  action="ChatCommentServlet" id= "AddMoneyNote">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalScrollableTitle">家計簿の登録</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container">
          <div class="row">
            <div class="col-sm-2">
              購入日
		    </div>
            <div class="col-sm-3">
		      <select class="custom-select" id="validationCustom04" required>
		        <option selected disabled value="">年</option>
		        <option>...</option>
		      </select>
		    </div>
		    <div class="col-sm-3">
		      <select class="custom-select" id="validationCustom04" required>
		      <option selected disabled value="">月</option>
		      <option>...</option>
		      </select>
		    </div>
            <div class="col-sm-3">
		      <select class="custom-select" id="validationCustom04" required>
		        <option selected disabled value="">日</option>
		        <option>...</option>
		      </select>
		    </div>
		  </div>
        </div>
        <div class="container">

          商品名
          <input type="text" name="product-name" class="form-control" placeholder="..." aria-label="..." aria-describedby="button-addon2">
        </div>
        <div>
		  カテゴリ
		  <input type="text" name="category-name" class="form-control" placeholder="..." aria-label="..." aria-describedby="button-addon2">
		</div>
		<div>
		  個数
		  <input type="text" name="number-of-purchase" class="form-control" placeholder="..." aria-label="..." aria-describedby="button-addon2">
        </div>
        <div>
          価格
          <input type="text" name="amount" class="form-control" placeholder="..." aria-label="..." aria-describedby="button-addon2">
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
        <button type="submit" class="btn btn-primary" name="MoneyNoteSubmit" id="MoneyNoteSubmit">登録</button>
      </div>
      </form>

    </div>
  </div>
</div>

<!-- 定型文モーダルの設定 -->
<div class="modal fade" id="exampleModalScrollable2" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
    <div class="modal-content">
    <form  action="ChatCommentServlet" id= "Chat">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalScrollableTitle">定型文</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div>
          <input type="radio" name="greeting" value="goodmorning">おはよう<br>
		  <input type="radio" name="greeting" value="hello" checked>こんにちは<br>
          <input type="radio" name="greeting" value="goodevening">こんばんは
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
        <button type="submit" class="btn btn-primary" name="ChatPhrase" id="ChatPhrase">送信</button>
      </div>
      </form>
    </div>
  </div>
</div>



<script>setInterval(communicate, 200, strArray); </script>

<!-- bootstrapのためのjqueryの読み込み -->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>

<!-- <script type="text/javascript">header("index");</script> -->
</body>
</html>
