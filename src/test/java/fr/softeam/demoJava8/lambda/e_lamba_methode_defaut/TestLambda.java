package fr.softeam.demoJava8.lambda.e_lamba_methode_defaut;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class TestLambda {
	
	private List<Personne> personnes;
	
	@Before
	public void initDonneesAvantTest() {
		Personne p1=new Personne("Pierre", 73, 182);
		Personne p2=new Personne("Roger", 60, 172);
		Personne p3=new Personne("Jacques",80 , 178);
		
		personnes=Arrays.asList(p1,p2,p3);
	}
	
	@Test
	public void test_forEach() throws InterruptedException {
		Consumer<Personne> c=s->System.out.println(s.getNom());
		
		personnes.forEach(c);
	}	
	
	@Test
	public void test_afficherStat_avecLambda() throws InterruptedException {
		Predicate<Personne> predicatPlusDe175cm=p->p.getTaille()>175;
	
		System.out.println("Personne faisant plus de 175 cm :");
		afficherPersonne(personnes,predicatPlusDe175cm);

		System.out.println("");
		Predicate<Personne> predicatPlusDe75kg=p->p.getPoids()>75;
		System.out.println("Personne faisant plus de 75 kg :");
		afficherPersonne(personnes,predicatPlusDe75kg);
		

		System.out.println("");
		System.out.println("Personne faisant plus de 175 cm et plus de 75 kg :");
		afficherPersonne(personnes,predicatPlusDe175cm.and(predicatPlusDe75kg));
	}

	private void afficherPersonne(List<Personne> personnes,Predicate<Personne> predicate) {
		for(Personne p:personnes) {
			if(predicate.test(p)) {
				System.out.println(p.getNom());
			}
		}
	}
	

	@Test
	public void test_afficherStat_avecLambda_avancee() throws InterruptedException {
		System.out.println("Personne faisant plus de 175 cm :");
		afficherPersonneAvancee(personnes,p->p.getTaille()>175);

		System.out.println("");
		System.out.println("Personne faisant plus de 75 kg :");
		afficherPersonneAvancee(personnes,p->p.getPoids()>75);
	}

	private void afficherPersonneAvancee(List<Personne> personnes,Predicate<Personne> predicate) {
		personnes.stream().filter(predicate).forEach(p -> System.out.println(p.getNom()));
	}
	


	
}
