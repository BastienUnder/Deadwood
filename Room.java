import java.util.*;
public class Room{
	
	private int shots;
	private String name;
	private ArrayList<Role> roles;
	private ArrayList<Room> adjacentRooms;
	
	public Room() {
		
		
	}
	
	public Room(String name, int shots, ArrayList<Role> roles) {
		
		this.name = name; 
		this.shots = shots; 
		roles = new ArrayList<Role>(); 
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













