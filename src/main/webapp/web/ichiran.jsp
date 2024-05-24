<%@ page import="java.util.ArrayList"%>
<%@ page import="sogo.ShohinBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタ</title>
<style>
p {
	text-align: center;
	margin: 0;
}

table {
	margin: 0 auto;
}

table, th, td {
	border: 1px solid black;
	text-align: center;
}

.button1 {
	margin-left: 48%;
	margin-top: 2%;
}

.button-list {
	display: flex;
	justify-content: center;
	gap: 10px;
	margin-top: 2%;
}

.register {
	color: red;
}
</style>
</head>
<body>

	<%
	String no = request.getParameter("no");
	%>

	<%
	if (no != null && no.equals("1")) {
	%>
	<%--タイトル行を作成する --%>
	<p>ユーザ一覧</p>
	<br>
	<table border="1">
		<tr align="center">
			<th>ID</th>
			<th>商品名</th>
			<th>価格</th>
		</tr>
		<%--リストからユーザ情報を取り出し、データ行を作成する --%>
		<%
		ArrayList<ShohinBean> list = (ArrayList<ShohinBean>) request.getAttribute("list");
		%>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>
		<tr align="center">
			<td><%=list.get(i).getId()%></td>
			<td><%=list.get(i).getName()%></td>
			<td><%=list.get(i).getKakaku()%>円</td>
		</tr>
		<%
		}
		%>
	</table>

	<button class="button1" type="button" onclick="history.back()">戻る</button>

	<%
	} else if (no != null && no.equals("2")) {
	%>
	<form method="post" action="/NockWeb/duControl">
		<%--タイトル行を作成する --%>
		<p>ユーザ一覧</p>
		<br>
		<table border="1">
			<tr align="center">
				<th></th>
				<th>ID</th>
				<th>商品名</th>
				<th>価格</th>
			</tr>
			<%--リストからユーザ情報を取り出し、データ行を作成する --%>
			<%
			ArrayList<ShohinBean> list = (ArrayList<ShohinBean>) request.getAttribute("list");
			%>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr align="center">
				<td><input type="radio" name="idValue" value="<%=list.get(i).getId()%>"></td>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getKakaku()%>円</td>
			</tr>
			<%
			}
			%>
		</table>
		<p class="register" style="visibility:<%= (request.getAttribute("complete") != null) ? "visible" : "hidden" %>;" name="register"><%= request.getAttribute("result") %></p>
		<div class="button-list">
			<input type="submit" name="submit" value="変更" />
			<input type="submit" name="submit" value="削除" />
			<button type="button" onclick="location.href='/NockWeb/menu'">戻る</button>
		</div>
	</form>
	<%
	}
	%>
</body>
</html>
