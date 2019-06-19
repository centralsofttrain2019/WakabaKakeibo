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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", { packages: ["corechart"] });
      google.setOnLoadCallback(drawChart);
      function drawChart() {
    	  var data = new google.visualization.DataTable();
          data.addColumn('string', '年月');
          data.addColumn('number', '貯金額');
          data.addColumn('number', '');
          data.addColumn('number', 'シミュレーション');

          //空列計算
          <%
          //
          int number = bean.getSimList().size();

          int start_balance = bean.getSimList().get(0).getBalance();			//初期貯金額
          int last_balance  = bean.getSimList().get(number - 2).getBalance();	//現在の貯金額
          int goal_balance  = bean.getSimList().get(number - 1).getBalance();	//目標金額

          %>
          //空列計算ここまで



          data.addRows([
              ["<%=bean.getSimList().get(0).getDate()%>", <%=start_balance %>, <%=start_balance %>, null],
              <% for(int i = 1; i < bean.getSimList().size() - 3 ; i++ )
              {%>
              ["<%=bean.getSimList().get(i).getDate() %>", <%=bean.getSimList().get(i).getBalance() %>, null, null],
              <% }%>
              ["<%=bean.getSimList().get(bean.getSimList().size()-2).getDate()%>", <%=last_balance %>, <%=last_balance %>, <%=last_balance %>],
              <% for(int j = 0; j < 8 ; j++ )
              {%>
              [null, null, null, null],
              <% }%>
              ["<%=bean.getSimList().get(bean.getSimList().size()-1).getDate()%>", <%=goal_balance %>, null, <%=goal_balance %>]
            ]);

        var options = {
          title: '',
          hAxis: { title: '日時', minValue: 0, maxValue: <%=bean.getSimList().get(bean.getSimList().size()-1).getDate() %>,textStyle :{ fontSize: 12 } },
          vAxis: { title: '貯金額', minValue: 0, maxValue: <%=bean.getSimList().get(bean.getSimList().size()-1).getBalance() %> },
          legend: 'none',
          interpolateNulls: true,
          colors: ['gray','black','red'], //色指定
          series: {
            1: { lineWidth: 1.5, pointSize: 0.1 },
          	2: { lineWidth: 3, pointSize: 0.1 ,lineDashStyle: [10, 2] }
          }
        };

        var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
<div class="container" style="padding-top:4.5rem;">
<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("simulationNav");</script>


<h3 class="my-3">シミュレーション</h3>
<div style="display:inline-flex">
現在の目標金額：<strong><%=bean.getTargetAmount()/10000 %>万円</strong>　　　目標金額の変更：
<form action="UpdateSimulationListServlet" method="post">
<input type="text" name="targetAmount" size="20"> 円
<input type="submit" value="変更">
</form>
</div>

<br><br>
<h5><center>シミュレーショングラフ</center></h5>
</div>

<div id="chart_div" style="width: 1200px; height: 600px;"></div>

<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
</body>
</html>