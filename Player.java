import java.util.Random;
import java.util.Scanner;

public class Player{
	String name;
	int score = 0;
	Scanner sc = new Scanner(System.in);
	public String getName(){
		return name;
	}
	public void setName(String playerName){
		this.name = playerName;
	}
	public int getScore(){
		return score;
		// return 7;
	}
	public void setScore(int score){
		this.score = score;
	}
}