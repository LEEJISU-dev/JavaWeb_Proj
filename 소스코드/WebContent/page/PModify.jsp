<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品修正</title>
<script type = "text/javascript" src = "./script/board.js"></script>
<script>
function paddCheck(){
	if(document.frm.PName.value.length ==0){
		alert("商品名を入力してください。");
		return false;
	}
	if(document.frm.PPhoto.value.length ==0){
		alert("写真をアップロードしてください。");
		return false;
	}
	if(document.frm.PPrice.value.length ==0){
		alert("価格を入力してください。");
		return false;
	}
	if(document.frm.PClass1.value.length ==0){
		alert("1次分類を選んでください。");
		return false;
	}
	if(document.frm.PClass2.value.length ==0){
		alert("２次分類を選んでください。");
		return false;
	}
	if(document.frm.PDetail.value.length ==0){
		alert("最小100字以上書いてください。");
		return false;
	}
	return true;
}
</script>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<style>
#wrap {
   padding: 2em;
}
#table {
   padding-bottom: 1em;
   padding-right: 2em;
   font-weight: 600;
}
#price {
   width: 93%;
}
#PClass {
   border: solid 1px #e0e0e0;
   border-radius: 5px;
   padding: 0.5em;
   text-decoration: none;
   width: 120%;
}
#main01 {
   margin-top: 1em;
   margin-left: 0.5em;
   width: 81%;
   color: #000;
}

#main02 {
   margin-left: 0.45em;
   width: 78%;
   color: #000;
}

#main03 {
   width: 100%;
   color: #000;
}

#bt {
   margin-left: 3.5em;
}

#st {
   color: #fff;
   background-color: #2d2d2d;
   border: 8px solid #36bbf5;
   padding: 20px 20px 0 20px;
   margin-bottom: 20px;
}

#nav {
   font-size: 1.2em;
   background-color: #2d2d2d;
}

#header {
   background-color: #2d2d2d;
}
</style>
<link rel="shortcut icon" href="images/favicon.ico">
</head>
<body>
   <div id="page-wrapper">

      <!-- Header -->
      <div id="header">

         <!-- Logo -->
         <h1>
            <a href="PageServlet?command=Main" id="logo"><img
               src="images/main logo.png"></a>
         </h1>

         <!-- Nav -->
         <nav id="nav">
         <ul>
            <li><a href="PageServlet?command=Main">ホーム</a></li>
            <li><a href="PageServlet?command=PList">商品リスト</a>
               <ul>
                  <li><a href="PageServlet?command=PList&PClass1=家電製品">家電製品</a></li>
                     <li><a href="PageServlet?command=PList&PClass1=パソコン">パソコン</a></li>
                     <li><a href="PageServlet?command=PList&PClass1=カメラ">カメラ</a></li>
                     <li><a href="PageServlet?command=PList&PClass1=携帯電話">携帯電話</a></li>
                     <li><a href="PageServlet?command=PList&PClass1=ゲーム">ゲーム</a></li>
               </ul></li>
            <li class="current"><a href="PageServlet?command=PAdd">商品登録</a></li>
            <li><a href="PageServlet?command=MInfo">マイページ</a></li>

         </ul>
         </nav>

      </div>
      <div id="wrap" align="center">
         <h1>商品修正</h1>
         <form name="frm" method="post" action="PageServlet?command=DoPModify" enctype="multipart/form-data">
            <table>
            
               <tr>
                  <th id="table">商品名</th>
                  <td><input type="text" name="PName" value="${PView.PName }"></td>
               </tr>
               <tr>
                  <th id="table">写真</th>
                  <td><input type="file" name="PPhoto" ></td>
               </tr>
               <tr>
                  <th id="table">価格</th>
                  <td><input id="price" type="text" size="10" name="PPrice" value="${PView.PPrice }">円</td>
               </tr>
               <tr>
                  <th id="table">説明</th>
                  <td><label for="content">最小100字以上詳しく書いてください。</label> <textarea
                        name="PDetail" rows="3" cols="10" >${PView.PDetail }</textarea></td>
               </tr>
               <input type="hidden" name="PNo" value="${PNo }">
            </table>
            <br> <br> <input type="submit" value="修正"
               onclick="return paddCheck()"> <a id="bt" href="javascript:history.go(-1)" class="button">CANCEL</a>

         </form>
      </div>
</body>
</html>