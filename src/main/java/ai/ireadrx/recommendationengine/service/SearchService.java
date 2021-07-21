package ai.ireadrx.recommendationengine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ai.ireadrx.recommendationengine.entity.ChemicalEntity;
import ai.ireadrx.recommendationengine.entity.PatentEntity;
import ai.ireadrx.recommendationengine.repository.ChemicalRepository;
import ai.ireadrx.recommendationengine.repository.PatentRepository;

@Service
public class SearchService {

	private final ChemicalRepository chemicalRepository;
	private final PatentRepository patentRepository;

	public SearchService(ChemicalRepository chemicalRepository, PatentRepository patentRepository) {
		this.chemicalRepository = chemicalRepository;
		this.patentRepository = patentRepository;
	}

	/**
	 * Search for a particular chemical
	 * 
	 * @param chemicalName The chemical name which to be searched
	 * @return A chemical node
	 */
	public Optional<ChemicalEntity> getChemicalByChemicalName(String chemicalName) {
		return chemicalRepository.findByChemicalName(chemicalName);
	}

	/**
	 * Get a list of all chemicals
	 * 
	 * @param resultLimit Optional. Specify a number to return that many values
	 * @return
	 */
	public List<ChemicalEntity> getAllChemicalsUsingCustomQuery(int resultLimit) {
		return chemicalRepository.findByCustomQuery(resultLimit);
	}

	/**
	 * Get a list of all patents
	 * 
	 * @param resultLimit Optional. Specify a number to return that many values
	 * @return
	 */
	public List<PatentEntity> getAllPatentsUsingCustomQuery(int resultLimit) {
		return patentRepository.findAllByCustomQuery(resultLimit);
	}
}
