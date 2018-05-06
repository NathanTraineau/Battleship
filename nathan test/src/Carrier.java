

public class Carrier extends Ship{
	protected static int lenghtCarrier = 5;
	
	
	public Carrier(String startCoord, String endCoord) {
		super(startCoord, endCoord);
		this.taille= lenghtCarrier;
		
	}

}
