package AdventureGame;

public class NPC
{
    private String name;
    private String hint;
    // Constructor to get name and hint of NPC
    public NPC(String name, String hint)
    {
        this.name = name;
        this.hint = hint;
    }
    // this method displays the hint for the room we are in.
    public String getHint()
    {
        return name + " says: " + hint;
    }
}

