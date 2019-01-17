package fr.softeam.demoJava8.stream.d_map;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

public class TestSyntaxe {

	@Test
	public void test_reduce(){
		
		List<Integer> nbs=Arrays.asList(2,1,4);
		
		System.out.println(nbs.stream().reduce(0,((i1,i2) -> i1+i2)));
						
	}
	
	@Test
	public void test_max(){
		
		List<Integer> nbs=Arrays.asList(2,1,4);
		
		Optional<Integer> result=nbs.stream().max(Comparator.naturalOrder());
		
		if(result.isPresent()) {
			System.out.println(result.get());
		}
		else {
			System.out.println("Pas de résultat");
		}
	}
	

}
