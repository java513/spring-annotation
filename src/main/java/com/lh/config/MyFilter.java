package com.lh.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @program: spring-annotation
 * @description: 自定义过滤规则
 * @author: lh
 * @date: 2021-06-27 21:41
 **/
public class MyFilter implements TypeFilter {
    /**
     * @param metadataReader 获取当前扫描的类信息
     * @param metadataReaderFactory 可以获取其他任何类信息
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类路径）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
