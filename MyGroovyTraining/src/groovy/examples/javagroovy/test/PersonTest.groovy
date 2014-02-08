package groovy.examples.javagroovy.test

import groovy.examples.javagroovy.Person
import spock.lang.Specification

class PersonTest extends Specification {
	Person p;
	
	def "Person object created from Java class should work"() {
		given: 
		p = new Person()
		
		when:
		p.name = 'Edek'
		
		then: 
		p.name == 'Edek'
	}
	
	def "Person object created from Java class in Groovy way should work"() {
		given:
		p = new Person(name: 'Zenek')
		
		expect:
		p.name == 'Zenek'
	}
}
