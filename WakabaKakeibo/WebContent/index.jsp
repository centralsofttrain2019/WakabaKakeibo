<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta   charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="history.css">
<title>ログイン画面</title>

<!-- javascript読み込み -->

</head>
<body>
ユーザ名とパスワードを入力してください<br>
<form method ="POST" action ="ChatServlet">
USER  ID<input name ="userID" type="text"><br>
PASSWORD<input name="password" type="password" >
<input type="submit" value="ログイン">
</form>

<form method ="POST" action ="userResist.jsp">
<input type="submit" value="新規登録">
</form>
<br>
ログインに失敗しました。

</body>