<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean
   		id="bean"
   		class="bean.MBEditEditBean"
   		scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap-arrows.css" data-angle="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>

<script type="text/javascript" src="inner.js"></script>

<style>
    .custom-file-input:lang(ja) ~ .custom-file-label::after {
	content: "参照";
	}

	.custom-file {
	max-width: 20rem;
	overflow: hidden;
	}
	.custom-file-label {
	white-space: nowrap;
	}
</style>

</head>
<body>
<div class="container" style="padding-top:4.5rem;">

<!-- ヘッダー部 -->
<div id="header"></div>
<script type="text/javascript">header("mBListEditNav");</script>

<h1>ミニグログ編集画面</h1>


<form action="MBEditEditServlet" method="POST">
	<!--タイトル-->
	<div class="form-group">
		<label for="exampleInputEmail1">タイトル</label>
		<input type="text" name="titleUp" class="form-control" id="exampleInputEmail1" value="<%= bean.getTitle() %>">
	</div>

  	<!--コンテンツ-->
	<div class="form-group">
		<label for="exampleFormControlTextarea1">コンテンツ</label>
		<textarea class="form-control"  name="ContentUp" id="exampleFormControlTextarea1" rows="7" placeholder="" wrap="hard" cols="400"><%= bean.getContent() %></textarea>
		<div class="col">
			<div class="imagePreview" id="preview1"></div>
		</div>
  	</div>

	<!--カテゴリ選択-->
	<div class="row">
		<div class="col-3">
			<div class="form-group">
				<label for="exampleSelect1exampleFormControlSelect1">ジャンル</label>
				<select class="form-control" id="exampleFormControlSelect1" name="categoryUp">
					<option id="FOODS" value="FOODS" >FOODS</option>
					<option id="BUSINESS" value="BUSINESS" >BUSINESS</option>
					<option id="OUTDOOR" value="OUTDOOR" >OUTDOOR</option>
				</select>
			</div>
		</div>
	</div>
	<div class="row">
		<!--画像の読み込み処理-->
		<div class="form-group col">
			<label for="file">画像ファイル（2つまで選択可）</label>
			<div id="file" class="input-group">
				<div class="custom-file">
					<input type="file" id="cutomfile" class="custom-file-input" name="cutomfile[]" lang="ja" multiple />
					<label class="custom-file-label" for="customfile">画像ファイル選択...</label>
				</div>
				<div class="input-group-append">
					<button type="button" class="btn btn-outline-secondary reset">取消</button>
				</div>
			</div>
		</div>
	</div>

	<input type="hidden" name="blogIDUp" value="<%= bean.getBlogID() %>">
	<div class="row justify-content-center my-4">
		<button type="submit" class="btn btn-success col-2">変更</button>
	</div>
</form>

</div>
</body>

<script>
	document.getElementById('<%= bean.getCategory() %>').selected = true;
</script>

<!-- bootstrapのためのjqueryの読み込み -->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
	$('.custom-file-input').on('change', handleFileSelect);

	function handleFileSelect(evt) {
		$('#preview').remove();// 繰り返し実行時の処理
		// $(this).parents('.input-group').after('<div id="preview"></div>');
		$('#preview1').after('<div id="preview"></div>');
		var files = evt.target.files;

		for (var i = 0, f; f = files[i]; i++) {
			if(i==2){
				break;
			}

			var reader = new FileReader();

			reader.onload = (function(theFile) {
				return function(e) {
					if (theFile.type.match('image.*')) {
						var $html = ['<div class="d-inline-block mr-1 mt-1"><img class="img-thumbnail" src="', e.target.result,'" title="', escape(theFile.name), '" style="height:100px;" /><div class="small text-muted text-center">', escape(theFile.name),'</div></div>'].join('');// 画像では画像のプレビューとファイル名の表示
					} else {
						var $html = ['<div class="d-inline-block mr-1"><span class="small">', escape(theFile.name),'</span></div>'].join('');//画像以外はファイル名のみの表示
					}

					$('#preview').append($html);
				};
			})(f);

			reader.readAsDataURL(f);
		}

		$(this).next('.custom-file-label').html(+ files.length + '個のファイルを選択しました');
	}

	//ファイルの取消
	$('.reset').click(function(){
		$(this).parent().prev().children('.custom-file-label').html('ファイル選択...');
		$('.custom-file-input').val('');
		$('#preview').remove('');
	})
</script>

</html>