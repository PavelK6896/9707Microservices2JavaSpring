package app.web.pavelk.microservices2.server7.component;


import app.web.pavelk.microservices2.server7.entities.User;
import app.web.pavelk.microservices2.server7.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component//добавить в токен инфу
public class CustomTokenEnhancer implements TokenEnhancer {
    @Autowired
    UserRepository userRepository;

    @Override//усилить
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        User user = userRepository.findOneByUsername(authentication.getName());

        additionalInfo.put("e-mail", user.getEmail());
        additionalInfo.put("information", "w@434#GYfgy223gb3");

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
