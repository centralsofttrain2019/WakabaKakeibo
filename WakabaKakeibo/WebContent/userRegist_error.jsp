
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean
   		id="bean"
   		class="bean.UserRegistBean"
   		scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<script type="text/javascript" src="inner.js"></script>

<script>
	alert("入力されたユーザIDは既に使用されています。");
</script>

</head>
<body class="bg-light">

<div class="container w-75">
<h1 class="my-4">新規登録</h1>

<form class="needs-validation" action="UserRegistServlet" method="POST" novalidate>
 <!-- ユーザID -->
  <div class="form-row">
    <div class="col-md-7 mb-3">
      <label for="validationCustom00">ユーザID</label>
      <input type="text" class="form-control" id="validationCustom00" name="userID" value="" required pattern="([0-9]{2,8})">
      <div class="valid-feedback">
        入力済み!
      </div>
      <div class="invalid-feedback">
          正しく入力してください
      </div>
      <small id="passwordHelpInline" class="text-muted col-5">
          　長さは4-8文字で、全角半角整数で入力してください
      </small>
    </div>
  </div>

  <!-- ユーザName -->
  <div class="form-row">
    <div class="col-md-7 mb-3">
      <label for="validationCustom01">ユーザ名</label>
      <input type="text" class="form-control" id="validationCustom01" name="userName" value="" required pattern="([^\x01-\x7E]|[a-zA-Z0-9]{4,8})">
      <div class="valid-feedback">
        入力済み!
      </div>
      <div class="invalid-feedback">
          正しく入力してください
      </div>
      <small id="passwordHelpInline" class="text-muted col-5">
          　長さは4-8文字で、全角半角英数、ひらカタ漢字で入力してください
      </small>
    </div>
  </div>

  <!-- 	パスワード -->
  <div class="form-row">
      <div class="col-md-7 mb-3">
        <label for="validationCustom02">パスワード</label>
        <input type="password" class="form-control" id="validationCustom02" name="password" value="" required pattern="[a-zA-Z0-9]{4,8}">
        <div class="valid-feedback">
          入力済み!
        </div>
        <div class="invalid-feedback">
            正しく入力してください
        </div>
        <small id="passwordHelpInline" class="text-muted col-5">
            　長さは4-8文字で、全角半角英数で入力してください
        </small>
      </div>
    </div>

    <div class="form-group">
      <label>生年月日</label>
      <div class="row">
        <div class="col">
          <label for="number">年</label>
          <input type="number" class="form-control" id="number" name="year" value="2000" min="1900" max="2019" step="1">
          <div class="valid-feedback">
            入力済み!
          </div>
          <div class="invalid-feedback">
              正しく入力してください
          </div>
          <small id="passwordHelpInline" class="text-muted col-5">
              　1900-2019年の間で入力してください
          </small>
        </div>
        <div class="col">
          <label for="number">月</label>
          <input type="number" class="form-control" id="number" name="month" value="1" min="1" max="12" step="1">
          <div class="valid-feedback">
            入力済み!
          </div>
          <div class="invalid-feedback">
              正しく入力してください
          </div>
          <small id="passwordHelpInline" class="text-muted col-5">
              　1-12の間で入力してください
          </small>
        </div>
        <div class="col">
          <label for="number">日</label>
          <input type="number" class="form-control" id="number" name="day" value="1" min="1" max="31" step="1">
          <div class="valid-feedback">
            入力済み!
          </div>
          <div class="invalid-feedback">
              正しく入力してください
          </div>
          <small id="passwordHelpInline" class="text-muted col-5">
              　1-31の間で入力してください
          </small>
        </div>
      </div>
    </div>

    <div class="custom-control custom-radio">
        <input id="customRadio1" name="sex" value="MAN" type="radio" class="custom-control-input" required>
        <label class="custom-control-label" for="customRadio1">男</label>
    </div>
    <div class="custom-control custom-radio">
        <input id="customRadio2" name="sex" value="WOMAN" type="radio" class="custom-control-input" required>
        <label class="custom-control-label" for="customRadio2">女</label>
    </div>

    <!-- 現在の貯金額 -->
  <div class="form-row">
      <div class="col-md-7 my-3">
        <label for="validationCustom04">現在の貯金額</label>
        <input type="text" class="form-control" name="presentAmount" id="validationCustom04" placeholder="現在の貯金額を入力してください"　value="" required pattern="[0-9]{1,8}">
        <div class="valid-feedback">
          入力済み!
        </div>
        <div class="invalid-feedback">
           正しく入力してください
        </div>
        <small id="passwordHelpInline" class="text-muted col-5">
            　単位は万円で1-8桁までの整数のみを入力してください
        </small>
      </div>
    </div>

    <!-- 目標の貯金額 -->
  <div class="form-row">
      <div class="col-md-7 mb-3">
        <label for="validationCustom05">目標の貯金額</label>
        <input type="text" class="form-control" name="targetAmount" id="validationCustom05" placeholder="目標の貯金額を入力してください" value="" required pattern="[0-9]{1,8}">
        <div class="valid-feedback">
          入力済み!
        </div>
        <div class="invalid-feedback">
            正しく入力してください
        </div>
        <small id="passwordHelpInline" class="text-muted col-5">
            　単位は万円で1-8桁までの整数のみを入力してください
        </small>
      </div>
    </div>



  <button type="submit" class="btn btn-primary my-5">フォームを送信</button>
</form>

</div>
<script>
// 無効なフィールドがある場合にフォーム送信を無効にするスターターJavaScriptの例
(function() {
  'use strict';

  window.addEventListener('load', function() {
    // カスタムブートストラップ検証スタイルを適用するすべてのフォームを取得
    var forms = document.getElementsByClassName('needs-validation');
    // ループして帰順を防ぐ
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>

</body>



<!-- bootstrapのためのjqueryの読み込み -->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</html>