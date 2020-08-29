package app.web.pavelk.microservices2.client9.controller;

import app.web.pavelk.microservices2.common1.CloudPacket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticController {
    @GetMapping("/request/{requestId}")
    public CloudPacket test(@PathVariable(value = "requestId") Long id) {
        return new CloudPacket(id, "TopSecret Packet");
    }

    @GetMapping("/simple")
    public CloudPacket simpleTest() {
        return new CloudPacket(1000L, "TopSecret Simple Packet");
    }
}
