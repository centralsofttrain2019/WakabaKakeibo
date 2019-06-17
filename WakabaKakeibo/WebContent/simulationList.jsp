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
          data.addColumn('number', 'a');
          data.addColumn('number', 'b');
          data.addColumn('number', '予測');

          data.addRows([
              ["<%=bean.getSimList().get(0).getDate()%>", <%=bean.getSimList().get(0).getBalance() %>, <%=bean.getSimList().get(0).getBalance() %>, null],
              <% for(int i = 1; i < bean.getSimList().size() - 3 ; i++ )
              {%>
              ["<%=bean.getSimList().get(i).getDate() %>", <%=bean.getSimList().get(i).getBalance() %>, null, null],
              <% }%>
              ["<%=bean.getSimList().get(bean.getSimList().size()-2).getDate()%>", <%=bean.getSimList().get(bean.getSimList().size()-2).getBalance() %>, <%=bean.getSimList().get(bean.getSimList().size()-2).getBalance() %>, <%=bean.getSimList().get(bean.getSimList().size()-2).getBalance() %>],
              ["<%=bean.getSimList().get(bean.getSimList().size()-1).getDate()%>", <%=bean.getSimList().get(bean.getSimList().size()-1).getBalance() %>, null, <%=bean.getSimList().get(bean.getSimList().size()-1).getBalance() %>]
            ]);

        var options = {
          title: 'シミュレーション図',
          hAxis: { title: '日時', minValue: 0, maxValue: <%=bean.getSimList().get(bean.getSimList().size()-1).getDate() %> },
          vAxis: { title: '貯金額', minValue: 0, maxValue: <%=bean.getSimList().get(bean.getSimList().size()-1).getBalance() %> },
          legend: 'none',
          interpolateNulls: true,
          series: {
            1: { lineWidth: 1, pointSize: 0 },
          	2: { lineWidth: 1, pointSize: 0 }
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


<%=bean.getSimList().get(0).getBalance() %>
<%=bean.getSimList().get(bean.getSimList().size()-2).getBalance() %>



</div>
<div id="chart_div" style="width: 1000px; height: 500px;"></div>

<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
</body>
</html>