<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
<title>主页</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css">
<script src="/js/vue.js"></script>
<style>
.ff {
	font: 1.5em sans-serif;
}

.jx {
	border-bottom: 2px solid #3b4d431e;
	margin-top: 5px;
}

.bg {
	margin-top: 50px;
}

/*与绿色边框的距离*/
.block1 {
	width: 265px;
	height: 287px;
	margin: auto;
	border: 1px solid #00ff73;
}
</style>
</head>

<body>
	<div id="app">
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
					<nav
						class="navbar navbar-expand-lg navbar-light bg-info text-white">
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
									<li><a class="nav-link" href="#">作业</a></li>
									<li><a class="nav-link" href="/notice">课程通知</a></li>
									<li><a class="nav-link" href="/dis">讨论区</a></li>
									<li><a class="nav-link" href="/logins">切换账号</a></li>
									<li><a class="nav-link " href="/logout">退出登录</a></li>
								</ul>
							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>


		<!-- 导航块 -->
		<div class="container">


			<div class="container">
				<div class="media p-3">
					<img :src="photo"
						onerror="javascript:this.src='/images/student/1.png'"
						alt="John Doe" class="mr-3 mt-3 rounded-circle"
						style="width: 60px; height: 60px;">
					<div class="media-body my-4">
						<h6>
							姓名：{{name}}</h6>
						<p>
							账号：{{id}}</p>

					</div>
				</div>
				<div class="row my-1 col-lg-10">
					<div class="col-lg-2 col-md-4  col-sm-4 col-6"
						style="text-align: center;">
						<a href="/persion"><img style="width: 100px;"
							src="/img/个人信息.png" alt="">
							<p>个人信息</p> </a>
					</div>
					<div class="col-lg-2 col-md-4 col-sm-4 col-6 "
						style="text-align: center;">
						<a href="/course/studying"> <img style="width: 100px;"
							src="/img/课程管理.png" alt="">
							<p>正在学习</p>
						</a>
					</div>
					<div class="col-lg-2 col-md-4 col-sm-4 col-6"
						style="text-align: center;">
						<a href="/dis"> <img style="width: 100px;"
							src="/img/作业.png" alt="">
							<p>消息</p>
						</a>
					</div>
					<div class="col-lg-2 col-md-4 col-sm-4 col-6"
						style="text-align: center;">
						<img style="width: 100px;" src="img/作业.png" alt="">
						<p>作业</p>
					</div>
					<div class="col-lg-2 col-md-4 col-sm-4 col-6"
						style="text-align: center;">
						<img style="width: 100px;" src="img/作业.png" alt="">
						<p>作业</p>
					</div>
					<div class="col-lg-2 col-md-4 col-sm-4 col-6"
						style="text-align: center;">
						<img style="width: 100px;" src="img/作业.png" alt="">
						<p>作业</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部导航 -->
	<script src="/component/nav-button.js"></script>
	<div id="nav_but">
		<runoob id="a1"></runoob>
	</div>
	<script>
		new Vue({
			el : '#nav_but',
			components : {
				"runoob" : runoob
			}
		})
	</script>
	<script>
		var data = ${json};
		new Vue({
			el : '#app',
			data : {
				photo : data.photo,
				name:data.name,
				id:data.id
			},
		})
	</script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
	<script src="/bootstrap-4.3.1/popper.min.js "></script>
	<script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>
</body>

</html>