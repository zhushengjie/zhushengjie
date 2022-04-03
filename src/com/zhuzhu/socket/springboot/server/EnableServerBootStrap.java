package com.zhuzhu.socket.springboot.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author 朱圣杰
 */
//@EnableServer(type = Server.Type.HTTP)
@EnableServerV2(type = Server.Type.HTTP)
@Configuration
public class EnableServerBootStrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(EnableServerBootStrap.class);
        context.refresh();
        Server server = context.getBean(Server.class);
        server.start();
        server.stop();
    }
}
