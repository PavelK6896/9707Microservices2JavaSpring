package app.web.pavelk.microservices2.client10.config;

import app.web.pavelk.microservices2.client10.component.UserFeignClientInterceptor;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatisticFeignClientConfiguration {
    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Bean
    public RequestInterceptor getUserFeignClientInterceptor() {
        return new UserFeignClientInterceptor();
    }

//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            requestTemplate.header("setClientId", clientId);
//            requestTemplate.header("setClientSecret", clientSecret);
//        };
//    }


//    @Bean
//    RequestInterceptor oauth2FeignRequestInterceptor() {
//        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource());
//    }
//
//    private OAuth2ProtectedResourceDetails resource() {
//        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
//        resourceDetails.setUsername("1");
//        resourceDetails.setPassword("1");
////        resourceDetails.setAccessTokenUri(accessTokenUri);
//        resourceDetails.setClientId(clientId);
//        resourceDetails.setClientSecret(clientSecret);
//        resourceDetails.setGrantType("password");
//        resourceDetails.setScope(Arrays.asList("webclient"));
//        return resourceDetails;
//    }

}
