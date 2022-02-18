package com.qinghuo.xduHelp.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;



@Configuration
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket docket(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        //environment。acceptsProfiles判断自己是否在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                //设置扫描
                .select()
                    //any（）扫描全部
                    .apis(RequestHandlerSelectors.any())
                        //过滤哪里什么路径
                        .paths(PathSelectors.any())
                            .build()
                .apiInfo(apiInfo()).enable(flag);
    }

    // 配置swagger基本信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("HUAWEI", "http://localhost:9688/", "email@.com");
        return new ApiInfo(
                "标题：西电活力工作室_西电优帮_接口文档",
                "描述：西电优帮接口汇总",
                "v1.0",
                "http://localhost:9688/",
                contact,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
