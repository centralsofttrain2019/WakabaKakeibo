<%@page import="dto.DepositDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="bean.SimulationListBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<!-- javascript読み込み -->
<script type="text/javascript" src="inner.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js"></script>

</head>
<body>
<div class="container" style="padding-top:4.5rem;">
<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("simulationNav");</script>


<h3 class="my-3">シミュレーション</h3>
シミュレーション図
<canvas id="myChart"></canvas>

<!--	データの中身確認
<table>
<% for(bean.SimulationBean b: bean.getSimList())
{%>
<tr>
 <td> <%=b.getDate().toString() %> </td>
 <td> <%=b.getBalance() %> </td>
 <td> <%=b.getStrIsReal() %> </td>
 <td> <%=b.getHiddenName() %> </td>
</tr>

<% }%>
</table>
 -->

</div>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
<script>

var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: [
    		<% for(bean.SimulationBean b: bean.getSimList())
  	  		{%>
  	  		'<%=b.getDate().toString() %>',
  	 		<% }%>
    ],
    datasets: [{
      label:'貯金額',
      data: [
    	  	<% for(bean.SimulationBean b: bean.getSimList())
    	 	 {%>
    	 	 <%=b.getBalance() %>,
    		  <% }%>
    	 	 ],
   	  fill: false
    }]
  }
});

</script>
</body>
</html>