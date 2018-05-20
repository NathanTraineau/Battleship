package game;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import player.*;

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
		
		System.out.println("Which mode do you want to play ? HumanVsHuman 0 / HumanVsAI 1  ");
		Scanner sc = new Scanner(System.in);
		int answer1 = sc.nextInt();
		Game game = new Game();
		Rules rules = new Rules();
		
		switch (answer1) {
			case 0 :
				System.out.println(((Human) game.play(rules, new Human(), new Human())).getName()+" has won");
				break;
			case 1 :
				System.out.println("Which AI do you want to play against ? AI0 0 / AI1 1  / AI2 2");
				int answer2 = sc.nextInt();
				switch (answer2) {
				case 0 :
					System.out.println(game.play(rules, new Human(), new AI0()).getName()+" has won");
					break;
				case 1 : 
					System.out.println(game.play(rules, new Human(), new AI1()).getName()+" has won");
					break;
				case 2 : 
					System.out.println(game.play(rules, new Human(), new AI2()).getName()+" has won");
					
				}break;
			
	}
		sc.close();
}
}
		
			
		// Demander dans varia StartCoord et EndCoord
		
		



