package com.lh.config;

import com.sun.jdi.connect.Connector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: spring-annotation
 * @description: 自定义逻辑。导入需要的组件
 * @author: lh
 * @date: 2021-06-27 22:57
 **/
public class MyImportSelect implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.lh.beans.Blue","com.lh.beans.Yellow"};
    }
}
