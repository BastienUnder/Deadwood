import java.util.ArrayList;

public class Set extends Room{
	
    private ArrayList<Role> roles;
    private Scene sceneCard;
    private int shotCount;

    public Set(String name, ArrayList<String> adjacentRoomNames){
    	
        setName(name);
        setAdjacentRoomNames(adjacentRoomNames);
    }

    public Set(String name, int shotCount, ArrayList<Role> roles, ArrayList<String> adjacentRoomNames) {
    	
        setName(name);
        setAdjacentRoomNames(adjacentRoomNames);
        this.shotCount = shotCount;
        this.roles = roles;
    }

    //Getters and Setters
    public ArrayList<Role> getRoles(){
    	
        return roles;
    }

    public Scene getSceneCard() {
    	
        return sceneCard;
    }

    public void setSceneCard(Scene sceneCard) {
    	
        this.sceneCard = sceneCard;
    }

    public int getShotCount() {
    	
        return shotCount;
    }

    public void setShotCount(int shotCount) {
    	
        this.shotCount = shotCount;
    }
    
    public boolean checkCard(Player player) {
    	
    	Set set = (Set) player.getRoom();
    	Scene sceneCard = set.getSceneCard();
    	
    	for(int i = 0; i < sceneCard.getSceneRoles().size(); i++) { 
    		
    		if(sceneCard.getSceneRoles().get(i).isOccupied()) {
    			
    			return true;
    		}
    	}
    	
    	return false;
    	
    	//check if all roles are occupied for the given player card
    	//player get room get scene card 
    	
    	
    	
    	//player.getRole().isOnCard()
    	
    	
    	
    	
    	
    }
    
    
    
    
    
}
