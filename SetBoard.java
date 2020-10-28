import java.util.*;

public class SetBoard extends Room{

	private static Map<String, Room> rooms = new HashMap<String, Room>();
	private static ArrayList<SceneRoom> allScenes = new ArrayList<SceneRoom>();


	public SetBoard() {
		
		setRooms();
		setScenes();
	}

	public void setScenes(){
		ArrayList<Role> evilWearsRoles = new ArrayList<>();
		evilWearsRoles.add(new Role("Defrocked Priest", 2, true));
		evilWearsRoles.add(new Role("Marshal Canfield", 3, true));
		evilWearsRoles.add(new Role("One-Eyed Man", 4, true));
		SceneRoom evilWears = new SceneRoom("Evil Wears a Hat", 4, evilWearsRoles);

		ArrayList<Role> squareDealCityRoles = new ArrayList<>();
		squareDealCityRoles.add(new Role("Squeaking Boy", 2, true));
		squareDealCityRoles.add(new Role("Pharoh Imhotep", 4, true));
		squareDealCityRoles.add(new Role("Aunt Marth", 6, true));
		SceneRoom squareDealCity = new SceneRoom("Square Deal City", 6, squareDealCityRoles);

		ArrayList<Role> lawAndOldWestRoles = new ArrayList<>();
		lawAndOldWestRoles.add(new Role("Rug Merchant", 1, true));
		lawAndOldWestRoles.add(new Role("Banker", 2, true));
		lawAndOldWestRoles.add(new Role("Talking Mule", 5, true));
		SceneRoom lawAndOldWest = new SceneRoom("Law and the Old West", 3, lawAndOldWestRoles);

		ArrayList<Role> davyCrockettRoles = new ArrayList<>();
		davyCrockettRoles.add(new Role("The Duck", 4, true));
		davyCrockettRoles.add(new Role("His Brother", 6, true));
		SceneRoom davyCrockett = new SceneRoom("Davy Crockett: A Drunkard's Tale", 4, davyCrockettRoles);

		ArrayList<Role> lifeAndTimesSkywaterRoles = new ArrayList<>();
		lifeAndTimesSkywaterRoles.add(new Role("Auctioneer", 5, true));
		lifeAndTimesSkywaterRoles.add(new Role("General Custer", 6, true));
		SceneRoom lifeAndTimesSkywater = new SceneRoom("The Life and Times of John Skywater", 5, lifeAndTimesSkywaterRoles);

		ArrayList<Role> wayWestRunRoles = new ArrayList<>();
		wayWestRunRoles.add(new Role("Town Drunk", 2, true));
		wayWestRunRoles.add(new Role("Squinting Miner", 4, true));
		wayWestRunRoles.add(new Role("Poltergeist", 5, true));
		SceneRoom wayWestRun = new SceneRoom("The Way the West Was Run", 4, wayWestRunRoles);

		ArrayList<Role> yearsOnPrairieRoles = new ArrayList<>();
		yearsOnPrairieRoles.add(new Role("Drunk", 3, true));
		yearsOnPrairieRoles.add(new Role("Librarian", 4, true));
		yearsOnPrairieRoles.add(new Role("Man with Hay", 6, true));
		SceneRoom yearsOnPrairie = new SceneRoom("My Years on the Prairie", 5, yearsOnPrairieRoles);

		ArrayList<Role> downInValleyRoles = new ArrayList<>();
		downInValleyRoles.add(new Role("Angry Barber", 1, true));
		downInValleyRoles.add(new Role("Woman with Board", 3, true));
		downInValleyRoles.add(new Role("Man on Fire", 5, true));
		SceneRoom downInValley = new SceneRoom("Down in the Valley", 3, downInValleyRoles);

		ArrayList<Role> buffaloBillLostRoles = new ArrayList<>();
		buffaloBillLostRoles.add(new Role("Hollering Boy", 2, true));
		buffaloBillLostRoles.add(new Role("Drunk Farmer", 3, true));
		buffaloBillLostRoles.add(new Role("Meek Little Sarah", 5, true));
		SceneRoom buffaloBillLost = new SceneRoom("Buffalo Bill: The Lost Years", 4, buffaloBillLostRoles);

		ArrayList<Role> olShooterRoles = new ArrayList<>();
		olShooterRoles.add(new Role("Sleeping Man", 1, true));
		olShooterRoles.add(new Role("Man with Pig", 2, true));
		olShooterRoles.add(new Role("Shooter", 4, true));
		SceneRoom olShooter = new SceneRoom("Ol' Shooter and Little Doll", 4, buffaloBillLostRoles);

		ArrayList<Role> robbersOfTrainsRoles = new ArrayList<>();
		robbersOfTrainsRoles.add(new Role("Buster", 1, true));
		robbersOfTrainsRoles.add(new Role("Man Reading Paper", 4, true));
		robbersOfTrainsRoles.add(new Role("Fat Pete", 5, true));
		SceneRoom robbersOfTrains = new SceneRoom("The Robbers of Trains", 4, robbersOfTrainsRoles);

		ArrayList<Role> jesseJamesRoles = new ArrayList<>();
		jesseJamesRoles.add(new Role("Shot in Back", 2, true));
		jesseJamesRoles.add(new Role("Shot in Leg", 4, true));
		jesseJamesRoles.add(new Role("Leaps into Cake", 5, true));
		SceneRoom jesseJames = new SceneRoom("Jesse James: Man of Action", 5, jesseJamesRoles);

		ArrayList<Role> beyondPailRoles = new ArrayList<>();
		beyondPailRoles.add(new Role("Martin", 6, true));
		SceneRoom beyondPail = new SceneRoom("Beyond the Pail: Life without Lactose", 2, beyondPailRoles);

		ArrayList<Role> disasterFlyingRoles = new ArrayList<>();
		disasterFlyingRoles.add(new Role("Piano Player", 2, true));
		disasterFlyingRoles.add(new Role("Man in Turban", 3, true));
		disasterFlyingRoles.add(new Role("Falls on Hoe", 4, true));
		SceneRoom disasterFlyingJ = new SceneRoom("Disaster at Flying J", 5, disasterFlyingRoles);

		ArrayList<Role> manCalledCowRoles = new ArrayList<>();
		manCalledCowRoles.add(new Role("Preacher", 3, true));
		manCalledCowRoles.add(new Role("Amused Witness", 6, true));
		SceneRoom manCalledCow = new SceneRoom("A Man called \"Cow\"", 3, manCalledCowRoles);

		ArrayList<Role> shakespeareLubbockRoles = new ArrayList<>();
		shakespeareLubbockRoles.add(new Role("Falls from Tree", 1, true));
		shakespeareLubbockRoles.add(new Role("Laughing Woman", 3, true));
		shakespeareLubbockRoles.add(new Role("Man with Whistle", 4, true));
		SceneRoom shakespeareLubbock = new SceneRoom("Shakespeare in Lubbock", 3, shakespeareLubbockRoles);

		ArrayList<Role> taffyRoles = new ArrayList<>();
		taffyRoles.add(new Role("Curious Girl", 3, true));
		taffyRoles.add(new Role("Ghost of Plato", 4, true));
		SceneRoom taffyCommercial = new SceneRoom("Taffy Commercial", 2, taffyRoles);

		ArrayList<Role> goWestRoles = new ArrayList<>();
		goWestRoles.add(new Role("Ex-Convict", 4, true));
		goWestRoles.add(new Role("Man with Onion", 6, true));
		SceneRoom goWest = new SceneRoom("Go West, You!", 3, goWestRoles);

		ArrayList<Role> gumCommercialRoles = new ArrayList<>();
		gumCommercialRoles.add(new Role("Surprised Bison", 2, true));
		gumCommercialRoles.add(new Role("Man with Horn", 4, true));
		SceneRoom gumCommercial = new SceneRoom("Gum Commercial", 2, gumCommercialRoles);

		ArrayList<Role> lifeTimesSkywaterRoles = new ArrayList<>();
		lifeAndTimesSkywaterRoles.add(new Role("Staggering Man", 3, true));
		lifeAndTimesSkywaterRoles.add(new Role("Woman with Beer", 5, true));
		lifeAndTimesSkywaterRoles.add(new Role("Marcie", 6, true));
		SceneRoom lifeTimesSkywater = new SceneRoom("The Life and Times of John Skywater", 5, lifeTimesSkywaterRoles);

		ArrayList<Role> gunMusicalRoles = new ArrayList<>();
		gunMusicalRoles.add(new Role("Looks like Elvis", 4, true));
		gunMusicalRoles.add(new Role("Singing Dead Man", 5, true));
		gunMusicalRoles.add(new Role("Apothecary", 6, true));
		SceneRoom gunMusical = new SceneRoom("Gun! The Musical", 6, gumCommercialRoles);

		ArrayList<Role> falseStepMankindRoles = new ArrayList<>();
		falseStepMankindRoles.add(new Role("Flustered Man", 1, true));
		falseStepMankindRoles.add(new Role("Space Monkey", 2, true));
		falseStepMankindRoles.add(new Role("Cowbot Dan", 5, true));
		SceneRoom falseStepMankind = new SceneRoom("One False Step for Mankind", 6, falseStepMankindRoles);

		ArrayList<Role> humorExpenseRoles = new ArrayList<>();
		humorExpenseRoles.add(new Role("Jailer", 2, true));
		humorExpenseRoles.add(new Role("Mephistopheles", 4, true));
		humorExpenseRoles.add(new Role("Breaks a Window", 5, true));
		SceneRoom humorExpense = new SceneRoom("Humor at the Expense of Others", 5, humorExpenseRoles);

		ArrayList<Role> thirteenHardRoles = new ArrayList<>();
		thirteenHardRoles.add(new Role("Man in Poncho", 1, true));
		thirteenHardRoles.add(new Role("Ecstatic Housewife", 3, true));
		thirteenHardRoles.add(new Role("Isaac", 5, true));
		SceneRoom thirteenHard = new SceneRoom("Thirteen the Hard Way", 5, thirteenHardRoles);

		ArrayList<Role> searchMaggieRoles = new ArrayList<>();
		searchMaggieRoles.add(new Role("Film Critic", 5, true));
		searchMaggieRoles.add(new Role("Hobo with Bat", 6, true));
		SceneRoom searchMaggie = new SceneRoom("The Search for Maggie White", 6, searchMaggieRoles);

		ArrayList<Role> howGetMilkRoles = new ArrayList<>();
		howGetMilkRoles.add(new Role("Cow", 2, true));
		howGetMilkRoles.add(new Role("St. Clement of Alexandria", 3, true));
		howGetMilkRoles.add(new Role("Josie", 4, true));
		SceneRoom howGetMilk = new SceneRoom("How They Get Milk", 4, howGetMilkRoles);

		ArrayList<Role> picanteSauceRoles = new ArrayList<>();
		picanteSauceRoles.add(new Role("Bewhisker'd Cowpoke", 3, true));
		picanteSauceRoles.add(new Role("Dog", 5, true));
		SceneRoom picanteSauce = new SceneRoom("Picante Sauce Commercial", 2, picanteSauceRoles);

		ArrayList<Role> yearsOnPrairie2Roles = new ArrayList<>();
		yearsOnPrairie2Roles.add(new Role("Willard", 2, true));
		yearsOnPrairie2Roles.add(new Role("Leprechaun", 3, true));
		yearsOnPrairie2Roles.add(new Role("Startled Ox", 5, true));
		SceneRoom yearsOnPrairie2 = new SceneRoom("My Years on the Prairie", 5, yearsOnPrairie2Roles);

		ArrayList<Role> jesseJames2Roles = new ArrayList<>();
		jesseJames2Roles.add(new Role("Shot in Head", 1, true));
		jesseJames2Roles.add(new Role("Leaps Out of Cake", 4, true));
		jesseJames2Roles.add(new Role("Shot Three Times", 6, true));
		SceneRoom jessJames2 = new SceneRoom("Jesse James: Man of Action", 5, jesseJames2Roles);

		ArrayList<Role> davyCrockett2Roles = new ArrayList<>();
		davyCrockett2Roles.add(new Role("Voice of God", 2, true));
		davyCrockett2Roles.add(new Role("Hands of God", 3, true));
		davyCrockett2Roles.add(new Role("Jack Kemp", 4, true));
		SceneRoom davyCrockett2 = new SceneRoom("Davy Crockett: A Drunkard's Tale", 4, davyCrockett2Roles);

		ArrayList<Role> czechsSonoraRoles = new ArrayList<>();
		czechsSonoraRoles.add(new Role("Opice (Monkey)", 5, true));
		czechsSonoraRoles.add(new Role("Man with Gun", 6, true));
		SceneRoom czechsSonora = new SceneRoom("Czechs in the Sonora", 4, czechsSonoraRoles);

		ArrayList<Role> robertLuckyRoles = new ArrayList<>();
		robertLuckyRoles.add(new Role("Man with Rope", 1, true));
		robertLuckyRoles.add(new Role("Svetlana", 2, true));
		robertLuckyRoles.add(new Role("Accidental Victim", 5, true));
		SceneRoom robertLucky = new SceneRoom("J. Robert Lucky, Man of Substance", 4, robertLuckyRoles);

		ArrayList<Role> swingEmRoles = new ArrayList<>();
		swingEmRoles.add(new Role("Thrifty Mike", 1, true));
		swingEmRoles.add(new Role("Sober Physician", 3, true));
		swingEmRoles.add(new Role("Man on Floor", 5, true));
		SceneRoom swingEm = new SceneRoom("Swing 'em Wide", 6, swingEmRoles);

		ArrayList<Role> thirteenHardWayRoles = new ArrayList<>();
		thirteenHardRoles.add(new Role("Very Wet Man", 2, true));
		thirteenHardRoles.add(new Role("Dejected Housewife", 4, true));
		thirteenHardRoles.add(new Role("Man with Box", 5, true));
		SceneRoom thirteenHardWay = new SceneRoom("Thirteen the Hard Way", 5, thirteenHardWayRoles);

		ArrayList<Role> swingEm2Roles = new ArrayList<>();
		swingEm2Roles.add(new Role("Liberated Nun", 3, true));
		swingEm2Roles.add(new Role("Witch Doctor", 5, true));
		swingEm2Roles.add(new Role("Voice of Reason", 6, true));
		SceneRoom swingEm2 = new SceneRoom("Swing 'em Wide", 6, swingEm2Roles);

		ArrayList<Role> getMilkRoles = new ArrayList<>();
		getMilkRoles.add(new Role("Marksman", 4, true));
		getMilkRoles.add(new Role("Postal Worker", 5, true));
		getMilkRoles.add(new Role("A Horse", 6, true));
		SceneRoom getMilk = new SceneRoom("How They Get Milk", 4, getMilkRoles);

		ArrayList<Role> trialsFirstRoles = new ArrayList<>();
		trialsFirstRoles.add(new Role("Burning Man", 2, true));
		trialsFirstRoles.add(new Role("Cheese Vendor", 4, true));
		trialsFirstRoles.add(new Role("Hit with Table", 5, true));
		SceneRoom trialsFirst = new SceneRoom("Trials of the First Pioneers", 4, trialsFirstRoles);

		ArrayList<Role> trickPoniesRoles = new ArrayList<>();
		trickPoniesRoles.add(new Role("Fraternity Pledge", 2, true));
		trickPoniesRoles.add(new Role("Man with Sword", 6, true));
		SceneRoom trickPonies = new SceneRoom("Breakin' in Trick Ponies", 3, trickPoniesRoles);

		ArrayList<Role> grinchTexasRoles = new ArrayList<>();
		grinchTexasRoles.add(new Role("Detective", 3, true));
		grinchTexasRoles.add(new Role("File Clerk", 4, true));
		grinchTexasRoles.add(new Role("Cindy Lou", 5, true));
		SceneRoom grinchTexas = new SceneRoom("How the Grinch Stole Texas", 5, grinchTexasRoles);

		ArrayList<Role> custersStandsRoles = new ArrayList<>();
		custersStandsRoles.add(new Role("Farmer", 2, true));
		custersStandsRoles.add(new Role("Exploding Horse", 4, true));
		custersStandsRoles.add(new Role("Jack", 6, true));
		SceneRoom custersStands = new SceneRoom("Custer's Other Stands", 5, custersStandsRoles);


		//Place all the scenes into a list. Broken into blocks of 10
		allScenes.add(evilWears);
		allScenes.add(squareDealCity);
		allScenes.add(lawAndOldWest);
		allScenes.add(davyCrockett);
		allScenes.add(lifeAndTimesSkywater);
		allScenes.add(wayWestRun);
		allScenes.add(yearsOnPrairie);
		allScenes.add(downInValley);
		allScenes.add(buffaloBillLost);
		allScenes.add(olShooter);

		allScenes.add(robbersOfTrains);
		allScenes.add(jesseJames);
		allScenes.add(beyondPail);
		allScenes.add(disasterFlyingJ);
		allScenes.add(manCalledCow);
		allScenes.add(shakespeareLubbock);
		allScenes.add(taffyCommercial);
		allScenes.add(goWest);
		allScenes.add(gumCommercial);
		allScenes.add(lifeAndTimesSkywater);

		allScenes.add(gunMusical);
		allScenes.add(falseStepMankind);
		allScenes.add(humorExpense);
		allScenes.add(thirteenHard);
		allScenes.add(searchMaggie);
		allScenes.add(howGetMilk);
		allScenes.add(picanteSauce);
		allScenes.add(yearsOnPrairie2);
		allScenes.add(jessJames2);
		allScenes.add(davyCrockett2);

		allScenes.add(czechsSonora);
		allScenes.add(robertLucky);
		allScenes.add(swingEm);
		allScenes.add(thirteenHardWay);
		allScenes.add(swingEm2);
		allScenes.add(getMilk);
		allScenes.add(trialsFirst);
		allScenes.add(trickPonies);
		allScenes.add(grinchTexas);
		allScenes.add(custersStands);

	}
	
