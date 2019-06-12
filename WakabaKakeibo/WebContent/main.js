function header(){
    $.ajax({
        url: "header.html", // 読み込むHTMLファイル
        cache: false,
        success: function(html){
            document.write(html);
        }
    });
}

//$(function(){
//	 $("#header-outer").load("/header.html #header-inner");
//	})