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
        clearConsole();
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

    public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void clearConsole()
    {
        if(DEBUG_MODE)
        {
            System.out.print("\033[H\033[2J");
            try
            {
                click(43,640);
            } catch(AWTException e1)
            {
                e1.printStackTrace();
            }
        }
        else
        {
            try
            {
                final String os = System.getProperty("os.name");
                if(os.contains("Windows"))
                {
                    Runtime.getRuntime().exec("cls");
                } else
                {
                    Runtime.getRuntime().exec("clear");
                }
            } catch(final Exception e)
            {
                System.out.println("something went wrong :(");
            }
        }
    }
}
