package learning;

public class salarier {
	
	protected String nom;
	protected int salaire;
	
	
	
	public salarier(String nom) {
		super();
		this.nom = nom;
	}
	
	
	 public void afficherSalaire() {
		 
		 System.out.println("Le salaire du "+this+"est "+ salaire); 
		 
	 }
	
	


	@Override
	public String toString() {
		return " " + nom + " ";
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
	
}