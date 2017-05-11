package story;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

import functions.Functions;
import org.omg.PortableServer.THREAD_POLICY_ID;
import stats.CharacterStats;

public class intro
{
    static InputMismatchException e = new InputMismatchException();
    static NullPointerException l = new NullPointerException        /*meme*/                                                                                                                                        ();


    public static void intro() throws InterruptedException
    {
        tryToEnterName();
        CharacterStats.Character.cName = CharacterStats.Character.cName.substring(0,1).toUpperCase() + CharacterStats.Character.cName.substring(1).toLowerCase();
        System.out.println("Hello " + CharacterStats.Character.cName);
        System.out.println("Ready to start an adventure?");
        tryToEnterYesOrNo();
        System.out.println("Great, then you are in for a real adventure");
        Thread.sleep(1000);
        System.out.println("██████╗    ██████╗     ██████╗");
        Thread.sleep(250);
        System.out.println("██╔══██╗   ██╔══██╗   ██╔════╝");
        Thread.sleep(250);
        System.out.println("██████╔╝   ██████╔╝   ██║  ███╗");
        Thread.sleep(250);
        System.out.println("██╔══██╗   ██╔═══╝    ██║   ██║");
        Thread.sleep(250);
        System.out.println("██║  ██║██╗██║     ██╗╚██████╔╝");
        Thread.sleep(250);
        System.out.println("╚═╝  ╚═╝╚═╝╚═╝     ╚═╝ ╚═════╝ ");
        Thread.sleep(2000);
        Functions.clearConsole();
        Thread.sleep(750);
        oldMan();

    }

    public static void main(String[] args) throws InterruptedException
    {
        intro();
    }

    public static void oldMan()throws InterruptedException
    {
        System.out.println("You are walking in a prairie, when all the sudden you encounter a stranger");
        Thread.sleep(750);
        Functions.clearConsole();
        Thread.sleep(250);
        System.out.print("Old man: Please help me, ");
        Thread.sleep(750);
        System.out.print("my cat went down this hole ");
        Thread.sleep(750);
        System.out.print("and I can't go down. ");
        Thread.sleep(750);
        System.out.print("Please help me");
        Thread.sleep(4000);
        Functions.clearConsole();
        Thread.sleep(250);
        System.out.println(CharacterStats.Character.cName+ " : I will help you");
        Thread.sleep(750);
        Functions.clearConsole();
        Thread.sleep(750);
        System.out.println("Old man: Thank you. ");
        Thread.sleep(750);
        System.out.println("Here take this");
        Thread.sleep(750);
        System.out.println("Short sword acquired");
        Thread.sleep(4000);
        Functions.clearConsole();
        Thread.sleep(250);
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
        for( ; ; ) /*meme*/
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
