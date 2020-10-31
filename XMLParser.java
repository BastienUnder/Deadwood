import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;


public class XMLParser {
    // building a document from the XML file
    // returns a Document object after loading an xml file.
    public Document getDocFromFile(String filename)
            throws ParserConfigurationException{
        {


            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = null;

            try{
                doc = db.parse(filename);
            } catch (Exception ex){
                System.out.println("XML parse failure");
                ex.printStackTrace();
            }
            return doc;
        } // exception handling

    }

    public ArrayList<Room> readBoardData(Document d){

        Element root = d.getDocumentElement();
        ArrayList<Room> rooms = new ArrayList<>();


        NodeList setRooms = root.getElementsByTagName("set");
        NodeList trailerRoom = root.getElementsByTagName("trailer");
        NodeList officeRoom = root.getElementsByTagName("office");

        for(int i=0; i<setRooms.getLength();i++){
            //Parameters to create new Room.java objects out of this data.
            String name;
            int numTakes = 0;
            ArrayList<String> neighbors = new ArrayList<>(); //Hashmap to actual Room objects
            ArrayList<Role> roles = new ArrayList<>();

            Node setRoom = setRooms.item(i);

            name = setRoom.getAttributes().getNamedItem("name").getNodeValue();
            //System.out.println("\n" + name);

            NodeList children = setRoom.getChildNodes();
            //Create all Set objects.
            for (int j=0; j< children.getLength(); j++) {

                Node sub = children.item(j);

                //System.out.println(sub.getNodeName());

                //Find list of neighboring Rooms.
                if("neighbors".equals(sub.getNodeName())){
                    NodeList neighborsNodes = sub.getChildNodes();

                    //Iterate through each neighboring Room to this room.
                    for(int k=0; k < neighborsNodes.getLength(); k++){
                        Node neighborsNode = neighborsNodes.item(k);

                        if("neighbor".equals(neighborsNode.getNodeName())){
                            neighbors.add(neighborsNode.getAttributes().getNamedItem("name").getNodeValue());
                            //System.out.println(neighborsNode.getAttributes().getNamedItem("name").getNodeValue());
                        }


                    }
                }

                //Find number of takes.
                else if("takes".equals(sub.getNodeName())){
                    NodeList takesNodes = sub.getChildNodes();

                    for(int k=0; k < takesNodes.getLength(); k++){
                        Node takesElement = takesNodes.item(k);

                        if("take".equals(takesElement.getNodeName())){
                            numTakes++;
                        }
                    }

                    //System.out.println("TAKES: " + numTakes);
                }

                //Create Roles list to add to Room.
                else if("parts".equals(sub.getNodeName())){
                    NodeList partsNodes = sub.getChildNodes();

                    for(int k=0; k < partsNodes.getLength(); k++){
                        Node partElement = partsNodes.item(k);

                        if("part".equals(partElement.getNodeName())){
                            String roleName = partElement.getAttributes().getNamedItem("name").getNodeValue();
                            int level = Integer.parseInt(partElement.getAttributes().getNamedItem("level").getNodeValue());

                            roles.add(new Role(roleName, level, false));

                        }
                    }
                }


            }

            //CREATE THE NEW SET OBJECT.
            Set newSet = new Set(name, numTakes, roles, neighbors);
            rooms.add(newSet);

        }//end loop creating all the Set objects

        //CREATE TRAILER
        ArrayList<String> neighbors = new ArrayList<>();
        Node trailerNode = trailerRoom.item(0);
        NodeList trailerChildren = trailerNode.getChildNodes();
        NodeList trailerNeighbors = trailerChildren.item(1).getChildNodes();
        String trailerName = "trailer";

        for(int i=0; i<trailerNeighbors.getLength();i++){
            Node tNeighbor = trailerNeighbors.item(i);

            if("neighbor".equals(tNeighbor.getNodeName())){
                neighbors.add(tNeighbor.getAttributes().getNamedItem("name").getNodeValue());
            }

        }
        Set newSet = new Set(trailerName, neighbors);
        rooms.add(newSet);

        //CREATE CASTING OFFICE
        ArrayList<String> officeNeighbors = new ArrayList<>();
        ArrayList<Upgrade> upgrades = new ArrayList<>();

        Node officeNode = officeRoom.item(0);
        NodeList officeChildren = officeNode.getChildNodes();

        for(int i=0; i<officeChildren.getLength();i++){
            Node officeSub = officeChildren.item(i);

            if("neighbors".equals(officeSub.getNodeName())){
                NodeList officeNeighborNodes = officeSub.getChildNodes();

                //Iterate through each neighboring Room to this room.
                for(int k=0; k < officeNeighborNodes.getLength(); k++){
                    Node neighborsNode = officeNeighborNodes.item(k);

                    if("neighbor".equals(neighborsNode.getNodeName())){
                        officeNeighbors.add(neighborsNode.getAttributes().getNamedItem("name").getNodeValue());
                    }


                }
            }

            if("upgrades".equals(officeSub.getNodeName())){
                NodeList officeUpgradeNodes = officeSub.getChildNodes();


                for(int k=0; k < officeUpgradeNodes.getLength(); k++){
                    Node upgradeNode = officeUpgradeNodes.item(k);

                    if("upgrade".equals(upgradeNode.getNodeName())){
                        int level = Integer.parseInt(upgradeNode.getAttributes().getNamedItem("level").getNodeValue());
                        String currency = upgradeNode.getAttributes().getNamedItem("currency").getNodeValue();
                        int amount = Integer.parseInt(upgradeNode.getAttributes().getNamedItem("amt").getNodeValue());
                        upgrades.add(new Upgrade(level, currency, amount));
                    }
                }
            }
        }

        CastingOffice office = new CastingOffice(officeNeighbors, upgrades);
        rooms.add(office);

        return rooms;

    }// end readBoardData()



    public ArrayList<Scene> readCardsData(Document d){
        Element root = d.getDocumentElement();
        ArrayList<Scene> scenes = new ArrayList<>();



        NodeList sceneNodes = root.getElementsByTagName("card");

        //Iterate through each scene card and create each Scene.java object.
        for(int i=0; i<sceneNodes.getLength();i++) {
            //Parameters to create new Scene.java objects out of this data.
            Node sceneNode = sceneNodes.item(i);
            String name = sceneNode.getAttributes().getNamedItem("name").getNodeValue();
            int budget = Integer.parseInt(sceneNode.getAttributes().getNamedItem("budget").getNodeValue());
            ArrayList<Role> sceneRoles = new ArrayList<>();

            NodeList children = sceneNode.getChildNodes();

            //Iterate through SCENE and PART data.
            for (int j=0; j< children.getLength(); j++) {

                Node sub = children.item(j);

                //Create each Role.java object on this scene card.
                if ("part".equals(sub.getNodeName())) {
                    String roleName = sub.getAttributes().getNamedItem("name").getNodeValue();
                    int level = Integer.parseInt(sub.getAttributes().getNamedItem("level").getNodeValue());

                    sceneRoles.add(new Role(roleName, level, true));
                    //System.out.println(roleName + " " + level);
                }

                //Get the Scene description and (and could get Scene number if needed).
                //else if ("scene".equals(sub.getNodeName())) {//FOR Text based iteration of Deadwood we don't need the description or scene number.}
            }

            //System.out.println(name + " " + budget);

            //Create each new Scene.java object and add it to the scenes list.
            scenes.add(new Scene(name, budget, sceneRoles));

        }

        return scenes;

    }// end readCardsData()

}
