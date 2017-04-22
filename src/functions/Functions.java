package functions;

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
    public static int MHPLeft;

    static InputMismatchException e = new InputMismatchException();

    public static void tryToEnterCombatOption(MonsterStats monster)
    {
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

    public static void fight(MonsterStats monster)
    {
        try
        {
            System.out.println("You choice to fight");
            if (CharacterStats.Character.cMSpeed >= monster.mSpeed)
            {
                System.out.println("Hit");
                hitMonster(monster, "COMBAT");
                if (monster.mHP > 0)
                {
                    hitCharacter(monster);
                }
            } else if (CharacterStats.Character.cMSpeed <= monster.mSpeed)
            {
                hitCharacter(monster);
                hitMonster(monster, "COMBAT");
            } else
            {
                print("Something went wrong");
            }
        } catch (NullPointerException e)
        {
            System.out.println(e);
        }
    }

    public static void Magic(MonsterStats monster)
    {
        if (CharacterStats.Character.cMSpeed >= monster.mSpeed)
        {
            hitMonster(monster, "MAGIC");

        } else if (CharacterStats.Character.cMSpeed <= monster.mSpeed)
        {
            hitCharacter(monster);
        }
    }

    public static void hitMonster(MonsterStats monster, String magicOrCombat)
    {
        monster.mHP = monster.mHP - magicOrCombat(magicOrCombat);
        System.out.println("Monster Hp: " + monster.mHP);
    }

    public static void hitCharacter(MonsterStats monster)
    {
     
      if (monster.mHP > 0 && CharacterStats.Character.cHP <= 0)
        {
            CharacterStats.Character.cHP = CharacterStats.Character.cHP - monster.mStrength;
            System.out.println(CharacterStats.Character.cName + "'s Hp: " + CharacterStats.Character.cHP);
        }
      else
      {
          System.out.println("You died!");
      }
    }

    public static int magicOrCombat(String magicOrCombat)
    {
        String magic = "MAGIC";
        String combat = "COMBAT";
        if (magicOrCombat.toUpperCase().hashCode() == magic.hashCode())
        {
            return CharacterStats.Character.cMDamage;
        } else if (magicOrCombat.toUpperCase().hashCode() == combat.hashCode())
        {
            return CharacterStats.Character.cDamage;
        } else
        {
            return 0;
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

    public static void print(String value)
    {
        System.out.println(value);
    }
}
