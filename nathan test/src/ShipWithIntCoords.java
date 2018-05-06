import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

abstract class ShipWithIntCoords {
	
	protected HashMap <int[],Integer> boatCoords = new HashMap<>();

	protected int taille;
	
	// un bateau doit savoir sa taille, ses coordonn√©es, o√π il est touch√©, si il est coul√©
	// On d√©fini que les prop du bateau en soit, pas en fonction des r√®gles de jeux toussa
	// On fait la progra d√©fensive √† a fin
	
	// dans bateau on a liste y a les cases du bateau
	// et une liste o√π y a les cases touchees du bateau 
	// une fonction isDestroyed si la liste des cases touch√©es == taille
	
	
	public ShipWithIntCoords(String startCoord, String endCoord) {
		
		char[] tabCoord = Map.converterBoatCoordinates(startCoord, endCoord);
		//there is 4 integer in this tab, they represent the coordinates of the boat
		
		
		for (char i = tabCoord[0]; i< tabCoord[2]; i++)
		{
			for (char j = tabCoord[1]; j < tabCoord[3]; j++)
				// https://stackoverflow.com/questions/2047228/auto-increment-alphabet-in-java
			{
				System.out.println(i+""+j+" ");
				//int[] tabKey= {i,j};
				// sous forme de tableau plus que de String pour ne pas a avoir a convertir tout le temps
				//this.boatCoords.put(tabKey, 0);
				// On initialize l'Ètat ‡ 0 ca veut dire que le bateau n'a pas ÈtÈ touchÈ ou coulÈ
				//0 pas touchÈ, 1 touchÈ, 2 coulÈ
				// Is the usage of integer easy to understand and to maintain the code or should I use String instead ?
				//Does the boat should be initialize on the map or initialize with coord, then put on the map ?
				// If I want to change structur of my Key I would be obliged to change a lot of things, 
				// what should I do to avoid this ?
			}
		
		}
		
		
	}
	
	
	
	public Set<int[]> getCoordBoat(){
		//Un Set de tableau est ce optimal et cohÈrent ?
		return this.boatCoords.keySet();
	}
	
	public void decrisToi() {
		System.out.println("Voici un" + this.getClass());
	}
	
	
	public Boolean isHit(int[] missileCoord) {
		return this.boatCoords.containsKey(missileCoord);
	}
	
	public void setHit(int[] missileCoord) {
		int[] key = missileCoord;
		this.boatCoords.put(key, 1);	
	}
	
	
	public Set<int[]> getHitCoordinates() {
		//Structure set do not accept twin elements
		// I think this is more pratical to stock it than to go through all of the hit coordinates of the map
		// to know if all of the coordinates have been hit and then tell that this ship is destroyed
	    Set<int[]> keys = new HashSet<int[]>();
	    for (Entry<int[], Integer> entry : this.boatCoords.entrySet()) {
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

}
