package fr.softeam.demoJava8.a_lamba_c_est_quoi;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestLambda {
	@Test
	public void testFileFilterAvecClasseConcrete() {
		
		FileFilter fileFilterJava=new FileFilterJava();		
		File repertoire=new File("c:\\temp");
		
		for(File f:repertoire.listFiles(fileFilterJava))
			System.out.println(f);
			
	}
	
	@Test
	public void testFileFilterAvecClasseAnonyme() {
		
		FileFilter fileFilterJava=new FileFilter() {		
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		
		File repertoire=new File("c:\\temp");
		
		for(File f:repertoire.listFiles(fileFilterJava))
			System.out.println(f);
		
	}
	
	@Test
	public void testRunnable() throws InterruptedException {
		
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<3;i++) {
					System.out.println("Hello from "+Thread.currentThread().getName());
				}
			}
		};
		
		Thread t=new Thread(runnable);
		t.start();
		t.join();
	}
	
	
	@Test
	public void testComparator() throws InterruptedException {
		Comparator<String> comparator= new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		}; 
		
		List<String> strings=Arrays.asList("aaaaaaa","aaaa","a","aaa");
		Collections.sort(strings, comparator);
		
		for(String s:strings){
			System.out.println(s);
		}
		
	}
	
	
	//Pour générer présentation : bundle exec asciidoctor-revealjs java8Lambda.adoc
}
