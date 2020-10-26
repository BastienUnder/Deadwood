import java.util.*;
public class Room{
	
	private int shots;
	private String name;
	private ArrayList<Role> roles;
	private ArrayList<Room> adjacentRooms;
	private SceneRoom sceneCard;
	
	public Room() {
		
		
	}
	
	public Room(String name, int shots, ArrayList<Role> roles) {
		
		this.name = name; 
		this.shots = shots;
		this.roles = roles;
		//roles = new ArrayList<Role>();
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

	public ArrayList<Role> getRoles(){
		return roles;
	}
	
	
	

}

