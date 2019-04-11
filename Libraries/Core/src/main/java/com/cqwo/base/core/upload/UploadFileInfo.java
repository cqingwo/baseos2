/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.upload;

/**
 * Created by cqnews on 2017/12/26.
 */
public class UploadFileInfo {

    /**
     * 文件名
     */
    private String fileName="";

    /**
     * 文件类型
     */
    private String fileType="";

    /**
     * 文件全路径
     */
    private String fileAllPath="";

    /**
     * 文件路径
     */
    private String relativeAllPath="";

    /**
     * 大小
     */
    private long fileSize=0L;

    public UploadFileInfo() {
    }

    public UploadFileInfo(String fileName, String fileType, String fileAllPath, String relativeAllPath, long fileSize) {
        this.fileName=fileName;
        this.fileType=fileType;
        this.fileAllPath=fileAllPath;
        this.relativeAllPath=relativeAllPath;
        this.fileSize=fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName=fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType=fileType;
    }

    public String getFileAllPath() {
        return fileAllPath;
    }

    public void setFileAllPath(String fileAllPath) {
        this.fileAllPath=fileAllPath;
    }

    public String getRelativeAllPath() {
        return relativeAllPath;
    }

    public void setRelativeAllPath(String relativeAllPath) {
        this.relativeAllPath=relativeAllPath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize=fileSize;
    }

    @Override
    public String toString() {
        return "UploadFileInfo{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileAllPath='" + fileAllPath + '\'' +
                ", relativeAllPath='" + relativeAllPath + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
