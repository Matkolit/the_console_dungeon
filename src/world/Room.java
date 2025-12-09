package src.World;

import java.util.EnumMap;
import src.Items.Item;
import src.Creatures.Monster;

public class Room {

    public enum Direction { NORTH, SOUTH, EAST, WEST }

    private String description;
    private boolean visited;

    private Monster monster;   
    private Item loot;         

    private EnumMap<Direction, Room> exits = new EnumMap<>(Direction.class);

    public Room(String description) {
        this.description = description;
    }

    // Connect two rooms bidirectionally
    public void connect(Room other, Direction dir) {
        exits.put(dir, other);

        switch (dir) {
            case NORTH -> other.exits.put(Direction.SOUTH, this);
            case SOUTH -> other.exits.put(Direction.NORTH, this);
            case EAST  -> other.exits.put(Direction.WEST, this);
            case WEST  -> other.exits.put(Direction.EAST, this);
        }
    }

    public Room getExit(Direction dir) {
        return exits.get(dir);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean v) {
        visited = v;
    }

    // Monster handling
    public boolean hasMonster() {
        return monster != null;
    }

    public void setMonster(Monster m) {
        this.monster = m;
    }

    public Monster getMonster() {
        return monster;
    }

    // Loot handling
    public boolean hasLoot() {
        return loot != null;
    }

    public void setLoot(Item loot) {
        this.loot = loot;
    }

    public Item getLoot() {
        return loot;
    }

    public String getDescription() {
        return description;
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== ").append(description).append(" ===\n");

        if (hasMonster()) sb.append("A MONSTER is here!\n");
        if (hasLoot()) sb.append("You notice something shiny...\n");

        sb.append("Exits: ");
        for (Direction d : exits.keySet()) {
            sb.append(d.toString().charAt(0)).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }
}