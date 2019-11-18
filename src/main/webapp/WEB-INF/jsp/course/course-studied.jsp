<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
  <title>已学习的课程页面</title>
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
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
              aria-controls="collapsibleNavId" aria-expanded="true" aria-label="Toggle navigation">
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
    <nav class="navbar-nav fixed-bottom " style="color: white;background: #000;height: 50px; ">
      <div style="position: absolute;top:15px;left:45%; ">&copy;2019</div>
    </nav>
    <div id="abc">
      <!--课程页面-->
      <div class="container-fluid mt-lg-4">
        <div class="row">
        <!--列表区-->
          <div class="list-group col-lg-2 col-sm-2 my-3">
            <a href="/course/allcourse" class="list-group-item list-group-item-action">
              所有课程
            </a>
            <a href="/course/studying" class="list-group-item list-group-item-action ">正在学习</a>
            <a href="/course/collect" class="list-group-item list-group-item-action ">我的收藏</a>
            <a href="/course/studied" class="list-group-item list-group-item-action active">学习完成</a>
          </div>
          <!--课程区-->
          <div class=" col-lg-8 mt-4 col-sm-8 ">
              <div class="input-group col-lg-5">
                  <input type="text" class=" form-control" placeholder="搜索课程" aria-describedby="button-addon2">
                  <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">搜索</button>
                  </div>
                </div>
            <v-card v-for="item in site" v-on:fun="fun" v-bind:subject="item"></v-card>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!--脚本-->
  <script>

    Vue.component(
      'v-card',
      {
        props: ['subject'],
        template: `
        <a :href="'/course/details?cid='+subject.id" class="panel  alert-success row py-1 my-2" >
			<div class="row   col-12">
            <div style="display: none;">{{subject.id}}</div>
        	  <div class="ml-3   .u-img mr-3"
            v-bind:style="{'background-image':'url('+subject.course_photo+')','background-repeat':'no-repeat','width': '90px','height': '90px','background-size':'100% 100%'}">
            </div>
            
            <table class="mt-3 col-4  ">
              <tr>
                <div class="  css2">{{subject.course_name}}</div>
              </tr>
              <tr>
                <div class="  card-blockquote">{{subject.course_teacher_name}}</div>
              </tr>
            </table>
			 <a :href="'/course/details-continue?cid='+subject.id" class="btn col-3 offset-1 u-font mt-4 mb-4" style="background: rgb(101, 147, 74);">复习</a>
      </div>
          </a>
              `
      })
    var data = { site: ${ json }};
    var m = new Vue(
      {
        el: '#abc',   //这是元素
        data: data,
        methods: {
          fun: function (elem) {
            var url1 = "/course/details?cid=" + elem.currentTarget.firstElementChild.innerHTML;
            window.location.href = location.host + url1;
            url2 = location.host + url1;
          }
        },
      }
    )
  </script>
  <nav class="navbar-nav fixed-bottom " style="color: white;background: #000;height: 50px; ">
    <div style="position: absolute;top:15px;left:45%; ">&copy;2019</div>
  </nav>
  <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
  <script src="/bootstrap-4.3.1/popper.min.js "></script>
  <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>
</body>

</html>