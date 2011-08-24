package org.obolibrary.obo2owl.test;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 * @author cjm
 * 
 *
 */
public class SynonymTest extends OboFormatTestBasics {

	@BeforeClass
	public static void beforeClass(){
		Logger.getRootLogger().setLevel(Level.ERROR);
	}
	
	@Test
	public void testConvert() throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
		// PARSE TEST FILE
		OWLOntology ontology =convert(parseOBOFile("synonym_test.obo"));
		
		Set<OWLAnnotation> anns = ontology.getAnnotations();
		for (OWLAnnotation ann : anns) {
			// TODO
			System.out.println("Ann="+ann);
		}
		
		Set<OWLAnnotationProperty> aps = ontology.getAnnotationPropertiesInSignature();
		for (OWLAnnotationProperty ap : aps) {
			System.out.println("ap="+ap);
		}
		
		// TODO


	}

}
