public class Destroyer extends Ship {
	protected static int lenghtDestroyer = 2;
	
	
	public Destroyer(String startCoord, String endCoord) {
		super(startCoord, endCoord);
		this.taille= lenghtDestroyer;
	}
}