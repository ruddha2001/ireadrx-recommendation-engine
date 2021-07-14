package ai.ireadrx.recommendationengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.ireadrx.recommendationengine.model.ChemicalEntity;
import ai.ireadrx.recommendationengine.repository.ChemicalRepository;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private final ChemicalRepository chemicalRepository;

	public SearchController(ChemicalRepository chemicalRepository) {
		super();
		this.chemicalRepository = chemicalRepository;
	}

	@GetMapping("/chemical")
	Mono<ChemicalEntity> findOneChemicalByName(@RequestParam String id) {
		return chemicalRepository.findById(id);
	}
}
