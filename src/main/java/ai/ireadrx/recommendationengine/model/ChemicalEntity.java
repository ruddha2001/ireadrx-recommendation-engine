package ai.ireadrx.recommendationengine.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Chemical")
public class ChemicalEntity {
	@Id
	private final String chemical_name;

	public String getChemical_name() {
		return chemical_name;
	}

	public ChemicalEntity(String chemical_name) {
		this.chemical_name = chemical_name;
	}
}
