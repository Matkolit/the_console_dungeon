package src.World;

import src.creatures.Monster;
import src.creatures.MonsterFactory;
import src.items.Item; 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

    private Room startRoom;
    private List<Room> allRooms = new ArrayList<>();
    private Random rand = new Random();
    private MonsterFactory monsterFactory = new MonsterFactory();

    public Map() {
        generateProcedural(12); 
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }

    private String randomRoomName() {
        String[] names = {
            "Ancient Hall", "Bone Crypt", "Forgotten Passage", "Shadow Nexus",
            "Dusty Tomb", "Hall of Echoes", "Sunken Archive", "Broken Forge",
            "Crystal Chamber", "Screaming Vault", "Twisted Corridor"
        };
        return names[rand.nextInt(names.length)];
    }

    private Room randomExistingRoom() {
        return allRooms.get(rand.nextInt(allRooms.size()));
    }

    private Room.Direction randomDirection() {
        Room.Direction[] dirs = Room.Direction.values();
        return dirs[rand.nextInt(dirs.length)];
    }

    private void generateProcedural(int count) {
        
        startRoom = new Room("Entrance");
        allRooms.add(startRoom);

        
        String[] lootItems = {
            "Mystic Blade",
            "Werewolf Helmet",
            "Soulmantle",
            "Spirithorn Armor",
            "Sanguine Legs",
            "Sanguine Galoshes",
            "Rift Shield",
            "Arcane Ring",
            "Ethereal Amulet",
            "Phantom Boots"
        };

        
        for (int i = 1; i < count; i++) {
            Room newRoom = new Room(randomRoomName());
            allRooms.add(newRoom);

            Room attachTo;
            Room.Direction dir;

            
            do {
                attachTo = randomExistingRoom();
                dir = randomDirection();
            } while (attachTo.getExit(dir) != null);
            attachTo.connect(newRoom, dir);

            
            if (rand.nextInt(100) < 30) {
                Monster m = monsterFactory.generate();
                newRoom.setMonster(m);
            }

            
            if (rand.nextInt(100) < 20) {
                String itemName = lootItems[rand.nextInt(lootItems.length)];
                Item loot = new Item(itemName);
                newRoom.setLoot(loot);
            }
        }

        
        Room bossRoom = allRooms.get(allRooms.size() - 1);
        Monster boss = monsterFactory.generate();
        bossRoom.setMonster(boss);

        
        String bossItemName = lootItems[rand.nextInt(lootItems.length)];
        bossRoom.setLoot(new Item(bossItemName));
    }
}
