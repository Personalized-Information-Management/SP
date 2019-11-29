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
  <!--个人信息页面部分-->

  <div id="abc" class="container mr-auto mt-lg-2 mt-sm-2 col-lg-8 col-sm-8 bg-light">
    <form action="/teacher/persion/edit" method="post">
      <div class="form-group">
        <label for="exampleInputname">账号</label>
        <input disabled="disabled" v-model="data.id" type="text" class="form-control">
        <input v-model="data.id" name="id" type="text" style="display: none;">
      </div>
      <div class="form-group">
        <label for="exampleInputname">姓名</label>
        <input v-model="data.teacher_name" name="teacher_name"  type="text" class="form-control">
      </div>
      <div class="form-group">
        <label for="exampleInputname">性别</label>

        <select class="form-control" v-model="data.teacher_sex"  name="teacher_sex">
          <option value="男">男</option>
          <option value="女">女</option>
        </select>
      </div>

      <div class="form-group">
        <label for="exampleInputphone">联系电话</label>
        <input v-model="data.teacher_phone" type="number"  class="form-control" name="teacher_phone"
          pattern="[0-9]*" title="仅数字">
      </div>

      <div class="form-group">
        <div class="form-group">
          <label for="exampleInputname">学院</label>
          <input v-model="data.teacher_coll" type="text" class="form-control" name="teacher_coll">
        </div>
      </div>

      <div class="form-group">
        <div class="form-group">
          <label for="exampleInputname">职称</label>
          <input v-model="data.teacher_rank" type="text"  class="form-control" name="teacher_rank">
        </div>
      </div>
      <br>
      <button type="submit" class="btn btn-primary">保存修改</button>
    </form>
  </div>
  <br>
  <!--脚本-->
  <script>
    var data = {data:${data}};
    // var data = { data: { "courses": null, "id": "1", "teacher_birth": null, "teacher_coll": "理学院", "teacher_name": "赵六", "teacher_per": null, "teacher_phone": "1234", "teacher_photo": "1234", "teacher_rank": "讲师", "teacher_sex": "男" } };
    var app = new Vue({
      el: '#abc',
      data: {
        data:data.data
      },
      methods: {
        fun1: function () {
          this.data = data1;
        }
      },
    });
  </script>


  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
  <script src="/bootstrap-4.3.1/popper.min.js "></script>
  <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>
</body>

</html>