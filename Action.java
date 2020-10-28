import java.util.*;
public class Action {
	
	public Scanner scanner = new Scanner(System.in);
	
	public void move(Player player, String roomName) { 
		
		ArrayList<Room> adjacentRooms = player.getRoom().getAdjacentRooms(); 
		
		if(roomName.equals("")) {
			
			System.out.println("Available move options: ");
			for(int i = 0; i < adjacentRooms.size(); i++) {
				
				System.out.println(adjacentRooms.get(i).getName());
			}
		}
		
		else if(!(player.isWorking())) {
			
			for(int i = 0; i < adjacentRooms.size(); i++) { 
				
				if(roomName.equals(adjacentRooms.get(i).getName())) { 
					
					player.setPosition(adjacentRooms.get(i)); 
					player.setMoved(true); 
				} 
			}
			
			if(!(player.hasMoved())) { 
				
				System.out.println("Invalid destination.\n");
			}
		}
		
		System.out.println(player.getName() + "'s position is " + player.getRoom().getName()); 
	}
	
	public void availableActions(Player player, String option) {
		
		String[] optionArray = option.split("\\s+");
		
		if(optionArray[0].equals("help")) {
			
			System.out.println("Keyword who shows your status");
			System.out.println("Keyword where shows your room");
			System.out.println("Keyword move shows adjacent rooms with added keyword 'roomName' to move to adjacent room"); 
			System.out.println("Keyword role shows available roles with added keyword 'work' to work a specific role"); 
			System.out.println("Keyword type and rank views upgrades");
			System.out.println("Keyword rehearse rehearses a role");
			System.out.println("Keyword act acts a role"); 
			System.out.println("Keyword end ends the players turn");
		}
		
		else if(optionArray[0].equals("who")) { 
			
			System.out.println(player.getName() + " has $" + player.getMoney() + " and " + player.getCredits() + " credits.");
			System.out.println("Player rank is " + player.getRank());
			
			if(player.isWorking()) {
				
				System.out.println("Player is working " + player.getRole().getName());
			}
		}
		
		else if(optionArray[0].equals("where")) {
			
			System.out.println(player.getName() + " is in " + player.getRoom().getName());
		}
		
		else if(optionArray[0].equals("move")) { 
			
			if(!(player.hasMoved())) { 
				
				if(optionArray.length == 2) {
					
					move(player, optionArray[1]); 
				}
				
				else {
					
					move(player, "");
				}
			}
		}
	}
	
	public void work(Player player) {
		
		
	}
	
	public void act(Player player) {
		
		
	}
	
	public void rehearse(Player player) {
		
		
	}
	
	public void upgrade(Player player) {
		
		
	}
	
	
	
	
	

}
