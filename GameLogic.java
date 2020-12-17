
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Dimension;
public class GameLogic extends GameGUI{

	String currPlayer;
	boolean hasWinner;
	int count = 0;
	Player p1;
	Player p2;
	String score;//For JLabel
	void getPlayerDetails(){
		p1 = new Player();
		p2 = new Player();

		String player1Name = (String)JOptionPane.showInputDialog(
			pane,
			"Enter Player 1 Name", 
            "Player Names",            
            JOptionPane.PLAIN_MESSAGE
            );
		if(player1Name == null || player1Name.equals(""))
			player1Name = "Player1";

		String player2Name = (String)JOptionPane.showInputDialog(
			pane,
			"Enter Player 2 Name", 
			"Player Names",            
			JOptionPane.PLAIN_MESSAGE
            );
		if(player2Name == null || player2Name.equals(""))
			player2Name = "Player2";

		p1.setName(player1Name);
		p2.setName(player2Name);
		initializeGame();
	}

	void initializeGame(){
		currPlayer = "X";
		hasWinner = false;
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				JButton button = new JButton();
				board[i][j] = button;
				button.setBackground(Color.white);
				// setVisible(true);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						
						System.out.println("Player Names-->"+p1.getName()+p1.getScore()+"<--this is-->"+p2.getName()+p2.getScore());
						// System.out.println("Player Name"+p1.getName());
						// System.out.println("Player Name"+p2.getName());
						if((((JButton)ae.getSource()).getText()).equals("") && hasWinner == false){

							button.setText(currPlayer);
							// count++;
							// System.out.println("Inside if count = "+count);
							hasWinner();
							switchPlayer();
						}
						else{

							showDraw();
						}
					}
				});
				pane.add(button);
			}
		}

		initializeResetQuit();

	}

	void initializeResetQuit(){
		Border blackline = BorderFactory.createLineBorder(Color.black);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		panel3.setBorder(blackline);

		label = new JLabel();
		resetBoard = new JButton("Reset Board");

		resetBoard.setBackground(Color.gray);
		resetBoard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				resetGame();
			}
		});

		resetScore = new JButton("Reset Score");

		resetScore.setBackground(Color.gray);
		resetScore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				resetScore();
			}
		});

		quit = new JButton("Quit Game");
		quit.setBackground(Color.gray);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				quitGame();
			}
		});
		score = "<html>Scores<br>"+p1.getName()+"--"+p1.getScore()+"<br>"+p2.getName()+"--"+p2.getScore();
		System.out.println("This is for the label"+score);
		label.setText(score);
		label.setFont(new Font("Serif", Font.PLAIN, 24));

		resetBoard.setPreferredSize(new Dimension(130, 40));
		resetScore.setPreferredSize(new Dimension(130, 40));
		panel1.add(resetBoard);
		panel1.add(resetScore);
		quit.setPreferredSize(new Dimension(130, 40));
		panel2.add(quit);
		panel3.add(label);
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		setVisible(true);

	}

	void resetGame(){
		currPlayer = "X";
		hasWinner = false;
		count = 0;
		for (int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				board[i][j].setText("");
		score = "<html>Scores<br>"+p1.getName()+"--"+p1.getScore()+"<br>"+p2.getName()+"--"+p2.getScore();
		label.setText(score);
	}
	void resetScore(){
		p1.setScore(0);
		p2.setScore(0);
		score = "<html>Scores<br>"+p1.getName()+"--"+p1.getScore()+"<br>"+p2.getName()+"--"+p2.getScore();
		label.setText(score);
	}
	void quitGame(){
		System.exit(0);
	}
	void switchPlayer(){
		if(currPlayer.equals("X"))
			currPlayer = "O";
		else
			currPlayer = "X";
	}
	void hasWinner(){
		count++;
		boolean conditionR0 = board[0][0].getText().equals(currPlayer) && board[0][1].getText().equals(currPlayer) && 
									 board[0][2].getText().equals(currPlayer);
		boolean conditionR1 = board[1][0].getText().equals(currPlayer) && board[1][1].getText().equals(currPlayer) && 
									 board[1][2].getText().equals(currPlayer);
		boolean conditionR2 = board[2][0].getText().equals(currPlayer) && board[2][1].getText().equals(currPlayer) && 
									 board[2][2].getText().equals(currPlayer);
		boolean conditionC0 = board[0][0].getText().equals(currPlayer) && board[1][0].getText().equals(currPlayer) && 
									 board[2][0].getText().equals(currPlayer);
		boolean conditionC1 = board[0][1].getText().equals(currPlayer) && board[1][1].getText().equals(currPlayer) && 
									 board[2][1].getText().equals(currPlayer);
		boolean conditionC2 = board[0][2].getText().equals(currPlayer) && board[1][2].getText().equals(currPlayer) && 
								 board[2][2].getText().equals(currPlayer);
		boolean conditionD0 = board[0][0].getText().equals(currPlayer) && board[1][1].getText().equals(currPlayer) && 
									 board[2][2].getText().equals(currPlayer);
		boolean conditionD1 = board[0][2].getText().equals(currPlayer) && board[1][1].getText().equals(currPlayer) && 
									 board[2][0].getText().equals(currPlayer);							 							 						 							 							 											
		if(conditionR0 || conditionR1 || conditionR2 || conditionC0 || conditionC1 || conditionC2 || conditionD0 || conditionD1){
			showWinner();
		}
		else if(count == 9)
			showDraw();
	}
	void showWinner(){
		if(currPlayer.equals("X")){
			JOptionPane.showMessageDialog(null, p1.getName() + " has won.");
			p1.setScore(p1.getScore() + 1);
			// System.out.println(p1.getScore());
		}
		else{
			JOptionPane.showMessageDialog(null, p2.getName() + " has won.");
			p2.setScore(p2.getScore() + 1);
			// System.out.println(p2.getScore());
		}
		hasWinner = true;
		resetGame();
	}

	void showDraw(){
		JOptionPane.showMessageDialog(null,  "Its a DRAW");
		resetGame();
	}
}