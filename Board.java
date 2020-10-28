import javax.xml.parsers.ParserConfigurationException;
import java.util.*;

public class Board extends Room{

	private static Map<String, Room> rooms = new HashMap<String, Room>();
	private static ArrayList<Scene> allScenes = new ArrayList<Scene>();
	private static XMLParser parser = new XMLParser();
	private static ArrayList<Room> roomsList;


	public Board() {
		setRooms();
		setScenes();
	}

	//AFTER ALL ROOMS ARE CREATED, THEN FILL ROOM'S ADJACENT ROOMS LIST WITH THE ACTUAL OBJECTS
	//AND NOT JUST THE STRINGS

	public void setRooms()  {
		try {
			roomsList = parser.readBoardData(parser.getDocFromFile("board.xml"));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	public void setScenes() {
		try {
			parser.readCardsData(parser.getDocFromFile("cards.xml"));
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




