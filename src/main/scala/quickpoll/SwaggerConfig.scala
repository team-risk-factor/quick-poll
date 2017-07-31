package quickpoll

import com.mangofactory.swagger.configuration.SpringSwaggerConfig
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder
import com.mangofactory.swagger.plugin.{EnableSwagger, SwaggerSpringMvcPlugin}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
@EnableSwagger
class SwaggerConfig {

  @Autowired
  val springSwaggerConfig: SpringSwaggerConfig = null

  @Bean
  def configureSwagger: SwaggerSpringMvcPlugin = {
    val swaggerMVCConfig = new SwaggerSpringMvcPlugin(springSwaggerConfig)
    swaggerMVCConfig.apiInfo(
      new ApiInfoBuilder().
        title("Quick Poll REST API").
        description("Quick poll api for creating and managing polls").
        termsOfServiceUrl("http://www.google.com").
        contact("javier.solorzano@risk-factor.biz").
        license("MIT license").
        licenseUrl("http://opensource.org/licenses/MIT").
        build()
    ).apiVersion("1.0").
      includePatterns("/polls/*.*", "/votes/*.*", "/computeresult/*.*")
  }

}
