package hello;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class helloRDF {
	  static final String inputFileName = "family.rdf";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sparqlTest();
		
	}

	static void sparqlTest() {
		// TODO Auto-generated method stub
		FileManager.get().addLocatorClassLoader(helloRDF.class.getClassLoader());
		Model m = FileManager.get().loadModel("C:/Users/smith/Documents/Notes/272/272FinalProject-old/272EC/src/family.rdf");
		String queryString = 
				"PREFIX rel: <http://purl.org/vocab/relationship/> " +
				"SELECT ?uncleoraunt " +
				"WHERE {" +
				"      <http://family/Smitha> rel:childOf ?x . " +
				"      ?x rel:siblingOf ?uncleoraunt . " +
				"      }";
		String queryString1 = "PREFIX rela: <http://purl.org/vocab/relationship/> " +
				"SELECT ?person ?grandparents " +
				"WHERE {" +
				"      ?grandparents rela:parentOf ?y . " +
				"      ?y rela:parentOf ?person . " +
				"      }";
		String queryString2 = "PREFIX rel: <http://purl.org/vocab/relationship/> " +
				"SELECT (COUNT(*) AS ?numberOfsiblingsOfGRANDPARENTS) " +
				"WHERE {" +
				"      ?grandparents rel:parentOf ?y . " +
				"      ?y rel:parentOf ?person . " +
				"      ?siblings rel:siblingOf ?grandparents . " +
				"      }";
		String queryString3 = "PREFIX rel: <http://purl.org/vocab/relationship/> " +
				"SELECT ?person ?spouse " +
				"WHERE {" +
				"      ?spouse rel:spouseOf ?person . " +
				"      }";
		Query query = QueryFactory.create(queryString);
		Query query1 = QueryFactory.create(queryString1);
		Query query2 = QueryFactory.create(queryString2);
		Query query3 = QueryFactory.create(queryString3);
		QueryExecution qexec = QueryExecutionFactory.create(query, m);
		QueryExecution qexec1 = QueryExecutionFactory.create(query1, m);
		QueryExecution qexec2 = QueryExecutionFactory.create(query2, m);
		QueryExecution qexec3 = QueryExecutionFactory.create(query3, m);
		try
		{
			ResultSet rs = qexec.execSelect();
			while(rs.hasNext())
			{
				ResultSetFormatter.out(System.out, rs, query);
			}
		}
		finally
		{
			qexec.close();
		}
		try
		{
			ResultSet rs1 = qexec1.execSelect();
			while(rs1.hasNext())
			{
				ResultSetFormatter.out(System.out, rs1, query1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			qexec1.close();
		}
		try
		{
			ResultSet rs2 = qexec2.execSelect();
			while(rs2.hasNext())
			{
				ResultSetFormatter.out(System.out, rs2, query2);
			}
		}
		finally
		{
			qexec2.close();
		}
		try
		{
			ResultSet rs3 = qexec3.execSelect();
			while(rs3.hasNext())
			{
				ResultSetFormatter.out(System.out, rs3, query3);
			}
		}
		finally
		{
			qexec3.close();
		}
	}	
}
