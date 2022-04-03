package com.zhuzhu.socket.springboot.server;

public class FtpServer implements Server{
    @Override
    public void start() {
        System.out.println("FTP 服务器启动中。。。");
    }

    @Override
    public void stop() {
        System.out.println("FTP 服务器关闭中。。。");
    }
}
