package kr.ac.hs.se.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages = {
        "kr.ac.hs.se.user.controller",
        "kr.ac.hs.se.reservation.controller"
})
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // 리소스 핸들러
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    // default servlet 제공, "spring"에서 설정하지 않은 경로에 대한 처리해줌
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
