import java.util.*;
public class Action {
	
	public Scanner scanner = new Scanner(System.in);
	private boolean endTurn = false;
	
	public void move(Player player, String roomName) { 
		
		ArrayList<Room> adjacentRooms = player.getRoom().getAdjacentRooms(); 

		//Display move options.
		if(roomName.equals("")) {

			System.out.println("Available move options: ");
			for(int i = 0; i < adjacentRooms.size(); i++) {

				System.out.println(adjacentRooms.get(i).getName());
			}
		}

		//Move the player to chosen destination if they're not working and have selected a proper destination.
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


	public void work(){

	}

	public void upgrade(){

	}

	public void act(){

	}

	public void rehearse(){

	}

	public void endTurn(){

	}


	
	public void availableActions(Player player, String option) {
		
		String[] optionArray = option.split("\\s+");
		
		if(optionArray[0].equals("help")) {
			
			System.out.println("Keyword \"who\" shows active player's status");
			System.out.println("Keyword \"where\" shows your location, keyword \"where all\" shows locations of all players");
			System.out.println("Keyword \"move\" shows adjacent rooms, use keyword \" move 'roomName'\" to move to adjacent room");
			System.out.println("Keyword \"work\" shows available roles, use keyword \"work 'role'\" to work a specific role");
			System.out.println("Keyword \"upgrade\" shows upgrade options while player is in the Casting Office");
			System.out.println("Keyword \"rehearse\" lets active player rehearse their role");
			System.out.println("Keyword \"act\" lets active player act their role");
			System.out.println("Keyword \"end\" ends the players turn");
		}
		
		else if(optionArray[0].equals("who")) { 
			
			System.out.println(player.getName() + " has $" + player.getDollars() + " and " + player.getCredits() + " credits.");
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

				else if(optionArray.length >= 3){
					StringBuffer sb = new StringBuffer();
					int i = 1;
					for(i=1; i< optionArray.length-1; i++){
						 sb.append(optionArray[i] + " ");
					}
					sb.append(optionArray[i]);
					String tempRoomName = sb.toString();
					System.out.println("MOVE TO: " + tempRoomName);

					move(player, tempRoomName);
				}
				
				else {
					
					move(player, "");
				}
			}
			else{
				System.out.println("You have already moved this turn.");
			}
		}

		else if(optionArray[0].equals("work")){

		}

		else if(optionArray[0].equals("upgrade")){

		}

		else if(optionArray[0].equals("rehearse")){

		}

		else if(optionArray[0].equals("act")){

		}

		else if(optionArray[0].equals("end")){
			endTurn = true;
			player.setMoved(false);
		}
		else{
			System.out.println("Please enter a valid action, type \"help\" for options.");
		}


		

	}//end availableActions()



	//Getters and Setters


	public boolean isEndTurn() {
		return endTurn;
	}

	public void setEndTurn(boolean endTurn) {
		this.endTurn = endTurn;
	}
}
