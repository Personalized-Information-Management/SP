<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="/js/vue.js"></script>
</head>

<body>
    <!-- 导航栏 -->
    <div>
        <div class="container">
            <br> <a href="http://localhost:8080/zhuye">
                <p>
                    <i><strong>个性化学习平台</strong></i>
                </p>
            </a>
        </div>
        <div class="container-fluid bg-info text-white">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light bg-info text-white">
                    <a class="navbar-brand">&nbsp;</a>
                    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                        data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="true"
                        aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="navbar-collapse collapse show" id="collapsibleNavId">
                        <div class="container ">
                            <ul class="navbar-nav mr-auto row mt-2 mt-lg-0">
                              <li class="nav-item active"><a class="nav-link" href="/zhuye">主页</a></li>
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
    <div class="container" id="app1">
        <ol class="breadcrumb mt-4">
            <li class="breadcrumb-item"><a href="#">主页</a></li>
            <li class="breadcrumb-item active"><a>课程通知</a></li>
            <div class="offset-5">未读消息：</div>
        </ol>
        <div v-for="item in items">
            <div class="card mt-4">
                <div class="card-header bg-secondary text-white" style="opacity: 0.8;">
                    [课程通知]{{item.courses.course_name}}
                    <div class="btn btn-info" style="float: right;" style="opacity: 0.9;">标记已读</div>
                </div>
                <div class="card-body" data-mrc>
                    <p class="card-text" v-html="item.notices.notice_content"></p>
                </div>
                <div class="card-footer text-muted">
                    {{item.notices.notice_time|timeTransform}}
                </div>
            </div>
        </div>
    </div>
    <script>
        var data =${json}
        	var app = new Vue({
            el: "#app1",
            data: {
                items: data,
            },
            filters: {
                timeTransform: function (value) {
                    var str = value + "000000000000000000000000000000000000000000000000000000000000000";
                    a = new Date(Number(str.substr(0, 13)));
                    return a.getFullYear() + '年' + a.getMonth() + "月" + a.getDate() + " " + a.getHours() + ":" + a.getMinutes();
                }
            },
        })
    </script>




    <!-- jquery动画，删除了booststrap的jquery插件 -->
    <script src="/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="/js/jquery.morecontent.js"></script>
    <script>
        $(document).ready(function () {
            var example = $('[data-mrc]');
            example.moreContent({
                easing: 'easeOutBounce',
                height: 100
            });
        });
    </script>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>