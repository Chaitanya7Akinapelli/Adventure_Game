package AdventureGame;

import java.util.HashMap;
import java.util.Scanner;

public class Game
{
    private HashMap<String, Room> rooms;
    private Player player;
    private boolean gameOver;
    // Constructor to create a new player and call the rooms for the player created
    public Game()
    {
        player = new Player();
        gameOver = false;
        createRooms();
    }
    // Create different rooms with name and description
    // Also check if rooms exist for a room in north , south , east and west using setExists method
    private void createRooms()
    {
        rooms = new HashMap<>();

        Room entrance = new Room("Entrance", "You are at the entrance of a mysterious world.");
        Room forest = new Room("Forest", "You are in a dense forest. Birds are chirping.");
        Room dungeon = new Room("Dungeon", "It’s dark and damp, with an eerie feeling.");
        Room treasureRoom = new Room("Treasure Room", "The final room! You see a treasure chest gleaming.");

        entrance.setExits(null, forest, null, null);
        forest.setExits(entrance, dungeon, null, null);
        dungeon.setExits(forest, treasureRoom, null, null);
        treasureRoom.setExits(dungeon, null, null, null);

        rooms.put("Entrance", entrance);
        rooms.put("Forest", forest);
        rooms.put("Dungeon", dungeon);
        rooms.put("Treasure Room", treasureRoom);

        entrance.addItem("key");
        forest.addItem("potion");
        dungeon.addNPC(new NPC("Old Man", "Beware of the dangers ahead!"));
        dungeon.addEnemy("Goblin", 20);

        player.setCurrentRoom(entrance);
    }
    // After creation of rooms and player , this play method enables user to play the adventure game.
    public void play()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Adventure Game!");
        while (!gameOver)
        {
            System.out.println(player.getCurrentRoom().getDescription());
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();
            processCommand(command);
        }
        scanner.close();
    }
    // Different commands in the play and checking conditions like the player can win or lose.
    private void processCommand(String command)
    {
        if (command.startsWith("go"))
        {
            player.move(command.substring(3), rooms);
        }
        else if (command.equals("check inventory"))
        {
            player.showInventory();
        }
        else if (command.equals("talk"))
        {
            player.talk();
        }
        else if (command.equals("attack"))
        {
            player.attack();
            if (player.getHealth() <= 0)
            {
                System.out.println("Game Over! You have been defeated.");
                gameOver = true;
            }
        }
        else if (command.equals("use potion"))
        {
            player.usePotion();
        }
        else if (player.getCurrentRoom().getName().equals("Treasure Room") && command.equals("collect treasure"))
        {
            System.out.println("You Win! You've collected the treasure!");
            gameOver = true;
        }
        else
        {
            System.out.println("Invalid command. Try again.");
        }
    }
    // main method to start the game
    public static void main(String[] args)
    {
        new Game().play();
    }
}

