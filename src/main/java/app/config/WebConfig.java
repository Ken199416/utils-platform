package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("http://localhost:8859","http://127.0.0.1:8859","http://127.0.0.1:8859",
                        "http://localhost:8989","http://111.229.135.141:8989","http://hmj.mbg17.cn:8989",
                        "http://192.168.3.59:8859","http://192.168.80.34:8859","http://192.168.80.34:8989");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/autoTest/platform/*")
//                .excludePathPatterns("/autoTest/platform/login","/autoTest/platform/createYmlConfig");
//    }


    public void addViewControllers(ViewControllerRegistry registry) {
//        做路径映射
        registry.addViewController("/").setViewName("index");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
