package ai.ireadrx.recommendationengine.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import ai.ireadrx.recommendationengine.entity.ChemicalEntity;

public interface ChemicalRepository extends Neo4jRepository<ChemicalEntity, String> {
	Optional<ChemicalEntity> findByChemicalName(String chemicalName);
}
