package training.springboot.cache.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置
 */
@Configuration
public class Swagger2Conf {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("training.springboot.cache"))//这里配置swagger扫描的base包
                .paths(PathSelectors.any())//筛选路径
                .build();
    }

    private ApiInfo apiInfo() {
        ApiInfo build = new ApiInfoBuilder()
                .title("SpringBoot 整合 swagger2 练习")
                .description("Swagger2页面的描述")
                .termsOfServiceUrl("")
                .contact(new Contact("youzhihua","https://blog.nowcoder.net/youzhihua","1761595830@qq.com"))
                .version("1.0.0")
                .build();
        return build;
    }

}
