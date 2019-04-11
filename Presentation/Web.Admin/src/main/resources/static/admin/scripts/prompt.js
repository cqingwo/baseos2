$(function () {

    var timer = $("#timer"); //获取ID为timer的对象
    timer.html(time); //初始化显示秒数
    time = time - 1;
    var g = window.setInterval(function () {
        if (time <= 0) {
            window.clearTimeout(g); //清除动画
            window.location.href = backUrl; //跳转到指定地址
            //window.history.back(-1); //后退
        } else {
            showTime();
        }
    }, 1000);

    //显示函数
    function showTime() {
        timer.html(time);
        time--;
    }
})