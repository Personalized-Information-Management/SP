<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>课程页面</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <!--注意引入css文件用link-->
    <script scr="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <link href="/bootstrap-4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!--vue.js-->
    <script src="/js/vue.js"></script>
    <!--axios.js-->
    <script src="/js/axios.min.js"></script>
    <style>
        .css2 {
            overflow: hidden;
            /*自动隐藏文字*/
            text-overflow: ellipsis;
            /*文字隐藏后添加省略号*/
            white-space: nowrap;
            /*强制不换行*/
            width: 7em;
            display: inline-block;
        }


        @media (min-width: 768px) {
            a {
                font-size: 14px;
            }

            .u-font {
                font-size: 10px;
            }

            .u-img {
                width: 10px;
            }
        }
    </style>
</head>

<body>
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

    <div class="container">
        <div id="abc">
            <!--课程页面-->
            <div class="container-fluid mt-lg-4">
                <div class="row">
                    <ol class="breadcrumb mt-4">
                        <li class="breadcrumb-item"><a href="#">主页</a></li>
                        <li class="breadcrumb-item active"><a>发布的课程</a></li>
                    </ol>
                </div>
            </div>
            <!--课程区-->
            <div class=" col-lg-12  mt-2 col-sm-12 ">
                <div class="input-group col-lg-5">
                    <input type="text" class=" form-control" placeholder="搜索课程" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">搜索</button>
                    </div>
                </div>

            </div>
            <!-- 模态框 -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- 模态框头部 -->
                        <div class="modal-header">
                            <h4 class="modal-title">删除课程</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- 模态框主体 -->
                        <div class="modal-body">
                          确认删除
                        </div>

                        <!-- 模态框底部 -->
                        <div class="modal-footer">
                            <a :href='"/teacher/course/delete-course?cid="+delete_couresid' class="btn btn-primary">确定</a> <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        </div>

                    </div>
                </div>
            </div>
            <div v-for="item in items">
                <div class="card mt-3">
                    <div class=" bg-secondary ">
                        <div class="card-header  text-white">
                            <table class=" col-12">
                                <tr class="row">
                                    <td class="row col-6 justify-content-start">
                                        <div>[{{item.course_name}}]{{item.course_time|timeTransform}} <a
                                                class="text-primary" style="cursor: pointer;" data-toggle="modal"
                                                data-target="#myModal" @click="shanchu(item.id)">删除</a></div>
                                    </td>
                                    <td class="row col-6  justify-content-end">
                                        <a :href='"/teacher/course/details?cid="+item.id' style="float: left;">查看</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="card-body">
                        <h6 class="card-title">{{item.course_introduce}}</h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--脚本-->
    <script>

        // var data = {
        //     data: [{
        //         "collect": null, "course_content": null, "course_folder": null, "course_hour": null,
        //         "course_introduce": "用高度凝练的语言，形象表达作者丰富情感，集中反映社会生活并具有一定节奏和韵律的文学体裁。 诗歌是一种抒情言志的文学体裁。《毛诗-大序》记载：“诗者，志之所之也。在心为志，发言为诗”。南宋严羽《沧浪诗话》云：“诗者，吟咏性情也”。只有一种用言语表达的艺术就是诗歌。",
        //         "course_name": "诗歌鉴赏", "course_photo": null, "course_state": null, "course_teacher": null, "course_teacher_name": null,
        //         "course_time": "1574584083682",
        //         "id": "7", "study": null
        //     }]
        // };
        var data={data:${data}};
        var url2;
        var m = new Vue(
            {
                el: '#abc',   //这是元素
                data: {
                    items: data.data,
                    delete_couresid:'',
                },
                methods: {
                    shanchu:function(num){
                        this.delete_couresid=num;
                        console.log(num)
                    },
                    fun: function (elem) {
                        var url1 = "/course/details?cid=" + elem.currentTarget.firstElementChild.innerHTML;
                        window.location.href = location.host + url1;
                        url2 = location.host + url1;
                    }
                },
                filters: {
                    timeTransform: function (value) {
                        var str = value + "000000000000000000000000000000000000000000000000000000000000000";
                        a = new Date(Number(str.substr(0, 13)));
                        return a.getFullYear() + '年' + a.getMonth() + "月" + a.getDate();
                    }
                },

            });
    </script>

    <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
    <script src="/bootstrap-4.3.1/popper.min.js "></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>

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
</body>

</html>