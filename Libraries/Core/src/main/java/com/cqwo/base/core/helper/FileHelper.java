/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆英卡电子有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.helper;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;

/**
 * 功能描述：
 *
 * @author Administrator
 * @version 1.0
 * @Date Jul 19, 2008
 * @Time 9:46:11 AM
 */
public class FileHelper {

    /**
     * 功能描述：列出某文件夹及其子文件夹下面的文件，并可根据扩展名过滤
     *
     * @param path 文件夹
     */
    public static void list(File path) {
        if (!path.exists()) {
            System.out.println("文件名称不存在!");
        } else {
            if (path.isFile()) {
                if (path.getName().toLowerCase().endsWith(".pdf")
                        || path.getName().toLowerCase().endsWith(".doc")
                        || path.getName().toLowerCase().endsWith(".chm")
                        || path.getName().toLowerCase().endsWith(".html")
                        || path.getName().toLowerCase().endsWith(".htm")
                        || path.getName().toLowerCase().endsWith(".xml")) {
                }
            } else {

                File[] files = path.listFiles();
                if (files != null) {
                    for (File file : files) {
                        list(file);
                    }
                }
            }
        }
    }

    /**
     * 功能描述：拷贝一个目录或者文件到指定路径下，即把源文件拷贝到目标文件路径下
     *
     * @param source 源文件
     * @param target 目标文件路径
     * @return void
     */
    public static void copy(File source, File target) {
        File tarpath = new File(target, source.getName());
        if (source.isDirectory()) {
            tarpath.mkdir();
            File[] dir = source.listFiles();
            if (dir != null) {
                for (File file : dir) {
                    copy(file, tarpath);
                }
            }
        } else {
            try {
                InputStream is = new FileInputStream(source); // 用于读取文件的原始字节流
                OutputStream os = new FileOutputStream(tarpath); // 用于写入文件的原始字节的流
                byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
                int len = 0;
                while ((len = is.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                is.close();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("D:\\wwwroot\\cqyywd.com");
        File target = new File("G:\\BaiduNetdiskDownload\\2");
        list(file);
        Date myDate = new Date();
        DateFormat df = DateFormat.getDateInstance();

        copy(file, target);

    }

}
