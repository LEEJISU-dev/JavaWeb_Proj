<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワード忘れ</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<style>
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

#array {
	float: right;
}

#array-bt {
	line-height: 2em;
	min-width: 3em;
}
</style>
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
				<%
               if (session.getAttribute("UserId") != null) {
            %>
				<li><a href="PageServlet?command=PAdd">商品登録</a></li>
				<%
               } else if(session.getAttribute("AId") != null){
            %>
				<li><a href="PageServlet?command=APMgr">商品管理</a></li>
				<%
               }else{
                  %>
				<li>商品登録</li>
				<%
               }
            %>

				<%
               if (session.getAttribute("UserId") != null) {
            %>
				<li><a href="PageServlet?command=MInfo">マイページ</a></li>
				<%
               }else if (session.getAttribute("AId") != null) {
               %>
				<li><a href="PageServlet?command=AUMgr">会員管理</a></li>

				<% 
            }else {
            %>
				<li class="current"><a href="PageServlet?command=FPW">アカウントを探し</a></li>
				<%
               }
            %>
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
						<!-- 만약 아이디가 있다면 아이디 출력 -->
						<%
                     if (session.getAttribute("UserId") != null) {
                  %>
						<section id="st">
						<h5>
							<b>${UserId}</b>様 ようこそ!
						</h5>
						<footer>
						<form name="frm" method="post" action="PageServlet">
							<input type="hidden" name="command" value="Logout"> <input
								type="submit" value="LOGOUT" onclick="return boardCheck()">
						</form>
						</footer> </section>
						<%
                     } else if(session.getAttribute("AId") != null) {
                         %>
						<section id="st">
						<h5>
							<b>管理者様</b> 待ちました!
						</h5>
						<footer>
						<form name="frm" method="post" action="PageServlet">
							<input type="hidden" name="command" value="Logout"> <input
								type="submit" value="LOGOUT" onclick="return boardCheck()">
						</form>
						</footer> </section>
						<%
                 
                     }else{
                  %>
						<section id="st">
						<form name="frm" method="post" action="PageServlet?command=Login">
							<!-- <input type="hidden" name="command" value="Login">  -->
							<h5>
								ID <input id="main01" type="text" name="UserId">
							</h5>
							<h5>
								PW <input id="main02" type="password" name="UPw">
							</h5>

							<input type="radio" name="ma" value="user" checked="checked">一般会員
							<input type="radio" name="ma" value="admin">管理者<br>
							 <a href="PageServlet?command=FPW">アカウントを探し</a> <br>
							<footer> <input id="bt" type="submit" value="LOGIN"
								onclick="return boardCheck()"> </footer>
						</section>
						</form>
						<%
                     }
                  %>
						<section id="st">
						<h5>
							SEARCH
							<%
                     if (request.getAttribute("LCK") == "1") {
                  %>
							<script>
                        alert("ユーザIDまたはパスワードをもう一度確認してください。バイセコに登録されなかったユーザIDであったり、ユーザIDまたはパスワードを誤って入力しました。");
                     </script>
							<%
                        }
                     %>



						</h5>
						<form name="frm" method="post" action="PageServlet?command=Search">
							<input id="main03" type="text" name="search">
							<footer> <br>
							<input type="submit" value="SEARCH" onclick="return boardCheck()">
							</footer>
						</section>
						</form>

						<section id="st">
						<h5>CATEGORY</h5>
						<ul class="links">
							<li><a href="PageServlet?command=PList&PClass1=家電製品">家電製品</a></li>
							<li><a href="PageServlet?command=PList&PClass1=パソコン">パソコン</a></li>
							<li><a href="PageServlet?command=PList&PClass1=カメラ">カメラ</a></li>
							<li><a href="PageServlet?command=PList&PClass1=携帯電話">携帯電話</a></li>
							<li><a href="PageServlet?command=PList&PClass1=ゲーム">ゲーム</a></li>
						</ul>
						</section>
					</div>
				</div>
				<div class="8u  12u(narrower) important(narrower)">
					<div id="content">


						<!-- Content -->
						<form name="frm" method="post" action="PageServlet?command=DoFPW">
							<div id="wrap" align="center">
								<h2>アカウントを探し</h2>


								<table>


									<tr>
										<th><h4>電話番号</h4></th>
										<td><input type="text" name="UPhone"></td>
									</tr>
									<tr>
										<th><h4>メール</h4></th>
										<td><input type="text" name="UEmail"></td>
									</tr>
								</table>
								<br> <br> <input type="submit" value="探し"
									onclick="retrun fpwCheck()"> <input type="reset"
									value="キャンセル">
						</form>
					</div>
				</div>
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