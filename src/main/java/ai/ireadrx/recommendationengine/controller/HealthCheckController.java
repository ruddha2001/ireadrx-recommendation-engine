package ai.ireadrx.recommendationengine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Recommendation Engine - iReadRX (Version:0.0.1-alpha)";
    }
}
