package functions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

import Inventory.CheckInventory;
import Inventory.PotionInventory;
import stats.CharacterStats;
import stats.MonsterStats;
import totalItems.TotalPotions;

public class Functions
{
     static String Choice = "";
     static String Fight = "FIGHT".toUpperCase();
     static String Magic = "MAGIC".toUpperCase();
     static String Flee = "FLEE".toUpperCase();
     static String Inventory = "Inventory".toUpperCase();
     static String Equip = "equip".toUpperCase();
     static String Potions = "use a Potion".toUpperCase();
     static CheckInventory checkInventory;
     static PotionInventory potionInventory;

    static InputMismatchException e = new InputMismatchException();

    public static void tryToEnterCombatOption(MonsterStats monster)
    {

        System.out.print("HP: " + CharacterStats.Character.cHP + " Melee damage: " + CharacterStats.Character.cDamage);
        System.out.println(" Mp: " + CharacterStats.Character.cMP + " Magic damage: " + CharacterStats.Character.cMDamage);
        System.out.println(monster + "'s " + "HP: " + monster.mHP + " " + monster.typeOfDamage + " damage: " + monster.mStrength);
        System.out.println("Enter either: \nFight, Magic, Flee, Inventory, equip, or use a Potion");
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
                } else if(Choice.toUpperCase().hashCode() == Inventory.toUpperCase().hashCode())
                {
                    break;
                }else if(Choice.toUpperCase().hashCode() == Equip.toUpperCase().hashCode())
                {
                    break;
                }
                else if(Choice.toUpperCase().hashCode() == Potions.hashCode())
                {
                    break;
                }
                else
                {
                    throw e;
                }

            } catch (InputMismatchException e)
            {
                System.out.println("Please enter either: \nFight, Magic, Flee, Inventory, equip, or use a Potion");
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
                System.out.println("You're slower then " + monster + ", " + monster + " hit you first");
                hitCharacter(monster);
                Thread.sleep(1000);
                if(CharacterStats.Character.cHP > 0)
                {
                    System.out.println("You hit " + monster + " back");
                    hitMonster(monster, "FIGHT");
                }
            } else
            {
                print("Something went wrong");
            }
        } catch(NullPointerException e)
        {
            System.out.println(e);
        }
    }

    public static void usePotion()
    {
        if(CharacterStats.Character.cHP != CharacterStats.Character.MaxHP)
        {
            while(true)
            {

                try
                {

                    print("How many Potions do you want to use? (You have: " + CharacterStats.Character.amountOfPotions + " potions)");

                    Scanner input = new Scanner(System.in);
                    int amount = input.nextInt();

                    if(amount <= CharacterStats.Character.amountOfPotions)
                    {
                        print("You used a Potion");
                        for(int i = 0; i <= amount; i++)
                        {
                            for(int x = 0; x < PotionInventory.values().length; x++)
                            {
                                if(potionInventory.getPotionInInventory(x).equiped)
                                {
                                    for(int y = 0; y < TotalPotions.values().length; y++)
                                    {
                                        if(potionInventory.getPotionInInventory(x).item == TotalPotions.getPotion(y).name)
                                        {
                                            if(CharacterStats.Character.cHP != CharacterStats.Character.MaxHP)
                                            {
                                                int health = CharacterStats.Character.cHP;
                                                if(CharacterStats.Character.amountOfPotions > 0)
                                                {
                                                    health  = health + TotalPotions.getPotion(y).totalHealingPower;
                                                    if(health <= CharacterStats.Character.MaxHP)
                                                    {
                                                        print("You gained " + TotalPotions.getPotion(y).totalHealingPower + " health");
                                                        CharacterStats.Character.cHP = CharacterStats.Character.cHP + TotalPotions.getPotion(y).totalHealingPower;
                                                        TotalPotions.getPotion(y).amount--;
                                                        CharacterStats.Character.amountOfPotions = TotalPotions.getPotion(y).amount;
                                                    }
                                                    else
                                                    {
                                                        int num=0;
                                                            while(num != CharacterStats.Character.MaxHP - CharacterStats.Character.cHP)
                                                            {
                                                                num++;
                                                            }
                                                            print("You gained " + num + " health");
                                                            CharacterStats.Character.cHP = CharacterStats.Character.cHP + num;
                                                            TotalPotions.getPotion(y).amount--;
                                                            CharacterStats.Character.amountOfPotions = TotalPotions.getPotion(y).amount;
                                                    }

                                                } else
                                                {
                                                    print("You have no more potions ");
                                                    break;
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("You are at full health");
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        print("You have " + CharacterStats.Character.amountOfPotions + " left");
                        print("Health: " + CharacterStats.Character.cHP);
                        break;
                    } else
                    {
                        print("You can't use that many");
                    }
                } catch(InputMismatchException e) {print("Please enter a number: ");}
            }
        }else
        {
            System.out.println("You are at max HP, can't use any potions");
        }
    }
    public static void Magic(MonsterStats monster) throws InterruptedException
    {
        if(canUseMagic(CharacterStats.Character.Spellcost))
        {
            try
            {
                checkInventory.checkWhichSpellIsEquiped();
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
                    System.out.println("You're slower then " + monster + ", " + monster + " hit you first");
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

    public static void checkInventory() throws InterruptedException
    {

        checkInventory.tryToEnterInventroy();
    }

    public static void tryToEquip() throws InterruptedException
    {
        while(true)
        {
            try
            {
                System.out.print("Do you either want to equip: Spell, Sword, or Potions: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                String Spell = "SPELL";
                String Sword = "SWORD";
                String Potions = "POTIONS";
                if(input.toUpperCase().hashCode() == Spell.hashCode() || input.toUpperCase().hashCode() == "SP".hashCode())
                {
                    checkInventory.chooseWhichSpellToEquip();
                    break;
                } else if(input.toUpperCase().hashCode() == Sword.hashCode() || input.toUpperCase().hashCode() == "SW".hashCode())
                {
                    checkInventory.chooseWhichSwordToEquip();
                    break;
                } else if(input.toUpperCase().hashCode() == Potions.hashCode()  || input.toUpperCase().hashCode() == "P".hashCode())
                {
                    checkInventory.chooseWhichPotionToEquip();
                    for(int i=0; i<PotionInventory.values().length; i++)
                    {
                        if(PotionInventory.getPotionInInventory(i).equiped)
                        {
                            for(int x=0; x<TotalPotions.values().length; x++)
                            {
                                if(PotionInventory.getPotionInInventory(i).item == TotalPotions.getPotion(x).name)
                                {
                                    CharacterStats.Character.amountOfPotions = TotalPotions.getPotion(x).amount;
                                }
                            }
                        }
                    }
                    break;
                }
                else
                {
                    throw e;
                }
            } catch(InputMismatchException e) {System.out.println("Please enter either Spell, Sword, or Potions");}
        }
    }
    public static void hitMonster(MonsterStats monster, String magicOrCombat)
    {
        monster.mHP = monster.mHP - magicOrCombat(magicOrCombat);
        System.out.println("Monster Hp: " + monster.mHP);
    }

    public static void hitCharacter(MonsterStats monster)
    {
        CharacterStats.Character.cHP = CharacterStats.Character.cHP - monster.mStrength;
      if (monster.mHP > 0 && CharacterStats.Character.cHP > 0)
        {
            System.out.println(CharacterStats.Character.cName + "'s Hp: " + CharacterStats.Character.cHP);

        }
      else
      {
          System.out.println("You were killed by " + monster);
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
        return (CharacterStats.Character.cHP <= 0);
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
        return (CharacterStats.Character.cMP > 0);
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
            click(43, 690);
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
