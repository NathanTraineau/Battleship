
public class Cruiser extends Ship {
	protected static int lenghtCruiser = 3;
	
	
	public Cruiser(String startCoord, String endCoord) {
		super(startCoord, endCoord);
		this.taille= lenghtCruiser;
	}
}