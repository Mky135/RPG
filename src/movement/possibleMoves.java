package movement;

public class possibleMoves
{
   static int[] emptySpaceY1 = {1,3,4,5,6,7,10,11,12,13,18,19,20,21,22,23,26,27,28,29,30};
   static int[] emptySpaceY2 = {};
   static int[] emptySpaceY3 = {};

    public static void possibleMoves(int Coordinate)
    {
        for(int i = 0; i < emptySpaceY1.length; i++)
        {
            if(Coordinate == emptySpaceY1[i])
            {
                System.out.println(1);
                System.out.print(TestMovement.count+": ");
                break;
            }
        }
    }
}
