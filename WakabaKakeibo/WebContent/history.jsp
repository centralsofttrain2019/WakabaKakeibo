<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean
		id="bean"
		class="bean.HistoryBean"
		scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta   charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="h41.css">
<title>円グラフと履歴</title>

<div class="container">
<h1> 履歴</h1>
<hr size="1">
</head>
<body>

<select name="year">
<option value="">-</option>

<option value="2016">2016</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>


</select>　年

<select name="month">
<option value="">-</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>　月

<br>
<div class="flex_testjoubu mt-5 ">
    <div class="flex_test-item bg-primary" id="graph">
        1.コンテンツが入ります。

    </div>
        <div class="flex_test-item bg-primary" id="shuushi">
        2.コンテンツが入ります。
    </div>
</div>


<div class="flex_testkabu mt-5">
    <div class="flex_test-item1 bg-primary">
        3.コンテンツが入ります。
    </div>

    <div class="flex_test-item1 bg-primary">
        4.コンテンツが入ります。
    </div>

    <div class="flex_test-item1 bg-primary">
        5.コンテンツが入ります。
    </div>

    <div class="flex_test-item1 bg-primary">
        6.コンテンツが入ります。
    </div>

</div>

<tr>

<td><%=bean.getMessage() %> </td>

</tr>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>

</body>
</html>