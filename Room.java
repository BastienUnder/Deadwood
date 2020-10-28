import java.util.*;
public abstract class Room{

	private String name;
	private ArrayList<Room> adjacentRooms;

	public Room() {
		
		
	}

	public String getName() {
		
		return name;
	}
	
	public void setAdjacentRooms(ArrayList<Room> adjacentRooms) {
		
		this.adjacentRooms = adjacentRooms; 
	}
	
	public ArrayList<Room> getAdjacentRooms(){
		
		return adjacentRooms;
	}

	
	
	

}

