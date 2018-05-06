

public class Battleship extends Ship {
	protected static int lenghtBattleShip = 5;
	
	
	public Battleship(String startCoord, String endCoord) {
		super(startCoord, endCoord);
		this.taille= lenghtBattleShip;
	}
}
