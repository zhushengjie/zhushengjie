package com.zhuzhu.socket.springboot.server;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author 朱圣杰
 */
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //读取EnableServer中所有的属性方法
        //其中key为属性方法名，value为属性放回对象
        Map<String,Object> annotationAttributes =
                importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());

        Server.Type type = (Server.Type) annotationAttributes.get("type");
        String[] importClassNames = new String[0];
        switch (type) {
            case HTTP:
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
            case FTP:
                importClassNames = new String[]{FtpServer.class.getName()};
                break;
        }
        return  importClassNames;
    }
}
