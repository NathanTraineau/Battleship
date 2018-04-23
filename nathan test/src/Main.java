import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// On d�clare les variables importantes
		
		boolean place = false;
		
		Carrier bateau1 = new Carrier(); 
		System.out.println(bateau1.getTaille());
		
		// Cr�ation de tableaux de bateaux, ca repr�sentera les joueurs
		Ship[] BateauxJoueur1 = {new Carrier(), new Battleship()};
		Ship[] BateauxJoueur2 = {new Carrier(), new Battleship()};
		
		Ship[][] AllShip = { BateauxJoueur1 };
		
		System.out.println("Voici les bateaux dont vous disposez \n");
		for( Ship b : BateauxJoueur1 ) {
			// On d�crit d'abord les bateaux
			System.out.println(b.decrisToi() + "\n");
		}
		
		
		for( Ship b : BateauxJoueur1 ) {
			//On demande o� le joueur veut placer ses bateaux
			place = false;
			while (place == false) {
			System.out.println("Vous allez maintenant placer sur votre carte de 10x10 un "+ b.getClass + "de taille" +
					b.getTaille()+"\n");
			
			System.out.println("Saississez les coordonn�es de d�but par ex 3a");
			
			Scanner sc = new Scanner(System.in);
			String demandeStartCoord = sc.nextLine();
			sc.nextLine();
			System.out.println("Saississez les coordonn�es de fin par ex 3f");
			String demandeEndCoord = sc.nextLine();
			System.out.println("Saississez les coordonn�es de d�but par ex 3a");
			
			if (b.placementAuxNormes(demandeStartCoord, demandeEndCoord) && b.placesNonOccup�s(demandeStartCoord, demandeEndCoord) ){
				b.placer(demandeStartCoord, demandeEndCoord);
				place = true;
			}
			else {System.out.println("Veuillez recommencer");
				
			}
			}
			
			
			
		}
			
		// Demander dans varia StartCoord et EndCoord
		
		
	}

}
