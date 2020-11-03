import java.util.*;
public class Scene {

    private String name;
    private int budget;
    private ArrayList<Role> sceneRoles;
    private boolean hasBeenUsed;

    public Scene(String name, int budget, ArrayList<Role> sceneRoles) {
        this.name = name;
        this.budget = budget;
        this.sceneRoles = sceneRoles;
    }

    public void wrapScene(){

    }

    public String getName() {
    	
        return name;
    }

    public int getBudget() {
    	
        return budget;
    }

    public void setUsed(boolean used) {
    	
    	this.hasBeenUsed = used;
    }

    public boolean isUsed() {
    	
    	return hasBeenUsed;
    }

    public ArrayList<Role> getSceneRoles() {
    	
        return sceneRoles;
    }
}















