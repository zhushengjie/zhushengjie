package com.zhuzhu.socket.springboot.server;

public interface Server {

    /**
     * 启动服务器
     */
    void start();

    /**
     * 关闭服务器
     */
    void stop();

    /**
     * 服务器类型
     */
    enum Type {
        HTTP,
        FTP
    }
}
