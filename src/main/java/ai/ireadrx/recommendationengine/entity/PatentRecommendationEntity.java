package ai.ireadrx.recommendationengine.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.core.schema.Id;

@EntityScan
public class PatentRecommendationEntity {
	@Id
	private final String from;
	private final String to;
	private final int count1;
	private final int count2;
	private final float intersection;
	private final float similarity;

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public int getCount1() {
		return count1;
	}

	public int getCount2() {
		return count2;
	}

	public float getIntersection() {
		return intersection;
	}

	public float getSimilarity() {
		return similarity;
	}

	public PatentRecommendationEntity(String from, String to, int count1, int count2, float intersection,
			float similarity) {
		super();
		this.from = from;
		this.to = to;
		this.count1 = count1;
		this.count2 = count2;
		this.intersection = intersection;
		this.similarity = similarity;
	}

}
