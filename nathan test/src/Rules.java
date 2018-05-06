import java.util.Scanner;

public class Rules {
	
	public static boolean goodCoordinatesForm(String coord) {
		// This function verify that the coordinates is like A-34 or R-5 ... not A2, 2A, a2...
		String[] parts = coord.split("-");
		try{
			 //Where exception may happen
		char letter1 = parts[0].charAt(0);
		
		if(( parts[0] != coord && isNumeric(parts[1])) && parts[0].equals(parts[0].toUpperCase()) && Character.isLetter(letter1) && parts[0].length() ==1 ) {
			return true;
		}
		else { 
			return false;
		}
		}

		catch(java.lang.ArrayIndexOutOfBoundsException e){
			return false;
			}
		
		
	}
	
	public static boolean inMap(Player player ,  char letter1, int nb1) {
		
		Map m = player.map;
		return (m.getLenght()>=letter1 && nb1>0 && m.getHeight()>=nb1 && letter1>='A') ;
	}
	
	
	public static boolean nonDiagonal(char letter1, int nb1, char letter2,int nb2) {
		// Does the fact that we can't change from coordinates system without change everything in this function
		// is something I should be aware of ?
		// Renvoie true si le bateau n'est pas en diagonal
		if ( (Math.abs(nb1 - nb2) == 0)
				||
				(Math.abs(letter1 - letter2) == 0 ))
				{
				// Le bateau n'est pas en diagonal
				return true; }
		else {return false;}
	}
	
	
	public static boolean bonneTaille( char letter1, int nb1, char letter2,int nb2, int taille) {
		// Renvoie true si le bateau a potentiellement la bonne taille
		
		return (
				(Math.abs(nb1 - nb2) == taille-1)
				|| 
				(Math.abs(letter1 - letter2) == taille-1 ));
	}
	
	
	public static boolean isEmpty( Player player, char letter1, int nb1, char letter2,int nb2) {
		//Return true if there is no ship already on this coordinates
		boolean empty = true;
		//We first chose the smallest coordinates to increment
		if  (nb1>nb2) {
			int interm = nb1;
			nb1= nb2;
			nb2 = interm;
			
		}
		
		if  (letter1>letter2) {
			char interm1 = letter1;
			letter1= letter2;
			letter2 = interm1;
			
			
		}
		
		for (int i = nb1; i<= nb2; i++)
		{
			for (char j = letter1; j <= letter2; j++){
				// if there was a ship it would be hit if a missile was launch 
				if  (player.isPlayerHit(j+""+i).isWater == false) {
					empty = false;
				}
			}
		}
		return empty;	
	}
	
	
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
	
	public static String[] askCoordShip(Player player, int taille) {
		// ask the coordinates of the ships considering all the rules
		
		if (player.AI == true) {
			return askCoordShipAI(player,taille);
		}
		else {
		while ( true ) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please enter the Start coordinates");
		String startCoord = sc1.nextLine();
		System.out.println("Please enter the End coordinates");
		String endCoord = sc1.nextLine();
		String[] coords = {startCoord,endCoord};
		if (Rules.goodCoordinatesForm(startCoord) && Rules.goodCoordinatesForm(endCoord) ) {
			// We can divide the coordinates now
			// We need it to tests 
			// I put it directly here because the set things doesn't work with several types
			// So I don't know how to easily return a letter and an int
			String[] parts1 = startCoord.split("-");
			String[] parts2 = endCoord.split("-");
			int nb1 = Integer.parseInt(parts1[1]);
			int nb2 = Integer.parseInt(parts2[1]);
			char letter1 = startCoord.charAt(0);
			char letter2 = endCoord.charAt(0);
			
			if (Rules.inMap(player,letter1,nb1) && Rules.inMap(player,letter2, nb2) ) {
				if (Rules.nonDiagonal(letter1,nb1,letter2, nb2)) {
					if(Rules.bonneTaille(letter1,nb1,letter2, nb2, taille)) {
						if (Rules.isEmpty(player, letter1,nb1,letter2, nb2)) {
							return coords;
						}
					}
					else { System.out.println("The size of the ship isn't good, try again it should be "+ taille + "coordinates large");
						
					}
				}
				else {System.out.println("The ship is in diagonal, try again it should be like A-2");
					
				}
				
			}
			else { System.out.println("Coordinates out of map, try again it should be between 0 and 10, and A to J" );// can't do this.height.. because cannot do a static reference to a non static..
			
			}
		}
		else { System.out.println("Wrong coordinates writing, try again it should be like A-2");
		}
		// is this presentation very clear ?
		}
	}
	
	}
	
	
	public static String askCoordMissile(Player player) {
		// ask the coordinates of the missile considering all the rules
		while (true) {
			Scanner sc1 = new Scanner(System.in);
			String coord = sc1.nextLine();
			if (Rules.goodCoordinatesForm(coord)  ) {
				String[] parts1 = coord.split("-");
				int nb1 = Integer.parseInt(parts1[1]);
				char letter1 = coord.charAt(0);
				if (Rules.inMap(player,letter1,nb1) ) {
						return letter1+""+nb1;
					}
				else { System.out.println("Coordinates out of map, try again it should be like A-2");
				
				}
			}
			else { System.out.println("Wrong coordinates writing, try again it should be like A-2");
			}
		}
	}
	
	
	
	public static String[] askCoordShipAI(Player AI, int taille) {
		
		int rand = (int) Math.random() * ((int) AI.getPlayerMap().getLenght()- (int) 'A') + (int) 'A';
		//the rank of the chosen letter
		char letter1 = '0';
		// it count the incrementation of i
		for ( char i = 'A'; i<= AI.getPlayerMap().getLenght(); i++) {
			if ( i- 'A' == rand) {
				letter1 = i;
			};
		}
		int nb1 = (int) Math.floor(Math.random() * (AI.getPlayerMap().getHeight()));
		// 1ere coord est letter-nb
		
		int rand2;
		int nb2 = -1;
		char letter2 = '0';
		
		// Now we will choose a endCoordinates considering the start one
		while (!inMap(AI,letter2,nb2) || !isEmpty( AI, letter1,nb1,  letter2, nb2)) {
		rand2= (int) Math.random() * (3);
			switch(rand2){
				case 0 :
					// we create the boat down
					nb2 = nb1 + (taille-1);
					letter2 = letter1;	
						
				case 1 :
					// we create the ship to the up
					nb2 = nb1 - (taille -1);
					letter2 = letter1;	
				case 2 :
					// we create the ship to the left
					nb2 = nb1 ;
					for ( char i = letter1; i>= 'A'; i--) {
						if ( letter1 - i == taille-1 ) {
							letter2 = i;
						};
					}
				case 3 :
					// we create the ship to the right
					nb2 = nb1 ;
					for ( char i = letter1; i<= AI.getPlayerMap().getLenght() ; i++) {
						if ( i - letter1 == taille-1 ) {
							letter2 = i;
						};
					}
				
			}
		}
		String[] coords = {letter1+""+ nb1 , letter2+""+nb2};
		return  coords;
		
		
	}

}
