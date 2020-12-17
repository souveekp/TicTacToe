import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.*;



public class GameGUI extends JFrame{
	Container pane;
	JButton [][] board;
	JMenuBar menuBar;
	JMenu menu;
	JPanel panel;
	JButton resetBoard;
	JButton resetScore;
	JButton quit;
	JTextArea textArea;
	JPanel panel1,panel2,panel3;
	JLabel label;

	GameGUI(){
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(4,3));
		setTitle("TTT");
		setSize(500,500);
		// pane.setOpaque(true);
		// setBackground(Color.black);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board = new JButton[3][3];
	}
}