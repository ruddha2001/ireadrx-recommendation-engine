package ai.ireadrx.recommendationengine.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

import ai.ireadrx.recommendationengine.model.PatentEntity;

public interface PatentRepository extends ReactiveNeo4jRepository<PatentEntity, String> {
//	Mono<PatentEntity> findOneById(String id);
}
