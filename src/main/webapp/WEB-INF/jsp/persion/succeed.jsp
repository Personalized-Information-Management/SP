<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="/js/vue.js"></script>
</head>

<body>
	<!-- 导航栏 -->
	<div>
		<div class="container">
			<br> <a href="/zhuye">
				<p>
					<i><strong>个性化学习平台</strong></i>
				</p>
			</a>
		</div>
		<div class="container-fluid bg-info text-white">
			<div class="container">
				<nav class="navbar navbar-expand-lg navbar-light bg-info text-white">
					<a class="navbar-brand">&nbsp;</a>
					<button class="navbar-toggler d-lg-none" type="button"
						data-toggle="collapse" data-target="#collapsibleNavId"
						aria-controls="collapsibleNavId" aria-expanded="true"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="navbar-collapse collapse show" id="collapsibleNavId">
						<div class="container ">
							<ul class="navbar-nav mr-auto row mt-2 mt-lg-0">
								<li class="nav-item active"><a class="nav-link"
									href="/zhuye">主页</a></li>
								<li><a class="nav-link" href="/course">课程</a></li>
								<li><a class="nav-link" href="/course#">作业</a></li>
								<li><a class="nav-link" href="/course#">成长</a></li>
								<li><a class="nav-link" href="/course#">教师通知</a></li>
								<li><a class="nav-link" href="/course#">讨论区</a></li>
								<li><a class="nav-link" href="/course#">活动</a></li>
								<li><a class="nav-link" href="/course#">切换账号</a></li>
								<li><a class="nav-link " href="/course#">退出登录</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>

	<div id="app" class="container">
		<br> <br> <br> <br> <br>
		<div class="row">
			<img id="a1" :src="photo" class="offset-2" style="width: 60px;"
				alt="">
			<div class="mt-4 mx-4">{{str}}</div>
		</div>
		<br> <br> <a href="/zhuye"><div class="offset-2">返回首页</div></a>
	</div>
	<script>
		var data = ${json};
		var app = new Vue({
			el : "#app",
			data : data,
		})
	</script>



	<!-- 底部导航 -->
	<div id="nav_but">
		<runoob id="a1"></runoob>
	</div>
	<script src="/component/nav-button.js"></script>
	<script>
		new Vue({
			el : '#nav_but',
			components : {
				"runoob" : runoob
			}
		})
	</script>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>