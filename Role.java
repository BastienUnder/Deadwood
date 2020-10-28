import java.util.*;
public class Role {

	private String name;
	private int roleRank;
	private boolean onCard;
	private boolean occupied;
	
	public Role(String name, int rank, boolean onCard) {
		this.name = name;
		this.roleRank = rank;
		this.onCard = onCard;
		occupied = false;
	}
	
	public String getName() {
		return name;
	}

	public int getRoleRank() {
		return roleRank;
	}

	public boolean isOnCard() {
		return onCard;
	}

	public boolean isOccupied() {
		return occupied;
	}

	//public void checkRole(int dice) { }
	
	//public void setDiceRolls(int currentRoll) { }


}
