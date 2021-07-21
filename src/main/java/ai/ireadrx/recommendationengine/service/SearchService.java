package ai.ireadrx.recommendationengine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ai.ireadrx.recommendationengine.entity.ChemicalEntity;
import ai.ireadrx.recommendationengine.repository.ChemicalRepository;

@Service
public class SearchService {

	private final ChemicalRepository chemicalRepository;

	public SearchService(ChemicalRepository chemicalRepository) {
		this.chemicalRepository = chemicalRepository;
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
	 * @return A list of all the chemical nodes
	 */
	public List<ChemicalEntity> getAllChemicals() {
		return chemicalRepository.findAll();
	}

	public List<ChemicalEntity> getAllChemicalsUsingCustomQuery(int resultLimit) {
		return chemicalRepository.findByCustomQuery(resultLimit);
	}
}
