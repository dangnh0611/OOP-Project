package oop.g8.repository.relation;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import oop.g8.model.entity.Person;
import oop.g8.model.relation.Rela;

@Repository
public interface RelaR extends Neo4jRepository<Rela, Long> {
	
//	Person findByE1_Age(int age);

}
