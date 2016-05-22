# 272extracredit
Extra Credit Project
Problem : Relationship is a vocabulary for describing relationship between people. 
Use this to describe your own family tree and then use Jena API to store and query such as: who is the grandparent? 
How many siblings he has etc… Hint: http://vocab.org/relationship/ Jena: https://jena.apache.org/index.html


src/hello/helloRDF.java - is my java class file that basically makes connection with an RDF file and queries it.
src/family.rdf - is my RDF file that defines the family relationships. 

Here, 
Smitha is the daughter of Kala and Ramani
Kala is the daughter of Vaithee and Chitra
Srikanth is the son of Vaithee and Chitra
Srikanth is the sibling of Kala
Srikanth is the uncle of Smitha
Madhu and Raghav are a couple

Based on these relationships defined in family.rdf, we query them using SPARQL from java project.
This is achieved with the help of Jena API.

Thanks!
Smitha



