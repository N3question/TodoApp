<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.TodoBeans"%>
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
		<h1 class="top-space">Edit</h1>
		<!-- <p>message</p> -->
		<div class="row">
			<div class="col-3">
				<div class="form">
					<div>
						<% 
					      TodoBeans todoSelect = (TodoBeans)request.getAttribute("todoSelect");
					    %>
						<form action="edit?list_id=<%= todoSelect.getListId() %>" method="post" class="form-controll">
							<div class="mb-3">
								<label class="form-label">title</label>
								<input type="text" name="title" value="<%= todoSelect.getTitle() %>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">content</label>
								<input type="text" name="content" value="<%= todoSelect.getContent() %>" class="form-control">
							</div>
							<%-- <div class="mb-3">
								<label class="form-label">priority</label>
								<input type="text" name="priority" value="<%= todoSelect.getPriority() %>" class="form-control">
							</div> --%>
							<div class="mb-3">
								<label class="form-label">priority</label>
								<select name="priority" class="form-control">
									<option hidden><%= todoSelect.getPriority() %></option>
									<option value="1">high</option>
									<option value="2">normal</option>
									<option value="3">row</option>
								</select>
							</div>
							<input type="submit" value="submit" class="btn btn-dark submit w-100">
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="anchor">
			<a href="index">Back to index</a>
		</div>
	</div>
</body>
</html>