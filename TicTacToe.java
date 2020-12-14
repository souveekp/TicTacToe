import javax.swing.SwingUtilities;

public class TicTacToe{
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				Player p1 = new Player();
				Player p2 = new Player();
				p1.setName("Player 1");
				p2.setName("Player 2");
				GameLogic gl = new GameLogic();
				gl.initializeGame();
				// gl.addPlayerDetails(p1.getName(), p2.getName());
			}
		});
		
	}
}