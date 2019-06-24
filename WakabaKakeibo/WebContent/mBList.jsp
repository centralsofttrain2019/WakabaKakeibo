<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean
   		id="bean"
   		class="bean.MBListBean"
   		scope="request" />

 <%@ page import="bean.MBCommentListBean" %>
 <%@ page import="bean.MBCommentBean" %>
<%@ page import="domain.BlogCategoryEnum" %>
<%@ page import="bean.ChatBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>ブログ一覧</title>
<!-- fontawesome -->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.0.10/font-awesome-animation.css" type="text/css" media="all" />
<!-- bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<!-- inner.jsの読み込み -->
<script type="text/javascript" src="./inner.js"></script>
<script type="text/javascript">
	history.replaceState('','','CommentServlet');
</script>

</head>
<body>
<!-- sessionのIDを1として決め打ち -->
<% ChatBean se = (ChatBean)request.getSession().getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME); %>
<% int sessionUserID = se.getUserID() ;%>
<% String sessionName = se.getUsersDto().getUserName(); %>



<div class="container " style="height: 500px; padding-top:4.5rem;">

	<div id="header"></div>
	<script type="text/javascript">header("mBListNav");</script>

<div class="my-3" style="display: flex; align-items: center;">
	<h3 class="my-3">ミニブログ一覧</h3>
	<div>
		<a href="MBEditServlet"><button type="button" class="btn btn-primary mx-5">新規作成</button></a>
	</div>
</div>

<!-- <div id="tab"></div> -->
<!-- <script>makeTab("myTab");</script> -->
<nav>
  <div class="nav nav-tabs" id="nav-tab" role="tablist">
    <a class="nav-item nav-link active" id="nav-profile-tab" data-toggle="tab" href="#nav-all" role="tab" aria-controls="nav-all" aria-selected="false">全体</a>
    <a class="nav-item nav-link" id="nav-home-tab" data-toggle="tab" href="#nav-my" role="tab" aria-controls="nav-my" aria-selected="true">自分</a>
    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-outdoor" role="tab" aria-controls="nav-outdoor" aria-selected="false">outdoor</a>
    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-business" role="tab" aria-controls="nav-business" aria-selected="false">business</a>
    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-food" role="tab" aria-controls="nav-food" aria-selected="false">food</a>
    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-like" role="tab" aria-controls="nav-like" aria-selected="false">いいねしたブログ</a>
  </div>
</nav>


<div class="tab-content mt-3" id="nav-tabContent">

<!-- 全体用のタグ -->
<!-- 全体用のタグ -->
<!-- 全体用のタグ -->
<!-- 全体用のタグ -->
<!-- 全体用のタグ -->
<!-- 全体用のタグ -->
	<div class="tab-pane active" id="nav-all" role="tabpanel" aria-labelledby="nav-all-tab">

