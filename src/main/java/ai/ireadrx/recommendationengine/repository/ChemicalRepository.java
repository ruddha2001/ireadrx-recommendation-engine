package ai.ireadrx.recommendationengine.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

import ai.ireadrx.recommendationengine.model.ChemicalEntity;
import reactor.core.publisher.Mono;

public interface ChemicalRepository extends ReactiveNeo4jRepository<ChemicalEntity, String> {
	Mono<ChemicalEntity> findOneByName(String chemical_name);
}
