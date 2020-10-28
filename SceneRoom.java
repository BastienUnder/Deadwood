import java.util.*;
public class SceneRoom extends Room{
	
	private Card card;
	private int shots;
	private String name; 
	private ArrayList<Role> roles; 
	
	public SceneRoom(String name, int shots, ArrayList<Role> roles) {
		
		this.name = name; 
		this.shots = shots;
		roles = new ArrayList<Role>(); 
	}
	
	public void dislayRoles() {
		
		
	}
	
	public Card getCard() {
		
		return card;
	}
	
	public String getName() {
		
		return name;
	}
	
	public int getShotTokens() {
		
		return shots;
	}
	
	public ArrayList<Role> getRoles(){
		
		return roles;
	}
	
	

}















