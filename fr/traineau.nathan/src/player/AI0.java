package player;
import coordinates.Coordinates;
import game.Rules;

public class AI0 extends AI{
	
	public AI0() {
		
	}
	
	public Coordinates chooseShoot(Rules rules, IPlayer opponentPlayer) {
		return chooseRandomCoordinates(opponentPlayer);
	}

}
