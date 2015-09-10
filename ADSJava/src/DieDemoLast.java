import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player {
	String playerName;
	int score;

	public Player(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}

class Dice {
	int dValue;

	public int rollDice(int max) {
		Random random = new Random();
		dValue = random.nextInt(max) + 1;
		System.out.println("Dice value is :" + dValue);
		return dValue;
	}
}

class Game {

	Dice dice;
	List<Player> playerList;

	Game() {
		playerList = new ArrayList<Player>();
		dice = new Dice();
	}

	public void addPlayer(Player player) {
		playerList.add(player);
	}

	public void startGame() {
		while(true){
			for(Player player : playerList){
				playGame(player);
				if(player.getScore() >= 100){
					System.out.println(player.getPlayerName() + " wins by " + player.getScore() + " points.");
					return;
				}
			}	
		}
	}


	public void playGame(Player player) {
		@SuppressWarnings("unused")
		Random random = new Random();
		int score = 0;

		while(true) {
			int fValue = dice.rollDice(6);

			if(fValue==1) {
				player.setScore(0);
				System.out.println(player.getPlayerName() + " turn over.");
				break;
			
			}else if(score >=100) {
				player.setScore(score);
				break;
			
			}else if(fValue==6) {
				score += fValue;
				//	We are asking the user to roll the dice. If the dice value is 1 the user will continue the game.
				//	otherwise the user turn is over by updating his score.
				int choice = dice.rollDice(2);
				if(choice == 2) {
					player.setScore(score);
					break;
				}
			}else {
				score = score + fValue;
			}
		}
	}
}



class DieDemoLast {
	
	public static void main(String[] args){
		Player dp;
		Game game = new Game();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		do{
			System.out.println("1. Add a player");
			System.out.println("2. Start a game");
			System.out.println("3. Exit");
			System.out.println("Enter for choice ");
			int ch = scan.nextInt();
			scan.nextLine();
			switch(ch){
				case 1:
					System.out.println("Enter a player name");
					String name = scan.nextLine();
					System.out.println("Enter a player score");
					int score  = scan.nextInt();

					dp = new Player(name,score);
					game.addPlayer(dp);
					break;

				case 2:
					game.startGame();
				break;

				default:
					System.out.println("Wrong choice...");
				break;
			} if(ch >= 3)
				break;

		} while(true);
	}
}