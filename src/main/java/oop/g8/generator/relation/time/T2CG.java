package oop.g8.generator.relation.time;

import java.util.Date;

import org.springframework.stereotype.Component;

import oop.g8.model.entity.Country;
import oop.g8.model.entity.Time;
import oop.g8.model.relation.time.T2C;

@Component
public class T2CG {
	public static T2C generateT2C(Time t, Country c, String relationName, String link, Date date) {
		return new T2C(relationName, link, date,  t, c);
	}
	
}
