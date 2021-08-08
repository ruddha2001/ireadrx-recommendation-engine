package ai.ireadrx.recommendationengine.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import ai.ireadrx.recommendationengine.entity.RecommendationEntity;

public interface RecommendationRepository extends Neo4jRepository<RecommendationEntity, String> {
	@Query("MATCH (chemical:Chemical)-[:PRESENT_IN]->(patent:Patent) "
			+ "WITH {item:id(patent), categories:collect(id(chemical))} as dataObject "
			+ "WITH collect(dataObject) as dataArray " + "CALL gds.alpha.similarity.overlap.stream({data:dataArray}) "
			+ "YIELD item1, item2, count1, count2, intersection, similarity "
			+ "WHERE gds.util.asNode(item1).patentId = $patentId " + "RETURN gds.util.asNode(item2).patentId as to "
			+ "ORDER BY intersection DESC, similarity DESC, count2 DESC")
	List<String> findPatentRecommendation(String patentId);

//	@Query("Match (givenChem:Chemical)-[:PRESENT_IN]->(topPatent:Patent) "
//			+ "Match (p:Patent {patentId:topPatent.patentId })<-[r:PRESENT_IN]-(c:Chemical)-[s:PRESENT_IN]->(n:Patent) "
//			+ "WITH count(c.chemicalName) as freq, c ORDER BY freq DESC " + "RETURN DISTINCT c.chemicalName "
//			+ "LIMIT 100")
//	List<String> findChemicalRecommendation(String chemicalName);

	@Query("CALL gds.nodeSimilarity.stream('chemicalGraph') " + "YIELD node1, node2, similarity "
			+ "WHERE gds.util.asNode(node1).chemicalName = '$chemicalName' "
			+ "RETURN gds.util.asNode(node2).chemicalName AS Chemical1 " + "ORDER BY similarity DESCENDING")
	List<String> findChemicalRecommendation(@Param("chemicalName") String chemicalName);
}
