<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">

<head>
    <title>创建课程</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css">
    <script src="/js/vue.js"></script>
    <script src="/wangEditor/wangEditor.js"></script>
    <script src="/js/axios.min.js"></script>
    <style>
        .tab {
            display: none
        }

        .tab-active {
            display: block
        }

        .text {
            min-height: 350px;
        }
    </style>

</head>

<body>


    <div id="app2">
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
            <div id="part1" style="display:block;">
                <h3>课程编辑</h3>
                <table>
                    <tr>
                        <td>
                            课程名：
                        </td>
                        <td>
                            <input type="text" name="" v-model="course_name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            课程介绍：
                        </td>
                        <td>
                            <input type="text" name="" v-model="course_intr">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            课程图片：
                        </td>
                        <td>
                            <div class="row">
                                <input class="btn col-6 " v-on:change="preview1" id="image" type="file">
                                <button class="btn btn-info" style="display: none;" @click="moren">使用默认</button>
                            </div>
                            <small id="fileHelpId" class="form-text text-muted">.png | jpg文件,文件小于1M,250*250</small>
                        </td>
                    </tr>
                </table>
                <img :src="imagePath1" style="width: 250px;" alt="">
                <br>
                <button id="newtpad" @click="newpae">下一步</button>
                <br>
            </div>

            <!-- 编辑章节 -->
            <div id="part2" style="display: none;">
                <div class="mt-4">编辑章节</div>
                <div v-for="(item, index) in items">
                    <hr>
                    <h3>第{{index+1}}章</h3>
                    标题：<input type="text" v-model='item.title'>
                    <button :id='"button"+item.count' class="btn btn-info"
                        @click="editContent(item.count)">编辑内容</button>
                    <!-- <button
                :id='"button1"+item.count' disabled="false">添加内容</button> -->
                    <button :id='"button2"+item.count' disabled="true" data-toggle="modal" class="btn btn-info"
                        data-target="#myModal1">添加图片</button><button :id='"button3"+item.count'
                        style="display: none;">设置图片</button>

                    <!-- <button @click="remove(index)"  style="float: right;">删除</button> -->
                    <div :id='"text"+item.count'></div>
                    <br>
                    <br>
                </div>
                <div style="display: none;">
                    <label for="title">标题</label>
                    <input type="text" id="title" class="form-control col-6" name="" placeholder="">
                </div>
                <button @click="add" class="btn btn-info">添加章节</button><button id="save" @click="save"
                    class="btn btn-info mx-4">发布</button>

                <!-- 模态框 -->
                <div class="modal fade" style="z-index: 99999;" id="myM">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- 模态框头部 -->
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- 模态框主体 -->
                            <div class="modal-body">
                                <h4>确认完成编辑并发布?</h4>
                            </div>
                            <!-- 模态框底部 -->
                            <div class="modal-footer">
                                <button class="btn btn-info" @click="publish">确定</button>
                                <button type="button" class="btn btn-secondary" id="myModal1_but1"
                                    data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mt-4">预览</div>
                <div v-for="(item, index) in items">
                    <h3>第{{index+1}}章 {{item.title}}</h3>
                    <p v-html="item.content"></p>
                </div>
                <!-- 上传图片模态框1 -->
                <div class="modal fade" style="z-index: 99999;" id="myModal1">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- 模态框头部 -->
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- 模态框主体 -->
                            <div class="modal-body">
                                <div style="width: 300px;height: 300px;">
                                    <img :src="imagePath" style="width: 300px;height: 300px;" alt="">
                                </div>
                                <div class="form-group">
                                    <input type="file" @change="preview" class="form-control-file" id="image1"
                                        pattern="" placeholder="" aria-describedby="fileHelpId">
                                    <small id="fileHelpId" class="form-text text-muted">.png |
                                        jpg文件,文件小于1M,250*250</small>
                                </div>
                                <button @click="uploads" name="" id="" class="btn btn-primary">上传并添加</button>
                            </div>
                            <!-- 模态框底部 -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" id="myModal1_but1"
                                    data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script>

        var E = window.wangEditor;
        var app2 = new Vue({
            el: "#app2",
            data: {
                count: 0,
                count1: 1,
                items: new Array(),
                // 文件相关
                imageSize: '', imageName: '', files: '', imagePath: "/img/upload.png",
                imagePath1: "/img/upload.png", imageSize1: '', imageName1: '', files1: '', course_intr: '', course_name: "",
                result: '<p>添加了图片</p>',
                edit_key: '',
                editor: new Array(),
                //编辑的课程编号
                course_id: "",
            },
            methods: {
                //发布编辑的章节
                publish: function () {
                    var formData = new FormData();
                    formData.append("course_id", this.course_id);
                    formData.append("items", JSON.stringify(app2.$data.items));
                    console.log(JSON.stringify(app2.$data.items));
                    axios.post("/teacher/course/published-content", formData)
                        .then(res => {
                            console.log(res.data);
                            if (res.data == 1) {
                                alert("发布成功")
                                $('#myM').modal('hide');
                                location.href='/teacher/course'
                            }
                        })
                        .catch(err => {
                            console.error(err);
                        })
                },
                save: function () {
                    var a = 0;
                    if (this.items.length > 0) {
                        for (let index = 0; index < this.items.length; index++) {
                            if (this.items[index].title == '') {
                                alert("第" + (index + 1) + "章的标题为空");
                                a++;
                                break;
                            }
                            if (this.items[index].content == '内容') {
                                alert("第" + (index + 1) + "章的内容未编辑");
                                a++;
                                break;
                            }
                        }

                    } else {
                        alert("未编辑")
                        return;
                    }
                    console.log("a:" + a)
                    if (a == 0) {
                        $('#myM').modal('show');
                    }
                },
                //下一步的事件
                moren: function () {
                },
                newpae: function () {
                    if (this.course_name == '') {
                        alert("未编辑课程名");
                        return;
                    }
                    if (this.course_intr == '') {
                        alert("未添加课程介绍")
                        return;
                    }
                    if (this.imagePath1 == '/img/upload.png') {
                        alert("未添加课程图片")
                        return;
                    }
                    document.getElementById("newtpad").disabled = true;
                    var formData = new FormData();
                    formData.append("course_name", this.course_name);
                    formData.append("course_intr", this.course_intr);
                    formData.append("image", this.files1);
                    formData.append("image_name", this.imageName1);
                    axios.post('/teacher/course/course-image-uqload', formData)
                        .then(res => {
                            this.course_id = res.data.course_id;

                            document.getElementById("part1").style.display = "none";
                            document.getElementById("part2").style.display = "block";
                            alert("课程创建成功！");
                        })
                        .catch(err => {
                            console.error(err);
                        })
                },
                add: function () {
                    count = this.count;
                    if (count > -1) {
                        for (var j = 0; j < count; j++) {
                            try {
                                if (document.getElementById("button" + j).disabled == false) {
                                    alert("第" + (j + 1) + "章未编辑");
                                    return;
                                }
                            } catch (error) {

                            }

                        }
                    }

                    var a = {
                        count: this.count,
                        title: document.getElementById("title").value,
                        content: "内容",
                    }
                    this.items.push(a);
                    a = this.count++;
                    this.content = a;
                },
                editContent: function (num) {
                    var editor = new E("#text" + num);
                    editor.customConfig.onchange = function (html) {
                        app2.$data.items[num].content = html;
                    };
                    editor.customConfig.menus = [
                        'head',  // 标题
                        'bold',  // 粗体
                        'fontSize',  // 字号
                        'fontName',  // 字体
                        'italic',  // 斜体
                        'underline',  // 下划线
                        'strikeThrough',  // 删除线
                        'foreColor',  // 文字颜色
                        'backColor',  // 背景颜色
                        'link',  // 插入链接
                        'list',  // 列表
                        'justify',  // 对齐方式
                        'quote',  // 引用
                        'emoticon',  // 表情
                        'image',  // 插入图片
                        'table',  // 表格
                        // 'video',  // 插入视频
                        // 'code',  // 插入代码
                        'undo',  // 撤销
                        'redo'  // 重复
                    ]
                    editor.create();
                    document.getElementById(String("button" + num)).disabled = true;
                    document.getElementById(String("button2" + num)).disabled = false;
                    // document.getElementById(String("button1" + num)).addEventListener('click', function () {
                    //     editor.txt.append('<p>追加的内容</p>');
                    //     editor.change();
                    // });
                    document.getElementById(String("button2" + num)).addEventListener('click', function () {
                        app2.$data.edit_key = "button3" + num;
                        console.log(app2.$data.edit_key);
                    })
                    document.getElementById(String("button3" + num)).addEventListener('click', function () {
                        console.log(app2.$data.result)
                        editor.txt.append(app2.$data.result);
                        editor.change();
                    }),
                        app2.$data.editor.push(editor);
                },
                addEditor: function (num) {
                    app2.$data.editor[num].txt.append('<p>追加的内容</p>');
                    app2.$data.editor[num].change();
                },
                remove: function (num) {
                    app2.$data.items.splice(num, 1);
                    app2.$data.editor.splice(num, 1);

                },
                preview: function () {
                    this.files = document.getElementById("image1").files[0];
                    var files = this.files;
                    this.imageName = files.name;
                    this.imageSize = (files.size / 1024).toFixed(0);
                    this.imagePath = this.getObjectURL(files);
                    if (this.imageSize > 1024) {
                        this.imageName = '';
                        this.imageSize = '';
                        this.imagePath = "/img/upload.png";
                        document.getElementById("image1").value = '';
                        alert("文件大于1M");
                    } else if (!this.imageName.match(/\.(png|jpg)$/)) {
                        this.imageName = '';
                        this.imageSize = '';
                        this.imagePath = "/img/upload.png";
                        document.getElementById("image1").value = '';
                        alert("文件类型不匹配");
                    };
                },
                preview1: function () {
                    this.files1 = document.getElementById("image").files[0];
                    var files1 = this.files1;
                    this.imageName1 = files1.name;
                    this.imageSize1 = (files1.size / 1024).toFixed(0);
                    this.imagePath1 = this.getObjectURL(files1);
                    if (this.imageSize1 > 1024) {
                        this.imageName1 = '';
                        this.imageSize1 = '';
                        this.imagePath = "/img/upload.png";
                        document.getElementById("image").value = '';
                        alert("文件大于1M");
                    } else if (!this.imageName1.match(/\.(png|jpg)$/)) {
                        this.imageName1 = '';
                        this.imageSize1 = '';
                        this.imagePath1 = "/img/upload.png";
                        document.getElementById("image").value = '';
                        alert("文件类型不匹配");
                    };
                },
                getObjectURL(file) {
                    let url = null;
                    if (window.createObjectURL != undefined) { // basic
                        url = window.createObjectURL(file);
                    } else if (window.webkitURL != undefined) { // webkit or chrome
                        url = window.webkitURL.createObjectURL(file);
                    } else if (window.URL != undefined) { // mozilla(firefox)
                        url = window.URL.createObjectURL(file);
                    }
                    return url;
                },
                uploads1: function () {
                    if (this.imageSize1 > 1024) {
                        this.imageName1 = '';
                        this.imageSize1 = '';
                        this.imagePath = "/img/upload.png";
                        document.getElementById("image").value = '';
                        alert("文件大于1M");
                        return false;
                    } else if (!this.imageName1.match(/\.(png|jpg)$/)) {
                        this.imageName1 = '';
                        this.imageSize1 = '';
                        this.imagePath = "/img/upload.png";
                        document.getElementById("image").value = '';
                        alert("文件类型不匹配");
                        return false;
                    };
                    var formData = new FormData;
                    formData.append("image", this.files1);
                    axios.post("/persion/upload", formData)
                        .then(res => {
                            alert("上传成功");

                        })
                        .catch(err => {
                            console.log("错误")
                            this.chufaEv;

                        })
                },
                uploads: function () {
                    if (this.imageSize > 1024) {
                        this.imageName = '';
                        this.imageSize = '';
                        this.imagePath = "/img/upload.png";
                        document.getElementById("image1").value = '';
                        alert("文件大于1M");
                        return false;
                    } else if (!this.imageName.match(/\.(png|jpg)$/)) {
                        this.imageName = '';
                        this.imageSize = '';
                        this.imagePath = "/img/upload.png";
                        document.getElementById("image1").value = '';
                        alert("文件类型不匹配");
                        return false;
                    };
                    var formData = new FormData;
                    formData.append("image", this.files);
                    formData.append("imageName", this.imageName);
                    formData.append("course_id", this.course_id);
                    // formData.append("course_id", "105");
                    // 上传代码
                    axios.post("/teacher/course/course-image-uqload1", formData)
                        .then(res => {
                            alert("上传成功");
                            app2.$data.result = res.data;
                            console.log("图片" + app2.$data.result)
                            var clickEvent = document.createEvent('MouseEvent'); // 1.创建一个鼠标事件类型
                            clickEvent.initMouseEvent('click', true, true); // 2.初始化一个click事件
                            console.log("按钮" + app2.$data.edit_key)
                            document.getElementById(app2.$data.edit_key).dispatchEvent(clickEvent); // 3.派发(触发)
                            console.log('值' + app2.$data.edit_key);
                            alert("插入成功");
                            $('#myModal1').modal('hide');

                        })
                        .catch(err => {
                            console.log("错误")
                        })
                },
            },
        });
    </script>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js"></script>
    <script src="/bootstrap-4.3.1/popper.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
</body>

</html>