package ai.ireadrx.recommendationengine.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import ai.ireadrx.recommendationengine.entity.PatentEntity;

@Repository
public interface PatentRepository extends Neo4jRepository<PatentEntity, String> {
	@Query("MATCH (p:Patent) RETURN p LIMIT $number")
	List<PatentEntity> findAllByCustomQuery(Integer number);
}
