package functions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

import stats.CharacterStats;
import stats.MonsterStats;

public class Functions
{
    public static String Choice = "";
    public static String Fight = "FIGHT";
    public static String Magic = "MAGIC";
    public static String Flee = "FLEE";

    static InputMismatchException e = new InputMismatchException();

    public static void tryToEnterCombatOption(MonsterStats monster)
    {
        System.out.print("HP: " + CharacterStats.Character.cHP + " Melee damage: " + CharacterStats.Character.cDamage);
        System.out.print(" Mp: " + CharacterStats.Character.cMP + " Magic damage: " + CharacterStats.Character.cMDamage + "\n");
        System.out.println(monster + "'s " + "HP: " + monster.mHP + " " + monster.typeOfDamage + ": " + monster.mStrength);
        System.out.println("Enter either: \n Fight, Magic, or Flee");
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                Choice = scanner.nextLine();
                if (Choice.toUpperCase().hashCode() == Fight.toUpperCase().hashCode())
                {
                    break;
                } else if (Choice.toUpperCase().hashCode() == Magic.toUpperCase().hashCode())
                {
                    break;
                } else if (Choice.toUpperCase().hashCode() == Flee.toUpperCase().hashCode())
                {
                    break;
                } else
                {
                    throw e;
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Please enter either: \n Fight, Magic, or Flee");
            }
        }

    }

    public static void fight(MonsterStats monster) throws InterruptedException
    {
        try
        {
            System.out.println("You choice to fight");
            Thread.sleep(500);
            if(CharacterStats.Character.cMSpeed >= monster.mSpeed)
            {
                System.out.println("Hit");
                hitMonster(monster, "FIGHT");
                if(monster.mHP > 0)
                {
                    Thread.sleep(1000);
                    System.out.println("Monster hit you back");
                    hitCharacter(monster);
                }
            } else if(CharacterStats.Character.cMSpeed <= monster.mSpeed)
            {
                Thread.sleep(1000);
                System.out.println("You're slower then" + monster + ", " + monster + " hit you first");
                hitCharacter(monster);
                Thread.sleep(500);
                System.out.println("You hit " + monster + " back");
                hitMonster(monster, "FIGHT");
            } else
            {
                print("Something went wrong");
            }
        } catch(NullPointerException e)
        {
            System.out.println(e);
        }
    }

    public static void Magic(MonsterStats monster) throws InterruptedException
    {
        if(canUseMagic(CharacterStats.Character.cSpell) == true)
        {
            try
            {
                System.out.println("You choice to use magic");
                System.out.println("MP left: " + CharacterStats.Character.cMP);
                Thread.sleep(500);
                if(CharacterStats.Character.cMSpeed >= monster.mSpeed)
                {
                    System.out.println("Hit");
                    hitMonster(monster, "MAGIC");
                    if(monster.mHP > 0)
                    {
                        Thread.sleep(1000);
                        System.out.println("Monster hit you back");
                        hitCharacter(monster);
                    }
                } else if(CharacterStats.Character.cMSpeed <= monster.mSpeed)
                {
                    Thread.sleep(1000);
                    System.out.println("You're slower then" + monster + ", " + monster + " hit you first");
                    hitCharacter(monster);
                    Thread.sleep(500);
                    System.out.println("You hit " + monster + " back");
                    hitMonster(monster, "MAGIC");
                } else
                {
                    print("Something went wrong");
                }
            } catch(NullPointerException e)
            {
                System.out.println(e);
            }
        }
        else
        {
            System.out.println("Can't use spell 0 MP left");
        }
    }

    public static void hitMonster(MonsterStats monster, String magicOrCombat)
    {
        monster.mHP = monster.mHP - magicOrCombat(magicOrCombat);
        System.out.println("Monster Hp: " + monster.mHP);
    }

    public static String hitCharacter(MonsterStats monster)
    {
     
      if (monster.mHP > 0 && CharacterStats.Character.cHP > 0)
        {
            CharacterStats.Character.cHP = CharacterStats.Character.cHP - monster.mStrength;
            System.out.println(CharacterStats.Character.cName + "'s Hp: " + CharacterStats.Character.cHP);
            return "Alive";
        }
      else
      {
          System.out.println("You were killed by " + monster);
          return "Died";
      }
    }

    public static int magicOrCombat(String magicOrCombat)
    {
        String magic = "MAGIC";
        String combat = "FIGHT";
        if (magicOrCombat.hashCode() == combat.hashCode())
        {
            return CharacterStats.Character.cDamage;

        } else
        {
            return CharacterStats.Character.cMDamage;
        }
    }
    public static boolean isCharacterDied()
    {
        if(CharacterStats.Character.cHP <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean flee(MonsterStats monster)
    {
        if (CharacterStats.Character.intelligence > monster.intelligence)
        {
            System.out.println("You fleed");
            return true;
        } else
        {
            System.out.println("You can't flee");
            hitCharacter(monster);            
            return false;
        }
    }
    public static boolean canUseMagic(int spellPower)
    {
        CharacterStats.Character.cMP = CharacterStats.Character.cMP - spellPower;
        if(CharacterStats.Character.cMP > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void print(String value)
    {
        System.out.println(value);
    }

    public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void clearConsole()
    {

        System.out.print("\033[H\033[2J");
        try
        {
            click(43, 640);
        } catch(AWTException e1)
        {
            e1.printStackTrace();
        }

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
