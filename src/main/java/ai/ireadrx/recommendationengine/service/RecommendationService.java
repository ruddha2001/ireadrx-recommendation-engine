package ai.ireadrx.recommendationengine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ai.ireadrx.recommendationengine.repository.RecommendationRepository;

@Service
public class RecommendationService {
	private final RecommendationRepository recommendationRepository;

	public RecommendationService(RecommendationRepository recommendationRepository) {
		this.recommendationRepository = recommendationRepository;
	}

	/**
	 * Get a list of patent recommendations
	 * 
	 * @param patentId The patent ID to be matched to other patents
	 * @return
	 */
	public List<String> getPatentRecommendation(String patentId) {
		return recommendationRepository.findPatentRecommendation(patentId);
	}

	/**
	 * Get a list of chemical recommendations
	 * 
	 * @param patentId The chemical name to be matched to other chemicals
	 * @return
	 */
	public List<String> getChemicalRecommendation(String chemicalName) {
		List<String> cachedList = CacheService.findListFromCache(chemicalName);
		if (cachedList != null)
			return cachedList;
		return recommendationRepository.findChemicalRecommendation(chemicalName);
	}
}
