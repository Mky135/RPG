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

    }

    public static void main(String[] args) throws InterruptedException
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
