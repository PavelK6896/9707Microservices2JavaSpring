package app.web.pavelk.microservices2.client10.controller;

import app.web.pavelk.microservices2.common1.CloudPacket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client9")
//, url= "https://localhost:8089", configuration = StatisticFeignClientConfiguration.class)
public interface StatisticFeignClient {
    @GetMapping("/simple")
    CloudPacket findOnePacketPlease();
}
