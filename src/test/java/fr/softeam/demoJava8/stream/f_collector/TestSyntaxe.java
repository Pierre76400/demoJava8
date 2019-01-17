package fr.softeam.demoJava8.stream.f_collector;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestSyntaxe {

	@Test
	public void test_collector1(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		String res=personnes.stream().filter(p->p.getAge()>20).map(p->p.getNom()).collect(Collectors.joining(","));
		System.out.println(res);
	}
	

	@Test
	public void test_collector2(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		List<String> res=personnes.stream().filter(p->p.getAge()>20).map(p->p.getNom()).collect(Collectors.toList());
		System.out.println(res);
	}
	
	

	@Test
	public void test_pro(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		Stream<Personne> s=Arrays.asList(p1,p2,p3).stream();
		s.map(p->p.getNom()).forEach(p->System.out.println(p));
	}
}