<% for(bean.MBBean b : bean.getbBeanList()){ %>

<% String blogModalIdTo = "#blogModalAll" + (b.getBlogID());
	String blogModalId = "blogModalAll" + (b.getBlogID());
	String mainBlogId = "mainBlogAll" + (b.getBlogID());
	String replyModalId = "replyModalAll" + (b.getBlogID());
	String mainBlogTagId = "mainBlogAll" + (b.getBlogID());
	String commentBlogTagId = "commentBlogTagIdAll" + (b.getBlogID());

	//リプレイモーダルのID
	String replyModalTagId = "replyModalTagAll" + (b.getBlogID());
	//リプレイsubmit
	String replySubmitId = "replySubmitIdAll" + (b.getBlogID());
	String replySubmitId2 = "#replySubmitIdAll" + (b.getBlogID());
	//リプレイform
	String replyFormId = "replyFormIdAll" + (b.getBlogID());
	String replyFormId2 = "#replyFormIdAll" + (b.getBlogID());
	//editButtonID
	String editButtonID = "editButtonIDAll" + b.getBlogID();

	//thumsUpIconID
	String thumsUpIconID = "iconAll" + b.getBlogID();
	//likeFormName
	String likeFormName = "likeFormAll" + b.getBlogID();

	//ログインしているユーザのID ここでは決め打ちで1 本来はsession
	int nowUserID = sessionUserID;
	String nowUserName = sessionName;
	%>

<button type="button" class="btn" data-toggle="modal" data-target=<%= blogModalIdTo %> >
	<%= b.getUserName() %>　<%= b.getTitle() %>
</button>


<!--ブログモーダル-->
 <div class="modal fade" id=<%= blogModalId %> tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div id=<%= mainBlogTagId %> ></div>

<!-- 							メインのブログカードの生成 -->
<!-- 							innerMainBlog() -->
<!-- 					使い方：innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', date, '楽しい旅行でした', likeNum, isChecked,このBlogId, "replyModal1",MainBlogのタグID, thumsUpIconID, likeFormName, blogID) -->
							<script type="text/javascript">innerMainBlog(
									'<%= b.getTitle() %>',
									'<%= b.getUserName() %>',
									'<%= b.getCategory() %>',
									'<%= b.getCreateDate() %>',
<%-- 									'<%= b.getCreateDate().getDayOfMonth() %>', --%>
									'<%= b.getContent() %>',
									'<%= bean.getBlMap().getLikeCount(b.getBlogID()) %>',
									'<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>',
									'<%= mainBlogId %>',
									'<%= replyModalId %>',
									'<%= mainBlogTagId %>',
									'<%= thumsUpIconID %>',
									'<%= likeFormName %>',
									'<%= b.getBlogID() %>',
									'<%= editButtonID %>');

							isCheckThumsUp('<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>', '<%= thumsUpIconID %>');
							</script>

							<!--コメントブログ-->
							<div id=<%= commentBlogTagId %>>
<!-- 							JavaScriptによる挿入 -->
<!-- 							innerComment('コメントするユーザ名', '内容', コメントブログタグID) -->
							<%if(bean.getCmap().containsKey(b.getBlogID())) { %>
								<% for(bean.MBCommentBean bComment : bean.getCmap().get(b.getBlogID())){ %>
								<script type="text/javascript">innerComment('<%= bComment.getUserName() %>','<%= bComment.getContent() %>', '<%= commentBlogTagId %>');</script>
								<% } %>
							<% } %>
							</div>
						</div>
						<div class="modal-footer">

						</div>
					</div>
				</div>
			</div>

<script>insertEditButton('<%= b.getUserName() %>', '<%= nowUserName %>', '<%= editButtonID %>')</script>

<!-- 返信用モーダルの作成 -->
<!-- 使い方：innerReplay(コメントするユーザー名、コメント先のブログID, 'このモーダルのID') -->
<div id=<%= replyModalTagId %>></div>
<script type="text/javascript">innerReply('<%= b.getUserName() %>', '<%= b.getBlogID() %>','<%= replyModalId %>', '<%= replyModalTagId %>', '<%= replySubmitId %>', '<%= replyFormId %>');</script>

<script type="text/javascript">
$('<%=replySubmitId2%>').click(function() { $('<%=replyFormId2%>').submit(); });
</script>

<!-- いいねform送信用のJS -->
<script>
    var btn = document.getElementById('<%= thumsUpIconID %>');

    btn.addEventListener('click', function() {

      //submit()でフォームの内容を送信
      document.<%= likeFormName %>.submit();
    })
  </script>

<% } %>
</div>

<!-- 自分用のタグ -->
<!-- 自分用のタグ -->
<!-- 自分用のタグ -->
<!-- 自分用のタグ -->
<!-- 自分用のタグ -->
<!-- 自分用のタグ -->

<div class="tab-pane fade" id="nav-my" role="tabpanel" aria-labelledby="nav-my-tab">


