import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

abstract class Ship {
	
	protected HashMap <String,Integer> boatCoords = new HashMap<>();
	protected boolean isWater = false; //We create a ghost ship in order to return a ship object in the function "isPlayerHit" 
	protected int firstNb;
	protected int endNb;
	protected char firstLetter;
	protected char endLetter;
	protected int taille;
	
	// un bateau doit savoir sa taille, ses coordonn√©es, o√π il est touch√©, si il est coul√©
	// On d√©fini que les prop du bateau en soit, pas en fonction des r√®gles de jeux toussa
	// On fait la progra d√©fensive √† a fin
	
	// dans bateau on a liste y a les cases du bateau
	// et une liste o√π y a les cases touchees du bateau 
	// une fonction isDestroyed si la liste des cases touch√©es == taille
	
	public Ship() {
		this.isWater = true;
	}
	
	
	public Ship(String startCoord, String endCoord) {
		
		coordinatesConverter(startCoord, endCoord);		
		// this function put in letter and nb the smaller in the "first"
		// the bigger in the "end"
		for (int i = this.firstNb; i<= this.endNb; i++)
		{
			for (char j = this.firstLetter; j <= this.endLetter; j++)
				// https://stackoverflow.com/questions/2047228/auto-increment-alphabet-in-java
			{
				String key = j+""+i;
				// sous forme de tableau plus que de String pour ne pas a avoir a convertir tout le temps
				this.boatCoords.put(key, 0);
				// On initialize l'Ètat ‡ 0 ca veut dire que le bateau n'a pas ÈtÈ touchÈ ou coulÈ
				//0 pas touchÈ, 1 touchÈ, 2 coulÈ
				// Is the usage of integer easy to understand and to maintain the code or should I use String instead ?
				//Does the boat should be initialize on the map or initialize with coord, then put on the map ?
				// If I want to change structur of my Key I would be obliged to change a lot of things, 
				// what should I do to avoid this ?
			}
		
		}
		
		
	}
	
	
	
	public Set<String> getCoordShip(){
		//Un Set de tableau est ce optimal et cohÈrent ?
		return this.boatCoords.keySet();
	}
	
	public void decrisToi() {
		System.out.println("Voici un" + this.getClass());
	}
	
	
	public Boolean isHit(String missileCoord) {
		return this.boatCoords.containsKey(missileCoord);
	}
	
	public void setHit(String missileCoord) {
		String key = missileCoord;
		this.boatCoords.put(key, 1);	
	}
	
	
	public Set<String> getHitCoordinates() {
		//Structure set do not accept twin elements
		// I think this is more pratical to stock it than to go through all of the hit coordinates of the map
		// to know if all of the coordinates have been hit and then tell that this ship is destroyed
	    Set<String> keys = new HashSet<String>();
	    for (Entry<String, Integer> entry : this.boatCoords.entrySet()) {
	        if (Objects.equals(1, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
	
	
	public Boolean isDestroyed() {
		// return True si le bateau est dÈtruit
		//If we wanted to change the data structur of the hitCoordinates we may need to change this too
		// 
		return getHitCoordinates().size() == this.boatCoords.size();
	}


	public void coordinatesConverter(String startCoord, String endCoord) {
		//We put this function in the ship class because it was difficult to return 
		// diferent value of coordinates (int and char), what I should have done if i wanted to 
		// put it in the map class
		String[] parts1 = startCoord.split("-");
		String[] parts2 = endCoord.split("-");
		int nb1 = Integer.parseInt(parts1[1]);
		int nb2 = Integer.parseInt(parts2[1]);
		char letter1 = startCoord.charAt(0);
		char letter2 = endCoord.charAt(0);
		// In order to begin with the coordinates that are the smaller to increment the coordinates in the constructor
		// We calculate the smaller one from the 2 types
		// A boat in diagonal would be a rectangle
		
		if  (nb1>nb2) {
			this.firstNb = nb2;
			this.endNb = nb1;
			//System.out.print("n1>n2");
		}
		else {
			this.firstNb = nb1;
			this.endNb = nb2;
			//System.out.print("n1<n2");;
		}
		if  (letter1>letter2) {
			this.firstLetter = letter2;
			this.endLetter = letter1;
			//System.out.print("letter1>letter2");
			
		}
		else {
			this.firstLetter = letter1;
			this.endLetter = letter2;
			//System.out.print("letter1<letter2");;
		}
	}
}
