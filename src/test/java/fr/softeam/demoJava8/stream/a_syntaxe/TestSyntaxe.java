package fr.softeam.demoJava8.stream.a_syntaxe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

public class TestSyntaxe {

	@Test
	public void test_forEach(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		Stream<Personne> s=personnes.stream();
		
		s.forEach(p->System.out.println(p));
	}
	
	@Test
	public void test_forEach2(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		
		Stream<Personne> s=Stream.of(p1,p2,p3);
		
		s.forEach(System.out::println);
	}
	
	@Test
	public void test_forEach_avecPlusieursConsumers(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		Stream<Personne> s=personnes.stream();
		
		Consumer<Personne> consNom=(p->System.out.println(p.getNom()));
		Consumer<Personne> consAge=(p->System.out.println(p.getAge()));
		
		s.forEach(consNom.andThen(consAge));
	}
	
	@Test
	public void test_forEach_filter(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		

		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		Stream<Personne> s=personnes.stream();
		
		s.filter(p->p.getAge()>20).forEach(p->System.out.println(p));
	}
	
	
	@Test
	public void test_forEach_filterPlusieursPredicates(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		

		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		Stream<Personne> s=personnes.stream();

		Predicate<Personne> ageSup20=(p->p.getAge()>20);
		Predicate<Personne> ageInf60=(p->p.getAge()<60);
		Predicate<Personne> nomCommencantParA=(p->p.getAge()<60);
		
		s.filter(ageSup20.and(ageInf60)).forEach(p->System.out.println(p));
		
		s.filter(nomCommencantParA.or(ageSup20.and(ageInf60)));// (nomCommencantParA OR ageSup20) AND ageInf60
	}
	
}
