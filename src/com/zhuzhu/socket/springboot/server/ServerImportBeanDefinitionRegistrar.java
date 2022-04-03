package com.zhuzhu.socket.springboot.server;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * @author 朱圣杰
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importClassMetadata, BeanDefinitionRegistry registry){
        // 复用
        ImportSelector importSelector = new ServerImportSelector();
        //筛选Class名称集合
        String[] selectedClassNames = importSelector.selectImports(importClassMetadata);
        //创建Bean定义
        Stream.of(selectedClassNames)
                // 转化为BeanDefinitionBuilder 对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                // 转化为 BeanDefinition
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> {
                    // 注册BeanDefinition 到 BeanDefinitionRegistry
                    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition,registry);
                });
    }
}
