<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
  <title>个人信息</title>
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
          <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
            aria-controls="collapsibleNavId" aria-expanded="true" aria-label="Toggle navigation">
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
  <!--个人信息页面部分-->

  <div id="abc" class="container mr-auto mt-lg-2 mt-sm-2 col-lg-8 col-sm-8 bg-light">
    <div class="form-group">
      <label for="exampleInputname">账号</label>
      <input disabled="disabled" v-model="id" type="text" class="form-control">
    </div>
    <div class="form-group">
      <label for="exampleInputname">原密码</label>
      <input v-model="old_pwd" name="old_pwd" type="password" class="form-control">
    </div>
    <div class="form-group">
      <label for="exampleInputname">新密码</label>
      <input v-model="new_pwd" name="new_pwd" type="password" class="form-control">
    </div>

    <div class="form-group">
      <label for="exampleInputname">请重复新密码</label>
      <input v-model="renew_pwd" name="renew_pwd" type="password" class="form-control">
    </div>
    <button id="save" class="btn btn-primary" onclick="save()" onsubmit="return false;">确认修改</button>

  </div>

  <br>
  <!--脚本-->
  <script>
    var id = ${ id };
    // var id = "1";
    var app = new Vue({
      el: '#abc',
      data: {
        id: id,
        old_pwd: '',
        new_pwd: '',
        renew_pwd: '',
      },
      methods: {
      },
    });
    function save() {
      document.getElementById("save").disabled = true;
      if (app.$data.old_pwd == '') {
        alert("原密码为空！");
        document.getElementById("save").disabled = false;
        return;
      }
      if (app.$data.new_pwd == '') {
        alert("请输入新密码！");
        document.getElementById("save").disabled = false;
        return;
      }
      if (app.$data.renew_pwd != app.$data.renew_pwd) {
        alert("请重新输入新密码！");
        document.getElementById("save").disabled = false;
        return;
      }
      if (app.$data.new_pwd != app.$data.renew_pwd) {
        alert("两次输入密码不一样！");
        document.getElementById("save").disabled = false;
        return;
      }
      var forDate = new FormData();
      forDate.append("id", app.$data.id);
      forDate.append("old_pwd", app.$data.old_pwd);
      forDate.append("renew_pwd", app.$data.renew_pwd);
      axios.post("http://localhost:8080//teacher/persion/edit-pwd-req", forDate)
        .then(res => {
          console.log(res.data.err);
          if (res.data.err == "true") {
            document.getElementById("save").disabled = false;
            alert(res.data.data);
            location.href = "/teacher/zhuye"
          } else {
            document.getElementById("save").disabled = false;
            alert(res.data.data);
          }
        })
        .catch(err => {
          console.error(err);
        })
    }
  </script>


  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
  <script src="/bootstrap-4.3.1/popper.min.js "></script>
  <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>
</body>

</html>