<% for(bean.MBBean b : bean.getbBeanList()){ %>

<!-- 	セッションのユーザIDとブログのユーザIDが同じじゃなかったらcontinue -->
<% if(b.getUserId() != sessionUserID) continue; %>
<% String blogModalIdTo = "#blogModalMY" + (b.getBlogID());
	String blogModalId = "blogModalMY" + (b.getBlogID());
	String mainBlogId = "mainBlogMY" + (b.getBlogID());
	String replyModalId = "replyModalMY" + (b.getBlogID());
	String mainBlogTagId = "mainBlogMY" + (b.getBlogID());
	String commentBlogTagId = "commentBlogTagIdMY" + (b.getBlogID());

	//リプレイモーダルのID
	String replyModalTagId = "replyModalTagMY" + (b.getBlogID());
	//リプレイsubmit
	String replySubmitId = "replySubmitIdMY" + (b.getBlogID());
	String replySubmitId2 = "#replySubmitIdMY" + (b.getBlogID());
	//リプレイform
	String replyFormId = "replyFormIdMY" + (b.getBlogID());
	String replyFormId2 = "#replyFormIdMY" + (b.getBlogID());
	//editButtonID
	String editButtonID = "editButtonIDMY" + b.getBlogID();

	//thumsUpIconID
	String thumsUpIconID = "iconMY" + b.getBlogID();
	//likeFormName
	String likeFormName = "likeFormMY" + b.getBlogID();

	//ログインしているユーザのID ここでは決め打ちで1 本来はsession
	int nowUserID = sessionUserID;
	String nowUserName = sessionName;
	%>

<button type="button" class="btn" data-toggle="modal" data-target=<%= blogModalIdTo %> >
	<%= b.getUserName() %>　<%= b.getTitle() %>
</button>


<!--ブログモーダル-->
 <div class="modal fade" id=<%= blogModalId %> tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div id=<%= mainBlogTagId %> ></div>

<!-- 							メインのブログカードの生成 -->
<!-- 							innerMainBlog() -->
<!-- 					使い方：innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', date, '楽しい旅行でした', likeNum, isChecked,このBlogId, "replyModal1",MainBlogのタグID, thumsUpIconID, likeFormName, blogID) -->
							<script type="text/javascript">innerMainBlog(
									'<%= b.getTitle() %>',
									'<%= b.getUserName() %>',
									'<%= b.getCategory() %>',
									'<%= b.getCreateDate() %>',
<%-- 									'<%= b.getCreateDate().getDayOfMonth() %>', --%>
									'<%= b.getContent() %>',
									'<%= bean.getBlMap().getLikeCount(b.getBlogID()) %>',
									'<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>',
									'<%= mainBlogId %>',
									'<%= replyModalId %>',
									'<%= mainBlogTagId %>',
									'<%= thumsUpIconID %>',
									'<%= likeFormName %>',
									'<%= b.getBlogID() %>',
									'<%= editButtonID %>');

							isCheckThumsUp('<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>', '<%= thumsUpIconID %>');
							</script>

							<!--コメントブログ-->
							<div id=<%= commentBlogTagId %>>
<!-- 							JavaScriptによる挿入 -->
<!-- 							innerComment('コメントするユーザ名', '内容', コメントブログタグID) -->
							<%if(bean.getCmap().containsKey(b.getBlogID())) { %>
								<% for(bean.MBCommentBean bComment : bean.getCmap().get(b.getBlogID())){ %>
								<script type="text/javascript">innerComment('<%= bComment.getUserName() %>','<%= bComment.getContent() %>', '<%= commentBlogTagId %>');</script>
								<% } %>
							<% } %>
							</div>
						</div>
						<div class="modal-footer">

						</div>
					</div>
				</div>
			</div>

<script>insertEditButton('<%= b.getUserName() %>', '<%= nowUserName %>', '<%= editButtonID %>')</script>

<!-- 返信用モーダルの作成 -->
<!-- 使い方：innerReplay(コメントするユーザー名、コメント先のブログID, 'このモーダルのID') -->
<div id=<%= replyModalTagId %>></div>
<script type="text/javascript">innerReply('<%= b.getUserName() %>', '<%= b.getBlogID() %>','<%= replyModalId %>', '<%= replyModalTagId %>', '<%= replySubmitId %>', '<%= replyFormId %>');</script>

<script type="text/javascript">
$('<%=replySubmitId2%>').click(function() { $('<%=replyFormId2%>').submit(); });
</script>

<!-- いいねform送信用のJS -->
<script>
    var btn = document.getElementById('<%= thumsUpIconID %>');

    btn.addEventListener('click', function() {

      //submit()でフォームの内容を送信
      document.<%= likeFormName %>.submit();
    })
  </script>

<% } %>
</div>

