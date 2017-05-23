package movement;

import functions.Functions;
import stats.CharacterStats;

import java.util.InputMismatchException;
import java.util.Scanner;

public class playerMovement
{
    static NullPointerException e;
    public static final String Forwards = "FORWARDS";
    public static final String f = "F";
    public static final String Backwards = "BACKWARDS";
    public static final String b = "B";
    public static final String Right = "RIGHT";
    public static final String r = "R";
    public static final String Left = "LEFT";
    public static final String l = "L";
    static Functions functions;

    static possibleMoves pm;
    public static void main(String[] args) throws InterruptedException
    {
        move();
    }
    public static void move() throws InterruptedException
    {
        while(!pm.reachedGoal() && CharacterStats.Character.cHP >0)
        {
            tryToMove();
        }
    }
    public static void tryToMove() throws InterruptedException
    {
        while(true)
        {
            if(CharacterStats.Character.cHP > 0)
            {
                try
                {
                    System.out.println("Enter directions (Left, Right, Forward, Backwards, inventory): ");
                    Scanner keyboard = new Scanner(System.in);
                    String input = keyboard.nextLine();
                    if(input.toUpperCase().hashCode() == Forwards.hashCode() || input.toUpperCase().hashCode() == f.hashCode())
                    {
                        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate + 30;
                        pm.possibleMoves(CharacterStats.Character.Coordinate);
                        System.out.println(CharacterStats.Character.Coordinate);
                        if(!pm.canPass)
                        {
                            CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate - 30;
                            System.out.print(CharacterStats.Character.Coordinate);
                        }
                        break;
                    } else if(input.toUpperCase().hashCode() == Backwards.hashCode() || input.toUpperCase().hashCode() == b.hashCode())
                    {
                        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate - 30;
                        pm.possibleMoves(CharacterStats.Character.Coordinate);
                        System.out.println(CharacterStats.Character.Coordinate);
                        if(!pm.canPass)
                        {
                            CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate + 30;
                            System.out.print(CharacterStats.Character.Coordinate);
                        }
                        break;
                    } else if(input.toUpperCase().hashCode() == Left.hashCode() || input.toUpperCase().hashCode() == l.hashCode())
                    {
                        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate - 1;
                        pm.possibleMoves(CharacterStats.Character.Coordinate);
                        System.out.println(CharacterStats.Character.Coordinate);
                        if(!pm.canPass)
                        {
                            CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate + 1;
                            System.out.print(CharacterStats.Character.Coordinate);
                        }
                        break;
                    } else if(input.toUpperCase().hashCode() == Right.hashCode() || input.toUpperCase().hashCode() == r.hashCode())
                    {
                        CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate + 1;
                        pm.possibleMoves(CharacterStats.Character.Coordinate);
                        System.out.println(CharacterStats.Character.Coordinate);
                        if(!pm.canPass)
                        {
                            CharacterStats.Character.Coordinate = CharacterStats.Character.Coordinate - 1;
                            System.out.print(CharacterStats.Character.Coordinate);
                        }
                        break;
                    } else if(input.toUpperCase().hashCode() == "INVENTORY".hashCode() || input.toUpperCase().hashCode()== "I".hashCode())
                    {
                        functions.clearConsole();
                        Thread.sleep(1000);
                        while(true)
                        {
                            try
                            {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("Do you either want to check inventory, equip, or use a potion");
                                String answer = scanner.nextLine();
                                if(answer.toUpperCase().hashCode() == "CHECK".hashCode())
                                {
                                    functions.clearConsole();
                                    Thread.sleep(750);
                                    functions.checkInventory();
                                    break;
                                }
                                else if(answer.toUpperCase().hashCode() == "EQUIP".hashCode())
                                {
                                    functions.clearConsole();
                                    Thread.sleep(750);
                                    functions.tryToEquip();
                                    break;
                                }
                                else if(answer.toUpperCase().hashCode() == "USE A POTION".hashCode())
                                {
                                    functions.clearConsole();
                                    Thread.sleep(750);
                                    functions.usePotion();
                                    break;
                                }
                                else
                                {
                                    throw  e;
                                }

                            } catch(InputMismatchException e){System.out.println("Please enter either: Check, Equip, or Use a potion");}
                        }
                    } else
                    {
                        throw e;
                    }
                } catch(NullPointerException x) {System.out.println("Please enter (Left, right, forwards, backwards) or (l,r,f,b,i)");}
            }
            else
            {
                System.out.println("Game over");
                break;
            }
        }

    }
}
