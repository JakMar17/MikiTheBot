package team.marela.covid.miki_the_bot;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBean {

    @Bean
    public RestTemplate createRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
