<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="/ShoppingSite/css/acount.css">
<title>退会</title>
<form action="../delete/UserDelete" method="post">
<div class="login-p">
		<div class="login">
<p>IDを入力してください</p>
<p>${error }</p>
		<input type="text" name="mail_address" placeholder="メールアドレス">
		<p> <input type="submit" value="退会する"></p>
		<p><a href="javascript:history.back()">&lt;&lt; 前のページに戻る</a></p>
		</div>
		</div>
</form>
