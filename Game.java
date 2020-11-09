import java.util.*;

public class Game {

	public static Map<String, Room> rooms = new HashMap<String, Room>();
	public Scanner scanner = new Scanner(System.in);
	
	public boolean gameRunning = true;
	public int daysLeft = 4;
	public boolean dayOver = false;
	
	public Board board;
	public Action actions = new Action();
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public Game() {

		startGame();
	}
	
	public void startGame() {
		
		board = new Board();
		setPlayers();
		actions.setPlayers(players);

		System.out.println("Welcome to Deadwood! Type \"help\" to see options.");
		board.resetBoard(players);
		while(daysLeft != 0) {
			
			System.out.println("There are " + daysLeft + " days left.");
			scanner.nextLine();
			
			while(actions.getScenesLeftInDay() > 1) {
				
				for (int i = 0; i < players.size(); i++) { 

					System.out.println("\n" + players.get(i).getName() + " it is your turn:");

					while(!(actions.isEndTurn())) {//end turn is false continue player's turn, player entering "end" will end their turn.
						
						String option = scanner.nextLine();
						actions.availableActions(players.get(i), option);				
						
						//Check board to see how many scenes are left, if only one end the day, or maybe let board reset dayOver when it sees that the 2nd to last scene has wrapped.
					}
					
					actions.setEndTurn(false);
					if(actions.getScenesLeftInDay() <= 1) break;
				}
			}
			
			if(daysLeft <= 1) calculateScore();
			board.resetBoard(players);
			actions.setScenesLeftInDay(10);
			daysLeft--;
			

			//Call board routine to setup a new day with new scene cards and shot tokens replaced, players returned to trailers and starting on the proper player's turn.
			System.out.println("Welcome to day " + daysLeft + "\n");
		}//end day loop
	}
	
	
	public void calculateScore() {
		
		System.out.println("The game is finished! Calculating Scores... ");
		
		for(int i = 0; i < players.size(); i++) {
			
			players.get(i).setScore(players.get(i).getDollars() + 
					players.get(i).getCredits() + players.get(i).getRank() * 5);
			
			System.out.println(players.get(i).getName() + 
					" score is " + players.get(i).getScore());
		}
		
		System.out.println("GAME OVER");
		System.exit(0);
	}



	public void setPlayers() {
		
		int startingRank = 1; 
		int startingCredits = 0;
		int numberOfPlayers;

		enter: while(true) {
			System.out.println("Please enter number of players(2-8): ");
			numberOfPlayers = scanner.nextInt();
			
			switch (numberOfPlayers) {

				case 2:
				case 3:
					daysLeft = 3;
					break enter;
				case 4:
					break enter;
				case 5:
					startingCredits = 2;
					break enter;
				case 6:
					startingCredits = 4;
					break enter;
				case 7:
				case 8:
					startingRank = 2;
					break enter;
				default:
					System.out.println("Not a valid number of players.");
			}
		}
	
		//Create PLayer Objects.
		for(int i = 0; i < numberOfPlayers; i++) {
		
		players.add(new Player("Player " + (i + 1), 
				board.getRooms().get("trailer"), startingRank, startingCredits, 0));
		}
	}
}





