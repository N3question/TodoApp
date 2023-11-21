<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.TodoBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
	<div class="container">
		<h1 class="top-space">Show</h1>
		<!-- <p>message</p -->
		<div class="row">
			<div class="col-3">
				<% 
			      TodoBeans todoSelect = (TodoBeans)request.getAttribute("todoSelect");
			    %>
				<table class="table">
					<tr>
						<th>List ID</th>
						<td><%= todoSelect.getListId() %></td>
					</tr>
					<tr>
						<th>Title</th>
						<td><%= todoSelect.getTitle() %></td>
					</tr>
					<tr>
						<th>Content</th>
						<td><%= todoSelect.getContent() %></td>
					</tr>
					<tr>
						<th>Create Date</th>
						<td><%= todoSelect.getDate() %></td>
					</tr>
					<tr>
						<th>Priority</th>
						<td><%= todoSelect.getPriority() %></td>
					</tr>
					<tr>
						<th>User ID</th>
						<td><%= todoSelect.getUserId() %></td>
					</tr>
				</table>
			</div>
		</div>
		<a href="index">Back to index</a>
	</div>
</body>
</html>