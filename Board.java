import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.Array;
import java.util.*;

public class Board extends Room{

	private static Map<String, Room> rooms = new HashMap<String, Room>();
	//private static ArrayList<Scene> allScenes = new ArrayList<Scene>();

	private static XMLParser parser = new XMLParser();
	private static ArrayList<Room> roomsList;
	private static ArrayList<Scene> scenesList;


	public Board() {
		setRooms();
		setScenes();
	}

	//AFTER ALL ROOMS ARE CREATED, THEN FILL ROOM'S ADJACENT ROOMS LIST WITH THE ACTUAL OBJECTS
	//AND NOT JUST THE STRINGS

	public void setRooms()  {
		try {
			//Read data from xml file and build all Room objects.
			roomsList = parser.readBoardData(parser.getDocFromFile("board.xml"));

			//Setup the hashMap to get from name of room to the room object.
			for(int i=0; i<roomsList.size(); i++){
				rooms.put(roomsList.get(i).getName(), roomsList.get(i));
			}

			//Provide each room with a list of adjacent rooms as Room objects(not just room names).
			for(int i=0; i< roomsList.size(); i++){
				Room tempRoom = roomsList.get(i);
				ArrayList<Room> adjacentRooms = new ArrayList<>();

				System.out.println("Room name:                                     " + tempRoom.getName());

				for(int j=0; j< tempRoom.getAdjacentRoomNames().size(); j++){
					String tempRoomName = tempRoom.getAdjacentRoomNames().get(j);
					adjacentRooms.add(rooms.get(tempRoomName));

				}
				tempRoom.setAdjacentRooms(adjacentRooms);
			}

			//Room tempRoom = rooms.get("Trailer");
			//System.out.println(tempRoom.getName());

			/*
			//TEST if HASH MAP FULL
			for(int i=0; i<roomsList.size(); i++){
				Room tempRoom = rooms.get(roomsList.get(i).getName());

				System.out.println("Room name: " + tempRoom.getName());

				if(tempRoom instanceof Set){
					System.out.println("Set shot count: " + ((Set) tempRoom).getShotCount());
				}
			}
			 */


		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	public void setScenes() {
		try {
			scenesList = parser.readCardsData(parser.getDocFromFile("cards.xml"));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	public void resetBoard(){

	}

	public void resetScenes(){

	}
	

	public Map<String, Room> getRooms(){
		return rooms;
	}
	
	
	
	
	
	
	
}




