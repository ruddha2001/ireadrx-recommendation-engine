package ai.ireadrx.recommendationengine.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node("Patent")
public class PatentEntity {
	@Id
	private final String patentId;
	@Relationship(type = "PRESENT_IN", direction = Direction.INCOMING)
	private Set<ChemicalEntity> chemicals = new HashSet<>();

	public String getPatentId() {
		return patentId;
	}

	public PatentEntity(String patentId) {
		super();
		this.patentId = patentId;
	}

}
