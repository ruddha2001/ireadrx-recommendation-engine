package ai.ireadrx.recommendationengine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.ireadrx.recommendationengine.entity.ChemicalEntity;
import ai.ireadrx.recommendationengine.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchService searchService;

	@GetMapping("/chemicals")
	Optional<ChemicalEntity> getSingleChemical(@RequestParam String chemicalName) {
		return searchService.getChemicalByChemicalName(chemicalName);
	}

	@GetMapping("/chemicals/all")
	List<ChemicalEntity> getChemicals() {
		return searchService.getAllChemicals();
	}

}
