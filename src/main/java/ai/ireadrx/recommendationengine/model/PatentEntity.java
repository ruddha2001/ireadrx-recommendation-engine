package ai.ireadrx.recommendationengine.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node("Patent")
public class PatentEntity {
	@Id
	private final String patent_id;

	@Relationship(type = "PRESENT_IN", direction = Direction.INCOMING)
	private Set<ChemicalEntity> chemicals = new HashSet<>();

	public String getPatent_id() {
		return patent_id;
	}

	public Set<ChemicalEntity> getChemicals() {
		return chemicals;
	}

	public void setChemicals(Set<ChemicalEntity> chemicals) {
		this.chemicals = chemicals;
	}

	public PatentEntity(String patent_id) {
		this.patent_id = patent_id;
	}

}
