import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;


public class Map {
	
	//It is more something like a coordinates class than a real map
	//It doesn't stock a map 
	
	// une map doit savoir quelles sont ses cases occupées, sa taille
	// Quelles sont les cases où les bateaux ont étés touchés
	// les cases déjà visées
	// S'afficher
	// Should I use string as coord and to display the map : only 

	
	int height;
	char lenght;
	HashSet<String> missCoords = new HashSet<String>();
	HashSet<String> hitCoords = new HashSet<String>();
	HashSet<String> sinkedCoords = new HashSet<String>();
	
	public Map() {
		
	}

	public void setMap( int height, char lenght){
		//So we can decide how tall the map is, in the main
		setHeight(height);
		setLenght(lenght);
		
	}
	
	public void mapDisplay() {
		//Print the map on the console
		for (int i = 0; i <= getHeight(); i++) {
			System.out.print(i);
		    for (char j = 'A'; j <= getLenght(); j++) {
		    	String coord = j+""+i;
		    	if (i == 0) {
		    		System.out.print("  |"+j);
		    	}
		    	else if (getMissCoords().contains(coord)) {
		    		System.out.print("  |O");
		    	}
		    	else if (getHitCoords().contains(coord)) {
		    		System.out.print("  |!");
		    	}
		    	else if (getSinkedCoords().contains(coord)) {
		    		System.out.print("  |X");
		    	}
		    	else {
		    		System.out.print("  |.");
		    	}
		    		
		        
		    }
		    System.out.println("|\n");
		    
		}
		
	}
	
		public int getHeight() {
			return this.height;
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		public int getLenght() {
			return this.lenght;
		}
		
		public void setLenght(char lenght) {
			this.lenght = lenght;
		}
		
		
		public void addMissCoords(String coord) {
			//Structure set do not accept twin elements
			 this.missCoords.add(coord);
		
		}
		
		
		public void  addHitCoords(String coord){
			// add coordinates were a boat was hit 
			this.hitCoords.add(coord);
			
		}
		public void  removeHitCoords(Set<String> coords){
			// remove coordinates from hitCoords (when ships ar sinked)
			for ( String coord : coords) {
				this.hitCoords.remove(coord);
			}
			
		}
		
		public void  addSinkedCoords(Set<String> coords){
			// add coordinates to sinkedCoords
			for ( String coord : coords) {
				this.sinkedCoords.add(coord);
			}
			
		}
		

		
	
		
	public Set<String> getMissCoords() {
		//Structure set do not accept twin elements
		 return this.missCoords;
	
	}
	
	
	public Set<String>  getHitCoords(){
		// Return all the coordinates were a boat was hit but not yet sinked
		return this.hitCoords;
		
	}
	

	
	public Set<String> getSinkedCoords(){
		// Return all the coordinates were was a sinked a boat
		return this.sinkedCoords;
		
	}
	
	
	


}
