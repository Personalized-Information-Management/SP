<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><html lang="en">

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
        <a href="#top" style="position: fixed;bottom: 20px;right: 100px;">返回顶部</a>
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
          <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
            aria-controls="collapsibleNavId" aria-expanded="true" aria-label="Toggle navigation">
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


        <!-- 课程展示 -->
        <div class="container">
            <div><a name="top"></a> 章节</div>

            <div v-for="(item, index) in data">
                <h3>
                    <div><a :href='"#"+index'> 第{{index+1}}章|{{item.title}}</a></div>
                </h3>
            </div>
            <hr>
            <br>
           
            <div v-for="(item, index) in data">
                <h3>
                    <div><a :name="index"></a> 第{{index+1}}章|{{item.title}}</div>
                </h3>
                <div v-html="item.content"></div>
            </div>



        </div>
    </div>
    <script>
        var data = { data: ${data} };
        var content = JSON.parse(data.data.course_content);
        var app = new Vue({
            el: "#app",
            data: {
                data: content,

            }
        });
    </script>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/bootstrap-4.3.1/jquery-3.3.1.slim.min.js "></script>
    <script src="/bootstrap-4.3.1/popper.min.js "></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js "></script>

</body>

</html>