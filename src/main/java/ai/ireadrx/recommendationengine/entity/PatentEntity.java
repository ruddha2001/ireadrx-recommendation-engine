package ai.ireadrx.recommendationengine.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Patent")
public class PatentEntity {
	@Id
	private final String patentId;

	public String getPatentId() {
		return patentId;
	}

	public PatentEntity(String patentId) {
		super();
		this.patentId = patentId;
	}

}
