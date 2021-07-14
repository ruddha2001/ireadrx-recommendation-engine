package ai.ireadrx.recommendationengine.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Chemical")
public class ChemicalEntity {
	@Id
	private final String id;
	@Property("chemical_name")
	private final String chemical_name;

	public String getChemical_name() {
		return chemical_name;
	}

	public ChemicalEntity(String id, String chemical_name) {
		this.id = id;
		this.chemical_name = chemical_name;
	}
}