<!-- OUTDOOR用のタグ -->
<!-- OUTDOOR用のタグ -->
<!-- OUTDOOR用のタグ -->
<!-- OUTDOOR用のタグ -->
<!-- OUTDOOR用のタグ -->
<!-- OUTDOOR用のタグ -->

<div class="tab-pane fade" id="nav-outdoor" role="tabpanel" aria-labelledby="nav-outdoor-tab">
<% for(bean.MBBean b : bean.getBlogMap().get(BlogCategoryEnum.OUTDOOR)){ %>

<% String blogModalIdTo = "#blogModalOUTDOOR" + (b.getBlogID());
	String blogModalId = "blogModalOUTDOOR" + (b.getBlogID());
	String mainBlogId = "mainBlogOUTDOOR" + (b.getBlogID());
	String replyModalId = "replyModalOUTDOOR" + (b.getBlogID());
	String mainBlogTagId = "mainBlogOUTDOOR" + (b.getBlogID());
	String commentBlogTagId = "commentBlogTagIdOUTDOOR" + (b.getBlogID());

	//リプレイモーダルのID
	String replyModalTagId = "replyModalTagOUTDOOR" + (b.getBlogID());
	//リプレイsubmit
	String replySubmitId = "replySubmitIdOUTDOOR" + (b.getBlogID());
	String replySubmitId2 = "#replySubmitIdOUTDOOR" + (b.getBlogID());
	//リプレイform
	String replyFormId = "replyFormIdOUTDOOR" + (b.getBlogID());
	String replyFormId2 = "#replyFormIdOUTDOOR" + (b.getBlogID());
	//editButtonID
	String editButtonID = "editButtonIDOUTDOOR" + b.getBlogID();

	//thumsUpIconID
	String thumsUpIconID = "iconOUTDOOR" + b.getBlogID();
	//likeFormName
	String likeFormName = "likeFormOUTDOOR" + b.getBlogID();

	//ログインしているユーザのID ここでは決め打ちで1 本来はsession
	int nowUserID = sessionUserID;
	String nowUserName = sessionName;
	%>

<button type="button" class="btn" data-toggle="modal" data-target=<%= blogModalIdTo %> >
	<%= b.getUserName() %>　<%= b.getTitle() %>
</button>


<!--ブログモーダル-->
 <div class="modal fade" id=<%= blogModalId %> tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div id=<%= mainBlogTagId %> ></div>

<!-- 							メインのブログカードの生成 -->
<!-- 							innerMainBlog() -->
<!-- 					使い方：innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', date, '楽しい旅行でした', likeNum, isChecked,このBlogId, "replyModal1",MainBlogのタグID, thumsUpIconID, likeFormName, blogID) -->
							<script type="text/javascript">innerMainBlog(
									'<%= b.getTitle() %>',
									'<%= b.getUserName() %>',
									'<%= b.getCategory() %>',
									'<%= b.getCreateDate() %>',
<%-- 									'<%= b.getCreateDate().getDayOfMonth() %>', --%>
									'<%= b.getContent() %>',
									'<%= bean.getBlMap().getLikeCount(b.getBlogID()) %>',
									'<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>',
									'<%= mainBlogId %>',
									'<%= replyModalId %>',
									'<%= mainBlogTagId %>',
									'<%= thumsUpIconID %>',
									'<%= likeFormName %>',
									'<%= b.getBlogID() %>',
									'<%= editButtonID %>');

							isCheckThumsUp('<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>', '<%= thumsUpIconID %>');
							</script>

							<!--コメントブログ-->
							<div id=<%= commentBlogTagId %>>
<!-- 							JavaScriptによる挿入 -->
<!-- 							innerComment('コメントするユーザ名', '内容', コメントブログタグID) -->
							<%if(bean.getCmap().containsKey(b.getBlogID())) { %>
								<% for(bean.MBCommentBean bComment : bean.getCmap().get(b.getBlogID())){ %>
								<script type="text/javascript">innerComment('<%= bComment.getUserName() %>','<%= bComment.getContent() %>', '<%= commentBlogTagId %>');</script>
								<% } %>
							<% } %>
							</div>
						</div>
						<div class="modal-footer">

						</div>
					</div>
				</div>
			</div>

<script>insertEditButton('<%= b.getUserName() %>', '<%= nowUserName %>', '<%= editButtonID %>')</script>

<!-- 返信用モーダルの作成 -->
<!-- 使い方：innerReplay(コメントするユーザー名、コメント先のブログID, 'このモーダルのID') -->
<div id=<%= replyModalTagId %>></div>
<script type="text/javascript">innerReply('<%= b.getUserName() %>', '<%= b.getBlogID() %>','<%= replyModalId %>', '<%= replyModalTagId %>', '<%= replySubmitId %>', '<%= replyFormId %>');</script>

<script type="text/javascript">
$('<%=replySubmitId2%>').click(function() { $('<%=replyFormId2%>').submit(); });
</script>

<!-- いいねform送信用のJS -->
<script>
    var btn = document.getElementById('<%= thumsUpIconID %>');

    btn.addEventListener('click', function() {

      //submit()でフォームの内容を送信
      document.<%= likeFormName %>.submit();
    })
  </script>

<% } %>

      </div>

