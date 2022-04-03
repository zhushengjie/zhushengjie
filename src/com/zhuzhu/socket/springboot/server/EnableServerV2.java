package com.zhuzhu.socket.springboot.server;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 朱圣杰
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServerV2 {

    /**
     * 设置服务器类型
     * @return
     */
    Server.Type type() default Server.Type.HTTP;
}
