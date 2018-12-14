package fr.softeam.demoJava8.c_lamba_syntaxe_avancee.solution;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class TestLambda2 {
	@Test
	public void testComparator_avecNouvelleSyntaxeParametre() throws InterruptedException {
		Comparator<String> comparatorLambda=(String o1, String o2)->Integer.compare(o1.length(), o2.length());
		
		List<String> strings=Arrays.asList("aaaaaaa","aaaa","a","aaa");
		Collections.sort(strings, comparatorLambda);
		
		for(String s:strings){
			System.out.println(s);
		}	
	}
	

	@Test
	public void testConsumer_avecSystemOutPrintln() throws InterruptedException {
		Consumer<String> consumerPrint=System.out::println;
		
		List<String> strings=Arrays.asList("aaaaaaa","aaaa","a","aaa");
		
		strings.forEach(consumerPrint);
		
	}
	
	@Test
	public void testComparator_avecSystemOutPrintln() throws InterruptedException {
		Comparator<Integer> comparatorLambda=Integer::compare;
		
		List<Integer> ints=Arrays.asList(Integer.valueOf(3),Integer.valueOf(2),Integer.valueOf(1));
		Collections.sort(ints, comparatorLambda);
		
		for(Integer s:ints){
			System.out.println(s);
		}	
	}
	
}
