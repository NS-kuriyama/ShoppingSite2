<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>新規登録</title>
<link rel="stylesheet" type="text/css"href="/ShoppingSite/css/acount.css">
<form action="../register/Register" method="post">
<div class="login-p">
		<div class="login">
	<h1>新規登録</h1>
	<p>姓</p>
	<p>
		<input type="text" name="last_name">
	<p>名</p>
	<p>
		<input type="text" name="first_name">
	<div data-formrun-show-if-error="first_name"></div>
	<p>ニックネーム</p>
	<input type="text" name="nick_name">
	<p>メールアドレス</p>
	<input type="text" name="mail_address">
	<p>パスワード</p>
	<input type="password" name="password">
	<p>
		<input type="radio" name="role" value="1">管理者で登録する <input
			type="radio" name="role" value="2" checked>ユーザーで登録する
	</p>
	<input type="submit" value="次に進む">
	</div>
	</div>
</form>