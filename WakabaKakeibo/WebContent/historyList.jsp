<%@page import="bean.HistoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="java.util.List" %>

<!--     pageEncoding="UTF-8"%> -->
<jsp:useBean
		id="bean"
		class="bean.HistoryListBean"
		scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta   charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="history.css">
<title>収支履歴</title>


<!-- javascript読み込み -->
<script type="text/javascript" src="inner.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChartIncome);
  google.charts.setOnLoadCallback(drawChartExpense);

  function drawChartIncome() {

    var data = google.visualization.arrayToDataTable([
      ['CategoryName', 'Amount']
	<% for (String key : bean.getIncomeTotal().keySet()) { %>
		,['<%= key %>', <%= bean.getIncomeTotal().get(key) %>]
     <% } %>
    ]);

    var options = {
      title: '支出'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechartIncome'));

    chart.draw(data, options);
  }

  function drawChartExpense() {

	    var data = google.visualization.arrayToDataTable([
	      ['CategoryName', 'Amount']
		<% for (String key : bean.getExpenseTotal().keySet()) { %>
			,['<%= key %>', <%= bean.getExpenseTotal().get(key) %>]
	     <% } %>
	    ]);

	    var options = {
	      title: '収入'
	    };

	    var chart = new google.visualization.PieChart(document.getElementById('piechartExpense'));

	    chart.draw(data, options);
	  }
</script>

</head>

<body>
<div class="container" style="padding-top:4.5rem;">
<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("historyNav");</script>

<h3 class="my-3 py-1 border-bottom" id="historyTitle">履歴</h3>

<!-- 日付選択 -->
<form name="selectDate" action="HistoryListServlet">

<select name="year">
<!-- <option value="0">-</option> -->
<option value="2016" id="2016">2016</option>
<option value="2017" id="2017">2017</option>
<option value="2018" id="2018">2018</option>
<option value="2019" id="2019">2019</option>

</select>　年

<select name="month">
<!-- <option value="0">-</option> -->
<option value="1" id="1">1</option>
<option value="2" id="2">2</option>
<option value="3" id="3">3</option>
<option value="4" id="4">4</option>
<option value="5" id="5">5</option>
<option value="6" id="6">6</option>
<option value="7" id="7">7</option>
<option value="8" id="8">8</option>
<option value="9" id="9">9</option>
<option value="10" id="10">10</option>
<option value="11" id="11">11</option>
<option value="12" id="12">12</option>
</select>　月

<input type="submit" id="update" value="更新">
</form>

<!-- 円グラフ -->
<div class="row my-3">
	<div id="piechartIncome" class="col"></div>
	<div id="piechartExpense" class="col"></div>
</div>
<div>
	<div class="row ">
		<div class="col-sm-2" style="font-size: 24px; color: blue;"><strong>収入合計</strong></div>
		<div class="col-sm-2" style="font-size: 24px;"><%= bean.getIncomeSum() %>円</div>
	</div>
	<div class="row">
		<div class="col-sm-2" style="font-size: 24px; color: red;"><strong>支出合計</strong></div>
		<div class="col-sm-2" style="font-size: 24px; color: red"> <%= bean.getExpenseSum() %>円</div>
	</div>
	<div class="row">
		<div class="col-sm-2" style="font-size: 24px;"><strong>差額</strong></div>
		<div class="col-sm-2" id="total" style="font-size: 24px;"><span id="total" style="font-size: 24px;"><%= bean.getIncomeSum() - bean.getExpenseSum()%></span><span style="font-size: 24px;">円</span></div>
	</div>
</div>

<h3 class="my-3 py-1 border-bottom ">購入履歴</h3>
　
<!-- indexの宣言 -->
<% int index = 1; %>

<table class="table table-bordered table-hover">
<!--   <caption>テーブルの表題</caption> -->
  <thead class="thead-light">
    <tr>
      <th>#</th>
      <th scope="col">日付</th>
      <th scope="col">品名</th>
      <th scope="col">金額</th>
      <th scope="col">カテゴリー</th>
      <th scope="col">収支</th>
    </tr>
  </thead>
  <tbody>
  <% for( bean.HistoryBean hd : bean.getHistoryList() ) { %>
    <tr>
      <th scope="row"><%= index %></th>
      <td><%= hd.getPurchaseDate() %></td>
      <td><%= hd.getProductName() %></td>
      <td><%= hd.getAmount() %></td>
      <td><%= hd.getCategoryName() %></td>
      <td><%= hd.getType().toString() %></td>
    </tr>
    <% index++; %>
   <% } %>
  </tbody>
</table>

<script>
var his = document.getElementById("historyTitle");

if(<%= bean.getHistory_year()%> != 0){
	his.innerHTML = "<%= bean.getHistory_year() %>" + "年" + "<%= bean.getHistory_month() %>" + "月の履歴";
	document.getElementById('<%= bean.getHistory_year() %>').selected = true;
	document.getElementById('<%= bean.getHistory_month() %>').selected = true;
}else{
	his.innerHTML = "すべての履歴";
}

var total = document.getElementById("total");

if(<%= bean.getIncomeSum() - bean.getExpenseSum()%> < 0){
	total.setAttribute("style", "color:red;");
}
</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js" integrity="sha384-zDnhMsjVZfS3hiP7oCBRmfjkQC4fzxVxFhBx8Hkz2aZX8gEvA/jsP3eXRCvzTofP" crossorigin="anonymous"></script>

</body>
</html>