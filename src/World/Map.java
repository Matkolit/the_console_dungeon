package src.World

public class Map {
    private Room startRoom;

 
    private void generate() {
        Room r1 = new Room("Cemetery");
        Room r2 = new Room("Darkness Tunnel");
        Room r3 = new Room("Ruined Library");
        Room r4 = new Room("Sarcophagus");
        Room r5 = new Room("Catacombs");
        Room r6 = new Room("Secret Sanctuary");

        r1.setEast(r2);
        r2.setEast(r3);
        r2.setWest(r1);
        r3.setWest(r2);
        r4.setEast(r6);
        r4.setWest(r6);
        r5.setWest(r4);
        startRoom = r1;
    }

    public Room getStartRoom() {
        return startRoom;

    }   public Map() {
        generate();
    }
}
