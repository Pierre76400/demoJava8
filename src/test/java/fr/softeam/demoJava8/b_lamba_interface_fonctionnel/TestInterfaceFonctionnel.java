package fr.softeam.demoJava8.b_lamba_interface_fonctionnel;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestInterfaceFonctionnel {
	@Test
	public void testMotDePasse() {
		MotDePasse mdp=(String s)->s.equals("secret");
		
		String motDePasseSaisie="secret";
		
		if(mdp.accept(motDePasseSaisie)) {
			System.out.println("Mot de passe trouvé");
		}
	}
	
	
	//Pour générer présentation : bundle exec asciidoctor-revealjs java8Lambda.adoc
}
