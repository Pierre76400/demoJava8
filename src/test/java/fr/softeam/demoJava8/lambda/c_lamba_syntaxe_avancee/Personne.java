package fr.softeam.demoJava8.lambda.c_lamba_syntaxe_avancee;

public class Personne {
	
	private String nom;
	private Integer poids;
	private Integer taille;
	
	public Personne(String nom, Integer poids, Integer taille) {
		super();
		this.nom = nom;
		this.poids = poids;
		this.taille = taille;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	
}
