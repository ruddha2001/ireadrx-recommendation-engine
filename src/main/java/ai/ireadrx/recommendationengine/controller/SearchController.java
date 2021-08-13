package ai.ireadrx.recommendationengine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.ireadrx.recommendationengine.entity.ChemicalEntity;
import ai.ireadrx.recommendationengine.entity.PatentEntity;
import ai.ireadrx.recommendationengine.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchService searchService;
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/chemicals")
	Optional<ChemicalEntity> getSingleChemical(@RequestParam String chemicalName) {
		return searchService.getChemicalByChemicalName(chemicalName);
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/chemicals/all")
	List<ChemicalEntity> getChemicals(@RequestParam Optional<String> limitResults) {
		int limit = 100;
		if (limitResults.isPresent())
			limit = Integer.parseInt(limitResults.get());

		return searchService.getAllChemicalsUsingCustomQuery(limit);
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/patents/all")
	List<PatentEntity> getPatents(@RequestParam Optional<String> limitResults) {
		int limit = 100;
		if (limitResults.isPresent())
			limit = Integer.parseInt(limitResults.get());

		return searchService.getAllPatentsUsingCustomQuery(limit);
	}

}
