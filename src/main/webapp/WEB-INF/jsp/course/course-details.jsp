<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
  <title>课程详细页面</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="/vue/vue.js"></script>
  <script src="/vue/vue-router.js"></script>
</head>

<body>
  <div class="card text-center">
    <div class="card-header">
      <ul class="nav nav-pills card-header-pills">
        <li class="nav-item">
          <a class="nav-link active" href="#">返回</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">课程详细信息</a>
        </li>
      </ul>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-2 col-sm-0">

    </div>
      <div id="introduction" class="col-lg-5 col-sm-12">
        <div class="card">
          <img src="holder.js/100x180/" alt="">
          <div class="card-body">
            <div class="row">
              <div class="col-lg-4">

                <img v-bind:src="course_photo" style="width: 250px;" alt="">
              </div>
              <div class="col-lg-3">
                <h5>{{course_name}}</h5>
                <p>{{course_teacher_name}}</p>
                <p style="font-size: 10px;">学习人数：{{study}}
                  <!--input type="text" disabled="disabled" style="width: 70px;"-->
                </p>
              </div>
              <div class="col-lg-2">

              </div>
              <div class="col-lg-3">
                <button type="button" class="btn btn-primary">加入+</button><br>
                <br>
                <p style="font-size: 10px;">创建时间：{{course_time}}
                  <!--br><input type="text" disabled="disabled" style="width: 70px;"-->
                  <br><br>收藏人数：{{collect}}
                  <!--br><input type="number" disabled="disabled" style="width: 70px;"-->
                  <button type="button" class="btn btn-outline-danger btn-sm">☆</button>
                </p>
              </div>
            </div>
          </div>
        </div>

        <div id="lessondiscribe" class="jumbotron">
          <h5 class="lead">课程简介</h5>
          <hr class="my-2">
          <p>{{course_introduce}}</p>
        </div>
      </div>
      <div class="container">
        <div id="app">
          <p class="offset-4">
            <!-- 使用 router-link 组件来导航. -->
            <!-- 通过传入 `to` 属性指定链接. -->
            <!-- <router-link> 默认会被渲染成一个 `<a>` 标签 -->
            <router-link to="/foo">课程讨论</router-link>
            <router-link to="/bar">课程评价</router-link>
          </p>
          <!-- 路由出口 -->
          <!-- 路由匹配到的组件将渲染在这里 -->
          <router-view></router-view>
        </div>


      </div>

    <div id="subject" class="col-lg-3">
      <v-project v-for="s in artic" v-bind:sub="s">
      </v-project>
    </div>
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>


  <!--脚本-->
  <script>

    //课程内容展示框架
    Vue.component('v-project',
      {
        props: ['sub'],
        template:
          `
            <div>
              <div class="card">
                <div class ="card-body">
                  <h4 class="card-title">{{sub.title}}</h4>
                  <p class="card-text">{{sub.discribe}}</p>
                  
                </div>
              </div>
            </div>
          `
      }
    );
    var data = ${ json };
    new Vue({
      el: '#introduction',
      data: data,
    });





    new Vue({
      el: '#subject',
      data: {
        artic: [
          { title: '第一章', discribe: '这是简介' },
          { title: '第二章', discribe: '这是简介' },
          { title: '第三章', discribe: '这是简介' },
          { title: '第四章', discribe: '这是简介' },
        ],
      },
    });

    // 0. 如果使用模块化机制编程，导入Vue和VueRouter，要调用 Vue.use(VueRouter)

    // 1. 定义 (路由) 组件。
    // 可以从其他文件 import 进来
    const Foo = {
      template: `<counter></counter>`
    }
    const Bar = {
      data: function () {
        return {
          comment: ['e', 'f', 'g']
        }
      },
      mounted() {
        this.comment = ['评价1', '评价2', '评价3']
      },
      methods: {
        add: function () {
          console.log('add' + this.info);
          //网络请求
          this.comment.push(this.info);
        },
      },
      template: `
            <div>
              <div v-for="com in comment" class="card">
                <img class="card-img-top" src="holder.js/100x180/" alt="">
                <div class="card-body">
                  <p class="card-text">{{com}}</p>
                </div>
              </div>
              <hr>
              <label for="">我要评论:</label>
                <div class="form-group">
                    <input 
                        v-model="info"
                        type="text"
                        class="form-control">
                </div>
                <!--按钮-->
                <button @click="add()" type="button" class="btn btn-primary">评论</button>
            </div>
          `
    }

    Vue.component('counter', {
      data: function () {
        return {
          discuss: ['a', 'b', 'c']
        }
      },
      mounted() {
        this.discuss = ['讨论1', '讨论2', '讨论3'];
      },
      template: `
            <div>
              <div  v-for="dis in discuss" class="card">
                <div class="card-body">
                  <p class="card-title">{{dis}}</p>
                </div>
              </div>
            </div>
          `,

    })

    // 2. 定义路由
    // 每个路由应该映射一个组件。 其中"component" 可以是
    // 通过 Vue.extend() 创建的组件构造器，
    // 或者，只是一个组件配置对象。
    // 我们晚点再讨论嵌套路由。
    const routes = [{
      path: '/foo',
      component: Foo
    },
    {
      path: '/bar',
      component: Bar
    },
    ]

    // 3. 创建 router 实例，然后传 `routes` 配置
    // 你还可以传别的配置参数, 不过先这么简单着吧。
    const router = new VueRouter({
      routes // (缩写) 相当于 routes: routes
    })

    // 4. 创建和挂载根实例。
    // 记得要通过 router 配置参数注入路由，
    // 从而让整个应用都有路由功能
    const app = new Vue({
      router
    }).$mount('#app')

      // 现在，应用已经启动了！
  </script>

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