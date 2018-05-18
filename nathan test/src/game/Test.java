package game;
import player.*;


public class Test {
	
	int[] resultTestAI2vsAI1 ;
	int[] resultTestAI2vsAI0 ;
	int[] resultTestAI1vsAI0 ;
	
	public Test() {
		
		resultTestAI2vsAI1 = testAI2vsAI1();
		resultTestAI2vsAI0 = testAI2vsAI0();
		resultTestAI1vsAI0 = testAI1vsAI0();
		
	}
	
	public int[] testAI2vsAI1() {
		
		Player winner;
		
		int p1Victories = 0;
		int p2Victories = 0 ;
		
		Player p1 = new AI2();
		Player p2 = new AI1();
		
		Game game = new Game();
		Rules rules = new Rules();
		
		for (int i=0; i<100; i++) {
			p1 = new AI2();
			p2 = new AI1();
			if (i%2 == 0) {
				winner = game.play(rules,p1,p2);
			}
			else {
				winner = game.play(rules,p2,p1);
			}
			if(p1 == winner) {
				p1Victories = p1Victories+1;
			}
			else {
				p2Victories = p2Victories +1;
			}
		}
		int[] results = {p1Victories,p2Victories};
		return results ;

	}
	
	public int[] testAI2vsAI0() {
		
		Player winner;
		
		int p1Victories = 0;
		int p2Victories = 0 ;
		
		Player p1 = new AI2();
		Player p2 = new AI0();
		
		Game game = new Game();
		Rules rules = new Rules();
		
		for (int i=0; i<100; i++) {
			p1 = new AI2();
			p2 = new AI0();
			if (i%2 == 0) {
				winner = game.play(rules,p1,p2);
			}
			else {
				winner = game.play(rules,p2,p1);
			}
			if(p1 == winner) {
				p1Victories = p1Victories+1;
			}
			else {
				p2Victories = p2Victories +1;
			}
		}
		int[] results = {p1Victories,p2Victories};
		return results ;

	}
	
	
	public int[] testAI1vsAI0() {
		
		Player winner;
		
		int p1Victories = 0;
		int p2Victories = 0 ;
		
		Player p1 = new AI1();
		Player p2 = new AI0();
		
		Game game = new Game();
		Rules rules = new Rules();
		
		for (int i=0; i<100; i++) {
			p1 = new AI1();
			p2 = new AI0();
			if (i%2 == 0) {
				winner = game.play(rules,p1,p2);
			}
			else {
				winner = game.play(rules,p2,p1);
			}
			if(p1 == winner) {
				p1Victories = p1Victories+1;
			}
			else {
				p2Victories = p2Victories +1;
			}
		}
		int[] results = {p1Victories,p2Victories};
		return results ;

	}

}
