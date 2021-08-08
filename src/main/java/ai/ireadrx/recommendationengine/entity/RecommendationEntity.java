package ai.ireadrx.recommendationengine.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.core.schema.Id;

@EntityScan
public class RecommendationEntity {
	@Id
	private final String result;

	public String getResult() {
		return result;
	}

	public RecommendationEntity(String result) {
		super();
		this.result = result;
	}

}
