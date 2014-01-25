package groovy.examples
import java.awt.event.ItemEvent;

// Numbers
x = 1
assert x.class == java.lang.Integer
x = 10000000000000000
assert x.class == java.lang.Long
x = 2.0 - 1.1
println x
assert x.class == java.math.BigDecimal

println 2**3 //8

def x = ""
3.times { x += "Hello!" }
println x

def total = 0
1.upto(3) { total += it }
println total

def countdown = []
5.downto 1, { countdown << "$it ..." }
println countdown

//Strings and GStrings
def s = 'this is a string'
assert s.class == java.lang.String
def s2 = "another string"
assert s2.class == java.lang.String
def k = 1
def s3 = "but this is a GString $k"
println s3
assert s3 instanceof GString
def s4 = '''
this is a multiline
strING
cool isnt'it'''
s4.eachLine {
	String ss = it.trim().replaceAll("[A-Z]", "x").toLowerCase()
	println ss
}

//POGOS
class Person {
	String firstName
	String lastName
	
	String toString() { "$firstName $lastName" };
}
Person p = new Person()
p.firstName = 'Zenek'
p.setLastName("Cool")
println p

Person p2 = new Person(firstName: 'Marcin', lastName: 'Cold')
println p2

//Collections
Range r = 5..8
r.contains(3)
r.from
r.to

Range r2 = 5..<8
println r2.to

def l = ['One', 'Two', 'Three']
assert l.class == java.util.ArrayList

List<Integer> l2 = [1, 2, 4]
l2 << 3
assert l2.class == java.util.ArrayList
println l2.sort()
println l2[-1]
println l*.size()
def z = l.collect { elem -> elem[0..1].toLowerCase() }
println z
def g = l.find { el -> el.contains('T') }
println g

def myMap = [one : 1, two: 2]
println myMap.two
Map<String, Integer> v = [one : 1, two : 2]
myMap.each { key,val -> println "$key=$val" }

//conditionals
if (1) { //non zero values are true, plus many more (Groovy Truth)
	println 'True'
}

//Elvis operator
def name = null
String ss = name ?: 'default' //if name is null then 'default' will be used
println ss

//Self dereference opearator
def xx = name?.toString() //checks if name is null
println xx

//XML
def xml = '''
<person>
	<name>Zenon</name>
	<age value="34"/>
</person>'''

def person = new XmlSlurper().parseText(xml)
println person.name
println person.age.@value

def builder = new groovy.xml.MarkupBuilder()
def dep = builder.department {
	depName "AFE"
	employee(id:1) {
		empName "Zenek"
	}
	employee(id:2) {
		empName "Edek"
	}
}
println dep

//JSON
def json = new groovy.json.JsonSlurper()
def res = json.parseText('{"first":"Zenon", "last":"Edek"}')
println res.first
println res.last

def b = new groovy.json.JsonBuilder()
res = b {
	first "Franek"
	last "Flinstone"
}
println b.toPrettyString()