<!--       ビジネス用のタグ -->
<!--       ビジネス用のタグ -->
<!--       ビジネス用のタグ -->
<!--       ビジネス用のタグ -->
<!--       ビジネス用のタグ -->
<!--       ビジネス用のタグ -->

      <div class="tab-pane fade" id="nav-business" role="tabpanel" aria-labelledby="nav-business-tab">
<% for(bean.MBBean b : bean.getBlogMap().get(BlogCategoryEnum.BUSINESS)){ %>

<% String blogModalIdTo = "#blogModalBUSINESS" + (b.getBlogID());
	String blogModalId = "blogModalBUSINESS" + (b.getBlogID());
	String mainBlogId = "mainBlogBUSINESS" + (b.getBlogID());
	String replyModalId = "replyModalBUSINESS" + (b.getBlogID());
	String mainBlogTagId = "mainBlogBUSINESS" + (b.getBlogID());
	String commentBlogTagId = "commentBlogTagIdBUSINESS" + (b.getBlogID());

	//リプレイモーダルのID
	String replyModalTagId = "replyModalTagBUSINESS" + (b.getBlogID());
	//リプレイsubmit
	String replySubmitId = "replySubmitIdBUSINESS" + (b.getBlogID());
	String replySubmitId2 = "#replySubmitIdBUSINESS" + (b.getBlogID());
	//リプレイform
	String replyFormId = "replyFormIdBUSINESS" + (b.getBlogID());
	String replyFormId2 = "#replyFormIdBUSINESS" + (b.getBlogID());
	//editButtonID
	String editButtonID = "editButtonIDBUSINESS" + b.getBlogID();

	//thumsUpIconID
	String thumsUpIconID = "iconBUSINESS" + b.getBlogID();
	//likeFormName
	String likeFormName = "likeFormBUSINESS" + b.getBlogID();

	//ログインしているユーザのID ここでは決め打ちで1 本来はsession
	int nowUserID = sessionUserID;
	String nowUserName = sessionName;
	%>

<button type="button" class="btn" data-toggle="modal" data-target=<%= blogModalIdTo %> >
	<%= b.getUserName() %>　<%= b.getTitle() %>
</button>


<!--ブログモーダル-->
 <div class="modal fade" id=<%= blogModalId %> tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div id=<%= mainBlogTagId %> ></div>

<!-- 							メインのブログカードの生成 -->
<!-- 							innerMainBlog() -->
<!-- 					使い方：innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', date, '楽しい旅行でした', likeNum, isChecked,このBlogId, "replyModal1",MainBlogのタグID, thumsUpIconID, likeFormName, blogID) -->
							<script type="text/javascript">innerMainBlog(
									'<%= b.getTitle() %>',
									'<%= b.getUserName() %>',
									'<%= b.getCategory() %>',
									'<%= b.getCreateDate() %>',
<%-- 									'<%= b.getCreateDate().getDayOfMonth() %>', --%>
									'<%= b.getContent() %>',
									'<%= bean.getBlMap().getLikeCount(b.getBlogID()) %>',
									'<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>',
									'<%= mainBlogId %>',
									'<%= replyModalId %>',
									'<%= mainBlogTagId %>',
									'<%= thumsUpIconID %>',
									'<%= likeFormName %>',
									'<%= b.getBlogID() %>',
									'<%= editButtonID %>');

							isCheckThumsUp('<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>', '<%= thumsUpIconID %>');
							</script>

							<!--コメントブログ-->
							<div id=<%= commentBlogTagId %>>
<!-- 							JavaScriptによる挿入 -->
<!-- 							innerComment('コメントするユーザ名', '内容', コメントブログタグID) -->
							<%if(bean.getCmap().containsKey(b.getBlogID())) { %>
								<% for(bean.MBCommentBean bComment : bean.getCmap().get(b.getBlogID())){ %>
								<script type="text/javascript">innerComment('<%= bComment.getUserName() %>','<%= bComment.getContent() %>', '<%= commentBlogTagId %>');</script>
								<% } %>
							<% } %>
							</div>
						</div>
						<div class="modal-footer">

						</div>
					</div>
				</div>
			</div>

<script>insertEditButton('<%= b.getUserName() %>', '<%= nowUserName %>', '<%= editButtonID %>')</script>

<!-- 返信用モーダルの作成 -->
<!-- 使い方：innerReplay(コメントするユーザー名、コメント先のブログID, 'このモーダルのID') -->
<div id=<%= replyModalTagId %>></div>
<script type="text/javascript">innerReply('<%= b.getUserName() %>', '<%= b.getBlogID() %>','<%= replyModalId %>', '<%= replyModalTagId %>', '<%= replySubmitId %>', '<%= replyFormId %>');</script>

<script type="text/javascript">
$('<%=replySubmitId2%>').click(function() { $('<%=replyFormId2%>').submit(); });
</script>

<!-- いいねform送信用のJS -->
<script>
    var btn = document.getElementById('<%= thumsUpIconID %>');

    btn.addEventListener('click', function() {

      //submit()でフォームの内容を送信
      document.<%= likeFormName %>.submit();
    })
  </script>

<% } %>
      </div>


