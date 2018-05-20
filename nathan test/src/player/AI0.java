package player;
import java.util.Random;

import boardGame.Coordinates;
import game.Rules;

public class AI0 extends AI{
	
	public AI0() {
		
	}
	
	public Coordinates shoot(Rules rules, IPlayer opponentPlayer) {
		return chooseRandomCoordinates(opponentPlayer);
	}

}
