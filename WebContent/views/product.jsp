<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="Product.Action" method="post">
	<input type="text" name="keyword"> <input type="submit"
		value="検索">
</form>
<hr>
<form action="../cart/CartAddAction" method="post">

<table style="border-coll:separate;border-spacing:10px;>
<td>商品名</td>
<td><img src="../img/嫌われる勇気.jpg"width="148" height="158"></td>
			<td>嫌われる勇気</td>
			<td>1000円</td>
			<input type ="hidden" name="book_name" value="嫌われる勇気">
			<td><input type="submit" value="カートに追加"></td>
			</tr>
</form>
</form>
<hr>
<form action="../cart/CartAddAction" method="post">

<table style="border-coll:separate;border-spacing:10px;>
<td>商品名</td>
<td><img src="../img/海賊と呼ばれた男.jpg"width="148" height="158"></td>
			<td>海賊と呼ばれた男</td>
			<td>1000円</td>
			<input type ="hidden" name="book_name" value="海賊と呼ばれた男">
			<td><input type="submit" value="カートに追加"></td>
			</tr>
</form>
</table>