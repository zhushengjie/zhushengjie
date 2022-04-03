package com.zhuzhu.socket.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author 朱圣杰
 */
@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootStrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new
                AnnotationConfigApplicationContext();
        //注册当前引导类
        configApplicationContext.register(EnableHelloWorldBootStrap.class);
        //启动上下文
        configApplicationContext.refresh();
        //获取bean
        String helloWorld = configApplicationContext.getBean("helloWorld",String.class);
        //输出用户名称: "Hello,World"
        System.out.printf("helloWorld = %s \n" ,helloWorld);
        //关闭上下文
        configApplicationContext.close();
    }
}
