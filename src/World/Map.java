public class Map {
    private Room startRoom;

    public Map() {
        generate();
    }

    private void generate() {
        Room r1 = new Room("Cmentarz");
        Room r2 = new Room("Podziemny tunel");
        Room r3 = new Room("Zniszczona biblioteka");
        Room r4 = new Room("Sarkofag");
        Room r5 = new Room("Katakumby");
        Room r6 = new Room("Tajemne sanktuarium");

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
    }