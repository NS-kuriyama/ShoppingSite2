<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>商品登録</title>
<link rel="stylesheet" type="text/css"href="/ShoppingSite/css/acount.css">
<form action="../register/ProductRegister" method="post">
<div class="login-p">
		<div class="login">
	<p>${product.name }${success }
	<h1>商品を登録する</h1>
	<p>商品名</p>
	<input type="text" name="name">

	<p>商品価格</p>
	<input type="text" name="price">

	<p>商品言葉<p>
	<input type="text" name="words">

	<p>商品ジャンル</p>
	<input type="text" name="genre">
	<p>
	<input type="submit" value="商品を登録する">
	<p>
	</p>
	<p><a href="javascript:history.back()">&lt;&lt; 前のページに戻る</a></p>
	</div>
	</div>
</form>
