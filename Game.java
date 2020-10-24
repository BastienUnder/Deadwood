import java.util.*;

public class Game {

	public static Map<String, Room> rooms = new HashMap<String, Room>();
	public Scanner scanner = new Scanner(System.in);
	
	public boolean gameRunning = true;
	public int daysLeft = 4;
	
	public SetBoard setBoard;
	public Action actions = new Action();
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public Game() {

		startGame();
	}
	
	
	public void startGame() {
		
		setBoard = new SetBoard();
		setPlayers();
		
		while(daysLeft != 0) {
			
			System.out.println("There are " + daysLeft + " days left.\n");
			scanner.nextLine();
			for(int i = 0; i < players.size(); i++) {
				
				System.out.println(players.get(i).getName() + "'s turn"); 
				String option = scanner.nextLine(); 
				
				actions.availableActions(players.get(i), option);
				
				
			} 
		}
		

	}
	
	
	public void setPlayers() {
		
		int startingRank = 1; 
		int startingCredits = 0; 
		
		System.out.println("Please enter number of players: "); 
		int numberOfPlayers = scanner.nextInt(); 
		
		switch(numberOfPlayers) {
		
			case 2: daysLeft = 3; break;
			case 3: daysLeft = 3; break;
			case 5: startingCredits = 2; break; 
			case 6: startingCredits = 4; break;
			case 7: startingRank = 2; break;
			case 8: startingRank = 2; break;
		}
		
		for(int i = 0; i < numberOfPlayers; i++) {
			
			players.add(new Player("Player " + (i + 1), 
					setBoard.getRooms().get("Trailers"), startingRank, startingCredits, 0));
		}
	}
	
	
}





