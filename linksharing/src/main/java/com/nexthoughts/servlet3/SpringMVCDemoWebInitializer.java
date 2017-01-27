package com.nexthoughts.servlet3;

import com.nexthoughts.config.ApplicationFilter;
import com.nexthoughts.config.HibernateConfig;
import com.nexthoughts.config.SpringRootConfig;
import com.nexthoughts.config.SpringWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class SpringMVCDemoWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class, HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new ApplicationFilter()};
    }
}