<!--       food用のタグ -->
<!--       food用のタグ -->
<!--       food用のタグ -->
<!--       food用のタグ -->
<!--       food用のタグ -->
<!--       food用のタグ -->
      <div class="tab-pane fade" id="nav-food" role="tabpanel" aria-labelledby="nav-food-tab">

      <% for(bean.MBBean b : bean.getBlogMap().get(BlogCategoryEnum.FOODS)){ %>

<% String blogModalIdTo = "#blogModalFOODS" + (b.getBlogID());
	String blogModalId = "blogModalFOODS" + (b.getBlogID());
	String mainBlogId = "mainBlogFOODS" + (b.getBlogID());
	String replyModalId = "replyModalFOODS" + (b.getBlogID());
	String mainBlogTagId = "mainBlogFOODS" + (b.getBlogID());
	String commentBlogTagId = "commentBlogTagIdFOODS" + (b.getBlogID());

	//リプレイモーダルのID
	String replyModalTagId = "replyModalTagFOODS" + (b.getBlogID());
	//リプレイsubmit
	String replySubmitId = "replySubmitIdFOODS" + (b.getBlogID());
	String replySubmitId2 = "#replySubmitIdFOODS" + (b.getBlogID());
	//リプレイform
	String replyFormId = "replyFormIdFOODS" + (b.getBlogID());
	String replyFormId2 = "#replyFormIdFOODS" + (b.getBlogID());
	//editButtonID
	String editButtonID = "editButtonIDFOODS" + b.getBlogID();

	//thumsUpIconID
	String thumsUpIconID = "iconFOODS" + b.getBlogID();
	//likeFormName
	String likeFormName = "likeFormFOODS" + b.getBlogID();

	//ログインしているユーザのID ここでは決め打ちで1 本来はsession
	int nowUserID = sessionUserID;
	String nowUserName = sessionName;
	%>

<button type="button" class="btn" data-toggle="modal" data-target=<%= blogModalIdTo %> >
	<%= b.getUserName() %>　<%= b.getTitle() %>
</button>


<!--ブログモーダル-->
 <div class="modal fade" id=<%= blogModalId %> tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div id=<%= mainBlogTagId %> ></div>

<!-- 							メインのブログカードの生成 -->
<!-- 							innerMainBlog() -->
<!-- 					使い方：innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', date, '楽しい旅行でした', likeNum, isChecked,このBlogId, "replyModal1",MainBlogのタグID, thumsUpIconID, likeFormName, blogID) -->
							<script type="text/javascript">innerMainBlog(
									'<%= b.getTitle() %>',
									'<%= b.getUserName() %>',
									'<%= b.getCategory() %>',
									'<%= b.getCreateDate() %>',
<%-- 									'<%= b.getCreateDate().getDayOfMonth() %>', --%>
									'<%= b.getContent() %>',
									'<%= bean.getBlMap().getLikeCount(b.getBlogID()) %>',
									'<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>',
									'<%= mainBlogId %>',
									'<%= replyModalId %>',
									'<%= mainBlogTagId %>',
									'<%= thumsUpIconID %>',
									'<%= likeFormName %>',
									'<%= b.getBlogID() %>',
									'<%= editButtonID %>');

							isCheckThumsUp('<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>', '<%= thumsUpIconID %>');
							</script>

							<!--コメントブログ-->
							<div id=<%= commentBlogTagId %>>
<!-- 							JavaScriptによる挿入 -->
<!-- 							innerComment('コメントするユーザ名', '内容', コメントブログタグID) -->
							<%if(bean.getCmap().containsKey(b.getBlogID())) { %>
								<% for(bean.MBCommentBean bComment : bean.getCmap().get(b.getBlogID())){ %>
								<script type="text/javascript">innerComment('<%= bComment.getUserName() %>','<%= bComment.getContent() %>', '<%= commentBlogTagId %>');</script>
								<% } %>
							<% } %>
							</div>
						</div>
						<div class="modal-footer">

						</div>
					</div>
				</div>
			</div>

<script>insertEditButton('<%= b.getUserName() %>', '<%= nowUserName %>', '<%= editButtonID %>')</script>

<!-- 返信用モーダルの作成 -->
<!-- 使い方：innerReplay(コメントするユーザー名、コメント先のブログID, 'このモーダルのID') -->
<div id=<%= replyModalTagId %>></div>
<script type="text/javascript">innerReply('<%= b.getUserName() %>', '<%= b.getBlogID() %>','<%= replyModalId %>', '<%= replyModalTagId %>', '<%= replySubmitId %>', '<%= replyFormId %>');</script>

<script type="text/javascript">
$('<%=replySubmitId2%>').click(function() { $('<%=replyFormId2%>').submit(); });
</script>

<!-- いいねform送信用のJS -->
<script>
    var btn = document.getElementById('<%= thumsUpIconID %>');

    btn.addEventListener('click', function() {

      //submit()でフォームの内容を送信
      document.<%= likeFormName %>.submit();
    })
  </script>

<% } %>
      </div>

