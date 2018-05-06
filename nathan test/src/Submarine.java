public class Submarine extends Ship {
	protected static int lenghtSubmarine = 3;
	
	
	public Submarine(String startCoord, String endCoord) {
		super(startCoord, endCoord);
		this.taille= lenghtSubmarine;
	}
}