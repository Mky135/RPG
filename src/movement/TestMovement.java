package movement;
import stats.CharacterStats;

public class TestMovement
{
    static possibleMoves pm;
    public static int count = 0;
    public static void main(String[]args) throws InterruptedException
    {
        count++;
        moveForward();
        count++;
        moveBackwards();
        count++;
        moveRight();
        count++;
        moveLeft();
        count++;
        moveRight();
        count++;
        moveRight();
        System.out.println(CharacterStats.Character.Coordinate);
    }
    public static void moveRight() throws InterruptedException
    {

        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate + 1;
        System.out.println("Right: " + CharacterStats.Character.Coordinate + "");
        pm.possibleMoves(CharacterStats.Character.Coordinate);

    }
    public static void moveForward() throws InterruptedException
    {
        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate + 30;
        System.out.println("Forward: " + CharacterStats.Character.Coordinate + " ");
        pm.possibleMoves(CharacterStats.Character.Coordinate);
    }
    public static void moveBackwards() throws InterruptedException
    {
        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate - 30;
        System.out.println("Backwards: " + CharacterStats.Character.Coordinate + " ");
        pm.possibleMoves(CharacterStats.Character.Coordinate);
    }
    public static void moveLeft() throws InterruptedException
    {
        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate - 1;
        System.out.println("Left: " + CharacterStats.Character.Coordinate + " ");
        pm.possibleMoves(CharacterStats.Character.Coordinate);
    }
}