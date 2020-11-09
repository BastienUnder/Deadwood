import java.util.*;
public class Action {

	public Scanner scanner = new Scanner(System.in);
	private boolean endTurn = false;
	private int scenesLeftInDay = 10;
	private ArrayList<Player> players = new ArrayList<Player>();

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

					System.out.print("Moved from \"" + player.getRoom().getName() + "\" ");
					player.setPosition(adjacentRooms.get(i));
					player.setMoved(true);
					System.out.println("to \"" + player.getRoom().getName() + "\"");

					//if(!(roomName.equals("office"))){
						//Set set = (Set) player.getRoom();
						//set.setShotCount(1);}

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
					roles.get(i).setPlayer(player);
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
		int dice = random.nextInt(6) + 1 + player.getRehearseTokens();
		Set set = (Set) player.getRoom();
		int movieBudget = set.getSceneCard().getBudget();

		if(dice >= movieBudget) {
			set.setShotCount(set.getShotCount() - 1);

			System.out.println("Success!! ");
			System.out.println("There are now " + set.getShotCount() + " shots left.");
			if(player.getRole().isOnCard()) {

				player.setCredits(player.getCredits() + 2);
				System.out.println(player.getName() + " recieves two credits!");
			}

			else {

				player.setCredits(player.getCredits() + 1);
				player.setDollars(player.getDollars() + 1);
				System.out.println(player.getName() + " recieves one credit and one dollar!");
			}


			//player.getRole().takeRole(false);

			//For each player check if they are in that room and if so set them to not working.
			//player.setWorking(false);

			//When player one takes on card, player two does not


			if(set.getShotCount() <= 0) {

				wrapScene(player);
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

	public void upgrade(Player player, String[] optionArray){
		CastingOffice office = (CastingOffice) player.getRoom();

		if(optionArray.length == 1){
			office.printUpgrades();
		}
		else if(optionArray.length == 3 && (optionArray[2].equals("dollar") || optionArray[2].equals("credit"))){
			boolean tryUpgrade = true;
			String sRank = optionArray[1];
			int rank;
			int price;
			String currency = optionArray[2];

			switch (sRank){
				case "1":
					rank = 1;
					break;
				case "2":
					rank = 2;
					break;
				case "3":
					rank = 3;
					break;
				case "4":
					rank = 4;
					break;
				case "5":
					rank = 5;
					break;
				case "6":
					rank = 6;
					break;
				default:
					return;
			}

			if(player.getRank() >= rank){
				System.out.println("You are already equal to or above desired rank.");
				return;
			}

			price = office.getUpgradePrice(rank, currency);

			if(currency.equals("dollar")){
				if(player.getDollars() >= price){
					player.setRank(rank);
					player.setDollars(player.getDollars() - price);
					System.out.println("You have been upgraded to level " + rank);
				}
				else{
					System.out.println("You do not have enough dollars to upgrade to rank level " + rank);
				}
			}
			else{
				if(player.getCredits() >= price){
					player.setRank(rank);
					player.setCredits(player.getCredits() - price);
					System.out.println("You have been upgraded to level " + rank);
				}
				else{
					System.out.println("You do not have enough credits to upgrade to rank level " + rank);
				}
			}
		}
		else{
			System.out.println("Please input your upgrade choice correctly.");
		}

	}//end upgrade()


	public void availableActions(Player player, String option) {

		String[] optionArray = option.split("\\s+");

		if(optionArray[0].equals("help")) {

			System.out.println("Keyword \"who\" shows active player's status");
			System.out.println("Keyword \"where\" shows your location, keyword \"where all\" shows locations of all players");
			System.out.println("Keyword \"move\" shows adjacent rooms, use keyword \" move 'roomName'\" to move to adjacent room");
			System.out.println("Keyword \"work\" shows available roles, use keyword \"work 'role'\" to work a specific role");
			System.out.println("Keyword \"upgrade\" shows upgrade options while player is in the Casting Office, \n use \"upgrade 'rank' 'currency'\" where 'rank' is a number from 1 to 6 and currency is either \"dollar\" or \"credit\"");
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
			if(optionArray.length > 1 && optionArray[1].equals("all")){
				for(int i=0; i<players.size(); i++){
					Player tempPlayer = players.get(i);
					System.out.println(tempPlayer.getName() + " is in the \"" + tempPlayer.getRoom().getName() + "\"");
				}
				System.out.println("The active player is " + player.getName());
			}
			else {
				System.out.println("\"" + player.getRoom().getName() + "\"");
			}
		}

		else if(optionArray[0].equals("move")) {

			if(!(player.hasMoved())) {

				if(optionArray.length == 2) {

					move(player, optionArray[1]);
				}

				else if(optionArray.length >= 3){

					String tempRoomName = getStringBuffer(optionArray);
					//System.out.println("MOVE TO: " + tempRoomName);

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

			if(player.getRoom().getName().equals("office")){
				System.out.println("No roles are available in the Casting Office");
				return;
			}

			if(!(player.isWorking())) {

				Set set = (Set) player.getRoom();

				ArrayList<Role> roles = set.getRoles();

				if(set.getShotCount() <= 0) {
					System.out.println("No roles available in the " + set.getName());

				}

				else {

					if(optionArray.length == 1) {

						Scene sceneCard = set.getSceneCard();

						System.out.println("The current scene is \"" + sceneCard.getName() + "\" with a move budget of $" + sceneCard.getBudget() + " (shot tokens: " + set.getShotCount() + ")");
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
			if(player.getRoom().getName().equals("office")){

				upgrade(player, optionArray);
			}
			else{
				System.out.println("You must be located in the Casting Office to upgrade.");
			}

		}

		else if(optionArray[0].equals("rehearse")){

			if(player.isWorking()) {
				System.out.println("Player recieved one token from rehearsing.");
				player.addOneRehearseToken();
				setEndTurn(true);
			}
			else {

				System.out.println(player.getName() + " is not working.");
			}

		}


		else if(optionArray[0].equals("act")){

			if(player.isWorking()) {

				act(player);
			}
			else {

				System.out.println(player.getName() + " is not working.");
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

	public void wrapScene(Player player) {

		Random random = new Random();
		Set set = (Set) player.getRoom();
		Scene card = set.getSceneCard();

		System.out.println("The scene is wrapped!");

		if(checkCard(player)) {

			int dice[] = new int[card.getBudget()];

			for(int i = 0; i < card.getBudget(); i++) {

				dice[i] = random.nextInt(6) + 1;
			}

			int sceneRoles = card.getSceneRoles().size();
			for(int i = 0; i < dice.length; i++) {

				if(card.getSceneRoles().get(i % sceneRoles).getPlayer() != null) {
					card.getSceneRoles().get(i % sceneRoles).getPlayer().setDollars(
							card.getSceneRoles().get(i % sceneRoles).getPlayer().getDollars() + dice[i]);
				}
			}

			for(int i = 0; i < set.getRoles().size(); i++) {
				
				if((set.getRoles().get(i).isOccupied()) &&
						(!(set.getRoles().get(i).isOnCard()))) {

					set.getRoles().get(i).getPlayer().setDollars(
							set.getRoles().get(i).getPlayer().getDollars() +
									set.getRoles().get(i).getRoleRank());
				}
			}
		}

		freeRoles(player);
		scenesLeftInDay--;
	}

	public boolean checkCard(Player player) {

		Set set = (Set) player.getRoom();
		ArrayList<Role> roles = set.getSceneCard().getSceneRoles();

		for(int i = 0; i < roles.size(); i++) {

			if(roles.get(i).isOccupied()) {

				return true;
			}
		}

		return false;
	}

	public void freeRoles(Player player) {

		Set set = (Set) player.getRoom();
		ArrayList<Role> roles = new ArrayList<Role>(set.getRoles());
		roles.addAll(set.getSceneCard().getSceneRoles());

		for(int i = 0; i < roles.size(); i++) {

			if(roles.get(i).isOccupied()) {

				roles.get(i).getPlayer().setWorking(false);
				roles.get(i).getPlayer().setMoved(false);
				roles.get(i).getPlayer().setRehearseTokens(0);
			}
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

	public int getScenesLeftInDay() {
		return scenesLeftInDay;
	}

	public void setScenesLeftInDay(int scenesLeftInDay) {
		this.scenesLeftInDay = scenesLeftInDay;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
}