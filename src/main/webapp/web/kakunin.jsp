<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタ</title>
</head>
<style>
p {
	text-align: center;
}

table {
	margin: 0 auto;
}

.button-2 {
	display: flex;
	justify-content: center;
	gap: 10px;
	margin-top: 1%;
}
</style>
<body>
	<!-- Change the value -->
	<%
	String no = request.getParameter("no");
	%>
	<%
	if (no != null && no.equals("1")) {
	%>

	<p>商品変更</p>
	<p>以下の商品を変更しましょう。</p>
	<form method="post" action="/NockWeb/shohin">
		<table>
			<tr>
				<td>ＩＤ：</td>
				<td><%=session.getAttribute("id")%></td>
			</tr>
			<tr>
				<td>商品名：</td>
				<td><%=session.getAttribute("name")%></td>
			</tr>
			<tr>
				<td>価格：</td>
				<td><%=session.getAttribute("kakaku")%>円</td>
			</tr>
		</table>
		<div class="button-2">
			<input type="submit" name="submit" value="変更">
			<button type="button" onclick="history.back()">戻る</button>
		</div>
	</form>

	<%
	} else if (no != null && no.equals("2")) {
	%>

	<p>商品削除</p>
	<p>以下の商品を削除しましょう。</p>
	<form method="post" action="/NockWeb/shohin">
		<table>
			<tr>
				<td>ＩＤ：</td>
				<td><%=session.getAttribute("id")%></td>
			</tr>
			<tr>
				<td>商品名：</td>
				<td><%=session.getAttribute("name")%></td>
			</tr>
			<tr>
				<td>価格：</td>
				<td><%=session.getAttribute("kakaku")%>円</td>
			</tr>
		</table>
		<div class="button-2">
			<input type="submit" name="submit" value="削除">
			<button type="button" onclick="history.back()">戻る</button>
		</div>
	</form>

	<%
	} else {
	%>

	<p>商品登録</p>
	<p>以下の商品を登録します。よろしいですか？</p>
	<form method="post" action="/NockWeb/shohin">
		<table>
			<tr>
				<td>ＩＤ：</td>
				<td><%=session.getAttribute("id")%></td>
			</tr>
			<tr>
				<td>商品名：</td>
				<td><%=session.getAttribute("name")%></td>
			</tr>
			<tr>
				<td>価格：</td>
				<td><%=session.getAttribute("kakaku")%>円</td>
			</tr>
		</table>
		<div class="button-2">
			<input type="submit" name="submit" value="確認">
			<button type="button" onclick="history.back()">戻る</button>
		</div>
	</form>
	<% } %>

</body>
</html>