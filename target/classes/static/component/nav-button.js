var runoob = {
  template: `
    <nav  class="navbar-nav fixed-bottom" style="color: white;background: #000;height: 50px;position: none;">
<div style="position: absolute;top:15px;left:45%; ">&copy;2019</div>
</nav>
    `
}
window.onload = function () {
  document.getElementById("a1").style.position = "absolute";
  if (document.body.clientHeight+50 > window.innerHeight) {
    document.getElementById("a1").style.position = "relative";
  } else {
    document.getElementById("a1").style.position = "none";
  }
}

{/* <nav class="navbar-nav fixed-bottom" id="a1" style="color: white;background: #000;height: 50px;position: null; ">
    <div style="position: absolute;top:15px;left:45%; ">©2019</div>
  </nav> */}