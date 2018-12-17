package cn.et;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class Example {

    @RequestMapping("/")
    String home() {
    	String url="https://restapi.amap.com/v3/weather/weatherInfo?city=440300&key=bab4c7212a804ba4abdca01fcbe55ae4";
    	String returnCode=restTemplate.getForEntity(url, String.class).getBody();
        return returnCode;
    }
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}