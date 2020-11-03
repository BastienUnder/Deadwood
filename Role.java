
public class Role {

	private String name;
	private int roleRank;
	private boolean onCard;
	private boolean occupied;
	private Player player;
	
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
	
	public void takeRole(boolean occupied) {
		
		this.occupied = occupied;
	}
	
	public void setPlayer(Player player) {
		
		this.player = player;
	}
	
	public Player getPlayer() {
		
		return player;
	}
}
