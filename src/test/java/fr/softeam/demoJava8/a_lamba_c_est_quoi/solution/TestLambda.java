package fr.softeam.demoJava8.a_lamba_c_est_quoi.solution;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestLambda {
	@Test
	public void testFileFilterAvecClasseAnonyme() {
		FileFilter fileFilterJavaLambda=(File pathname)->pathname.getName().endsWith(".java");
		
		File repertoire=new File("c:\\temp");
		
		for(File f:repertoire.listFiles(fileFilterJavaLambda))
			System.out.println(f);
		
	}
	
	@Test
	public void testRunnable() throws InterruptedException {
		Runnable runnableLambda=()->{
			for(int i=0;i<3;i++) {
				System.out.println("Hello from "+Thread.currentThread().getName());
			}
		};
		
		Thread t=new Thread(runnableLambda);
		t.start();
		t.join();
	}
	
	
	@Test
	public void testComparator() throws InterruptedException {
		Comparator<String> comparatorLambda=(String o1, String o2)->Integer.compare(o1.length(), o2.length());
		
		List<String> strings=Arrays.asList("aaaaaaa","aaaa","a","aaa");
		Collections.sort(strings, comparatorLambda);
		
		for(String s:strings){
			System.out.println(s);
		}
		
	}
	
	
	//Pour générer présentation : bundle exec asciidoctor-revealjs java8Lambda.adoc
}
