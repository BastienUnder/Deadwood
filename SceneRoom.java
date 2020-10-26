import java.util.*;
public class SceneRoom {

    private String name;
    private int budget;
    private ArrayList<Role> sceneRoles;
    private boolean beenUsed;

    public SceneRoom(String name, int budget, ArrayList<Role> sceneRoles) {
        this.name = name;
        this.budget = budget;
        this.sceneRoles = sceneRoles;
        beenUsed = false;
    }


    public void wrapScene(){

    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }



    public ArrayList<Role> getSceneRoles() {
        return sceneRoles;
    }
}















