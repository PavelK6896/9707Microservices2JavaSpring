package app.web.pavelk.microservices2.client8.controller;

import app.web.pavelk.microservices2.common1.CloudPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate; // прокидывает токен

    @Autowired
    TokenStore tokenStore;

    @GetMapping("/try")
    public String doSomething() {
        return "Hi there!";
    }

    @GetMapping("/get_statistic")
    // @PreAuthorize("#oauth2.hasScope('write')")
    public String getSomeStatistic() {
        ResponseEntity<CloudPacket> restExchange = oAuth2RestTemplate
                .exchange("http://localhost:8084/client9/request/{statisticId}",
                        HttpMethod.GET, null, CloudPacket.class, 1L);

        return restExchange.getBody().toString();
    }

    @GetMapping("/get_s")
    // @PreAuthorize("#oauth2.hasScope('write')")
    public String getS() {
        ResponseEntity<CloudPacket> restExchange = oAuth2RestTemplate
                .exchange("http://localhost:8084/client9/simple",
                        HttpMethod.GET, null, CloudPacket.class);

        return restExchange.getBody().toString();
    }

    @GetMapping("/token/token/try")
    public String tokenToken(OAuth2Authentication auth) {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
        System.out.println(accessToken.getAdditionalInformation());
        return "token!";
    }
}
