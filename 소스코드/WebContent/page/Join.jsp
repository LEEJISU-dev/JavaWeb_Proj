<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>バイセコ</title>
<script type = "text/javascript" src = "./script/board.js"></script>
<script>
function joinCheck(){
	if(document.frm.UserId.value.length ==0){
		alert("ユーザIDを入力してください。");
		return false;
	}
	if(document.frm.UName.value.length ==0){
		alert("氏名を入力してください。");
		return false;
	}
	if(document.frm.UPw.value.length ==0){
		alert("パスワードを入力してください。");
		return false;
	}
	if(document.frm.UAddr.value.length ==0){
		alert("住所を入力してください。");
		return false;
	}
	if(document.frm.UPhone.value.length ==0){
		alert("電話番号を入力してください。");
		return false;
	}
	if(document.frm.UEmail.value.length ==0){
		alert("メールを入力してください。");
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
            <%if(session.getAttribute("UserId")!=null){ %>   
            <li><a href="PageServlet?command=PAdd">商品登録</a></li>
            <%}else{ %>
            <li>商品登録</li>
            <%} %>
            <li class="current"><a href="PageServlet?command=Join">会員登録</a></li>

         </ul>
         </nav>

      </div>
      <div id="wrap" align="center">
         <h1>会員登録</h1>
         <form name="frm" method="post" action="PageServlet">
            <input type="hidden" name="command" value="DoJoin">
            <table>
               <tr>
                  <th id="table">ユーザID</th>
                  <td><input type="text" name="UserId"></td>
               </tr>
               <tr>
                  <th id="table">氏名</th>
                  <td><input type="text" name="UName"></td>
               </tr>
               <tr>
                  <th id="table">パスワード</th>
                  <td><input type="password" name="UPw"></td>
               </tr>
               <tr>
                  <th id="table">電話番号</th>
                  <td><input type="text" name="UPhone"></td>
               </tr>
               <tr>
                  <th id="table">メール</th>
                  <td><input type="text" name="UEmail"></td>
               </tr>
               <tr>
                  <th id="table">住所</th>
                  <td><input type="text" name="UAddr"></td>
               </tr>
               <%if(request.getAttribute("CID")=="1"){%>
                     <script>
                   alert("存在するユーザIDです。");
                   </script>
               <%}%>
            </table>
            <br>
            <br> <input type="submit" value="登録" onclick="return joinCheck()"> 
            <input type="reset" value="キャンセル">

         </form>
      </div>
</body>
</html>