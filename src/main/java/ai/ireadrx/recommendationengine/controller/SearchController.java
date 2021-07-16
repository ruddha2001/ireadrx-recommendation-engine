package ai.ireadrx.recommendationengine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.ireadrx.recommendationengine.entity.ChemicalEntity;
import ai.ireadrx.recommendationengine.repository.ChemicalRepository;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/search")
public class SearchController {

	private final ChemicalRepository chemicalRepository;

	public SearchController(ChemicalRepository chemicalRepository) {
		this.chemicalRepository = chemicalRepository;
	}

	@GetMapping("/chemicals")
	Mono<ChemicalEntity> getSingleChemical(@RequestParam String chemicalName) {
		System.out.println(chemicalName);
		return chemicalRepository.findByChemicalName(chemicalName);
	}

}
