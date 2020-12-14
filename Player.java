import java.util.Random;
import java.util.Scanner;

public class Player{
	String name;
	int score;
	Scanner sc = new Scanner(System.in);
	public String getName(){
		return name;
	}
	public void setName(String playerNumber){
		System.out.println("Enter "+playerNumber+" Name");
		this.name = sc.nextLine();
	}
	public int getScore(){
		return score;
		// return 7;
	}
	public void setScore(int score){
		this.score = score;
	}
}