package ai.ireadrx.recommendationengine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ai.ireadrx.recommendationengine.repository.PatentRecommendationRepository;

@Service
public class RecommendationService {
	private final PatentRecommendationRepository patenrPatentRecommendationRepository;

	public RecommendationService(PatentRecommendationRepository patenrPatentRecommendationRepository) {
		this.patenrPatentRecommendationRepository = patenrPatentRecommendationRepository;
	}

	/**
	 * Get a list of patent recommendations
	 * 
	 * @param patentId The patent ID to be matched to other patents
	 * @return
	 */
	public List<String> getPatentRecommendation(String patentId) {
		return patenrPatentRecommendationRepository.findPatentRecommendation(patentId);
	}
}
