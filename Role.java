import java.util.*;
public class Role {
	
	private int rank;
	private String name;
	private boolean card;
	private boolean occupied;
	
	public Role(String name, int rank, boolean card) {
		
		this.name = name;
		this.rank = rank;
		this.card = card;
		occupied = false;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void checkRole(int dice) {
		
		
	}
	
	public void setDiceRolls(int currentRoll) {
		
		
	}

	public boolean getOccupied(){
		return occupied;
	}
	
	
	

}
