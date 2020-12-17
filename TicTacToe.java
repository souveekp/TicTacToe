import javax.swing.SwingUtilities;

public class TicTacToe{
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				GameLogic gl = new GameLogic();
				gl.getPlayerDetails();
			}
		});
		
	}
}