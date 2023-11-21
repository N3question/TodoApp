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
	<!-- [TODO]昇順、降順を行うクラスを作りhref=""内に記述 -->
	<!-- [TODO]編集ボタン、削除ボタンの作成 -->
	<div class="container">
		<h1 class="top-space">My page</h1>
		<% String message = (String)request.getAttribute("message"); %>
		<% if (message != null) { %>
    		<p class="success"><%= message %></p>
    	<% } %>
		<div class="row">
			<div class="col-3">
				<div class="form">
					<form action="mypage" method="post" class="form-controll">
						<div class="mb-3">
							<label class="form-label">title</label>
							<input type="text" name="title" value="" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">content</label>
							<input type="text" name="content" value="" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">priority</label><br>
							<select name="priority" class="form-control">
								<option hidden>選択してください</option>
								<option value="1">high</option>
								<option value="2">normal</option>
								<option value="3">row</option>
							</select>
						</div>
						<input type="submit" value="submit" class="btn btn-dark submit w-100">
					</form>
				</div>
				<div class="anchor">
					<a href="index">Go to index</a><br>
					<a href="#">Logout</a>
				</div>
			</div>
			<div class="col-8 offset-1">
				<div class="sort">
					<div class="sort-div">
						<span class="btn">
							<a href="#" class="sort-anchor">
								<i class="bi bi-sort-down"></i>
								<small>A-Z</small>
							</a>
						</span>
						<span class="btn">
							<a href="#" class="sort-anchor">
								<i class="bi bi-sort-down-alt"></i>
								<small>Z-A</small>
							</a>
						</span>
						<span class="btn">
							<a href="#" class="sort-anchor">
								<i class="bi bi-sort-down-alt"></i>
								<small>Date</small>
							</a>
						</span>
						<span class="btn">
							<a href="#" class="sort-anchor">
								<i class="bi bi-sort-down"></i>
								<small>Priority</small>
							</a>
						</span>
						<span class="btn">
							<a href="#" class="sort-anchor">
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