package com.sky.config;

import com.sky.filter.ClearThreadLocalFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<ClearThreadLocalFilter> clearThreadLocalFilter() {
        log.info("正在注册线程空间清空过滤器");
        FilterRegistrationBean<ClearThreadLocalFilter> registration =
                new FilterRegistrationBean<>();

        registration.setFilter(new ClearThreadLocalFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(Integer.MAX_VALUE); // 最后执行

        return registration;
    }
}
