package com.muyinatech.myspringdata;

import com.muyinatech.myspringdata.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisExample {

    public static void main(String[] args) {

        boolean useJavaConfig = false;
        ApplicationContext ctx;

        //Showing examples of both Xml and Java based configuration
        if (useJavaConfig) {
            ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        } else {
            ctx = new ClassPathXmlApplicationContext("config/application-context.xml");
        }

        RedisTemplate<String, String> redisTemplate = ctx.getBean("redisTemplate", RedisTemplate.class);

        redisTemplate.opsForValue().set("test", "value1");

        System.out.println(redisTemplate.opsForValue().get("test"));

    }
}
