import java.util.*;
public class Room{
	
	private int shots; 
	private String name; 
	private ArrayList<Room> adjacentRooms; 
	
	public Room() { 
		
	}
	
	public Room(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return name;
	}
	
	public int getShotTokens() {
		
		return shots;
	}
	
	public void setAdjacentRooms(ArrayList<Room> adjacentRooms) {
		
		this.adjacentRooms = adjacentRooms; 
	}
	
	public ArrayList<Room> getAdjacentRooms(){
		
		return adjacentRooms;
	}
	
	
	

}













