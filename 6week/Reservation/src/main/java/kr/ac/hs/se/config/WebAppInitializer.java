package kr.ac.hs.se.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Spring 기본 설정 파일인 "ApplicationConfig.class"를 지정.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class};
    }

    // Spring MVC 설정 파일인 "MvcConfig.class"를 지정.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMvcContextConfiguration.class};
    }

    // "DispatcherServlet"이 동작할 맵핑정보를 설정.
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   // "/"를 작성함으로써 모든 요청을 "DispatcherServlet"이 처리하게 함.
    }

    // 필터 설정: 한글 문제 해결.
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[]{encodingFilter};
    }
}
// "Web.xml"의 역할대신 하기