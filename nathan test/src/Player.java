import java.util.Set;

public interface Player {
	
	public void setName(String name);
	public String getName();
	
	public Set<Ship> getShips();
	public void addShipPlayer(Ship ship);
	
	// Map
	
	// Could a map exists without a player ? I guess
	public Map getPlayerMap();
	
	public void setPlayerMap( char lenght,int height);
	public Ship isPlayerHit(Coordinates missileCoord) ;

	public boolean playerIsDead();
	
	public boolean occupyCoordinates(Coordinates coord);

	
}
