package AdventureGame;

import java.util.HashMap;

public class Room
{
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private String item;
    private NPC npc;
    private String enemyName;
    // Room constructor to assign the name and description.
    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
    }
    // Getter function for the name of the Room
    public String getName()
    {
        return name;
    }
    // Getter function for the description of the room
    public String getDescription()
    {
        String exitStr = exits.keySet().toString();
        return description + "\nExits: " + exitStr;
    }
    // This method to check neighbor rooms of an existing room
    public void setExits(Room north, Room south, Room east, Room west)
    {
        if (north != null) exits.put("north", north);
        if (south != null) exits.put("south", south);
        if (east != null) exits.put("east", east);
        if (west != null) exits.put("west", west);
    }
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    // addItem method to add items  to the exists hashmap
    public void addItem(String item)
    {
        this.item = item;
    }
    // Check if NPC exists
    public boolean hasNPC()
    {
        return npc != null;
    }

    public NPC getNPC()
    {
        return npc;
    }

    public void addNPC(NPC npc)
    {
        this.npc = npc;
    }
    // Check if enemy exists
    public boolean hasEnemy()
    {
        return enemyName != null;
    }

    public String getEnemyName()
    {
        return enemyName;
    }
    // This method is to add enemies , includes the name of the enemy.
    public void addEnemy(String name, int hp)
    {
        this.enemyName = name;
    }
    // Can remove the enemy by making it null.
    public void removeEnemy()
    {
        enemyName = null;
    }
}

