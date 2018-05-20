package player;
import boardGame.*;
import java.util.Iterator;
import java.util.Set;

import boardGame.Coordinates;
import boardGame.Map;
import boardGame.Ship;

public interface IPlayer {
	
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

	public void addOwnMapMissCoords(Coordinates coord);
	
	public void  addOwnMapHitCoords(Coordinates coord);
	
	public void addOpponentMapMissCoords(Coordinates coord);
	
	
	public void  addOpponentMapHitCoords(Coordinates coord);
	
	public void  addShipMapCoords(Ship ship);
		
	}
	
