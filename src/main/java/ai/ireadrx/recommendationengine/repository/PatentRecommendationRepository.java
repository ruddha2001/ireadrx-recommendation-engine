package ai.ireadrx.recommendationengine.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import ai.ireadrx.recommendationengine.entity.PatentRecommendationEntity;

public interface PatentRecommendationRepository extends Neo4jRepository<PatentRecommendationEntity, String> {
	@Query("MATCH (chemical:Chemical)-[:PRESENT_IN]->(patent:Patent) "
			+ "WITH {item:id(patent), categories:collect(id(chemical))} as dataObject "
			+ "WITH collect(dataObject) as dataArray " + "CALL gds.alpha.similarity.overlap.stream({data:dataArray}) "
			+ "YIELD item1, item2, count1, count2, intersection, similarity "
			+ "WHERE gds.util.asNode(item1).patentId = $patentId " + "RETURN gds.util.asNode(item2).patentId as to "
			+ "ORDER BY intersection DESC, similarity DESC, count2 DESC")
	List<String> findPatentRecommendation(String patentId);
}
