import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public abstract class AI implements Player {
	
	
	String name;
	HashSet<Ship> ships = new HashSet<Ship>();
	Map map = new Map();
	
	public AI() {;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name ;
	}
	
	public Set<Ship> getShips(){
		return this.ships ;
	}
	public void addShipPlayer(Ship ship) {
		this.ships.add(ship);
		this.getPlayerMap().addShipCoords(ship);
	};
	
	// Map
	
	// Could a map exists without a player ? I guess
	public Map getPlayerMap(){
		return this.map ;
	}
	
	public void setPlayerMap(  char lenght,int height){
		this.getPlayerMap().setMap( height, lenght);
		
	}
	public Ship isPlayerHit(Coordinates missileCoord) {
		//Check if the player is hit and put the hit marker on the boat
		Iterator<Ship> it = getShips().iterator();
		while (it.hasNext()) {
			Ship ship = it.next();
			if (ship.isHit(missileCoord)){
				return ship;
			}
		};
		
		return null;
	}
	
	
	public boolean occupyCoordinates(Coordinates coords) {
		Iterator<Ship> it = getShips().iterator();
		while (it.hasNext()) {
			if (it.next().shipIsOnCoord(coords)){
				return true;
			}
		};
		return false;
	}

	public boolean playerIsDead() {
		Iterator<Ship> it = getShips().iterator();
		while (it.hasNext()) {
			if ((it.next().isDestroyed()) == false) {
				return false;
			}
			
		}
		
		return true;
	}
	
	
	public Coordinates chooseRandomCoordinates( Player player) {
		// choose random coord on the player map
		
		Random r = new Random();
		
		int rand = (int) 65 + r.nextInt((int) (player.getPlayerMap().getLenght()+1)- 65);
		rand = rand - 65;
		//the rank of the chosen letter
		char letter1 = '0';
		// it count the incrementation of i
		for ( char i = 'A'; i<= player.getPlayerMap().getLenght(); i++) {
			if ( (int) i- (int)'A' == rand) {
				letter1 = i;
				
			};
		
		}
		int nb1 = 1 + r.nextInt(player.getPlayerMap().getHeight());
		
		return new Coordinates(letter1,nb1);
	}
	/*
	public Coordinates chooseShipCoordinates(Rules rules, Player opponentPlayer, int size) {
		return new Coordinates("E-4","E-9");
		
	}*/
	
		public Coordinates[] chooseShipCoordinates(Rules rules, Player currentPlayer, int size) {
			
		int isBlocked = 0;
		
	    Coordinates startCoord = chooseRandomCoordinates( currentPlayer);
	
		int nb1 = startCoord.getNumber(); 
		char letter1 = startCoord.getLetter(); 
		
		int rand2;
		int nb2 = -1;
		char letter2 = '0';
		Coordinates endCoord = new Coordinates(letter2,nb2);
		
		
		// Now we will choose a endCoordinates considering the start one
		while ((!rules.verifAIShipCoordinates(currentPlayer, letter1+"-"+nb1,letter2+"-"+nb2, size))) {
		Random r = new Random();
		rand2 = 0 + r.nextInt(3);
		
		isBlocked = isBlocked +1;
		if (isBlocked > 10)
		{
			// if the ship is blocked because the startCoord is surrounded by ships
			return chooseShipCoordinates(rules, currentPlayer, size);
		}
		System.out.println(letter1+""+nb1+""+rand2);
			switch(rand2){
				case 0 :
					
					// we create the boat down
					nb2 = nb1 + (size-1);
					letter2 = letter1;	
					break;
						
				case 1 :
					
					// we create the ship to the up
					nb2 = nb1 - (size -1);
					letter2 = letter1;	
					break;
				case 2 :
					
					// we create the ship to the left
					nb2 = nb1 ;
					for ( char i = letter1; i<= 'A'; i--) {
						if ( (int) letter1 - (int)i == size-1 ) {
							letter2 = i;
						};
					}
					break;
				case 3 :
					// we create the ship to the right
					nb2 = nb1 ;
					for ( char i = letter1; i<= currentPlayer.getPlayerMap().getLenght() ; i++) {
						if ( (int) i - (int) letter1 == size-1 ) {
							letter2 = i;
						};
					}
					break;
					}
		}
		
		endCoord = new Coordinates(letter2,nb2);
		
		Coordinates[] coords= {startCoord,endCoord};
		
		return coords ;
		}
		
	
	
		abstract Coordinates shoot(Player opponentPlayer);
		
}





