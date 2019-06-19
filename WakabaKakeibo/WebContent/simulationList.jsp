<%@page import="dto.DepositDto"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.Period"%>

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
          	  int number = bean.getSimList().size();								//レコードの数

              LocalDate start_month = bean.getSimList().get(0).getDate();			//家計簿開始した月
          	  LocalDate last_month  = bean.getSimList().get(number - 2).getDate();	//最新のデータがある月
          	  LocalDate goal_month  = bean.getSimList().get(number - 1).getDate();	//目標達成の予測結果(月)

          	  int start_balance = bean.getSimList().get(0).getBalance();			//初期貯金額
          	  int last_balance  = bean.getSimList().get(number - 2).getBalance();	//現在の貯金額
          	  int goal_balance  = bean.getSimList().get(number - 1).getBalance();	//目標金額

          	  Period p = Period.between(last_month, goal_month);					//最新データ～予測データまでの期間

          	  int empty = p.getYears() * 12 + p.getMonths() - 1;					//空列を挿入する数(予測データ月 - 最新データ月 - 1)

          %>
          //空列計算ここまで


          data.addRows([
        	  //家計簿開始した月のデータ
              ["<%=start_month %>", <%=start_balance %>, <%=start_balance %>, null],

              //家計簿開始してから最新の月までの間のデータ
              <% for(int i = 1; i < number - 3 ; i++ )
              {%>
              ["<%=bean.getSimList().get(i).getDate() %>", <%=bean.getSimList().get(i).getBalance() %>, null, null],
              <% }%>

              //最新の月のデータ
              ["<%=bean.getSimList().get( number - 2 ).getDate()%>", <%=last_balance %>, <%=last_balance %>, <%=last_balance %>],

              //間隔調整のための空列
              <% for(int j = 0; j < empty ; j++ )
              {%>
              [null, null, null, null],
              <% }%>

              //予測データ
              ["<%=goal_month %>", <%=goal_balance %>, null, <%=goal_balance %>]
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
</html>