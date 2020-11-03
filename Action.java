import java.util.*;
public class Action {
	
	public Scanner scanner = new Scanner(System.in);
	private boolean endTurn = false; 
	
	public void move(Player player, String roomName) { 
		
		ArrayList<Room> adjacentRooms = player.getRoom().getAdjacentRooms(); 

		//Display move options.
		if(roomName.equals("")) {

			System.out.print("Available rooms: ");
			for(int i = 0; i < adjacentRooms.size(); i++) {

				System.out.print("\"" + adjacentRooms.get(i).getName() + "\", ");
			}
			
			System.out.println();
		}

		//Move the player to chosen destination if they're not working and have selected a proper destination. 
		else if(!(player.isWorking())) {
			
			for(int i = 0; i < adjacentRooms.size(); i++) { 
				
				if(roomName.equals(adjacentRooms.get(i).getName())) { 
					
					player.setPosition(adjacentRooms.get(i)); 
					player.setMoved(true); 
					System.out.println("Moved: \"" + player.getRoom().getName() + "\"");
					Set set = (Set) player.getRoom();
					set.setShotCount(1);
				} 
			}
			
			if(!(player.hasMoved())) { 
				
				System.out.println("Unable to move to: \"" + roomName + "\"");
			}
		}
	}
	
	
	public void work(Player player, String roleName) {
		
		Set set = (Set) player.getRoom();
		ArrayList<Role> roles = new ArrayList<Role>(set.getRoles());
		roles.addAll(set.getSceneCard().getSceneRoles());

		for(int i = 0; i < roles.size(); i++) {
			
			if(roles.get(i).getName().equals(roleName)) {
				
				if(roles.get(i).isOccupied()) {
					
					System.out.println("Role is occupied. "); return;
				}
				
				else if(roles.get(i).getRoleRank() <= player.getRank()) {
					
					roles.get(i).takeRole(true);
					player.setRole(roles.get(i));
					player.setWorking(true); 
					setEndTurn(true); 
					
					System.out.println(player.getName() + " WORKING: \"" + roles.get(i).getName() + "\"");
					return;
				}
				
				else {
					
					System.out.println("Player does not meet required rank. "); return;
				}
			}
		}
		
		System.out.println("The role \"" + roleName + "\" is not available.");	
	}
	
	public void act(Player player) { 
		
		Random random = new Random();
		int dice = random.nextInt(6) + 1;
		Set set = (Set) player.getRoom();
		int movieBudget = set.getSceneCard().getBudget();
		
		if(dice >= movieBudget) {
			
			System.out.println("Success!! ");
			if(player.getRole().isOnCard()) {
				
				player.setCredits(player.getCredits() + 2);
			}
			
			else {
				
				player.setCredits(player.getCredits() + 1);
				player.setDollars(player.getDollars() + 1);
			}
			
			set.setShotCount(set.getShotCount() - 1);
			player.getRole().takeRole(false);
			player.setWorking(false); 
			
			if(set.getShotCount() <= 0) {
				
				//wrapScene(player);
			}
		}
		
		else {
			
			System.out.println("Failure! ");
			
			if(!(player.getRole().isOnCard())) {
				
				player.setDollars(player.getDollars() + 1);
			}
		}
		
		setEndTurn(true);
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
			
			System.out.println(player.getName() + " it is your turn: ");
			System.out.println("($" + player.getDollars() + ", C: " + player.getCredits() + ")        Rank: " + player.getRank());
			
			if(player.isWorking()) {
				
				System.out.println("Player is working " + player.getRole().getName());
			}
		}
		
		else if(optionArray[0].equals("where")) {
			
			System.out.println("\"" + player.getRoom().getName() + "\"");
		}
		
