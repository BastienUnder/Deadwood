import java.util.*;

public class SetBoard extends Room{

	private Map<String, Room> rooms = new HashMap<String, Room>();

	public SetBoard() {
		
		setRooms();
	}
	
	public void setRooms() {
		
		Room trailers = new Room("Trailers", 0, new ArrayList<Role>()); 
		Room castingOffice = new Room("Casting Office", 0, new ArrayList<Role>());
		
		ArrayList<Role> mainStreetRoles = new ArrayList<Role>();
		mainStreetRoles.add(new Role("Mayor McGinty", 4, false));
		mainStreetRoles.add(new Role("Falls off Roof", 2, false));
		mainStreetRoles.add(new Role("Railroad Worker", 1, false));
		mainStreetRoles.add(new Role("Woman in Black Dress", 2, false));
		Room mainStreet = new Room("Main Street", 4, mainStreetRoles);
		
		ArrayList<Role> saloonRoles = new ArrayList<Role>();
		saloonRoles.add(new Role("Reluctant Farmer", 1, false));
		saloonRoles.add(new Role("Woman in Red Dress", 2, false));
		Room saloon = new Room("Saloon", 2, saloonRoles);
		
		ArrayList<Role> jailRoles = new ArrayList<Role>();
		jailRoles.add(new Role("Feller in Irons", 3, false));
		jailRoles.add(new Role("Prisoner in Cell", 2, false));
		Room jail = new Room("Jail", 2, jailRoles);
		
		ArrayList<Role> generalStoreRoles = new ArrayList<Role>();
		generalStoreRoles.add(new Role("Mister Keach", 3, false));
		generalStoreRoles.add(new Role("Main in Overalls", 1, false));
		Room generalStore = new Room("General Store", 2, generalStoreRoles);
		
		ArrayList<Role> trainStationRoles = new ArrayList<Role>();
		trainStationRoles.add(new Role("Dragged by Train", 1, false));
		trainStationRoles.add(new Role("Preacher with Bag", 2, false));
		trainStationRoles.add(new Role("Crusty Prospector", 1, false));
		trainStationRoles.add(new Role("Gyrus the Gunfighter", 4, false));
		Room trainStation = new Room("Train Station", 4, trainStationRoles);
		
		ArrayList<Role> hotelRoles = new ArrayList<Role>();
		hotelRoles.add(new Role("Sleeping Drunkard", 1, false));
		hotelRoles.add(new Role("Faro Player", 1, false));
		hotelRoles.add(new Role("Falls from Balcony", 2, false));
		hotelRoles.add(new Role("Australian Bartender", 3, false));
		Room hotel = new Room("Hotel", 4, hotelRoles);
		
		ArrayList<Role> churchRoles = new ArrayList<Role>();
		churchRoles.add(new Role("Dead Man", 1, false));
		churchRoles.add(new Role("Crying Woman", 2, false));
		Room church = new Room("Church", 2, churchRoles);
		
		ArrayList<Role> bankRoles = new ArrayList<Role>();
		bankRoles.add(new Role("Flustered Teller", 3, false));
		bankRoles.add(new Role("Suspicious Gentleman", 2, false));
		Room bank = new Room("Bank", 2, bankRoles);
		
		ArrayList<Role> ranchRoles = new ArrayList<Role>();
		ranchRoles.add(new Role("Shot in Leg", 1, false));
		ranchRoles.add(new Role("Saucy Fred", 2, false));
		ranchRoles.add(new Role("Man Under Horse", 3, false));
		Room ranch = new Room("Ranch", 3, ranchRoles);
		
		ArrayList<Role> hideoutRoles = new ArrayList<Role>();
		hideoutRoles.add(new Role("Clumsy Pit Fighter", 1, false));
		hideoutRoles.add(new Role("Thug with Knife", 2, false));
		hideoutRoles.add(new Role("Dangerous Tom", 3, false));
		hideoutRoles.add(new Role("Penny, who is Lost", 4, false));
		Room secretHideout = new Room("Hideout", 4, hideoutRoles);
		
		rooms.put("Jail", jail);
		rooms.put("Bank", bank);
		rooms.put("Ranch", ranch);
		rooms.put("Hotel", hotel);
		rooms.put("Church", church);
		rooms.put("Saloon", saloon);
		rooms.put("Trailers", trailers);
		rooms.put("Main Street", mainStreet);
		rooms.put("Train Station", trainStation);
		rooms.put("General Store", generalStore);
		rooms.put("Casting Office", castingOffice);
		rooms.put("Secret Hideout", secretHideout);
		
		ArrayList<Room> adjacentTrailerRooms = new ArrayList<Room>();
		adjacentTrailerRooms.add(mainStreet);
		adjacentTrailerRooms.add(saloon);
		adjacentTrailerRooms.add(hotel);
		rooms.get("Trailers").setAdjacentRooms(adjacentTrailerRooms);
		
		ArrayList<Room> adjacentSaloonRooms = new ArrayList<Room>();
		adjacentSaloonRooms.add(bank);
		adjacentSaloonRooms.add(trailers);
		adjacentSaloonRooms.add(mainStreet);
		adjacentSaloonRooms.add(generalStore);
		rooms.get("Saloon").setAdjacentRooms(adjacentSaloonRooms);
		
		ArrayList<Room> adjacentMainStreetRooms = new ArrayList<Room>();
		adjacentMainStreetRooms.add(trailers);
		adjacentMainStreetRooms.add(saloon);
		adjacentMainStreetRooms.add(jail);
		rooms.get("Main Street").setAdjacentRooms(adjacentMainStreetRooms);
		
		ArrayList<Room> adjacentJailRooms = new ArrayList<Room>();
		adjacentJailRooms.add(mainStreet);
		adjacentJailRooms.add(trainStation);
		adjacentJailRooms.add(generalStore);
		rooms.get("Jail").setAdjacentRooms(adjacentJailRooms);
		
		ArrayList<Room> adjacentTrainStationRooms = new ArrayList<Room>();
		adjacentTrainStationRooms.add(jail);
		adjacentTrainStationRooms.add(generalStore);
		adjacentTrainStationRooms.add(castingOffice);
		rooms.get("Casting Office").setAdjacentRooms(adjacentTrainStationRooms);
		
		ArrayList<Room> adjacentGeneralStoreRooms = new ArrayList<Room>();
		adjacentGeneralStoreRooms.add(trainStation);
		adjacentGeneralStoreRooms.add(jail);
		adjacentGeneralStoreRooms.add(ranch);
		adjacentGeneralStoreRooms.add(saloon);
		rooms.get("General Store").setAdjacentRooms(adjacentGeneralStoreRooms);
		
		ArrayList<Room> adjacentCastingOfficeRooms = new ArrayList<Room>();
		adjacentCastingOfficeRooms.add(trainStation);
		adjacentCastingOfficeRooms.add(ranch);
		adjacentCastingOfficeRooms.add(secretHideout);
		rooms.get("Casting Office").setAdjacentRooms(adjacentCastingOfficeRooms);
		
		ArrayList<Room> adjacentRanchRooms = new ArrayList<Room>();
		adjacentRanchRooms.add(generalStore);
		adjacentRanchRooms.add(castingOffice);
		adjacentRanchRooms.add(secretHideout);
		adjacentRanchRooms.add(bank);
		rooms.get("Ranch").setAdjacentRooms(adjacentRanchRooms);
		
		ArrayList<Room> adjacentSecretHideoutRooms = new ArrayList<Room>();
		adjacentSecretHideoutRooms.add(ranch);
		adjacentSecretHideoutRooms.add(castingOffice);
		adjacentSecretHideoutRooms.add(church);
		rooms.get("Secret Hideout").setAdjacentRooms(adjacentSecretHideoutRooms);
		
		ArrayList<Room> adjacentChurchRooms = new ArrayList<Room>();
		adjacentChurchRooms.add(secretHideout);
		adjacentChurchRooms.add(bank);
		adjacentChurchRooms.add(hotel);
		rooms.get("Church").setAdjacentRooms(adjacentChurchRooms);
		
		ArrayList<Room> adjacentBankRooms = new ArrayList<Room>();
		adjacentBankRooms.add(church);
		adjacentBankRooms.add(ranch);
		adjacentBankRooms.add(saloon);
		adjacentBankRooms.add(hotel);
		rooms.get("Bank").setAdjacentRooms(adjacentBankRooms);
		
		ArrayList<Room> adjacentHotelRooms = new ArrayList<Room>(); 
		adjacentHotelRooms.add(bank);
		adjacentHotelRooms.add(church);
		adjacentHotelRooms.add(trailers);
		rooms.get("Hotel").setAdjacentRooms(adjacentHotelRooms); 
	}
	
	
	public void getCards() { 
		
		
		
		
	} 
	
	
	public Map<String, Room> getRooms(){
		
		return rooms;
	}
	
	
	
	
	
	
	
}




