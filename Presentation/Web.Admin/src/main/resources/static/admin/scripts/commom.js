__CreateJSPath = function (js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}


document.write('<script src="/components/jbox/jquery.jBox-2.3.min.js"></sc' + 'ript>');
document.write('<link href="/components/jbox/Skins/Default/jbox.css"/>');


var bootPATH = __CreateJSPath("jquery.jcarousellite.js");





$(function () {
    //bootPATH = __CreateJSPath("jquery.jcarousellite.js");

    $(".panel-heading").click(function (e) {
        /*切换折叠指示图标*/
        $(this).find("i.right").toggleClass("icon-caretdown");
        $(this).find("i.right").toggleClass("icon-caretright");
    });
    $("#main").css("height", ($(document).height() - 120) + "px");
    $("#leftMenu").css("height", ($(document).height() - 120) + "px");
    $(document).resize(function () {
        $("#main").css("height", ($(document).height() - 120) + "px");
        $("#leftMenu").css("height", ($(document).height() - 120) + "px");
    });


    $(".logo").click(function () {
        var sidebarlefty = $("#Sidebar");
        var mainContentlefty = $("#MainContent");
        var marginLeft = parseInt(sidebarlefty.css('marginLeft'), 10);

        if (marginLeft == 0) {


            sidebarlefty.animate({
                marginLeft: (-sidebarlefty.outerWidth() + 10)
            }, function () {

                mainContentlefty.animate({
                    width: "98.33333%"
                });

            });
        } else {

            mainContentlefty.animate({
                width: "83.3333%"
            }, function () {

                sidebarlefty.animate({
                    marginLeft: 0
                });

            });



        }



    });
});


function openJbox(url, title, width, height) {
    if (!width) width = 1200;
    if (!height) height = 600;
    $.jBox.open("iframe:" + url, title, width, height, { buttons: { "关闭": true } });
}




function getUserByMobile(mobile) {

    if (!validatemobile(mobile)) {
        return;
    }

    $.get("/oadmin/User/getpartuserbymobile?mobile=" + mobile, function (data, status) {

        var result = eval(data);

        var userInfo;
        if (result.State === "success") {
            userInfo = result.Data;
            $("#userInfo .realname").html(userInfo.RealName);
            $("#RealName").val(userInfo.RealName);
            $("#Phone").val(userInfo.Phone);
            $("#Address").val(userInfo.Address);
            $("#Email").val(userInfo.Email);


            if (userInfo.Avatar.length >= 5) {
                $("#userInfo .litpic").attr('src', '/upload/user/thumb100_100/' + userInfo.Avatar);
            } else {
                $("#userInfo .litpic").attr('src', '/upload/user/nopic.png');
            }
            $("#Mobile").attr("readonly", true);
        } else if (result.State === "complete") {

            userInfo = result.Data;

            var mymessage = confirm("当前用户已经是员工,你是否继续添加");

            if (mymessage == true) {
                $("#userInfo .realname").html(userInfo.RealName);
                $("#RealName").val(userInfo.RealName);
                $("#Phone").val(userInfo.Phone);
                $("#Address").val(userInfo.Address);
                $("#Email").val(userInfo.Email);


                if (userInfo.Avatar.length >= 5) {
                    $("#userInfo .litpic").attr('src', '/upload/user/thumb100_100/' + userInfo.Avatar);
                } else {
                    $("#userInfo .litpic").attr('src', '/upload/user/nopic.png');
                }

                $("#Mobile").attr("readonly", true);
            }
            else if (mymessage == false) {
                $(this).val("");
            }

        } else {
            alert("未找到当前手机用户");
        }

    });
}


