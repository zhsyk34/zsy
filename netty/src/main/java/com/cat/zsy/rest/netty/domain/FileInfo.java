package com.cat.zsy.rest.netty.domain;

import lombok.*;

import java.io.*;

@Data
public class FileInfo implements Serializable {
    private File file;// 文件
    private String file_md5;// 文件名
    private int starPos;// 开始位置
    private byte[] bytes;// 文件字节数组
    private int endPos;// 结尾位置
}