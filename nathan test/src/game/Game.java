package game;
import java.util.Scanner;

import boardGame.Coordinates;
import boardGame.Map;
import boardGame.Ship;
import player.*;


public class Game {
	//Faire une interface partie ?
	
	public Game() {
		
	}
	Scanner sc1 = new Scanner(System.in);
	public Player play(Rules rules, Player p1, Player p2) {
		// play a game between the 2 players with the rules given and return the winer
		
		// List of players
		Player[] players = {p1,p2};
		// initialize the scanner to get the info
		
		
		//List of the ship to place
		int[] ListOfShiptoPlace = rules.getListOfShipsToPlace();
		
		
		for (Player player : players) {
			// Creation des map
			player.setPlayerMap( rules.getLenghtMap(),rules.getHeightMap());
			
			//****************************** Ships Placement *******************************************
			
			if (player instanceof Human) {
			System.out.println("Please enter your name");
			player.setName(sc1.nextLine());
			System.out.println(player.getName()+" please put your ships on your map");
			System.out.println("For each ships enter 2 coordinates like'A-2','A-3' in two times ( separated with an enter)");
			}
			
			
			String askStartCoord;
			String askEndCoord; 
			Coordinates startCoord = null ;
			Coordinates endCoord = null ;
			
			
			for ( int size : ListOfShiptoPlace) {
				
				//******Human********
				if (player instanceof Human) {
					System.out.println("Please put on the map a Ship "+ size + " tall");
					
						do{
							System.out.println("Please enter the Start coordinates");
							askStartCoord =sc1.nextLine();
							System.out.println("Please enter the End coordinates");
							askEndCoord =sc1.nextLine();
						}
						while(!rules.verifShipCoordinates(player, askStartCoord,askEndCoord, size));
						
							startCoord = new Coordinates(askStartCoord);
							endCoord = new Coordinates(askEndCoord);
							
				}
				//**************
				
				//******AI********
				if (player instanceof AI) {
						Coordinates[] coords = ((AI) player).chooseShipCoordinates(rules, player, size);
						startCoord = coords[0];
						endCoord = coords[1];
				
				}
				
				// now that we have 2 coordinates we create the Ship
				player.addShipPlayer(new Ship(startCoord,endCoord));
				if (player instanceof Human) {
				System.out.println("this is your current map");
				player.getPlayerMap().ownMapDisplay();
				}
			}
				//**************
			}
	
		
		// Each player launch a missile when his turn comes
		Player opponentPlayer = null;
		Player currentPlayer = null;
		
		
		//************************* ATTAK ***************************************************
		
		while( !p1.playerIsDead() && !p2.playerIsDead() ) {
			if (currentPlayer == p1) {
				currentPlayer = p2;
				opponentPlayer = p1;
			}
			else {
				currentPlayer = p1;
				opponentPlayer = p2;
				}
			
			// We annonce which player will play
			
			
			
			// We show the player what he already have done on the opponent map
			Map opponentPlayerMap = opponentPlayer.getPlayerMap();
			Map currentPlayerMap = currentPlayer.getPlayerMap();
			
			// Should I display the own map of the current Player ?
			
			//We initialize the variable which are used to ask and save the result of the missile coordinates
			String askMissileCoord = null;
			Coordinates missileCoord = new Coordinates();
			
			//******Human********
			if(currentPlayer instanceof Human) {
				System.out.println("C'est au tour de "+ currentPlayer.getName() );	
				System.out.println("Voici votre map ");
				currentPlayerMap.ownMapDisplay();
				System.out.println("Voici vos attaques sur la map adverse");
				currentPlayerMap.opponentMapDisplay();
				do {
						System.out.println("Entrez les coordonn�es du missile ");
						askMissileCoord = sc1.nextLine();
						
				}
				while(!rules.verifyCoordMissile(opponentPlayer, askMissileCoord));
							
						missileCoord.setCoordinates(askMissileCoord);
						System.out.println(askMissileCoord);
			}
			//**************
			
			//******AI********
			if(currentPlayer instanceof AI) {
				try {
				missileCoord = ((AI) currentPlayer).shoot(rules, opponentPlayer );
				}
				catch (StackOverflowError s) {
					//System.out.println(s);
					//currentPlayerMap.opponentMapDisplay();
					
				}
				
			}
			//**************
			
			// Now that we have the coordinates we can launch the missile
			Ship hitShip =	opponentPlayer.isPlayerHit(missileCoord);	
			
			if ( hitShip == null) {
				//System.out.println("No ship were hit !");
				currentPlayer.addOwnMapMissCoords(missileCoord);
				opponentPlayer.addOpponentMapMissCoords(missileCoord);
				if (currentPlayer instanceof AI2) {
					((AI2) currentPlayer).setCurrentNumberOfMissShots(((AI2) currentPlayer).getCurrentNumberOfMissShots() + 1);
				}
				
			}
			else {
				//System.out.println("A ship were hit !");
				hitShip.setHit(missileCoord);
				
				currentPlayerMap.addOwnHitCoords(missileCoord);
				opponentPlayerMap.addOpponentHitCoords(missileCoord);
				
				
				if (currentPlayer instanceof AI2) {
					currentPlayerMap.opponentMapDisplay();
					((AI2) currentPlayer).setCurrentNumberOfMissShots(0);
					((AI2) currentPlayer).addHitShots(missileCoord);
					if (hitShip.isDestroyed()) {
					
							((AI2) currentPlayer).currentHitShotsClear();
						}
					
				}
			}
			
			
			
		}	
		return currentPlayer;
	};
}
	

	
	
	
	


