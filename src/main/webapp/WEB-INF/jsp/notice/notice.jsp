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
                    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                        data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="true"
                        aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="navbar-collapse collapse show" id="collapsibleNavId">
                        <div class="container ">
                            <ul class="navbar-nav mr-auto row mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link" href="/zhuye">我的主页</a></li>
                                <li><a class="nav-link" href="/course">我的课程</a></li>
                                <li><a class="nav-link" href="/notice">课程通知</a></li>
                                <li><a class="nav-link" href="/dis">讨论圈子</a></li>
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

        <div class="row">
            <div class="col-9">
                <ol class="breadcrumb mt-2">
                    <li class="breadcrumb-item"><a href="#">主页</a></li>
                    <li class="breadcrumb-item active"><a>来自课程的通知</a></li>
                    <div class="offset-5" style="display: none;">未读消息：</div>
                </ol>
                <div v-for="(item, index) in items">
                    <div class="card mt-3">
                        <div class="card-body">
                            <div>{{item.course_name}}</div>
                        </div>
                        <div class="card-footer text-muted">
                            <div class="row">
                                <div class="mx-4">发布的通知：{{item.notices.length}}</div>
                                <a :href='"#demo"+index' data-toggle="collapse">展开</a>
                            </div>
                        </div>
                    </div>
                    <div :id='"demo"+index' class="collapse mx-4">
                        <div v-for="(item1, index1) in item.notices">
                            <div class="card mt-3">
                                <div class="card-body">
                                    <div v-html="item1.notice_content"></div>
                                    <div>{{item1.notice_time|timeTransform}} </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        var data = { data: ${ data }};

        // var data = { data: [{ "collect": null, "course_content": null, "course_folder": null, "course_hour": null, "course_introduce": null, "course_name": "数学", "course_photo": null, "course_state": null, "course_teacher": null, "course_teacher_name": null, "course_time": null, "id": "12", "notices": [{ "id": "18", "notice_content": "<p>数学的第一条通知</p>", "notice_courseName": null, "notice_courseid": "12", "notice_read": null, "notice_time": "1574955913866", "student_id": null, "timeout": null }, { "id": "19", "notice_content": "<p>数学的第二条通知</p>", "notice_courseName": null, "notice_courseid": "12", "notice_read": null, "notice_time": "1574955927758", "student_id": null, "timeout": null }, { "id": "20", "notice_content": "<p>数学的第三条通知</p>", "notice_courseName": null, "notice_courseid": "12", "notice_read": null, "notice_time": "1574955948102", "student_id": null, "timeout": null }], "study": null }, { "collect": null, "course_content": null, "course_folder": null, "course_hour": null, "course_introduce": null, "course_name": "数据结构", "course_photo": null, "course_state": null, "course_teacher": null, "course_teacher_name": null, "course_time": null, "id": "11", "notices": [{ "id": "21", "notice_content": "<p>数据结构第一条消息</p>", "notice_courseName": null, "notice_courseid": "11", "notice_read": null, "notice_time": "1574956132451", "student_id": null, "timeout": null }, { "id": "22", "notice_content": "<p>数据结构第二条消息</p>", "notice_courseName": null, "notice_courseid": "11", "notice_read": null, "notice_time": "1574956143793", "student_id": null, "timeout": null }, { "id": "23", "notice_content": "<p>数据结构第三条消息</p>", "notice_courseName": null, "notice_courseid": "11", "notice_read": null, "notice_time": "1574956158552", "student_id": null, "timeout": null }], "study": null }] };

        var app = new Vue({
            el: "#app1",
            data: {
                items: data.data,
            },
            filters: {
                timeTransform: function (value) {
                    var str = value + "000000000000000000000000000000000000000000000000000000000000000";
                    a = new Date(Number(str.substr(0, 13)));
                    return a.getFullYear() + '年' + a.getMonth() + "月" + a.getDate();
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