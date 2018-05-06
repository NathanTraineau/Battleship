import java.util.HashSet;
import java.util.Set;

public class Player {
	
	boolean AI;
	String name;
	HashSet<Ship> ships = new HashSet<Ship>();
	Map map = new Map(); //A player need a map in this game but in order to separate
	//all of the entities shouldn't I only affiliate a map to it in the main ?
	// player.map is more clear to me as we may need to create multiple players 
	// which would occur many maps if we change the rules etc..
	// But 2 players could also have the same map..
							
	
	public Player() {
		
	}
	
	// Name
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name ;
	}
	
	// Ships
	
	public Set<Ship> getShips(){
		return this.ships ;
	}
	public void addShipPlayer(Ship ship) {
		this.ships.add(ship);
	};
	
	// Map
	
	// Could a map exists without a player ? I guess
	public Map getPlayerMap(){
		return this.map ;
	}
	
	public void setMap( int height, char lenght){
		this.getPlayerMap().setMap( height, lenght);
		
	}
	public Ship isPlayerHit(String missileCoord) {
		//Check if the player is hit and put the hit marker on the boat
		for( Ship ship : this.getShips()) {
			if (ship.isHit(missileCoord)){
				
				return ship;
			}
		};
		
		return new Water();
	}
	
	
	

	public boolean playerIsDead() {
		for (Ship ship : getShips()) {
			if (ship.isDestroyed() == false) {
				return false;
			}
			
		}
		
		return true;
	}

}
