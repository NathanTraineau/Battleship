
public class Ville {
	private String nomVille;
	private String nomPays;
	private int nbreHabitants;
	
	public Ville() {
		System.out.println("Cr�ation d'une ville!");
		nomVille = "Inconnu";
		nomPays = "Inconnu";
		nbreHabitants = 0;
		
		
	}
	
	public Ville ( String pNom, int pNbre, String pPays) {
		nomVille = pNom;
		nomPays = pPays;
		nbreHabitants = pNbre;
	}
	
	public String getNom() {
		return nomVille;
	}
	
	public String getNomPays() {
		return nomPays;
	}

	public int getNombreHabitants() {
		return nbreHabitants;
	}
	
	public void setNom(String pNom)
	  {
	    nomVille = pNom;
	  }

	  //D�finit le nom du pays
	public void setNomPays(String pPays)
	  {
	    nomPays = pPays;
	  }

	  //D�finit le nombre d'habitants
	public void setNombreHabitants(int nbre)
	  {
	    nbreHabitants = nbre;
	  } 

}
