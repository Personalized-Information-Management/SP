<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
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
    <script src="/js/axios.min.js"></script>

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
                    <a href="/teacher/course/notice-course" class="list-group-item list-group-item-action active">
                        已发布课程
                    </a>
                    <a href="/teacher/course/notice" class="list-group-item list-group-item-action ">
                        已发布通知
                    </a>
                </div>
                <div class="col-9 mt-4">
                    <div v-for="(item, index) in items">
                        <div class="card mt-3">
                            <a :href='"/teacher/course/notice/details?cid="+item.id'>
                                <div class="card-body">
                                    <div>[{{item.course_name}}]{{item.course_time|timeTransform}}</div>
                                </div>
                            </a>
                            <div class="card-footer text-muted">
                                <button class="btn mt-2 bg-primary" data-toggle="modal" data-target="#myModal"
                                    @click="bianji(item.id)">编辑通知</button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- 模态框 -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- 模态框头部 -->
                    <div class="modal-header">
                        <small id="helpId" class="form-text text-muted">通知内容</small>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- 模态框主体 -->
                    <div class="modal-body">
                        <div id="app1" class="container">
                            <div id="div1" style="height: 340px;"></div>
                            <button class="btn mt-2 bg-primary" @click="fabu"> 发布</button>
                            <button class="btn mt-2 bg-primary" onclick="qingkong()">清空</button>
                        </div>
                    </div>
                    <!-- 模态框底部 -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/wangEditor/wangEditor.js"></script>
    <script>

        var data = { data: ${ data }};
        // var data = { data: [{ "collect": null, "course_content": null, "course_folder": null, "course_hour": null, "course_introduce": "用高度凝练的语言，形象表达作者丰富情感，集中反映社会生活并具有一定节奏和韵律的文学体裁。 诗歌是一种抒情言志的文学体裁。《毛诗-大序》记载：“诗者，志之所之也。在心为志，发言为诗”。南宋严羽《沧浪诗话》云：“诗者，吟咏性情也”。只有一种用言语表达的艺术就是诗歌。", "course_name": "诗歌鉴赏", "course_photo": null, "course_state": null, "course_teacher": null, "course_teacher_name": null, "course_time": "1574584083682", "id": "1", "notices": null, "study": null }, { "collect": null, "course_content": null, "course_folder": null, "course_hour": null, "course_introduce": "用高度凝练的语言，形象表达作者丰富情感，集中反映社会生活并具有一定节奏和韵律的文学体裁。 诗歌是一种抒情言志的文学体裁。《毛诗-大序》记载：“诗者，志之所之也。在心为志，发言为诗”。南宋严羽《沧浪诗话》云：“诗者，吟咏性情也”。只有一种用言语表达的艺术就是诗歌。", "course_name": "诗词鉴赏", "course_photo": null, "course_state": null, "course_teacher": null, "course_teacher_name": null, "course_time": "1574584083682", "id": "2", "notices": null, "study": null }, { "collect": null, "course_content": null, "course_folder": null, "course_hour": null, "course_introduce": "用高度凝练的语言，形象表达作者丰富情感，集中反映社会生活并具有一定节奏和韵律的文学体裁。 诗歌是一种抒情言志的文学体裁。《毛诗-大序》记载：“诗者，志之所之也。在心为志，发言为诗”。南宋严羽《沧浪诗话》云：“诗者，吟咏性情也”。只有一种用言语表达的艺术就是诗歌。", "course_name": "诗词鉴赏", "course_photo": null, "course_state": null, "course_teacher": null, "course_teacher_name": null, "course_time": "1574584083682", "id": "3", "notices": null, "study": null }] };
        var app = new Vue({
            el: '#app',
            data: {
                items: data.data,
                content: '',
                course_id: '',

            },
            methods: {
                //b编辑通知
                bianji: function (id) {
                    //设置编辑的课程id
                    this.course_id = id;
                    editor.txt.clear();
                },
                fabu: function () {
                    if (this.content == '') {
                        alert("通知内容为空");
                        return;
                    };
                    var formDate = new FormData();
                    formDate.append("content", this.content);
                    formDate.append("course_id", this.course_id);

                    axios.post("/teacher/course/notice-publish", formDate)
                        .then(res => {
                            console.log(res.data);
                            alert("发布成功");
                            location.href="/teacher/course/notice-course";
                        })
                        .catch(err => {
                            console.error(err);
                        })
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
        var E = window.wangEditor;
        var editor = new E('#div1')
        //创建之前自定义视图
        editor.customConfig.menus = [
            'bold',  // 粗体
            'underline',  // 下划线
            'strikeThrough',  // 删除线
            'foreColor',  // 文字颜色
            'backColor',  // 背景颜色
            'link',  // 插入链接
            'list',  // 列表
            'justify',  // 对齐方式
            'emoticon',  // 表情
            'undo',  // 撤销
            'redo'  // 重复
        ];
        editor.customConfig.onchange = function (html) {
            // html 即变化之后的内容
            app.$data.content = html
        }
        editor.create();
        function qingkong() {
            editor.txt.clear()
        }
    </script>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
    <script src="/bootstrap-4.3.1/popper.min.js "></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>
</body>

</html>