<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>主页</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
                <br> <a href="/teacher/zhuye">
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
                                    <li class="nav-item active"><a class="nav-link" href="/teacher/zhuye">主页</a></li>
                                    <li><a class="nav-link" href="/teacher/course">课程管理</a></li>
                                    <li><a class="nav-link" href="/teacher/course/notice-course">作业通知</a></li>
                                    <li><a class="nav-link" href="">讨论圈子</a></li>
                                    <li><a class="nav-link" href="">切换账号</a></li>
                                    <li><a class="nav-link " href="">退出登录</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>


        <!-- 导航块 -->
        <div class="container">
            <div class="row">
                <div class="list-group mt-4">
                    <a href="/teacher/course/notice-course" class="list-group-item list-group-item-action">
                        已发布课程
                    </a>
                    <a href="/teacher/course/notice" class="list-group-item list-group-item-action active">
                        已发布通知
                    </a>
                </div>
                <div class="col-9 mt-4">
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
                                        <div>{{item1.notice_time|timeTransform}} <a :href='"/teacher/course/delete_notice?cid="+item1.id'>删除</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        
        var data = { data: ${data}};
        // var data = { data: [{"collect":null,"course_content":null,"course_folder":null,"course_hour":null,"course_introduce":null,"course_name":"诗歌鉴赏","course_photo":null,"course_state":null,"course_teacher":null,"course_teacher_name":null,"course_time":null,"id":"1","notices":[{"id":"1","notice_content":"<p>我的世界，你的世界，他的世界</p>","notice_courseName":null,"notice_courseid":"1","notice_read":null,"notice_time":"1573794990000","student_id":null,"timeout":null},{"id":"2","notice_content":"<p>请完成第二张的内容</p>","notice_courseName":null,"notice_courseid":"1","notice_read":null,"notice_time":"1573794990000","student_id":null,"timeout":null},{"id":"3","notice_content":"<p>请完成第三张的内容</p>","notice_courseName":null,"notice_courseid":"1","notice_read":null,"notice_time":"1573794990000","student_id":null,"timeout":null}],"study":null},{"collect":null,"course_content":null,"course_folder":null,"course_hour":null,"course_introduce":null,"course_name":"诗词鉴赏","course_photo":null,"course_state":null,"course_teacher":null,"course_teacher_name":null,"course_time":null,"id":"2","notices":[{"id":"6","notice_content":"<p>请完成第1张的内容</p>","notice_courseName":null,"notice_courseid":"2","notice_read":null,"notice_time":"1573794990000","student_id":null,"timeout":null}],"study":null},{"collect":null,"course_content":null,"course_folder":null,"course_hour":null,"course_introduce":null,"course_name":"诗词鉴赏","course_photo":null,"course_state":null,"course_teacher":null,"course_teacher_name":null,"course_time":null,"id":"3","notices":[{"id":"7","notice_content":"<p>请完成第1张的内容</p>","notice_courseName":null,"notice_courseid":"3","notice_read":null,"notice_time":"1573794990000","student_id":null,"timeout":null}],"study":null}]};
        new Vue({
            el: '#app',
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
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
    <script src="/bootstrap-4.3.1/popper.min.js "></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>
</body>

</html>