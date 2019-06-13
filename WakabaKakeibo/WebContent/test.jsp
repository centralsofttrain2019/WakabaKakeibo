<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean
  		id="bean"
  		class="bean.MBListBean"
  		scope="request" />

<%@ page import="bean.MBCommentListBean" %>
<%@ page import="bean.MBCommentBean" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<!-- inner.jsの読み込み -->
<script type="text/javascript" src="./test.js"></script>

</head>
<body>
<div class="container" style="height: 500px">

	<div id="header"></div>
	<script type="text/javascript">header("mBListNav");</script>


"<div class="modal fade" id=" + thisModalId + " tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
	    + <div class="modal-dialog" role="document">
		+   <div class="modal-content">
		+		<div class="modal-header">
		+			<h5 class="modal-title" id="exampleModalLabel">コメント先：" + replyUser + </h5>
		+			<button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
		+				<span aria-hidden="true">&times;</span>
		+			</button>
		+			</div>
		+			<div class="modal-body">
		+				<form>
		+					<div class="form-group">
		+						<textarea class="form-control" id="FormControlTextarea1" placeholder="返信を書き込む"></textarea>
		+					</div>
		+				</form>
		+			</div>
		+			<div class="modal-footer">
		+				<button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
		+				<button type="button" class="btn btn-primary">コメント</button>
		+			</div>
		+		</div>
		+	</div>
		+</div>;

<%-- <% for(bean.MBCommentBean b : bean.getMbClb().getMbCList()){ %> --%>

<%-- 			<%= b.getContent() %> --%>

<%-- <% } %> --%>

<!-- テキスト出力 -->
<%-- <%  for (Map.Entry<Integer, List<MBCommentBean>> entry : bean.getMap().entrySet()) { %> --%>
<%--     <%= (entry.getKey() + ": " + entry.getValue()) %> --%>
<%-- <% } %> --%>


</div>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM crossorigin="anonymous"></script>
</body>
</html>