
public class Player {

	private String name;
	private Room room;
	private boolean turn;
	private boolean working;
	private boolean moved;

	private int rank;
	private int dollars;
	private int credits;
	
	private Role role;
	
	public Player(String name, Room room, int rank, int credits, int dollars) {

		this.name = name;
		this.room = room;
		this.rank = rank;
		this.dollars = dollars;
		this.credits = credits;
	}

	//Getters and Setters
	public void setPosition(Room room) {
		
		this.room = room;
	}
	
	public Room getRoom() {
		
		return room;
	}

	public void setTurn(boolean turn) {
		
		this.turn = turn;
	}

	public boolean getTurn() {
		
		return turn;
	}
	
	public void setWorking(boolean working) {
		
		this.working = working; 
	}
	
	public boolean isWorking() {
		
		return working;
	}
	
	public void setMoved(boolean moved) {
		
		this.moved = moved;
	}
	
	public boolean hasMoved() {
		
		return moved;
	}
	
	public void setCredits(int credits) {
		
		this.credits = credits;
	}
	
	public int getCredits() {
		
		return credits;
	}

	public int getDollars() {
		
		return dollars;
	}

	public void setDollars(int dollars) {
		
		this.dollars = dollars;
	}

	public void setRank(int rank) {
		
		this.rank = rank;
	}
	
	public int getRank() {
		
		return rank;
	}
	
	public void setRole(Role role) {
		
		this.role = role;
	}
	
	public Role getRole() {
		
		return role;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void freeRole() {
		
		role = null;
	}
	
	
}
