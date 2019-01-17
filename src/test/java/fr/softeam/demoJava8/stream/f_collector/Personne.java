package fr.softeam.demoJava8.stream.f_collector;

public class Personne {
	private String nom;
	private Integer age;

	public Personne (String nom,Integer age) {
		this.nom=nom;
		this.age=age;
	}
	public String getNom() {
		return nom;
	}


	public Integer getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + "]";
	}

	
}
