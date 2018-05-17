
public class Test {
	
	public Test() {
		
	}
	
	public void test() {
		
		
		
		int p1Victories = 0;
		int p2Victories = 0 ;
		
		Player p1 = new AI1();
		Player p2 = new AI0();
		
		Game game = new Game();
		
		Rules rules = new Rules();
		for (int i=0; i<100; i++) {
			p1 = new AI1();
			p2 = new AI0();
			if(p1 == game.play(rules,p1,p2)) {
				p1Victories = p1Victories+1;
			}
			else {
				p2Victories = p2Victories +1;
			}
			System.out.println("p1 = "+p1Victories+ " p2 = "+ p2Victories);
		}

	}

}
