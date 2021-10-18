package com.example.tomcattest.configurations.usersConfig;

import com.example.tomcattest.configurations.AppConfigurations;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfigurations.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}