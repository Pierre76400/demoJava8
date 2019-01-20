package fr.softeam.demoJava8.stream.g_parrallele;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Demo {
	final static Logger logger = LoggerFactory.getLogger(Demo.class);
	
	@Test
	public void test_parrallele1(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		Personne p4=new Personne("François",21);
		Personne p5=new Personne("Bertrand",14);
		Personne p6=new Personne("Patricia",71);
		Personne p7=new Personne("Lucie",21);
		Personne p8=new Personne("Mathieu",14);
		Personne p9=new Personne("Mike",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9);
		
		personnes.stream().parallel().forEach(p->logger.info(p.getNom()));
	}
	
	
	@Test
	public void test_parrallele2(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",14);
		Personne p3=new Personne("Paul",71);
		Personne p4=new Personne("François",21);
		Personne p5=new Personne("Bertrand",14);
		Personne p6=new Personne("Patricia",71);
		Personne p7=new Personne("Lucie",21);
		Personne p8=new Personne("Mathieu",14);
		Personne p9=new Personne("Mike",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9);
		
		personnes.parallelStream().forEach(p->logger.info(p.getNom()));
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
	public void test_collectorMap(){
		Personne p1=new Personne("John",21);
		Personne p2=new Personne("Luc",21);
		Personne p3=new Personne("Paul",71);
		
		List<Personne> personnes=Arrays.asList(p1,p2,p3);
		
		Map<Integer,List<Personne>> res=personnes.stream().filter(p->p.getAge()>20).collect(Collectors.groupingBy(p->p.getAge()));
		System.out.println(res);
	}
	
}
