package boardGame;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	HashSet<Coordinates> ownMissCoords = new HashSet<Coordinates>();
	HashSet<Coordinates> ownHitCoords = new HashSet<Coordinates>();
	HashSet<Coordinates> shipCoords = new HashSet<Coordinates>();
	
	// Shot of the opponent on your map
	HashSet<Coordinates> opponentMissCoords = new HashSet<Coordinates>();
	HashSet<Coordinates> OpponentHitCoords = new HashSet<Coordinates>();
	public Map() {
		
	}

	public void setMap( int height, char lenght){
		//So we can decide how tall the map is, in the main
		setHeight(height);
		setLenght(lenght);
		
	}
	
	public void opponentMapDisplay() {
		//Print the map on the console
		for (int i = 0; i <= getHeight(); i++) {
			System.out.print(i);
		    for (char j = 'A'; j <= getLenght(); j++) {
		    	Coordinates coord = new Coordinates(j,i);
		    	if (i == 0) {
		    		System.out.print("  |"+j);
		    	}
		    	else if (coord.containsCoord(getOwnMissCoords())) {
		    		System.out.print("   O");
		    	}
		    	 else if (coord.containsCoord(getOwnHitCoords())) {
		    		System.out.print("   !");
		    	}
		    	
		    	else {
		    		System.out.print("   .");
		    	}
		    		
		        
		    }
		    System.out.println(" |\n");
		    
		}
		
	}
	
	
	public void ownMapDisplay() {
		//Print the map on the console
		for (int i = 0; i <= getHeight(); i++) {
			System.out.print(i);
		    for (char j = 'A'; j <= getLenght(); j++) {
		    	Coordinates coord = new Coordinates(j,i);
		    	if (i == 0) {
		    		System.out.print("  |"+j);
		    	}
		    	else if (coord.containsCoord(getOpponentMissCoords())) {
		    		System.out.print("   O");
		    	}
		    	 else if (coord.containsCoord(getOpponentHitCoords())) {
		    		System.out.print("   !");
		    	}
		    	else if (coord.containsCoord(getShipCoords())) {
		    		System.out.print( "   S");
		    	}
		    	
		    	else {
		    		System.out.print("   .");
		    	}
		    		
		        
		    }
		    System.out.println(" |\n");
		    
		}
		
	}
	
		public int getHeight() {
			return this.height;
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		public char getLenght() {
			return this.lenght;
		}
		
		public void setLenght(char lenght) {
			this.lenght = lenght;
		}
		
		
		public void addOwnMissCoords(Coordinates coord) {
			//Structure set do not accept twin elements
			 this.ownMissCoords.add(coord);
		
		}
		
		
		public void  addOwnHitCoords(Coordinates coord){
			// add coordinates were a boat was hit 
			this.ownHitCoords.add(coord);
			
		}
		
		public void addOpponentMissCoords(Coordinates coord) {
			//Structure set do not accept twin elements
			 this.opponentMissCoords.add(coord);
		
		}
		
		
		public void  addOpponentHitCoords(Coordinates coord){
			// add coordinates were a boat was hit 
			this.OpponentHitCoords.add(coord);
			
		}
		
		public void  addShipCoords(Ship ship){
			// add coordinates were a boat was hit 
			Iterator<Coordinates> it = ship.getCoordShip().iterator();
			while (it.hasNext()) {
				this.shipCoords.add(it.next());
			}
			
		}



		
	public Set<Coordinates> getOwnMissCoords() {
		//Structure set do not accept twin elements
		 return this.ownMissCoords;
	
	}
	
	
	public Set<Coordinates>  getOwnHitCoords(){
		// Return all the coordinates were a boat was hit but not yet sinked
		return this.ownHitCoords;
		
	}
	
	public Set<Coordinates> getOpponentMissCoords() {
		//Structure set do not accept twin elements
		 return this.opponentMissCoords;
	
	}
	
	
	public Set<Coordinates>  getOpponentHitCoords(){
		// Return all the coordinates were a boat was hit but not yet sinked
		return this.OpponentHitCoords;
		
	}
	
	public Set<Coordinates> getShipCoords() {
		//Structure set do not accept twin elements
		 return this.shipCoords;
	
	}
	


	
	
	


}
