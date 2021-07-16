package ai.ireadrx.recommendationengine.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Chemical")
public class ChemicalEntity {
	@Id
	private final String chemicalName;

	public String getChemicalName() {
		return chemicalName;
	}

	public ChemicalEntity(String chemicalName) {
		super();
		this.chemicalName = chemicalName;
	}

}
