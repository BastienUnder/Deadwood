import java.util.ArrayList;

public class Set extends Room{
    private String name;
    private ArrayList<Role> roles;
    private ArrayList<String> adjacentRooms;
    private Scene sceneCard;
    private int shotCount;

    public Set(ArrayList<String> adjacentRooms){
        this.adjacentRooms = adjacentRooms;
    }

    //GOING to need to add hash functionality to adjacentRooms to get the
    //actual object from the String list.

    public Set(String name, int shotCount, ArrayList<Role> roles, ArrayList<String> adjacentRooms) {
        this.name = name;
        this.shotCount = shotCount;
        this.roles = roles;
        this.adjacentRooms = adjacentRooms;
    }

    //Getters and Setters
    public String getName() {

        return name;
    }

    //public ArrayList<Room> getAdjacentRooms(){ return adjacentRooms; }

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
}
