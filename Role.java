
public class Role { 
	
	private int rank;
	private String name;
	private boolean card; 
	private boolean taken; 
	
	public Role(String name, int rank, boolean card) {
		
		this.name = name;
		this.rank = rank;
		this.card = card;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() { 
		
		return name;
	}
	
	public void setTaken(boolean taken) {
		
		this.taken = taken; 
	}
	
	public boolean isTaken() {
		
		return taken;
	}
	
	public void setCard(boolean card) {
		
		this.card = card;
	}
	
	public boolean onCard() {
		
		return card;
	}
	
	public void setRank(int rank) {
		
		this.rank = rank;
	}
	
	public int getRank() {
		
		return rank;
	}
	
	public void setDiceRolls(int currentRoll) {
		
		
	}
	
	public void distributeBonusMoney() {
		
		
	}
}



