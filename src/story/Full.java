package story;

import movement.playerMovement;

public class Full
{
    static intro intro;
    static playerMovement playerMovement;
    public static void main(String[] args) throws InterruptedException
    {
        intro.intro();
        playerMovement.move();
    }
}
