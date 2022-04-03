package com.zhuzhu.socket.springboot;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 朱圣杰
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface  EnableHelloWorld {
}
