package player;
import java.util.HashSet;
import java.util.Set;

import boardGame.Coordinates;
import game.Rules;

public class AI1 extends AI{
	
	HashSet<Coordinates> shotCoords = new HashSet<Coordinates>();
	
	public AI1() {
		
	}
	
	public Coordinates shoot(Rules rules,Player opponentPlayer) {
		
		Coordinates shot = chooseRandomCoordinates(opponentPlayer);
		if (shot.containsCoord(getShotCoords())) {
			return shoot(rules, opponentPlayer);
		}
		else {
			addShotCoords( shot);
			return shot;
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
}
