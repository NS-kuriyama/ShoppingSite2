<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="../purchase/Purchase" method="post">
	<p><img src="../img/${product.name }.jpg" width="96" height="104"></p>
	<p>商品名:${product.name }</p>
		<input type ="hidden" name="cartbook" value="${product.name }"
		<p>値段:${product.price }</p>
		<input type ="hidden" name="cartprice" value="${product.price }"

		<p><input type="submit" value="購入する"></p>
		</form>

