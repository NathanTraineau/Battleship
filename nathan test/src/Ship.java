
abstract class Ship {
	
	protected String startCoord;
	protected String endCoord;
	protected int taille;
	
	// un bateau doit savoir sa taille, ses coordonnées, où il est touché, si il est coulé
	// On défini que les prop du bateau en soit, pas en fonction des règles de jeux toussa
	// On fait la progra défensive à a fin
	
	// dans bateau on a liste où y a les cases du bateau
	// et une liste où y a les cases touchées du bateau 
	// une fonction isDestroyed si la liste des cases touchées == taille
	
	
	public Ship(String startCoord, string endCoord) {
		//Fonction cr�eant un bateau
		this.startCoord = null;
		this.endCoord = null;
		this.taille = Staille;
		
	}
	
	public int getTaille(){
		return this.taille;
	}
	
	public String getStartCoord(){
		return this.startCoord;
	}
	
	public String getEndCoord(){
		return this.endCoord;
	}
	
	public void decrisToi() {
		System.out.println("Voici un" + this.getClass());
	}
	
	
	public boolean placesNonOccupes(String demandeStartCoord, String demandeEndCoord) {
		// return true if the coordinates entered as parameters are empty (no boat occupies it)
	}
	
	public void placerBateau(String startCoordChoisir, String endCoordChoisir, int taille) {
		
		
	}
	
	public Boolean isHit(String missileCoord) {};
	
	public Boolean isDestroyed(String missileCoord) {};

}
