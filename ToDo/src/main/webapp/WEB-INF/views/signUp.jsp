<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1 class="top-space">Let's join us!</h1>
		<!-- <p>message</p> -->
		<div class="row">
			<div class="col-3">
				<div class="form">
					<div>
						<h3>Sign Up</h3>
						<form action="#" method="post" class="form-controll">
							<div class="mb-3">
								<label class="form-label">Name</label>
								<input type="text" name="name" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label>
								<input type="password" name="password" class="form-control"  id="password" required>
							</div>
							<div>
								<label>Password (reconfirmation)</label>
								<input type="password" class="form-control" name="confirm" oninput="CheckPassword(this)" required>
							</div>
							<input type="submit" value="Create" class="btn btn-dark submit w-100">
						</form>
					</div>
				</div>
				<div class="mt-3">
					<a href="index">Login</a><span>はこちら</span>
				</div>
			</div>
		</div>
	</div>
	<script>
	function CheckPassword(confirm){
		// 入力値取得
		var input1 = password.value;
		var input2 = confirm.value;
		// パスワード比較
		if(input1 != input2){
			confirm.setCustomValidity("入力値が一致しません。");
		}else{
			confirm.setCustomValidity('');
		}
	}
	</script>
</body>
</html>