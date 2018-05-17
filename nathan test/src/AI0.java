import java.util.Random;

public class AI0 extends AI{
	
	public AI0() {
		
	}
	
	public Coordinates shoot(Player opponentPlayer) {
		return chooseRandomCoordinates(opponentPlayer);
	}

}
