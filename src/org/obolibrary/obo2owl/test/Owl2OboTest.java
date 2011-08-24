package org.obolibrary.obo2owl.test;

import static junit.framework.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.obolibrary.obo2owl.Owl2Obo;
import org.obolibrary.oboformat.model.OBODoc;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class Owl2OboTest extends OboFormatTestBasics {

	@BeforeClass
	public static void beforeClass() {
		Logger.getRootLogger().setLevel(Level.ERROR);
	}
	
	@Test
	public void testConversion() throws Exception{

		OWLOntology ontology = convert(parseOBOFile("caro.obo"));
		OBODoc doc = convert(ontology);
		
		writeOBO(doc, "caro_converted.obo");
	}

	@Test
	public void testIRTsConversion() throws Exception{
		IRI ontologyIRI = IRI.create("http://purl.obolibrary.org/obo/test.owl");

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		OWLOntology ontology = manager.createOntology(ontologyIRI);

		convert(ontology);

		String ontId = Owl2Obo.getOntologyId(ontology);

		assertTrue("test".equals(ontId));

		IRI iri = IRI.create("http://purl.obolibrary.org/obo/OBI_0000306");
		String id = Owl2Obo.getIdentifier(iri);
		assertTrue("OBI:0000306".endsWith(id));

		if (false) {
			// TODO

			iri = 	IRI.create("http://purl.org/obo/owl/NCBITaxon#NCBITaxon_5794");
			id = Owl2Obo.getIdentifier(iri);
			System.out.println("tax id = "+id);
			assertTrue("http://purl.org/obo/owl/NCBITaxon#NCBITaxon_5794".equals(id));
		}

		iri = 	IRI.create("http://purl.obolibrary.org/obo/IAO_0000119");
		id = Owl2Obo.getIdentifier(iri);
		assertTrue("IAO:0000119".equals(id));

		iri = 	IRI.create("http://purl.obolibrary.org/obo/caro_part_of");
		id = Owl2Obo.getIdentifier(iri);
		assertTrue("http://purl.obolibrary.org/obo/caro_part_of".equals(id));

		iri = 	IRI.create("http://purl.obolibrary.org/obo/MyOnt#_part_of");
		id = Owl2Obo.getIdentifier(iri);
		assertTrue("MyOnt:part_of".equals(id));


		iri = 	IRI.create("http://purl.obolibrary.org/obo/MyOnt#termid");
		id = Owl2Obo.getIdentifier(iri);
		assertTrue("termid".equals(id));


		iri =   IRI.create("http://www.w3.org/2002/07/owl#topObjectProperty");
		id = Owl2Obo.getIdentifier(iri);
		assertTrue("owl:topObjectProperty".equals(id));		

	}



}
