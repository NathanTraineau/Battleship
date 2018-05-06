import java.util.Scanner;

public class Main {
	
	//On créer les players, les maps
	// each player places his boats on his map
	//Round by round each it is given to the current player the parts of the enemy map where he already has launched a missile
	// In order to get that, the map will browse all of its coordinate, see if there is a boat, then check if that square is hit or
	// is from a destroyed boat to see which value it has and display a graphic map in consequence 
	//then launch a missile on a chosen coordinate
	// We wil browse through all of the boat of the other player in order to see if there is a boat on this coordinates
	// We will use the function isHit() from the Ship class
	// If there is a boat, we will add that coordinate to a list that save the hit coordinates
	// Then 
	
	//Faire une classe coordonnées
	//stocker un tableau de tir
	//We 
	
	

	
	public static void main(String[] args) {
		
		boolean manual = true;
		System.out.println('E'-'A');
		//Règles
		//tailleMap 
		int heightMap = 10;
		char lenghtMap = 'J';
		
		// On déclare les variables importantes
		
		System.out.println("Which mode do you want to play ? \n 2 players (0) or against the AI ? (1) ");
		Scanner sc2 = new Scanner(System.in);
		int mode = sc2.nextInt();
		if (mode == 1) {
			manual = false;
		}
		System.out.println("player 1, please enter your nickname");
		sc2.nextLine();
		
		String nom1 = sc2.nextLine();
		Player p1 = new Player();
		p1.setName(nom1);
		System.out.println("Welcome " + p1.name + "\nplayer 2, please enter your nickname");
		
		
		Player p2 = new Player(); 
		if (!manual) {
		    p2 = new AI();
		}
		else {
			String nom2 = sc2.nextLine();
			p2.setName(nom2);
		}
		
		System.out.println("Welcome " + p2.name );
		
		Player[] players = {p1,p2};
		
		for (Player player : players) {
		// Creation des map
		player.setMap(heightMap, lenghtMap);
		
		// Put the ship on the map
		System.out.println(player.getName()+" please put your ships on your map");
		System.out.println("For each ships enter 2 coordoniates like'A-2','A-3' in two times ( separated with an enter)");
	
		System.out.println("Please put on the map a Ship called Carrier it is 5 tall");
		String[] Coords1 = Rules.askCoordShip(player, 5);
		player.addShipPlayer(new Carrier(Coords1[0],Coords1[1]));
		
		System.out.println("Please put on the map a Ship called Battleship it is 4 tall");
		String[] Coords2 = Rules.askCoordShip(player, 4);
		player.addShipPlayer(new Battleship(Coords2[0],Coords2[1]));
		/*
		System.out.println("Please put on the map a Ship called Cruiser de it is 3 tall");
		String[] Coords3 = Rules.askCoordShip(player, 3);
		player.addShipPlayer(new Cruiser(Coords3[0],Coords3[1]));
		
		System.out.println("Please put on the map a Ship called Submarine de taille 3 tall");
		String[] Coords4 = Rules.askCoordShip(player, 3);
		player.addShipPlayer(new Submarine(Coords4[0],Coords4[1]));
		
		System.out.println("Please put on the map a Ship called Destroyer de taille 2 tall");
		String[] Coords5 = Rules.askCoordShip(player,2);
		player.addShipPlayer(new Destroyer(Coords5[0],Coords5[1]));
		*/
		}
		// We could have arrange it with arrays and only one println with variables but 
		//With the structure I choose we can't easily implement a 		
		
		// Each player launch a missile when his turn comes
		Player opponentPlayer = null;
		Player currentPlayer = null;
		while( !p1.playerIsDead() && !p2.playerIsDead()) {
			if (currentPlayer == p1) {
				currentPlayer = p2;
				opponentPlayer = p1;
			}
			else {
				currentPlayer = p1;
				opponentPlayer = p2;
				}
			System.out.println("C'est au tour de "+ currentPlayer.getName() );
			
			Map opponentMap = opponentPlayer.getPlayerMap();
			
			opponentMap.mapDisplay();
			// Should I display the own map of the current Player ?
			
			System.out.println("Entrez coordonnées du missile ");
			String missileCoord = Rules.askCoordMissile(opponentPlayer);
			System.out.println(missileCoord);
			Ship hitShip = opponentPlayer.isPlayerHit(missileCoord);
			if (hitShip.isWater == true) {
				System.out.println("No ships were hit !");
				opponentPlayer.getPlayerMap().addMissCoords(missileCoord);
			}
			else {
				System.out.println("A ship were hit !");
				hitShip.setHit(missileCoord);
				opponentMap.addHitCoords(missileCoord);
				if (hitShip.isDestroyed()) {
					opponentMap.removeHitCoords(hitShip.getCoordShip());
					opponentMap.addSinkedCoords(hitShip.getCoordShip());
					System.out.println("This ship is now sinked !! congratulation");
				}
			}
			
			
		}
		
			
			
			/*if (b.placementAuxNormes(demandeStartCoord, demandeEndCoord) && b.placesNonOccupés(demandeStartCoord, demandeEndCoord) ){
				b.placer(demandeStartCoord, demandeEndCoord);
				place = true;
			}*/
			
				
			
	}
			
			
			
		
			
		// Demander dans varia StartCoord et EndCoord
		
		
}


