package movement;

import battles.GoblinBattle;
import stats.CharacterStats;

public class possibleMoves
{
    static GoblinBattle goblinBattle;

    static int[] emptySpaceY1 = {1,3,4,5,6,7,10,11,12,13,18,19,20,21,22,23,26,27,28,29,30};
   static int[] emptySpaceY2 = {1,3,4,5,6,7,13,14,15,16,20,21,26,26,27,28,29,30};
   static int[] emptySpaceY3 = {1,5,6,7,10,14,15,16,17,20,23,24,25,28,29,30};
   static int[] emptySpaceY4 = {1,2,7,10,11,12,16,17,18,24,25,26,29,30};
   static int[] emptySpaceY5 = {1,2,3,7,8,10,11,12,13,16,17,18,19,23,24,25,26,27,30};
   static int[] emptySpaceY6 = {};
   static int[] emptySpaceY7 = {};
   static int[] emptySpaceY8 = {};
   static int[] emptySpaceY9 = {};
   static int[] emptySpaceY10 = {};
   static int[] emptySpaceY11 = {};
   static int[] emptySpaceY12 = {};
   static int[] emptySpaceY13 = {};
   static int[] emptySpaceY14 = {};
   static int[] emptySpaceY15 = {};
   static int[] emptySpaceY16 = {};
   static int[] emptySpaceY17 = {};
   static int[] emptySpaceY18 = {};
   static int[] emptySpaceY19 = {};
   static int[] emptySpaceY20 = {};

   public static boolean canPass = false;

   public static boolean reachedGoal()
   {
       if(CharacterStats.Character.Coordinate == 297)
       {
           return true;
       }
       else
       {
           return false;
       }
   }

    public static void possibleMoves(int Coordinate) throws InterruptedException
    {
        if(Coordinate == 94 || Coordinate == 93 || Coordinate == 64)
        {
            goblinBattle.goblinBattle();
        }
        if(Coordinate <= 30)
        {
            for(int i = 0; i < emptySpaceY1.length; i++)
            {
                if(Coordinate == emptySpaceY1[ i ])
                {
                    System.out.print(TestMovement.count + ": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
            }
        }
        else if(Coordinate <=60 && Coordinate >30)
        {
            for(int i = 0; i < emptySpaceY2.length; i++)
            {
                if(Coordinate == emptySpaceY2[i]+30)
                {
                    System.out.print(TestMovement.count +": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
            }
        }
        else if(Coordinate <=90 && Coordinate > 60)
        {
            for(int i = 0; i < emptySpaceY3.length; i++)
            {
                if(Coordinate == emptySpaceY3[i]+60)
                {
                    System.out.print(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
            }
        }
        else if(Coordinate <=120 && Coordinate > 90)
        {
            for(int i = 0; i < emptySpaceY4.length; i++)
            {
                if(Coordinate == emptySpaceY4[i]+90)
                {
                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass \n");
                    canPass = false;
                    break;
                }
            }
        }
        else if(Coordinate <=150 && Coordinate > 120)
        {
            for(int i = 0; i < emptySpaceY5.length; i++)
            {
                if(Coordinate == emptySpaceY5[i]+120)
                {
                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
            }
        }
        else
        {
            System.out.println("You may pass ");
            canPass = true;
        }
    }
}
