package movement;

import battles.GoblinBattle;
import stats.CharacterStats;

import java.util.zip.CRC32;

public class possibleMoves
{
    static GoblinBattle goblinBattle;

    static int[] emptySpaceY1 = {1,3,4,5,6,7,10,11,12,13,18,19,20,21,22,23,26,27,28,29,30};
   static int[] emptySpaceY2 = {1,3,4,5,6,7,13,14,15,16,20,21,26,27,28,29,30};
   static int[] emptySpaceY3 = {1,5,6,7,10,14,15,16,17,20,23,24,25,28,29,30};
   static int[] emptySpaceY4 = {1,2,7,10,11,12,16,17,18,24,25,26,29,30};
   static int[] emptySpaceY5 = {1,2,3,7,8,10,11,12,13,16,17,18,19,23,24,25,26,27,30};
   static int[] emptySpaceY6 = {1,2,3,4,11,12,13,16,17,18,19,20,21,23,28,30};
   static int[] emptySpaceY7 = {1,2,3,4,11,12,13,14,16,17,19,20,21,23,28,30};
   static int[] emptySpaceY8 = {1,2,3,4,5,7,8,9,10,11,12,13,17,19,20,21,23,25,28,30};
   static int[] emptySpaceY9 = {7,8,9,10,11,12,15,16,18,19,20,23,25,27,28,30};
   static int[] emptySpaceY10 = {2,3,6,14,16,22,23,25,28,30};
   static int[] emptySpaceY11 = {1,2,4,5,8,9,13,17,22,23,26,27,28,30};
   static int[] emptySpaceY12 = {4,5,8,9,10,12,18,19,23,24,26,27,28,30};
   static int[] emptySpaceY13 = {4,5,12,20,24,26,27,28,30};
   static int[] emptySpaceY14 = {1,2,4,5,10,11,21,24,28,30};
   static int[] emptySpaceY15 = {10,21,23,24,25,26,28,20};
   static int[] emptySpaceY16 = {2,3,4,5,10,20,23,24,28,30};
   static int[] emptySpaceY17 = {2,5,11,12,1,22,23,24,26,27,28,30};
   static int[] emptySpaceY18 = {4,5,6,7,8,9,13,14,17,18,22,23,24,30};
   static int[] emptySpaceY19 = {9,10,11,13,14,17,18,22,23,24,25,26,27,28,29,30};
   static int[] emptySpaceY20 = {4,10,11,15,21,22,23,24,25,26,27,28,29,30};

   public static boolean canPass = true;

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

    /**
     * @param y == row
     * @param x == columns
     * @return
     */
   public static int coordinates(int y, int x)
   {
       if(y == 1)
       {
           return x;
       }
       else
       {
           return (((y*30)+x)-30);
       }
   }
    public static void possibleMoves(int Coordinate) throws InterruptedException
    {
//        if(Coordinate == coordinates(4,3) || Coordinate == coordinates(4,4)|| Coordinate == coordinates(3,4) || Coordinate == coordinates(7,5) || Coordinate == coordinates(6,8) || Coordinate == coordinates(2,8))
//        {
//            goblinBattle.goblinBattle();
//        }
        if(Coordinate <= 30 && Coordinate >=1)
        {
            for(int i = 0; i < emptySpaceY1.length; i++)
            {
                if(Coordinate == emptySpaceY1[ i ])
                {
//                    System.out.print(TestMovement.count + ": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass");
            }

        }
        else if(Coordinate <=60 && Coordinate >30)
        {
            for(int i = 0; i < emptySpaceY2.length; i++)
            {
                if(Coordinate == emptySpaceY2[i]+30)
                {
//                    System.out.print(TestMovement.count +": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass");
            }
        }
        else if(Coordinate <=90 && Coordinate > 60)
        {
            for(int i = 0; i < emptySpaceY3.length; i++)
            {
                if(Coordinate == emptySpaceY3[i]+60)
                {
//                    System.out.print(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass");
            }
        }
        else if(Coordinate <=120 && Coordinate > 90)
        {
            for(int i = 0; i < emptySpaceY4.length; i++)
            {
                if(Coordinate == emptySpaceY4[i]+90)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass \n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=150 && Coordinate > 120)
        {
            for(int i = 0; i < emptySpaceY5.length; i++)
            {
                if(Coordinate == emptySpaceY5[i]+120)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=180 && Coordinate > 150)
        {
            for(int i = 0; i < emptySpaceY6.length; i++)
            {
                if(Coordinate == emptySpaceY6[i]+150)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=210 && Coordinate > 180)
        {
            for(int i = 0; i < emptySpaceY7.length; i++)
            {
                if(Coordinate == emptySpaceY7[i]+180)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <= 240 && Coordinate > 210)
        {
            for(int i = 0; i < emptySpaceY8.length; i++)
            {
                if(Coordinate == emptySpaceY8[i]+210)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    System.out.println("You may pass ");
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=270 && Coordinate > 240)
        {
            for(int i = 0; i < emptySpaceY9.length; i++)
            {
                if(Coordinate == emptySpaceY7[i]+240)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=300 && Coordinate > 270)
        {
            for(int i = 0; i < emptySpaceY10.length; i++)
            {
                if(Coordinate == emptySpaceY10[i]+270)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=330 && Coordinate > 300)
        {
            for(int i = 0; i < emptySpaceY11.length; i++)
            {
                if(Coordinate == emptySpaceY11[i]+300)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=360 && Coordinate > 330)
        {
            for(int i = 0; i < emptySpaceY12.length; i++)
            {
                if(Coordinate == emptySpaceY12[i]+330)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=390 && Coordinate > 360)
        {
            for(int i = 0; i < emptySpaceY13.length; i++)
            {
                if(Coordinate == emptySpaceY13[i]+360)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=420 && Coordinate > 390)
        {
            for(int i = 0; i < emptySpaceY14.length; i++)
            {
                if(Coordinate == emptySpaceY14[i]+390)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=450 && Coordinate > 420)
        {
            for(int i = 0; i < emptySpaceY15.length; i++)
            {
                if(Coordinate == emptySpaceY15[i]+420)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=480 && Coordinate > 450)
        {
            for(int i = 0; i < emptySpaceY16.length; i++)
            {
                if(Coordinate == emptySpaceY16[i]+450)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=510 && Coordinate > 480)
        {
            for(int i = 0; i < emptySpaceY17.length; i++)
            {
                if(Coordinate == emptySpaceY17[i]+480)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=540 && Coordinate > 510)
        {
            for(int i = 0; i < emptySpaceY18.length; i++)
            {
                if(Coordinate == emptySpaceY18[i]+510)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=570 && Coordinate > 540)
        {
            for(int i = 0; i < emptySpaceY19.length; i++)
            {
                if(Coordinate == emptySpaceY19[i]+540)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else if(Coordinate <=600 && Coordinate > 570)
        {
            for(int i = 0; i < emptySpaceY20.length; i++)
            {
                if(Coordinate == emptySpaceY20[i]+570)
                {
//                    System.out.println(TestMovement.count+": ");
                    System.out.print("Can't pass\n");
                    canPass = false;
                    break;
                }
                else
                {
                    canPass = true;
                }
            }
            if(canPass && CharacterStats.Character.cHP > 0)
            {
                System.out.println("You may pass ");
            }
        }
        else
        {
            System.out.println("You may not pass ");
            canPass = false;
        }
    }
}
