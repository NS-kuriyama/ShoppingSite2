<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><script src="https://sdk.form.run/js/v2/formrun.js"></script></head>

<link rel="stylesheet" type="text/css"href="/ShoppingSite/css/acount.css">

<title>ログイン画面</title>
<body>
<form class="formrun" action="../login/UserSearch" method="post">
	<div class="login-p">
		<div class="login">
			<h1>ログイン</h1>
			<p>ログインID</p>
			<input type="text" name="mail_address" data-formrun-type="email" placeholder="メールアドレス">
			<div data-formrun-show-if-error="mail_address">メールアドレスを正しく入力してください
			</div>
			<p>パスワード</p>
			<input type="password" name="password" data-formrun-required> <br>
			<input type="submit" value="ログイン"data-formrun-submitting-text="ログイン中...">
			<p><a href ="../views/register.jsp">登録が済んでいない方</a>
	</div>
	</div>
</form>
</body>
