import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

public class AI2 extends AI {
	
	HashSet<Coordinates> shotCoords = new HashSet<Coordinates>();;
	ArrayList<Coordinates> currentHitShots = new ArrayList<Coordinates>();
	// We save the lasts hit shots until we have sinked the ship targeted
	
	public AI2() {
		
	}
	
public Coordinates shoot(Player opponentPlayer) {
	// This ai will save the 2 lasts HitShots
		
		Coordinates shot;
		int nbHitShot = getCurrentHitShots().size() ;
		ArrayList<Coordinates> hitShots =getCurrentHitShots();	
		
		
		switch(nbHitShot) {
		
		case 0 :
			 shot = chooseRandomCoordinates(opponentPlayer);
			if (shot.containsCoord(getShotCoords())) {
				return shoot(opponentPlayer);
			}
			else {
				addShotCoords( shot);
				return shot;
			}
		
		
		case 1 :
			shot = chooseCoordinatesAroundHitShot(hitShots.get(0));
			if (shot.containsCoord(getShotCoords())) {
				return shoot(opponentPlayer);
			}
			else {
				addShotCoords( shot);
				return shot;
			}
		default :
			ListIterator<Coordinates> li = hitShots.listIterator();
			Coordinates last;
			 while(li.hasNext()) {
				 last = li.next();
				  
			 }

			if (isShipHorizontal(getCurrentHitShots())){
				getHighestLetter(getCurrentHitShots()){
					
				}
			}
		}
		
	}

	public void addShotCoords(Coordinates coord) {
		//Structure set do not accept twin elements
		 this.shotCoords.add(coord);
	
	}
	
	public Set<Coordinates> getShotCoords() {
		//Structure set do not accept twin elements
		 return this.shotCoords;
	
	}
	
	
	public void addHitShots(Coordinates shot) {
		//Structure set do not accept twin elements
		 this.currentHitShots.add(shot);
	
	}
	
	public ArrayList<Coordinates> getCurrentHitShots() {
		//Structure set do not accept twin elements
		 return this.currentHitShots;
	
	}
	
	public void hitShotsClear() {
		getCurrentHitShots().removeAll(getCurrentHitShots());
	}
	
	public boolean isShipVertical(ArrayList<Coordinates> coords) {
		//takes an array of 2 coordinates and return true if they are vertical
		return coords.get(0).getNumber() == coords.get(1).getNumber();
	}

	public boolean isShipHorizontal(ArrayList<Coordinates> coords) {
		//takes an array of 2 coordinates and return true if they are Horizontal
		return coords.get(0).getLetter() == coords.get(1).getLetter();
	}

	public Coordinates chooseCoordinatesAroundHitShot(Coordinates coord) {
		
		int nb1 = coord.getNumber(); 
		char letter1 = coord.getLetter(); 
		
		int rand;
		int nb2 = 0;
		char letter2 = '0';
		
		Random r = new Random();
		rand = 0 + r.nextInt(3);
		
		switch(rand){
			case 0 :
				
				// we create the boat down
				nb2 = nb1 -1;
				letter2 = letter1;	
				break;
					
			case 1 :
				
				// we create the ship to the up
				nb2 = nb1 + 1;
				letter2 = letter1;	
				break;
			case 2 :
				
				// we create the ship to the left
				nb2 = nb1 ;
				for ( char i = letter1; i<= 'A'; i--) {
					if ( (int) letter1 - (int)i == 1 ) {
						letter2 = i;
					};
				}
				break;
			case 3 :
				// we create the ship to the right
				nb2 = nb1 ;
				for ( char i = letter1; i<= getPlayerMap().getLenght() ; i++) {
					if ( (int) i - (int) letter1 == 1 ) {
						letter2 = i;
					};
				}
				break;
			}
		return new Coordinates(letter2,nb2);
}
		
	public Coordinates chooseVerticalCoordinatesAroundHitShot(Coordinates coord, boolean down) {
		// parameter down is true if we want to go to the down, false to the up
		int nb1 = coord.getNumber(); 
		char letter1 = coord.getLetter(); 
		
		int rand;
		int nb2 = 0;
		char letter2 = '0';
		
		if (down) rand = 0;
		else rand =1;
		;
		
		switch(rand){
			case 0 :
				
				// we create the boat down
				nb2 = nb1 -1;
				letter2 = letter1;	
				break;
					
			case 1 :
				
				// we create the ship to the up
				nb2 = nb1 + 1;
				letter2 = letter1;	
				break;
			}
		return new Coordinates(letter2,nb2);
}

	
	public Coordinates chooseHorizontalAroundHitShot(Coordinates coord, boolean left) {
		// parameter left is true if we want to go to the left, false to the right
		int nb1 = coord.getNumber(); 
		char letter1 = coord.getLetter(); 
		
		int rand;
		int nb2 = 0;
		char letter2 = '0';
		
		if (left) rand = 0;
		else rand =1;
		
		switch(rand){
			case 0 :
				
				// we create the ship to the left
				nb2 = nb1 ;
				for ( char i = letter1; i<= 'A'; i--) {
					if ( (int) letter1 - (int)i == 1 ) {
						letter2 = i;
					};
				}
				break;
			case 1 :
				// we create the ship to the right
				nb2 = nb1 ;
				for ( char i = letter1; i<= getPlayerMap().getLenght() ; i++) {
					if ( (int) i - (int) letter1 == 1 ) {
						letter2 = i;
					};
				}
				break;
			}
		return new Coordinates(letter2,nb2);
}
}


