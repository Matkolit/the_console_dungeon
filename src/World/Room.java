public class Room {
    private String description;
    private boolean hasMonster;
    private boolean hasLoot;
    private Room north, south, east, west;

    public Room(String description) {
        this.description = description;
    }

}