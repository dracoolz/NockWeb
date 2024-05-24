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

.register {
	color: red;
}
</style>
<body>
	<!-- Change the value -->
	<% String no = request.getParameter("no"); %>
	<% if (no != null && no.equals("1")) { %>
	<p>商品変更 [mod]</p>
	<p>以下の商品を変更しましょう。</p>
	<form method="post" action="/NockWeb/control?id=<%= session.getAttribute("id") %>">
	<table>
		<tr>
			<td>ＩＤ：</td>
			<td><%=session.getAttribute("id")%></td>
		</tr>
		<tr>
			<td>商品名：</td>
			<td><input type="text" size="10" name="name" value="<%=session.getAttribute("name")%>"></td>
		</tr>
		<tr>
			<td>価格：</td>
			<td><input type="number" size="5" name="kakaku" value="<%=session.getAttribute("kakaku")%>" style="width: 96px">円</td>
		</tr>
	</table>
	<div class="button-2">
		<input type="submit" name="submit" value="変更">
		<button type="button" onclick="history.back()">戻る</button>
	</div>
	</form>
	
	<% } else if (no != null && no.equals("2")) { %>
	<!-- not in use -->
	<p>商品削除 [mod]</p>
	<p>以下の商品を削除しましょう。</p>
	<!--	<form method="post" action="/SampleWeb2/loginUserConf">-->
	<table>
		<tr>
			<td>ＩＤ：</td>
			<td><input type="text" size="20" name="id"></td>
		</tr>
		<tr>
			<td>商品名：</td>
			<td><input type="text" size="20" name="name"></td>
		</tr>
		<tr>
			<td>価格：</td>
			<td><input type="number" size="20" name="kakaku">円</td>
		</tr>
	</table>
	<div class="button-2">
		<input type="submit" name="submit" value="削除">
		<button type="button" onclick="history.back()">戻る</button>
	</div>
	<!--	</form>-->
	
	<% } else { %>
	
	<p>商品登録 [mod]</p>
	<p>以下の商品を登録しましょう。</p>
	<form method="post" action="/NockWeb/control">
		<table>
			<tr>
				<td>ＩＤ：</td>
				<td><input type="text" size="20" name="id"></td>
			</tr>
			<tr>
				<td>商品名：</td>
				<td><input type="text" size="20" name="name"></td>
			</tr>
			<tr>
				<td>価格：</td>
				<td><input type="number" size="20" name="kakaku">円</td>
			</tr>
		</table>
		<p class="register" style="visibility:<%= (request.getAttribute("registrationComplete") != null) ? "visible" : "hidden" %>;" name="register">登録が完了しました</p>
		<div class="button-2">
			<input type="submit" name="submit" value="登録">
			<button type="button" onclick="location.href='/NockWeb/menu'">戻る</button>
		</div>
	</form>
	
	<% } %>
</body>
</html>