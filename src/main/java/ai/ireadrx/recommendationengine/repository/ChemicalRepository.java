package ai.ireadrx.recommendationengine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import ai.ireadrx.recommendationengine.entity.ChemicalEntity;

@Repository
public interface ChemicalRepository extends Neo4jRepository<ChemicalEntity, String> {
	Optional<ChemicalEntity> findByChemicalName(String chemicalName);

	@Query("MATCH (c:Chemical) RETURN c LIMIT $number")
	List<ChemicalEntity> findByCustomQuery(Integer number);
}
