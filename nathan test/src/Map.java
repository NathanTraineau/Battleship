
public class Map {
	
	// une map doit savoir quelles sont ses cases occupées, sa taille
	// Quelles sont les cases où les bateaux ont étés touchés
	// les cases déjà visées
	// S'afficher
	
	public Map( int height, int lenght){
		// we generate a map as an hashmap, with the coordinates as key and integer as "case state"
		// en bleue les à l'eau, orange les touché, rouge les coulés
		// genre un int : 0 si pas visé / 1 si à l'eau / 2 si touché / 3 si coulé
		
		
	}

	// comment on met que 
	public void  hitSquare(){
		// list of all the squares that was hit during the game
		//return an hashtable with the coordinates
		
	}
	
	public void touchSquare(){
		// Return all the squares were a boat was hit but not yet sinked
		
	}
	
	public void sinkSquare(){
		// Return all the squares were was a sinked boat
		
	}
	

}
