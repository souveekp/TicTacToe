
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;
public class GameLogic extends GameGUI{

	String currPlayer;
	boolean hasWinner;
	int count = 0;
	
	// void getPlayerDetails(){
	// 	p1.setName("Player 1");
	// 	p2.setName("Player 2");
	// }

	void initializeGame(){
		currPlayer = "X";
		hasWinner = false;
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				JButton button = new JButton();
				board[i][j] = button;
				button.setBackground(Color.white);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						
						// System.out.println("Outside if count = "+count);
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
				// count ++;
				pane.add(button);
			}
		}
		initializeResetQuit();
	}

	void initializeResetQuit(){
		panel = new JPanel();
		
		reset = new JButton("Reset Game");
		// reset.setBounds(0,0,200,20);
		reset.setBackground(Color.gray);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				resetGame();
			}
		});

		quit = new JButton("Quit Game");
		quit.setBackground(Color.gray);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				quitGame();
			}
		});

		reset.setPreferredSize(new Dimension(130, 40));
		panel.add(reset);
		
		quit.setPreferredSize(new Dimension(130, 40));
		// quit.setLocation(10000,0);
		panel.add(quit);

		pane.add(panel);

	}

	// void addPlayerDetails(String s1, String s2){
	// 	// System.out.println(s1);
	// 	// System.out.println(s2);
	// 	// panel.add(p1.getName());
	// 	textArea = new JTextArea();
	// 	textArea.append(s1);
	// 	textArea.append(s2);
	// 	panel.add(textArea);

	// 	// pane.add(panel);

	// }

	void resetGame(){
		currPlayer = "X";
		hasWinner = false;
		count = 0;
		for (int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				board[i][j].setText("");
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
		JOptionPane.showMessageDialog(null,  "Player "+ currPlayer + " has won.");
		hasWinner = true;
		resetGame();
	}
	void showDraw(){
		JOptionPane.showMessageDialog(null,  "Its a DRAW");
		resetGame();
	}
}