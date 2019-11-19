<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!doctype html>
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
            <br>
            <a href="http://localhost:8080/zhuye">
                <p><i><strong>个性化学习平台</strong></i></p>
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

            <div v-for="item in items">
                <div class="card mt-3">
                    <div class=" bg-secondary ">
                        <div class="card-header  text-white">
                            <table class=" col-12">
                                <tr class="row">
                                    <td class="row col-6 justify-content-start">
                                        <div>{{item.course_name}}</div>
                                    </td>
                                    <td class="row col-6  justify-content-end">
                                        <a :href='"#1"' style="float: left;">查看</a>
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

        var data = ${json};
        var url2;
        var m = new Vue(
            {
                el: '#abc',   //这是元素
                data: {
                    items: data,
                },
                methods: {
                    fun: function (elem) {
                        var url1 = "/course/details?cid=" + elem.currentTarget.firstElementChild.innerHTML;
                        window.location.href = location.host + url1;
                        url2 = location.host + url1;
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