package AdventureGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Player
{
    private ArrayList<String> inventory;
    private Room currentRoom;
    private int health;
    // Health or points of a player - initially set to 100 , decreases if takes wrong moves
    public Player()
    {
        inventory = new ArrayList<>();
        health = 100;
    }
    // setter method to set the current room
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    // getter method that returns the current rom
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    // This wil return current health of the player
    public int getHealth()
    {
        return health;
    }
    // This method checks if the player can move to particular direction or not
    // If good move then navigate to that room , else invald room print statement.
    public void move(String direction, HashMap<String, Room> rooms)
    {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null)
        {
            setCurrentRoom(nextRoom);
            System.out.println("You move " + direction + " to the " + nextRoom.getName());
        }
        else
        {
            System.out.println("You can't go that way!");
        }
    }
    // Displays the inventory
    public void showInventory()
    {
        System.out.println("Inventory: " + inventory);
    }
    // Talk to the NPC , this enables to print the name of the speaker and the hint they are giving
    public void talk()
    {
        if (currentRoom.hasNPC())
        {
            System.out.println(currentRoom.getNPC().getHint());
        }
        else
        {
            System.out.println("There's no one here to talk to.");
        }
    }
    // Can attack the enemies
    // If hit by enemy decrease in health
    public void attack()
    {
        if (currentRoom.hasEnemy())
        {
            System.out.println("You engage in combat with " + currentRoom.getEnemyName());
            health -= 10;
            System.out.println("You took 10 damage! Health: " + health);
            if (health > 0)
            {
                System.out.println("You defeated the enemy!");
                currentRoom.removeEnemy();
            }
        }
        else
        {
            System.out.println("There's no one to attack here.");
        }
    }

    public void usePotion()
    {
        if (inventory.contains("potion"))
        {
            health += 20;
            System.out.println("You used a potion! Health: " + health);
            inventory.remove("potion");
        }
        else
        {
            System.out.println("You don't have any potions!");
        }
    }

    public void collectItem(String item)
    {
        inventory.add(item);
        System.out.println("Collected: " + item);
    }
}

