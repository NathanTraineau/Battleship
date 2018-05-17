import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class Ship {
	
	protected HashMap <Coordinates,Integer> shipCoords = new HashMap<>(); //We create a ghost ship in order to return a ship object in the function "isPlayerHit" 
	protected int taille;
	
	protected Rules rules = new Rules();
	
	// un bateau doit savoir sa taille, ses coordonn√©es, o√π il est touch√©, si il est coul√©
	// On d√©fini que les prop du bateau en soit, pas en fonction des r√®gles de jeux toussa
	// On fait la progra d√©fensive √† a fin
	
	// dans bateau on a liste y a les cases du bateau
	// et une liste o√π y a les cases touchees du bateau 
	// une fonction isDestroyed si la liste des cases touch√©es == taille
	
	
	
	public Ship(Coordinates startCoord, Coordinates endCoord) {
		
		rules.coordinatesShipConverter(startCoord, endCoord);		
		// this function put in letter and nb the smaller in the "first"
		// the bigger in the "end"
		for (int i = startCoord.getNumber(); i<= endCoord.getNumber(); i++)
		{
			for (char j = startCoord.getLetter(); j <= endCoord.getLetter(); j++)
				// https://stackoverflow.com/questions/2047228/auto-increment-alphabet-in-java
			{
				Coordinates key = new Coordinates(j,i);
				
				// sous forme de tableau plus que de String pour ne pas a avoir a convertir tout le temps
				this.shipCoords.put(key, 0);
				// On initialize l'Ètat ‡ 0 ca veut dire que le bateau n'a pas ÈtÈ touchÈ ou coulÈ
				//0 pas touchÈ, 1 touchÈ, 2 coulÈ
				// Is the usage of integer easy to understand and to maintain the code or should I use String instead ?
				//Does the boat should be initialize on the map or initialize with coord, then put on the map ?
				// If I want to change structur of my Key I would be obliged to change a lot of things, 
				// what should I do to avoid this ?
			}
		
		}
		
		
	}
	
	
	
	public Set<Coordinates> getCoordShip(){
		//Un Set de tableau est ce optimal et cohÈrent ?
		return this.shipCoords.keySet();
	} 
	
	public Boolean isHit(Coordinates missileCoord) {
		return missileCoord.containsCoord(getCoordShip());
	}
	
	public Boolean shipIsOnCoord(Coordinates coords) {
		return coords.containsCoord(getCoordShip());
	}
	
	public void setHit(Coordinates missileCoord) {
		Iterator<Coordinates> it = getCoordShip().iterator();
		while (it.hasNext()) {
			Coordinates coord = it.next();
			if (coord.compareCoordinates(missileCoord)){
				this.shipCoords.put(coord, 1);
			}
		
		}
			
	}
	
	
	public Set<Coordinates> getHitCoordinates() {
		//Structure set do not accept twin elements
		// I think this is more pratical to stock it than to go through all of the hit coordinates of the map
		// to know if all of the coordinates have been hit and then tell that this ship is destroyed
	    Set<Coordinates> keys = new HashSet<Coordinates>();
	    for (Entry<Coordinates, Integer> entry : this.shipCoords.entrySet()) {
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
		return getHitCoordinates().size() == this.shipCoords.size();
	}

	
	

}
