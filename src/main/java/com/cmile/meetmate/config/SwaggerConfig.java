package com.cmile.meetmate.config;

import com.cmile.meetmate.utils.constant.StringConstant;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableJpaAuditing
public class SwaggerConfig {

    private Predicate<String> postPaths() {
        return or(regex(StringConstant.TEXT_SWAGGER_REGEX_PATH));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(StringConstant.TEXT_SWAGGER_TITLE)
                .description(StringConstant.TEXT_SWAGGER_DESC)
                .contact(StringConstant.TEXT_SWAGGER_CONTACT_EMAIL)
                .license(StringConstant.TEXT_APP_NAME)
                .licenseUrl(StringConstant.TEXT_SWAGGER_LICENCE)
                .version(StringConstant.TEXT_SWAGGER_API_VERSION)
                .build();
    }

    @Configuration
    @EnableSwagger2
    public class SpringFoxConfig {
        @Bean
        public Docket apiDocket() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();
        }
    }
}
