package kr.ac.hs.se.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "kr.ac.hs.se.repository",
        "kr.ac.hs.se.service"
})
@Import({DBConfig.class})
public class ApplicationConfig {
}