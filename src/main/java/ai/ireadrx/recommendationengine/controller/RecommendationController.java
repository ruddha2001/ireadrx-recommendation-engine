package ai.ireadrx.recommendationengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.ireadrx.recommendationengine.service.RecommendationService;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

	@Autowired
	RecommendationService recommendationService;

	@GetMapping("/patent")
	List<String> getPatentRecommendation(@RequestParam String patentId) {
		return recommendationService.getPatentRecommendation(patentId);
	}
}
