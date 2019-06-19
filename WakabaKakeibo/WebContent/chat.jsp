<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean
  		id="bean"
  		class="bean.ChatBean"
  		scope="request" />

<%@ page
	import="bean.MessageBean"
	import="java.time.LocalDate"
%>

<%
	int nowYear = LocalDate.now().getYear();
	int nowMonth = LocalDate.now().getMonthValue();
	int nowDay = LocalDate.now().getDayOfMonth();
%>


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
<form method = "POST" action = "ChatMessageServlet">
<div class="fixed-bottom container">
	<div class="mt-5" id="chat" style="height:10vh;background: rgba(230,200,200,0.5); font-weight:bold;">
	</div>
	<div id="select"></div>
	 <!-- class="mt-5 h-10"></div> -->

	<div class="input-group mb-3">

			<input type="text" name = "chatMessage" class="form-control" placeholder="..." aria-label="..." aria-describedby="button-addon2">
			<div class="input-group-append">
				<input type="submit" id="button-addon2" class="btn btn-primary" value="送信">
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
</form>

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
		      <select class="custom-select" name="purchase-year" id="purchase-year" required>
			    <% for(int i=2019; i<=2022; i++ ){ %>
			      <option <%= i==nowYear ? "selected" : "" %> value="<%= i %>"><%= i %></option>
			    <% } %>
		      </select>
		    </div>
		    <div class="col-sm-3">
		      <select class="custom-select" name="purchase-month"  id="purchase-month" required>
			    <% for(int i=1; i<=12; i++ ){ %>
			      <option <%= i==nowMonth ? "selected" : "" %> value="<%= i %>"><%= i %></option>
			    <% } %>
		      </select>
		    </div>
            <div class="col-sm-3">
		      <select class="custom-select" name="purchase-day" id="purchase-day" required>
			    <% for(int i=1; i<=31; i++ ){ %>
			      <option <%= i==nowDay ? "selected" : "" %> value="<%= i %>"><%= i %></option>
			    <% } %>
		      </select>
		    </div>
		  </div>
        </div>

        <div class="container">
          <div class="row">
            <div class="col-sm-2">
              商品名
            </div>
            <div class="col-sm-8">
              <input type="text" name="product-name" class="form-control" placeholder="..." aria-label="..." aria-describedby="button-addon2">
            </div>
          </div>
        </div>

        <div class="container">
          <div class="row">
            <div class="col-sm-2">
              カテゴリ
            </div>
            <div class="col-sm-4">
              <select class="custom-select"  name="category-id" id="category-id" required>
		        <option selected disabled value="0">未選択</option>
		          <optgroup label="支出">
			      <option value="11">食費</option>
			      <option value="12">日用品</option>
			      <option value="13">交通費</option>
			      <option value="14">衣服</option>
			      <option value="19">その他</option>
			    </optgroup>
			      <optgroup label="収入">
			      <option value="21">給与</option>
			      <option value="22">おこづかい</option>
			      <option value="29">その他</option>
			      </optgroup>
		      </select>
            </div>
          </div>
		</div>

		<div class="container">
          <div class="row">
            <div class="col-sm-2">
              個数
            </div>
            <div class="col-sm-2">
              <select class="custom-select" name="number-of-purchase" id="number-of-purchase">
		        <% for(int i=1; i<=10; i++ ){ %>
		          <option value="<%= i %>"><%= i %></option>
		        <% } %>
		      </select>
            </div>
          </div>
       </div>

        <div class="container">
          <div class="row">
            <div class="col-sm-2">
              価格
            </div>
            <div class="col-sm-2">
              <input type="number" name="amount" class="amount" placeholder="..." aria-label="..." aria-describedby="button-addon2">
            </div>
          </div>
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
