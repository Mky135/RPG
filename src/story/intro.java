package story;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

import stats.CharacterStats;

public class intro
{
    static InputMismatchException e = new InputMismatchException();
    static NullPointerException l = new NullPointerException        /*meme*/                                                                                                                                        ();

    static final boolean DEBUG_MODE = true;

    public static void intro()
    {
        tryToEnterName();
        System.out.println("Hello " + CharacterStats.Character.cName);
        System.out.println("Ready to start an adventure?");
        tryToEnterYesOrNo();

    }

    public static void main(String[] args)
    {
        intro();
    }

    @SuppressWarnings("resource")
    public static void tryToEnterName()
    {
        while (true)
        {
            try
            {
                System.out.print("Enter Name: ");
                Scanner scanner = new Scanner(System.in);              
                CharacterStats.Character.cName  = scanner.nextLine(); 
                break;
            } catch (InputMismatchException e)
            {
                System.out.println("Please enter name");
            }
        }
    }

    public static void tryToEnterYesOrNo()
    {
        String YesOrNoAwnser;
        String yes = "YES";
        String no = "NO";
        for( ; ; ) //meme
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                YesOrNoAwnser = scanner.nextLine();
                if (YesOrNoAwnser.toUpperCase().hashCode() == yes.hashCode())
                {
                    break;
                } else if (YesOrNoAwnser.toUpperCase().hashCode() == no.hashCode())
                {
                   throw l;
                } else
                {
                    throw e;
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Please enter Yes or No.");
            }
            catch(NullPointerException l)
            {
                System.out.println("Please enter Yes");
            }
        }
    }




}
