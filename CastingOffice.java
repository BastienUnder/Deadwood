import java.util.ArrayList;

public class CastingOffice extends Room{
    private String name;
    private ArrayList<String> adjacentRooms;
    private ArrayList<Upgrade> upgrades;

    public CastingOffice(ArrayList<String> adjacentRooms, ArrayList<Upgrade> upgrades) {
        this.adjacentRooms = adjacentRooms;
        this.upgrades = upgrades;
        name = "Casting Office";
    }


    //Getters and Setters
    public String getName() {
        return name;
    }


    public void setUpgrades(ArrayList<Upgrade> upgrades) {
        this.upgrades = upgrades;
    }

    public ArrayList<Upgrade> getUpgrades() {
        return upgrades;
    }



    //public ArrayList<String> getAdjacentRooms(){return adjacentRooms;}

}
