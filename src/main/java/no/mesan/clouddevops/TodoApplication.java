package no.mesan.clouddevops;

import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class TodoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<TodoApplication> applicationClass = TodoApplication.class;

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        final WebRequestTrackingFilter webRequestTrackingFilter = new WebRequestTrackingFilter();
        filterRegistrationBean.setFilter(webRequestTrackingFilter);
        return filterRegistrationBean;
    }
}
