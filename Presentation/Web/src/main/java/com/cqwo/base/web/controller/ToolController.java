package com.cqwo.base.web.controller;


import com.cqwo.base.services.CWMUtils;
import com.cqwo.base.services.Users;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.cqwo.base.web.framework.controller.BaseWebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Controller(value = "ToolController")
@RequestMapping(value = "/tool")
public class ToolController extends BaseWebController {

    @Autowired
    private CWMUtils cwmUtils;


    @Autowired
    private Users users;

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @RequestMapping("verifyimage")
    public void defaultKaptcha() throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 获取用户头像
     *
     * @param uid
     */
    @RequestMapping(value = "avatar")
    @ResponseBody
    public String avatar(@RequestParam(defaultValue = "0") String uid) {

        try {


            String avatar = users.getUserAvatarUrl(uid);
            sendRedirect(avatar, "http://www.510link.com/img/logo.png");

        } catch (Exception ex) {


        }


        return "ok";
    }

}
