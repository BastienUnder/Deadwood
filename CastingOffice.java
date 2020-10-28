import java.util.ArrayList;

public class CastingOffice extends Room{
    private ArrayList<Upgrade> upgrades;

    public CastingOffice(ArrayList<String> adjacentRoomNames, ArrayList<Upgrade> upgrades) {
        setName("Casting Office");
        setAdjacentRoomNames(adjacentRoomNames);
        this.upgrades = upgrades;

    }


    //Getters and Setters
    public void setUpgrades(ArrayList<Upgrade> upgrades) {
        this.upgrades = upgrades;
    }

    public ArrayList<Upgrade> getUpgrades() {
        return upgrades;
    }

}
