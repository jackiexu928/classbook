package com.jackie.classbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/30
 */
/**
 * classpath路径：locations={"classpath:classpath:aop-spring.xml","classpath:classpath:aop-spring2.xml"}可以多个
 * file路径： locations = {"file:E:/j/classbook/classpath:aop-spring.xml"};
 */
@Configuration
@ImportResource(locations={"classpath:aop-spring.xml"})
public class Config {
}