<!--       いいね用のタブ -->
<!--       いいね用のタブ -->
<!--       いいね用のタブ -->
<!--       いいね用のタブ -->
<!--       いいね用のタブ -->
<!--       いいね用のタブ -->
      <div class="tab-pane fade" id="nav-like" role="tabpanel" aria-labelledby="nav-like-tab">

      <% for(bean.MBBean b : bean.getbBeanList()){ %>

<!-- 	likeBeanが同じじゃなかったらcontinue -->
<% if(!bean.getBlMap().isCheckedLike(b.getBlogID(),sessionUserID)) continue; %>

<% String blogModalIdTo = "#blogModalLIKE" + (b.getBlogID());
	String blogModalId = "blogModalLIKE" + (b.getBlogID());
	String mainBlogId = "mainBlogLIKE" + (b.getBlogID());
	String replyModalId = "replyModalLIKE" + (b.getBlogID());
	String mainBlogTagId = "mainBlogLIKE" + (b.getBlogID());
	String commentBlogTagId = "commentBlogTagIdLIKE" + (b.getBlogID());

	//リプレイモーダルのID
	String replyModalTagId = "replyModalTagLIKE" + (b.getBlogID());
	//リプレイsubmit
	String replySubmitId = "replySubmitIdLIKE" + (b.getBlogID());
	String replySubmitId2 = "#replySubmitIdLIKE" + (b.getBlogID());
	//リプレイform
	String replyFormId = "replyFormIdLIKE" + (b.getBlogID());
	String replyFormId2 = "#replyFormIdLIKE" + (b.getBlogID());
	//editButtonID
	String editButtonID = "editButtonIDLIKE" + b.getBlogID();

	//thumsUpIconID
	String thumsUpIconID = "iconLIKE" + b.getBlogID();
	//likeFormName
	String likeFormName = "likeFormLIKE" + b.getBlogID();

	//ログインしているユーザのID ここでは決め打ちで1 本来はsession
	int nowUserID = sessionUserID;
	String nowUserName = sessionName;
	%>

<button type="button" class="btn" data-toggle="modal" data-target=<%= blogModalIdTo %> >
	<%= b.getUserName() %>　<%= b.getTitle() %>
</button>


<!--ブログモーダル-->
 <div class="modal fade" id=<%= blogModalId %> tabinex="-1" role="dialog" aria-labelledby="myModalLabel">
		   <div class="modal-dialog" role="document">
			   <div class="modal-content">
						<div class="modal-body">

							<!--メインブログ-->
							<div id=<%= mainBlogTagId %> ></div>

<!-- 							メインのブログカードの生成 -->
<!-- 							innerMainBlog() -->
<!-- 					使い方：innerMainBlog('沖縄旅行', 'しんのすけ', '旅行', date, '楽しい旅行でした', likeNum, isChecked,このBlogId, "replyModal1",MainBlogのタグID, thumsUpIconID, likeFormName, blogID) -->
							<script type="text/javascript">innerMainBlog(
									'<%= b.getTitle() %>',
									'<%= b.getUserName() %>',
									'<%= b.getCategory() %>',
									'<%= b.getCreateDate() %>',
<%-- 									'<%= b.getCreateDate().getDayOfMonth() %>', --%>
									'<%= b.getContent() %>',
									'<%= bean.getBlMap().getLikeCount(b.getBlogID()) %>',
									'<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>',
									'<%= mainBlogId %>',
									'<%= replyModalId %>',
									'<%= mainBlogTagId %>',
									'<%= thumsUpIconID %>',
									'<%= likeFormName %>',
									'<%= b.getBlogID() %>',
									'<%= editButtonID %>');

							isCheckThumsUp('<%= bean.getBlMap().isCheckedLike(b.getBlogID(), nowUserID) %>', '<%= thumsUpIconID %>');
							</script>

							<!--コメントブログ-->
							<div id=<%= commentBlogTagId %>>
<!-- 							JavaScriptによる挿入 -->
<!-- 							innerComment('コメントするユーザ名', '内容', コメントブログタグID) -->
							<%if(bean.getCmap().containsKey(b.getBlogID())) { %>
								<% for(bean.MBCommentBean bComment : bean.getCmap().get(b.getBlogID())){ %>
								<script type="text/javascript">innerComment('<%= bComment.getUserName() %>','<%= bComment.getContent() %>', '<%= commentBlogTagId %>');</script>
								<% } %>
							<% } %>
							</div>
						</div>
						<div class="modal-footer">

						</div>
					</div>
				</div>
			</div>

<script>insertEditButton('<%= b.getUserName() %>', '<%= nowUserName %>', '<%= editButtonID %>')</script>

<!-- 返信用モーダルの作成 -->
<!-- 使い方：innerReplay(コメントするユーザー名、コメント先のブログID, 'このモーダルのID') -->
<div id=<%= replyModalTagId %>></div>
<script type="text/javascript">innerReply('<%= b.getUserName() %>', '<%= b.getBlogID() %>','<%= replyModalId %>', '<%= replyModalTagId %>', '<%= replySubmitId %>', '<%= replyFormId %>');</script>

<script type="text/javascript">
$('<%=replySubmitId2%>').click(function() { $('<%=replyFormId2%>').submit(); });
</script>

<!-- いいねform送信用のJS -->
<script>
    var btn = document.getElementById('<%= thumsUpIconID %>');

    btn.addEventListener('click', function() {

      //submit()でフォームの内容を送信
      document.<%= likeFormName %>.submit();
    })
  </script>

<% } %>
      </div>
    </div>

</div>

</body>
</html>