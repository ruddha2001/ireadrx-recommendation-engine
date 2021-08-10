package ai.ireadrx.recommendationengine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CacheService {
	static final String chemicalList[][] = {
			{ "benzene", "toluene", "naphthalene", "xylene", "dibenzofuran", "carbazole", "pyridine", "triphenylene",
					"quinoline", "pyrimidine", "pyrazine" },
			{ "naphthalene", "unsubstituted C 1 -C 60 heteroaryl group", "benzofuran", "quinoxaline", "isoquinoline",
					"unsubstituted C 1 -C 60 alkyl group", "unsubstituted C 3 -C 10 cycloalkenyl group",
					"dibenzocarbazolyl", "unsubstituted C 3 -C 10 cycloalkyl group",
					"unsubstituted C 2 -C 60 alkynyl group", "unsubstituted C 2 -C 60 alkenyl group" },
			{ "quinoline", "isoquinoline", "quinoxaline", "quinazoline", "pyrazine", "pyridazine", "indole", "triazine",
					"benzofuran", "oxazole", "thiazole" },
			{ "ethanol", "methanol", "isopropanol", "acetone", "alcohol", "tetrahydrofuran", "propanol", "acetic acid",
					"butanol", "toluene", "n-butanol" },
			{ "hydroxychloroquine", "chloroquine", "sulfasalazine", "nitrofurantoin", "deferoxamine", "doxycycline",
					"abatacept", "mycophenolic acid", "meloxicam", "rifabutin", "leflunomide" },
			{ "sucrose", "lactose", "sorbitol", "mannitol", "fructose", "glucose", "maltose", "trehalose", "starch",
					"sodium chloride", "xylose" },
			{ "carbazole", "dibenzofuran", "triphenylene", "dibenzothiophene", "aza-dibenzoselenophene",
					"aza-dibenzothiophene", "aza-dibenzofuran", "dibenzoselenophene", "azatriphenylene", "azacarbazole",
					"heteroalkyl" },
			{ "pyridine", "pyrimidine", "pyrazine", "imidazole", "quinoline", "triazine", "pyridazine", "isoquinoline",
					"oxazole", "dibenzofuran", "quinoxaline" } };
	static HashMap<String, List<String>> cache = new HashMap<String, List<String>>();

	public static void initCache() {
		for (int i = 0; i < chemicalList.length; i++) {
			List<String> tempList = new ArrayList<String>();
			for (int j = 1; j < chemicalList[i].length; j++)
				tempList.add(chemicalList[i][j]);
			cache.put(chemicalList[i][0], tempList);
		}
	}

	public static List<String> findListFromCache(String chemical) {
		if (cache.size() == 0) {
			initCache();
			System.out.println("Populated Cache has the following entries:");
			cache.entrySet().forEach(entry -> {
				System.out.println(entry.getKey() + " " + entry.getValue());
			});
		}

		return cache.containsKey(chemical) ? cache.get(chemical) : null;
	}
}
