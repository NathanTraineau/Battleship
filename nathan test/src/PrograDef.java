
public class PrograDef {
	
	
	public boolean bonFormatCoord(String startCoordChoisir, String endCoordChoisir) {
		// V�rifie que les string rentr�s correspondent au format en vigeur "LettreChiffre"
		// exemple "B3"
		
		
	}
	
	public boolean nonDiagonal(String startCoordChoisir, String endCoordChoisir) {
		// Renvoie true si le bateau n'est pas en diagonal
		if ( (Math.abs(startCoordChoisir.charAt(0)-endCoordChoisir.charAt(0)) == 0)
				||
				(Math.abs(startCoordChoisir.charAt(0)-endCoordChoisir.charAt(0)) == 0 ))
				{
				// Le bateau n'est pas en diagonal
				return true; }
		else {return false;}
	}
	
	public boolean bonneTaille(String startCoordChoisir, String endCoordChoisir) {
		// Renvoie true si le bateau a potentiellement la bonne taille
		return (
			(Math.abs(startCoordChoisir.charAt(1)-endCoordChoisir.charAt(1)) == this.getTaille())
			|| 
			(Math.abs(startCoordChoisir.charAt(0)- endCoordChoisir.charAt(0)) == this.getTaille()))
				{
			// le bateau a potentielement une bonne taille si il n'est pas en diagonal
			;}
	}
	
	public boolean dansMap(String startCoordChoisir, String endCoordChoisir) {
		// Renvoie true si le bateau a potentiellement la bonne taille
		
		return
		    ((startCoordChoisir.charAt(0)<='J' || startCoordChoisir.charAt(0)>='A' )
				&&
				(startCoordChoisir.charAt(1)<=10 || startCoordChoisir.charAt(1)>=1 ))
				&&
				((endCoordChoisir.charAt(0)<='J' || endCoordChoisir.charAt(0)>='A' )
				&&
				(endCoordChoisir.charAt(1)<=10 || endCoordChoisir.charAt(1)>=1 ));
	}
	
	public boolean placementAuxNormes(String startCoordChoisir, String endCoordChoisir) {
		// Renvoie true si le placement est aux normes ( si cela ne d�passe pas la grille, la taille du bateau, n'est pas en diagonale)
		boolean bonneTaille = bonneTaille(startCoordChoisir, endCoordChoisir);
		boolean nonDiagonal = nonDiagonal(startCoordChoisir, endCoordChoisir) ;
		boolean dansMap = dansMap(startCoordChoisir, endCoordChoisir);
		
		
		
		if (bonneTaille && nonDiagonal && dansMap &&)

		
		
		System.out.println("Le bateau est en diagonal !") ;
		System.out.println("ce n'est pas la bonne taille ce bateau fait" + this.getTaille());
	}

}
