package app.web.pavelk.microservices2.client10.controller;

import app.web.pavelk.microservices2.common1.CloudPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SecuredFeignController {
    private StatisticFeignClient statisticFeignClient;
    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @Autowired
    public void setStatisticFeignClient(StatisticFeignClient statisticFeignClient) {
        this.statisticFeignClient = statisticFeignClient;
    }

    @GetMapping("/check")
    public CloudPacket checkTest() {
        System.out.println("check !!!!!!!!!!!!!!1");
        System.out.println(statisticFeignClient + " =========");
        return statisticFeignClient.findOnePacketPlease();
    }

    @GetMapping("/c")
    public String test(HttpServletRequest request) {// HttpServletResponse response
        request.getHeaderNames().asIterator().forEachRemaining(System.out::println);
        System.out.println(request.getHeader("authorization"));
        return "CCCCCCCCCCCCcc " + (request.getHeader("authorization"));
    }

    @GetMapping("/c2")
    public String test2(HttpServletRequest request) {// HttpServletResponse response

        ResponseEntity<CloudPacket> restExchange = oAuth2RestTemplate
                .exchange("http://localhost:8089/simple",
                        HttpMethod.GET, null, CloudPacket.class);

        return restExchange.getBody().toString();
    }


}
