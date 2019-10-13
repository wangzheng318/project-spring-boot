package com.wz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class SpringBootLesson1Application extends SpringBootServletInitializer {
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "hello,spring boot!";
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("come index!!");
        return "index";
    }

    @RequestMapping("/rest")
    @ResponseBody
    public Map<String, Object> rest() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("1", "A");
        data.put("2", 2);
        return data;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLesson1Application.class, args);
    }

    public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootLesson1Application.class);
    }
}
