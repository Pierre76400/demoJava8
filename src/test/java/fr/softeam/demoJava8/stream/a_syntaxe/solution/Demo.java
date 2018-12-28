package fr.softeam.demoJava8.stream.a_syntaxe.solution;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

import fr.softeam.demoJava8.stream.a_syntaxe.Personne;

public class Demo {

	@Test
	public void test_stream(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		

		Stream<Personne> s=Stream.of(p1,p2,p3);
		

		Predicate<Personne> ageSup20=(p->p.getAge()>20);
		Predicate<Personne> ageInf60=(p->p.getAge()<60);
		Predicate<Personne> nomCommencantParP=(p->p.getNom().startsWith("P"));
		
		s.filter(nomCommencantParP.or(ageSup20.and(ageInf60))).forEach(p->System.out.println(p));
		
	}
	
	
}
