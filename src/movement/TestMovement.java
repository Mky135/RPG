package movement;


import stats.CharacterStats;

public class TestMovement
{
    static possibleMoves pm;
    public static int count = 0;
    public static void main(String[]args)
    {

        for(int x = 0; x < 10; x++)
        {
            count ++;
            moveRight();

        }
    }
    public static void moveRight()
    {
        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate + 1;
        pm.possibleMoves(CharacterStats.Character.Coordinate);
    }
}