	public void setRooms() {
		
		Room trailers = new Room("Trailers"); 
		Room castingOffice = new Room("Casting Office");
		
		ArrayList<Role> mainStreetRoles = new ArrayList<Role>();
		mainStreetRoles.add(new Role("Mayor McGinty", 4, false));
		mainStreetRoles.add(new Role("Falls off Roof", 2, false));
		mainStreetRoles.add(new Role("Railroad Worker", 1, false));
		mainStreetRoles.add(new Role("Woman in Black Dress", 2, false));
		SceneRoom mainStreet = new SceneRoom("Main Street", 4, mainStreetRoles);
		
		ArrayList<Role> saloonRoles = new ArrayList<Role>();
		saloonRoles.add(new Role("Reluctant Farmer", 1, false));
		saloonRoles.add(new Role("Woman in Red Dress", 2, false));
		SceneRoom saloon = new SceneRoom("Saloon", 2, saloonRoles);
		
		ArrayList<Role> jailRoles = new ArrayList<Role>();
		jailRoles.add(new Role("Feller in Irons", 3, false));
		jailRoles.add(new Role("Prisoner in Cell", 2, false));
		SceneRoom jail = new SceneRoom("Jail", 2, jailRoles);
		
		ArrayList<Role> generalStoreRoles = new ArrayList<Role>();
		generalStoreRoles.add(new Role("Mister Keach", 3, false));
		generalStoreRoles.add(new Role("Main in Overalls", 1, false));
		SceneRoom generalStore = new SceneRoom("General Store", 2, generalStoreRoles);
		
		ArrayList<Role> trainStationRoles = new ArrayList<Role>();
		trainStationRoles.add(new Role("Dragged by Train", 1, false));
		trainStationRoles.add(new Role("Preacher with Bag", 2, false));
		trainStationRoles.add(new Role("Crusty Prospector", 1, false));
		trainStationRoles.add(new Role("Gyrus the Gunfighter", 4, false));
		SceneRoom trainStation = new SceneRoom("Train Station", 4, trainStationRoles);
		
		ArrayList<Role> hotelRoles = new ArrayList<Role>();
		hotelRoles.add(new Role("Sleeping Drunkard", 1, false));
		hotelRoles.add(new Role("Faro Player", 1, false));
		hotelRoles.add(new Role("Falls from Balcony", 2, false));
		hotelRoles.add(new Role("Australian Bartender", 3, false));
		SceneRoom hotel = new SceneRoom("Hotel", 4, hotelRoles);
		
		ArrayList<Role> churchRoles = new ArrayList<Role>();
		churchRoles.add(new Role("Dead Man", 1, false));
		churchRoles.add(new Role("Crying Woman", 2, false));
		SceneRoom church = new SceneRoom("Church", 2, churchRoles);
		
		ArrayList<Role> bankRoles = new ArrayList<Role>();
		bankRoles.add(new Role("Flustered Teller", 3, false));
		bankRoles.add(new Role("Suspicious Gentleman", 2, false));
		SceneRoom bank = new SceneRoom("Bank", 2, bankRoles);
		
		ArrayList<Role> ranchRoles = new ArrayList<Role>();
		ranchRoles.add(new Role("Shot in Leg", 1, false));
		ranchRoles.add(new Role("Saucy Fred", 2, false));
		ranchRoles.add(new Role("Man Under Horse", 3, false));
		SceneRoom ranch = new SceneRoom("Ranch", 3, ranchRoles);
		
		ArrayList<Role> hideoutRoles = new ArrayList<Role>();
		hideoutRoles.add(new Role("Clumsy Pit Fighter", 1, false));
		hideoutRoles.add(new Role("Thug with Knife", 2, false));
		hideoutRoles.add(new Role("Dangerous Tom", 3, false));
		hideoutRoles.add(new Role("Penny, who is Lost", 4, false));
		SceneRoom secretHideout = new SceneRoom("Hideout", 4, hideoutRoles);
		
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
	
	
	public void resetBoard() {
		
	}
	
	public void initializeCards() {
		
	}
	
	public void pickCards() {
		
		
	}
	
	public Map<String, Room> getRooms(){
		
		return rooms;
	}
	
	public ArrayList<Card> getCards(){
		
		return cards;
	}
	
	
	
	
	
	
	
	
	
}