		else if(optionArray[0].equals("move")) { 
			
			if(!(player.hasMoved())) { 
				
				if(optionArray.length == 2) {
					
					move(player, optionArray[1]); 
				}

				else if(optionArray.length >= 3){
					
					String tempRoomName = getStringBuffer(optionArray);
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

			if(!(player.isWorking())) {
			
				Set set = (Set) player.getRoom();
				ArrayList<Role> roles = set.getRoles();
				
				if(set.getShotCount() <= 0) {
					
					System.out.println("No roles available. "); 
				}
				
				else {
			
					if(optionArray.length == 1) {
						
						Scene sceneCard = set.getSceneCard();
						
						System.out.println("The current scene is \"" + sceneCard.getName() + "\" with a move budget of $" + sceneCard.getBudget());
						System.out.print("\nAvailable on card roles: \n"); 
					
						ArrayList<Role> cardRoles = sceneCard.getSceneRoles();
						for(int i = 0; i < cardRoles.size(); i++) {
							
							if(!(cardRoles.get(i).isOccupied()))
							System.out.println("\"" + cardRoles.get(i).getName() + "\"   (Required rank: " + cardRoles.get(i).getRoleRank() + ")");
						}
						
						System.out.println("\nAvailable off card roles: ");
						for(int i = 0; i < roles.size(); i++) {
							
							if(!(roles.get(i).isOccupied()))
							System.out.println("\"" + roles.get(i).getName() + "\"   (Required rank: " + roles.get(i).getRoleRank() + ")"); 
						}
					}
					
					else if(optionArray.length >= 2) {
						
						String tempRoleName = getStringBuffer(optionArray);
						//System.out.println("ROLE: " + tempRoleName);
						work(player, tempRoleName);
					}
				}
			}
			
			else {
				
				System.out.println("You are already working a role. ");
			}
		}

		else if(optionArray[0].equals("upgrade")){

			
		}

		else if(optionArray[0].equals("rehearse")){

			
		}
		

		else if(optionArray[0].equals("act")){ 

			if(player.isWorking()) {
				
				act(player);
			}
		}

		else if(optionArray[0].equals("end")){
			
			setEndTurn(true);
			player.setMoved(false);
		}
		
		else{
			
			System.out.println("Please enter a valid action, type \"help\" for options.");
		}
	}

	//check for all players in the same room
	public void wrapScene(Player player) {
		
		//if player.getSet().checkCard()
		Set set = (Set) player.getRoom();
		Random random = new Random();
		
		if(set.checkCard(player)) {
			
			//distribute bonus money
			int dice[] = new int[set.getSceneCard().getBudget()];
			for(int i = 0; i < dice.length; i++) {
				
				dice[i] = random.nextInt(6) + 1;
			}
			
			for(int i = 0; i < dice.length; i++) {
				
				System.out.println("Dice roll: " + i + " is " + dice[i]);
			}
			System.out.println();
		
			int sceneCardRoles = set.getSceneCard().getSceneRoles().size();
			int array[] = new int[sceneCardRoles];

			for(int i = 0; i < dice.length; i++) {
				
				array[i % sceneCardRoles] += dice[i];
			}

			for(int i = 0; i < array.length; i++) {
				
				System.out.println("Array index " + i + " is: " + array[i]);
			}
			System.out.println();
			
			System.out.println("Array length: " + array.length);
			ArrayList<Role> sceneRoles = new ArrayList<Role>(set.getSceneCard().getSceneRoles());
			int j = (sceneCardRoles - 1); 
			for(int i = 0; i < array.length; i++) {
				
				if(sceneRoles.get(i % 3).isOccupied() && sceneRoles.get(i % 3).getPlayer() != null) {
					
					System.out.println("Scene Role: " + sceneRoles.get(i % 3).getName() + " is getting: $" + array[j]);
					player.setDollars(player.getDollars() + array[j]);
					j--;
					
				}
			}
			
			//mod it by 3
			//each card has three roles
		
			
			
			
		}
		
		else {
			
			System.out.println("Shot tokens are zero! No player on working card!");
		}
		
		
	}
		
	public String getStringBuffer(String optionArray[]) {
		
		StringBuffer sb = new StringBuffer();
		
		int i = 1;
		for(i = 1; i < optionArray.length - 1; i++){
			
			 sb.append(optionArray[i] + " ");
		}
		
		sb.append(optionArray[i]);
		String getString = sb.toString();
		return getString;
	}
	
	public boolean isEndTurn() {
		
		return endTurn;
	}

	public void setEndTurn(boolean endTurn) {
		
		this.endTurn = endTurn;
	}
}
