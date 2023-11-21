<!-- サーブレットからの指示をもとに表示を行う役割 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.List, model.bean.TodoBeans, model.bean.UserBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoApp</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
	<div class="container">
		<h1 class="top-space">index</h1>
		<% String message = (String)request.getAttribute("message"); %>
		<% if (message != null) { %>
    		<p class="success"><%= message %></p>
    	<% } %>
		<div class="row">
			<% UserBeans user = (UserBeans)request.getAttribute("user"); %>
			<% if (user != null) { %>
			<div class="col-lg-3">
				<div class="userInfo">
					<div class="w-100">
						<h5>Your Profile</h5>
						<% String name = (String)request.getAttribute("name"); %>
						<% Integer userId = (Integer)request.getAttribute("userId"); %>
						<table class="table userInfoTable">
							<tr>
								<td>User Name : </td>
								<td><%= name %></td>
							<tr>
							<tr>
								<td>User ID : </td>
								<td><%= userId %></td>
							<tr>
							<tr>
								<td colspan="2">Profile : </td>
							<tr>
							<tr>
								<td colspan="2">あとで追加</td>
							<tr>
						</table>
					</div>
				</div>
				<div class="anchor">
					<a href="mypage">Mypage</a>
				</div>
			</div>
			<% } else {%>
			<div class="col-3">
				<div class="form">
					<div>
						<h3 class="mb-3">Login</h3>
						<form action="index" method="post" class="form-controll">
							<div class="mb-3">
								<label class="form-label">Name</label>
								<input type="text" name="name" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label>
								<input type="password" name="password" class="form-control">
							</div>
							<input type="submit" value="Login" class="btn btn-dark submit w-100">
						</form>
					</div>
				</div>
				<div class="mt-3">
					<a href="signup">Sign Up</a><span>はこちら</span>
				</div>
			</div>
			<% } %>
			<div class="col-lg-8 offset-lg-1">
				<div class="sort">
					<div class="sort-div">
						<span class="btn">
							<a href="ascAbc" class="sort-anchor" id="ascending-abc">
								<i class="bi bi-sort-down"></i>
								<small>A-Z</small>
							</a>
						</span>
						<span class="btn">
							<a href="descAbc" class="sort-anchor" id="descending-abc">
								<i class="bi bi-sort-down-alt"></i>
								<small>Z-A</small>
							</a>
						</span>
						<span class="btn">
							<a href="descDate" class="sort-anchor" id="descending-date">
								<i class="bi bi-sort-down-alt"></i>
								<small>Date</small>
							</a>
						</span>
						<span class="btn">
							<a href="ascPriority" class="sort-anchor" id="ascending-pri">
								<i class="bi bi-sort-down"></i>
								<small>Priority</small>
							</a>
						</span>
						<span class="btn">
							<a href="descPriority" class="sort-anchor" id="descending-pri">
								<i class="bi bi-sort-down-alt"></i>
								<small>Priority</small>
							</a>
						</span>
					</div>
				</div>
				<table class="table">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Content</th>
						<th>Create Date</th>
						<th>Priority</th>
						<th>User ID</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<!-- Beansで定義しているメソッド()の引数があるかないかを覚えておく。 -->
					<% 
				      ArrayList<TodoBeans> todoList = (ArrayList)request.getAttribute("todoList");
				    %>
				    <% if(todoList != null) { %>
						<% 
					      for (TodoBeans todo : todoList) {
					    %>
							<tr>
								<td><%= todo.getListId() %></td>
							    <td><a href='show?list_id=<%= todo.getListId() %>'><%= todo.getTitle() %></a></td>
							    <td><%= todo.getContent() %></td>
							    <td><%= todo.getDate() %></td>
							    <td><%= todo.getPriority() %></td>
							    <td><%= todo.getUserId() %></td>
							    <td>
							    	<a href='edit?list_id=<%= todo.getListId() %>'>
							    		<i class="bi bi-pencil edit"></i>
							    	</a>
								</td>
							    <td>
							    	<a href="destroy?list_id=<%= todo.getListId() %>">
							    		<i class="bi bi-trash delete"></i>
							    	</a>
							    </td>
							</tr>
						<% } %>
					<% } %>
				</table>
			</div>
		</div>
    </div>
</body>
</html>