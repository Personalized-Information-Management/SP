<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>登录页面</title>
	<!-- boostrap4 -->
	<!-- 新 Bootstrap4 核心 CSS 文件 -->
	<link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">

	<script src="vue/vue.min.js"></script>
	<style>
	</style>
</head>

<body>
	<div id="app">
		<div class="container-fluid" style="padding: 0px; vertical-align: center">
			<div class="nav col-12" style="background: rgb(71, 62, 62); height: 50px;">
				<div class="container">
					<div class="nav-item" style="position: absolute; top: 5px">
						<a class="nav-link" href="#">个性化平台</a>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<br> <br> <br> <br> <br>
			<div class="card col-sm-6 col-md-6 col-lg-4  offset-sm-3 offset-lg-4" style="text-align: center;">
				<div v-show="true" class="alert alert-warning   col-12" role="alert"
					style="position: absolute; top: -80px; left: -2px;">账号或密码错误</div>
				<div class="card-body ">
					<h1>个性化平台</h1>
					<div class="row">
						<div class="col-6" @click="fun1()" style="text-align: center; color: blue; cursor: pointer;">
							<p style="position: relative; top: 15px">
								<span>学生登录</span>
							</p>
							<div v-show="Tab1" style="border-bottom: 4px solid blue;"></div>
						</div>
						<div class="col-6" @click="fun2()" style="text-align: center; color: blue; cursor: pointer;">
							<p style="position: relative; top: 15px">
								<span>教师登录</span>
							</p>
							<div v-show="Tab2" style="border-bottom: 4px solid blue;"></div>
						</div>
					</div>
				</div>
				<form action="/login" method="post" style="text-align: center">
					<input style="display: none;" type="text" class="form-control" v-model="role" name="role"> <input
						type="text" class="form-control" v-model="name" name="name" placeholder="输入账号" pattern="[0-9]*"
						title="仅数字" required="required"> <br>
					<input type="password" class="form-control" v-model="password" name="password" placeholder="输入密码"
						pattern="[0-9]*[a-z]*[A-Z]*[_]*" required="required" title="大小写字母，数字，或下划线的组合"> <br>
					<button type="submit" class="btn btn-primary col-12 ">登录</button>
				</form>
				<br>
			</div>
		</div>
	</div>
	<!-- 底部导航 -->
	<div id="nav_but">
		<runoob id="a1"></runoob>
	</div>
	<script src="/component/nav-button.js"></script>
	<script>
		new Vue({
			el: '#nav_but',
			components: {
				"runoob": runoob
			}
		})
	</script>
	<script>
		var data = {
			Tab1: true,
			Tab2: false,
			role: 1,
			name: "",
			password: "",
			show: false,
			showTexe: ""
		}
		var app = new Vue({
			el: '#app',
			data: data,
			methods: {
				fun1: function () {
					this.Tab1 = true;
					this.Tab2 = false;
					this.role = 1;
				},
				fun2: function () {
					this.Tab1 = false;
					this.Tab2 = true;
					this.role = 2;
				},
			},
		});
	</script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
	<script src="bootstrap-4.3.1/popper.min.js "></script>
	<script src="bootstrap-4.3.1/js/bootstrap.min.js "></script>

</body>

</html>