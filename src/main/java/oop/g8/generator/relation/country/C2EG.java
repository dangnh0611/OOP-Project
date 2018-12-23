package oop.g8.generator.relation.country;

import oop.g8.model.entity.Country;
import oop.g8.model.entity.Event;
import oop.g8.model.relation.country.C2E;

public class C2EG {

	public static C2E generateC2E(Country c, Event e, String realtionName) {
		return new C2E(realtionName, c, e);
	}
}
