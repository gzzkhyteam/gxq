package com.hengyunsoft.platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletContext;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Swagger2WebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Value("${auth.client.token-header:token}")
    protected String tokenHeader;
    @Value("${auth.client.user-id:_user_id}")
    protected String userIdHeader;
    @Autowired
    protected ServletContext servletContext;

    protected abstract Swagger2BaseProperties getSwagger2BaseProperties();

    protected static class Swagger2BaseProperties {

        private String contactName;
        private String contactUrl;
        private String contactEmail;
        private String host = "";
        private String basePath = "";

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }
    }

    /**
     * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
     * <!--swagger资源配置-->
     * <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
     * <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
     * 不知道为什么，这也是spring boot的一个缺点（菜鸟觉得的）
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    protected ArrayList<ResponseMessage> getResponseMessages() {
        //自定义异常响应头信息
        return new ArrayList<ResponseMessage>() ;
    }

    protected List<Parameter> getParameters() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(tokenHeader).description("token令牌")
                .modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return pars;
    }

    protected List<Parameter> getTokenUserParameters() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(tokenHeader).description("token令牌")
                .modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());

        tokenPar = new ParameterBuilder();
        tokenPar.name(userIdHeader).description("用户id")
                .modelRef(new ModelRef("long")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return pars;
    }

    protected ApiInfo getApiInfo(String title, String description) {
        Contact contact = new Contact(getSwagger2BaseProperties().getContactName(),
                getSwagger2BaseProperties().getContactUrl(),
                getSwagger2BaseProperties().getContactEmail());
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(contact)
                .version("1.0")
                .build();
    }



    protected Docket getDocket(Map<String, String> map, String basePackage, String groupName, List<Parameter> pars, ArrayList<ResponseMessage> responseMessages) {
        String title = map.get("title");
        String description = map.get("description");
        return new Docket(DocumentationType.SWAGGER_2)
                .host(getSwagger2BaseProperties().getHost())
                .apiInfo(getApiInfo(title, description))
                .groupName(groupName)  //内部API
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars)
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages);
    }
    
    protected Docket getDocket(Map<String, String> map, Class<? extends Annotation> clazz, String groupName,
			List<Parameter> pars, ArrayList<ResponseMessage> responseMessages) {
    	 String title = map.get("title");
         String description = map.get("description");
         return new Docket(DocumentationType.SWAGGER_2)
                 .host(getSwagger2BaseProperties().getHost())
                 .apiInfo(getApiInfo(title, description))
                 .groupName(groupName)  //内部API
                 .select()
                 .apis(RequestHandlerSelectors.withClassAnnotation(clazz))
                 .paths(PathSelectors.any())
                 .build().globalOperationParameters(pars)
                 .globalResponseMessage(RequestMethod.GET, responseMessages)
                 .globalResponseMessage(RequestMethod.POST, responseMessages)
                 .globalResponseMessage(RequestMethod.PUT, responseMessages)
                 .globalResponseMessage(RequestMethod.DELETE, responseMessages);
	}

}
