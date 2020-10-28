import java.util.*;
public class Room{

	private String name;
	private ArrayList<Room> adjacentRooms;
	private ArrayList<String> adjacentRoomNames;

	public Room() {
		
		
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getAdjacentRoomNames() {
		return adjacentRoomNames;
	}

	public void setAdjacentRoomNames(ArrayList<String> adjacentRoomNames) {
		this.adjacentRoomNames = adjacentRoomNames;
	}

	public void setAdjacentRooms(ArrayList<Room> adjacentRooms) {
		
		this.adjacentRooms = adjacentRooms; 
	}
	
	public ArrayList<Room> getAdjacentRooms(){
		
		return adjacentRooms;
	}

	
	
	

}

