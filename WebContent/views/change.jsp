<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet" type="text/css"
	href="/ShoppingSite/css/acount.css">
<title>会員情報変更画面</title>
<body>
<section>
	<form action="../change/Change" method="post">
	<div class="login-p">
		<div class="login">
		<p>${error }</p>


		<p>ログインID</p>
		<input type="text" name="mail_address" placeholder="メールアドレス">
		<p>
			<input type="submit" value="このIDの情報を変更する">
		</p>

	</form>
	<form action="../update/Update" method="post">
		姓
		<p>
			<input type="text" name="last_name" value="${user.lastName }">
		</p>
		名
		<p>
			<input type="text" name="first_name" value="${user.firstName}">
		</p>
		パスワード
		<p>
			<input type="password" name="password" value="${user.password }">
		</p>
		ニックネーム
		<p>
			<input type="text" name="nick_name" value="${user.nickName }">
		</p>
		ロール
		<p>
			<input type="text" name="role" value="${user.role }">
		</p>
		<p>
			<input type="submit" value="入力内容を変更する">
		</p>
		<p>${succes }</p>
	</form>
	</div>
	</div>

</section>
<p><button onclick="location.href='../views/index.html'">ホームに戻る</button></p>
</body>
