<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>販売リスト</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<style>
td{
border-bottom: 1px solid #444444;
    padding-left: 40px;
    padding-bottom: 10px;
    padding-top: 10px;
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
            <li><a href="PageServlet?command=PAdd">商品登録</a></li>
            <!-- 로그인 후는 마이페이지로 넘어감 -> command 이름 설정해주세요 -->
            <li class="current"><a href="PageServlet?command=MInfo">マイページ</a></li>
         </ul>
         </nav>
      </div>

      <!-- Main -->
      <section class="wrapper style1">
      <div class="container">
         <div class="row 200%">
            <div class="4u 12u(narrower)">
               <div id="sidebar">

                  <!-- Sidebar -->
                  <section id="st">
                  <h5>
                     <b>${UserId }</b> 様　ようこそ！
                  </h5>
                  <footer> <form name="frm" method="post" action="PageServlet">
                     <input type="hidden" name="command" value="Logout"> <input
                        type="submit" value="LOGOUT" onclick="return boardCheck()">
                  </form> </footer> </section>

                  <section id="st">
                     <ul class="links">
                        <li><a href="PageServlet?command=MInfo">私の情報</a></li>
                        <li><a href="PageServlet?command=PSList">販売リスト</a></li>
                        <li><a href="PageServlet?command=PBList">購買リスト</a></li>
                        <li><a href="PageServlet?command=CPW">会員情報修正</a></li>
                     </ul>
                  </section>
               </div>
            </div>

            <!-- Content -->
  <!--           <div class="8u  12u(narrower) important(narrower)"> -->
               <div id="content">

                  <article> <header>
                  <h2>私の販売リスト</h2>
                  </header>
                  <table>
                     <tr>
                    	<td><h4>商品写真</td>
                        <td><h4>商品名</h4></td>
                        <td><h4>価格</h4></td>
                        <td><h4>販売状況</h4></td>
						<td><h4>販売日</h4></td>
                     </tr>

                   
               <c:forEach var="sell" items="${PSList}">
                        <tr>
                           <td><a href="PageServlet?command=PView&PNo=${sell.PNo}"><img src="./upload/${sell.PPhoto }" style="width:70px; height:70px"/></a></td>
                           <td><a href="PageServlet?command=PView&PNo=${sell.PNo}">${sell.PName}</a></td>
                           <td>${sell.PPrice} 円</td>
                           <td>
                           	<c:choose>
                           		<c:when test="${sell.PSelled==1}">
                           			販売完了
                           		</c:when>
                           		<c:otherwise>
                           			販売中
                           		</c:otherwise>
                           	</c:choose>
                           <td><fmt:formatDate value="${sell.PSDate}"/></td>
                        </tr>
                     </c:forEach>
                     
                  </table>
                  </article>

       <!--         </div> -->
            </div>
         </div>
      </div>
      </section>

      <!-- Scripts -->
      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/js/jquery.dropotron.min.js"></script>
      <script src="assets/js/skel.min.js"></script>
      <script src="assets/js/util.js"></script>
      <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
      <script src="assets/js/main.js"></script>
</body>
</html>