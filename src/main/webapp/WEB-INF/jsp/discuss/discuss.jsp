<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>讨论区</title>
  <!-- Required meta tags -->
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
    .box {
      border: 1px solid red;
    }

    .flo {
      display: block;
      float: right;
    }

    .wang-col-1 {
      display: inline;
    }

    .wang-col-2 {
      display: none;
    }


    @media(max-width: 576px) {
      .wang-col-1 {
        display: none;
      }

      .wang-col-2 {
        display: inline;
      }
    }
  </style>
</head>

<body>
  <!-- 导航栏 -->
  <div>
    <div class="container">
      <br>
      <a href="/zhuye">
        <p><i><strong>个性化学习平台</strong></i></p>
      </a>
    </div>
    <div class="container-fluid bg-info text-white">
      <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-info text-white">
          <a class="navbar-brand">&nbsp;</a>
          <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
            aria-controls="collapsibleNavId" aria-expanded="true" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="navbar-collapse collapse show" id="collapsibleNavId">
            <div class="container ">
              <ul class="navbar-nav mr-auto row mt-2 mt-lg-0">
                <li class="nav-item active">
                  <a class="nav-link" href="/zhuye">主页</a>
                </li>
                <li>
                  <a class="nav-link" href="/course">课程</a>
                </li>
                <li>
                  <a class="nav-link" href="#">作业</a>
                </li>
                <li>
                  <a class="nav-link" href="#">成长</a>
                </li>
                <li>
                  <a class="nav-link" href="#">教师通知</a>
                </li>
                <li>
                  <a class="nav-link" href="#">讨论区</a>
                </li>
                <li>
                  <a class="nav-link" href="#">活动</a>
                </li>
                <li>
                  <a class="nav-link" href="/logins">切换账号</a>
                </li>
                <li>
                  <a class="nav-link " href="/logout">退出登录</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </div>
  </div>

  <div id="app" class="container">
    <div class="row">
      <!-- 个人信息 -->
      <table class="col-sm-2 wang-col-1 offset-1">
        <tbody>
          <tr>
            <td class="flo">
              <img :src="seudent_photo" onerror="javascript:this.src='/images/student/1.png'"
                class="mr-0 rounded-circle" style="width: 60px; height: 60px;">
            </td>
          </tr>
          <tr>
            <td class="flo">
              <div class="">姓名：{{student_name}}</div>
            </td>
          </tr>
          <tr>
            <td class="flo">
              <p class="">账号：{{id}}</p>
            </td>
          </tr>
        </tbody>
      </table>
      <!-- 搜索栏 -->
      <div class="col-sm-9 wang-col-1">
        <br>
        <br>
        <div class="row  justify-content-center">
          <input type="text" class="input-medium col-sm-8 search-query">
          <button class="btn btn-primary mx-2">搜索</button>
          <img data-toggle="modal" data-target="#myModal" src="/img/addnote.png" width="40px"
            class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}" alt="">
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-3 ">
        <table class="col-0 col-sm-12 wang-col-1">
          <tbody>
            <tr>
              <td class="row justify-content-end ">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item active"><img src="/img/课程.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">收件箱&nbsp;&nbsp;&nbsp;</a></li>
                </ol>
              </td>
            </tr>
            <tr>
              <td class="row justify-content-end ">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item active"><img src="/img/作业1.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">课程讨论</a></li>
                </ol>
              </td>
            </tr>
            <tr>
              <td class="row justify-content-end ">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item active"><img src="/img/教师.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">回复我的</a></li>
                </ol>
              </td>
            </tr>
            <tr>
              <td class="row justify-content-end ">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item active  "><img src="/img/课程.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">我发表的</a></li>
                </ol>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 当屏幕宽度小于576px时显示 -->
      <div class="wang-col-2">
        <table class="offset-3">
          <tbody>
            <tr>
              <td class="">
                <img :src="seudent_photo" onerror="javascript:this.src='/images/student/1.png'" class="mr-0 "
                  class="mr-0 rounded-circle" style="width: 60px; height: 60px;">

              </td>
            </tr>
            <tr>
              <td class="flo">
                <div class="">姓名：{{student_name}}</div>
              </td>
            </tr>
            <tr>
              <td class="flo">
                <p class="">账号：{{id}}</p>
              </td>
            </tr>
          </tbody>
        </table>

        <!-- 链接 -->
        <table class="offset-1 col-12">
          <tbody>
            <tr>
              <td class="row col-12 justify-content-end ">
                <ol class="breadcrumb col-12">
                  <li class="breadcrumb-item active"><img src="/img/课程.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">收件箱&nbsp;&nbsp;&nbsp;</a></li>
                </ol>
              </td>
            </tr>
            <tr>
              <td class="row col-12 justify-content-end ">
                <ol class="breadcrumb col-12">
                  <li class="breadcrumb-item active"><img src="/img/作业1.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">课程讨论</a></li>
                </ol>
              </td>
            </tr>
            <tr>
              <td class="row col-12 justify-content-end ">
                <ol class="breadcrumb col-12">
                  <li class="breadcrumb-item active"><img src="/img/教师.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">回复我的</a></li>
                </ol>
              </td>
            </tr>
            <tr>
              <td class="row col-12 justify-content-end ">
                <ol class="breadcrumb col-12">
                  <li class="breadcrumb-item active  "><img src="/img/课程.png"
                      class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}"
                      alt="" style="width: 30px; height: 30px;"></li>
                  <li class="breadcrumb-item"><a href="#">我发表的</a></li>
                </ol>
              </td>
            </tr>
          </tbody>
        </table>
        <!-- 搜索栏 -->
        <div class="row offset-1 mt-1">
          <input type="text" class="input-medium search-query">
          <button class="btn btn-primary mx-2">搜索</button>
          <img src="/img/addnote.png" width="40px"
            class="img-fluid \${3|rounded-top,rounded-right,rounded-bottom,rounded-left,rounded-circle,|}" alt="">
        </div>
      </div>

      <!-- 段子区 -->
      <div class=" col-sm-9">
        <!-- 一条用户信息 -->
        <div v-for="item in items">
          <div class="card">
            <div class="card-header">
              <table>
                <tr>
                  <td>
                    <img :src="item.author_photo" onerror="javascript:this.src='/images/student/1.png'" alt="John Doe"
                      class="rounded-circle mr-3 " style="width: 60px; height: 60px;border-radius: 1px soild red;">
                  </td>
                  <td>
                    <table>
                      <tr>
                        <td>
                          <div>{{item.author_name}}</div>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <small>{{item.dis_time|timeTransform}}</small>
                        </td>
                      </tr>
                    </table>
                  </td>
                  <td>
                    <a href="/dis/delete"><span v-if="item.dis_auto==id&&student_per==item.dis_per" @click="deleteItem"
                        class="col-6">删除</span></a>
                    <div style="display: none;">{{item.id}}</div>
                  </td>
                </tr>
              </table>
            </div>
            <div class="card-body">
              <div data-mrc>
                <h5 class="card-title" v-html="item.dis_title"></h5>
                <p class="card-text" v-html="item.dis_content"></p>
              </div>
            </div>
            <div class="card-footer text-muted">
              <div class="row">
                <div class="col-sm-xs-10">
                </div>
                <div class="col-sm-xs-1">
                  <img src="/img/点赞1.png" alt="dianzan" class="mr-3 " style="width: 30px; height: 30px;">
                </div>
                <div class="col-sm-xs-1">
                  <img src="/img/讨论区1.png" alt="comment" class="mr-3 " style="width: 30px; height: 30px;">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
    //讨论区内容
    var data = ${ json };
    //学生内容
    var student = ${ json1 };
    var app = new Vue({
      el: "#app",
      data: {
        items: data,
        student_name: student.student_name,
        id: student.id,
        seudent_photo: student.seudent_photo,
        student_per: student.student_per,
      },
      filters: {
        timeTransform: function (value) {
          var str = value + "000000000000000000000000000000000000000000000000000000000000000";
          a = new Date(Number(str.substr(0, 13)));
          return a.getFullYear() + '年' + a.getMonth() + "月" + a.getDate() + " " + a.getHours() + ":" + a.getMinutes();
        }
      },
      methods: {
        deleteItem: function () {

        }
      }
    })
  </script>
  <!-- 模态框 -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <!-- 模态框头部 -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <!-- 模态框主体 -->
        <div class="modal-body">
          <div id="app1" class="container">
            <div class="form-group">
              <small id="helpId" class="form-text text-muted">标题</small>
              <input type="text" class="form-control" v-model="title" name="" id="" aria-describedby="helpId"
                placeholder="">
            </div>
            <small id="helpId" class="form-text text-muted">正文</small>
            <div id="editor"></div>
            <button @click="publish" class="btn mt-2 bg-primary "> 发布</button>
            <button class="btn mt-2 bg-primary " onclick="editor.txt.clear();">清空</button>
          </div>
        </div>
        <!-- 模态框底部 -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
        </div>
      </div>
    </div>
  </div>
  <script>
    var data = { title: '', html: '', content: '' };
    var app = new Vue({
      el: '#app1',
      data: data,
      methods: {
        publish: function () {
          if (this.title == '') {
            alert("标题不能为空");
            return 0;
          }
          this.content = editor.txt.text();
          if (this.content == '') {
            alert("内容不能为空");
            return 0;
          }
          var formdata = new FormData();
          formdata.append("title", this.title);
          this.html = editor.txt.html();
          formdata.append("html", this.html);
          axios.post("/dis/publish", formdata)
            .then(res => {
              console.log(res.data);
              if (res.error != 0) {
                alert("发布成功！");
              } else {
                alter("发布成功！")
              }
              location.reload();
            })
            .catch(err => {
              alert("发布失败!");
            })
        }
      },
    })
  </script>
  <script src="/wangEditor/wangEditor.js"></script>
  <script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E(document.getElementById('editor'))
    //创建之前自定义视图
    editor.customConfig.menus = [
      'bold',  // 粗体
      'italic',  // 斜体
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
    editor.customConfig.emotions = [
      {
        // tab 的标题
        title: 'emoji',
        // type -> 'emoji' / 'image'
        type: 'emoji',
        // content -> 数组
        content: ['😀', '😃', '😄', '😁', '😆', '😀', '😁', '😂', '🤣', '😃', '😄', '😅', '😆', '😉', '😊', '😋', '😎', '😍', '😘', '😗', '😙', '😚', '🙂', '🤗', '🤩', '🤔', '🤨', '😐', '😑', '😶', '🙄', '😏', '😀', '😃', '😄', '😁', '😆', '😀', '😁', '😂', '🤣', '😃', '😄', '😅', '😆', '😉', '😊', '😋', '😎', '😍', '😘', '😗', '😙', '😚', '🙂', '🤗', '🤩', '🤔', '🤨', '😐', '😑', '😶', '🙄', '😏', '😀', '😃', '😄', '😁', '😆', '😀', '😁', '😂', '🤣', '😃', '😄', '😅', '😆', '😉', '😊', '😋', '😎', '😍', '😘', '😗', '😙', '😚', '🙂', '🤗', '🤩', '🤔', '🤨', '😐', '😑', '😶', '🙄', '😏', '😀', '😃', '😄', '😁', '😆', '😀', '😁', '😂', '🤣', '😃', '😄', '😅', '😆', '😉', '😊', '😋', '😎', '😍', '😘', '😗', '😙', '😚', '🙂', '🤗', '🤩', '🤔', '🤨', '😐', '😑', '😶', '🙄', '😏', '😀', '😃', '😄', '😁', '😆', '😀', '😁', '😂', '🤣', '😃', '😄', '😅', '😆', '😉', '😊', '😋', '😎', '😍', '😘', '😗', '😙', '😚', '🙂', '🤗', '🤩', '🤔', '🤨', '😐', '😑', '😶', '🙄', '😏']
      }
    ];
    editor.create();
    editor.customConfig.pasteIgnoreImg = false;
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
      });
    });
  </script>
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="/bootstrap-4.3.1/popper.min.js "></script>
  <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>


  </div>
</body>

</html>