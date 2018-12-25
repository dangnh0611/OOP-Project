package oop.g8.model.relation;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import oop.g8.model.entity.Entity;

@RelationshipEntity
@Data
@ToString(callSuper = true, includeFieldNames = true)
@NoArgsConstructor
@AllArgsConstructor
public class Rela {
	@Id
	@GeneratedValue
	private Long neo4jId;

	private String type;

	private String link;

	private Date date;
	
	@StartNode
	private Entity e1;
	
	@EndNode
	private Entity e2;

	public Rela(String type, String link, Date date, Entity e1, Entity e2) {
		super();
		this.type = type;
		this.link = link;
		this.date = date;
		this.e1 = e1;
		this.e2 = e2;
	}
	
	
}
