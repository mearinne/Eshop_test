package net.homecredit.testautomation.us.config;


import org.jbehavesupport.core.web.WebSetting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class webMapConfig {

    @Bean
    public WebSetting shopSetting(){
        return WebSetting.builder()
                .elementLocatorsSource("eshop/*.yaml").build();
    }
}
