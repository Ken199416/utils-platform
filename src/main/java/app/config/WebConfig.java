package app.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
//                .allowedOrigins("*");
                .allowedOrigins("http://localhost:8859","http://127.0.0.1:8859","http://127.0.0.1:8859",
                        "http://localhost:8989","http://111.229.135.141:8989","http://hmj.mbg17.cn:8989",
                        "http://192.168.3.59:8859","http://192.168.80.34:8859","http://192.168.80.34:8989",
                        "http://www.haomingjian.top:8989","http://www.haomingjian.top").allowCredentials(true);
    }

    /**
     * 登录拦截器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/*")
//                .excludePathPatterns("/login","/createYmlConfig",
//                        "/debug/*","/**/*.css",
//                        "/**/*.woff",
//                        "/**/*.ttf",
//                        "/**/*.js",
//                        "/**/*.js.map",
//                        "/**/*.ico",
//                        "/**/*.html");
//    }

    /**
     * 根目录路径映射
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
//        做路径映射
        registry.addViewController("/").setViewName("index");

    }

    /**
     * 静态资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


    /**
     * FastJson解析器
     * @param converters
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig config = new FastJsonConfig();
//        config.setDateFormat("yyyy-MM-dd");
//        config.setCharset(Charset.forName("UTF-8"));
//        config.setSerializerFeatures(
//                SerializerFeature.WriteClassName,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullStringAsEmpty
//        );
//        converter.setFastJsonConfig(config);
//        converters.add(converter);
//    }
}
