package functions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

import Inventory.CheckInventory;
import Inventory.PotionInventory;
import stats.CharacterStats;
import stats.MonsterStats;
import totalItems.TotalHealingPotions;
import totalItems.TotalMpPotions;

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
                if (Choice.toUpperCase().hashCode() == Fight.hashCode())
                {
                    break;
                } else if (Choice.toUpperCase().hashCode() == Magic.hashCode())
                {
                    break;
                } else if (Choice.toUpperCase().hashCode() == Flee.hashCode())
                {
                    break;
                } else if(Choice.toUpperCase().hashCode() == Inventory.hashCode())
                {
                    break;
                }else if(Choice.toUpperCase().hashCode() == Equip.hashCode())
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

    public static void tryToEnterPotionUsage() throws InterruptedException
    {
        boolean inStore = true;
        while(inStore)
        {
            try
            {
                print("What do you want to use, either Mp or Hp");
                Scanner input = new Scanner(System.in);
                String choice = input.nextLine();
                if(choice.equalsIgnoreCase("Hp"))
                {
                    useHealingPotion();
                    Thread.sleep(1500);
                    clearConsole();
                    Thread.sleep(1000);
                    break;
                }
                else if (choice.equalsIgnoreCase("Mp"))
                {
                    useMpPotion();
                    Thread.sleep(1500);
                    clearConsole();
                    Thread.sleep(1000);
                    break;
                }
                else
                {
                    throw e;
                }
            }
            catch(InputMismatchException e){print("Enter either Mp or Hp.");}
        }
    }
    public static void useMpPotion()
    {
        if(CharacterStats.Character.cMP != CharacterStats.Character.MaxMP)
        {
            while(true)
            {

                try
                {

                    print("How many Potions do you want to use? (You have: " + CharacterStats.Character.amountOfMpPotions + " potions)");

                    Scanner input = new Scanner(System.in);
                    int amount = input.nextInt();

                    if(amount <= CharacterStats.Character.amountOfMpPotions)
                    {
                        print("You used a Potion");
                        for(int i = 1; i <= amount; i++)
                        {
                            for(int x = 0; x < PotionInventory.values().length; x++)
                            {
                                if(potionInventory.getPotionInInventory(x).equipped)
                                {
                                    for(int y = 0; y < TotalMpPotions.values().length; y++)
                                    {
                                        if(potionInventory.getPotionInInventory(x).item == TotalMpPotions.getPotion(y).name)
                                        {
                                            if(CharacterStats.Character.cMP != CharacterStats.Character.MaxMP)
                                            {
                                                int Mp = CharacterStats.Character.cMP;
                                                if(CharacterStats.Character.amountOfMpPotions > 0)
                                                {
                                                    Mp  = Mp + TotalMpPotions.getPotion(y).totalMpPower;
                                                    if(Mp <= CharacterStats.Character.MaxMP)
                                                    {
                                                        print("You gained " + TotalMpPotions.getPotion(y).totalMpPower + " Mp");
                                                        CharacterStats.Character.cMP = CharacterStats.Character.cMP + TotalMpPotions.getPotion(y).totalMpPower;
                                                        TotalMpPotions.getPotion(y).amount--;
                                                        CharacterStats.Character.amountOfMpPotions = TotalMpPotions.getPotion(y).amount;
                                                    }
                                                    else
                                                    {
                                                        int num=0;
                                                        while(num != CharacterStats.Character.MaxMP - CharacterStats.Character.cMP)
                                                        {
                                                            num++;
                                                        }
                                                        print("You gained " + num + " Mp");
                                                        CharacterStats.Character.cMP = CharacterStats.Character.cMP + num;
                                                        TotalMpPotions.getPotion(y).amount--;
                                                        CharacterStats.Character.amountOfMpPotions = TotalMpPotions.getPotion(y).amount;
                                                    }

                                                } else
                                                {
                                                    print("You have no more potions ");
                                                    break;
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("You are at full Mp");
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        print("You have " + CharacterStats.Character.amountOfMpPotions + " left");
                        print("Mp: " + CharacterStats.Character.cMP);
                        break;
                    } else
                    {
                        print("You can't use that many");
                    }
                } catch(InputMismatchException e) {print("Please enter a number: ");}
            }
        }else
        {
            System.out.println("You are at max Mp, can't use any potions");
        }
    }

    public static void useHealingPotion()
    {
        if(CharacterStats.Character.cHP != CharacterStats.Character.MaxHP)
        {
            while(true)
            {

                try
                {

                    print("How many Potions do you want to use? (You have: " + CharacterStats.Character.amountOfHealingPotions + " potions)");

                    Scanner input = new Scanner(System.in);
                    int amount = input.nextInt();

                    if(amount <= CharacterStats.Character.amountOfHealingPotions)
                    {
                        print("You used a Potion");
                        for(int i = 1; i <= amount; i++)
                        {
                            for(int x = 0; x < PotionInventory.values().length; x++)
                            {
                                if(potionInventory.getPotionInInventory(x).equipped)
                                {
                                    for(int y = 0; y < TotalHealingPotions.values().length; y++)
                                    {
                                        if(potionInventory.getPotionInInventory(x).item == TotalHealingPotions.getPotion(y).name)
                                        {
                                            if(CharacterStats.Character.cHP != CharacterStats.Character.MaxHP)
                                            {
                                                int health = CharacterStats.Character.cHP;
                                                if(CharacterStats.Character.amountOfHealingPotions > 0)
                                                {
                                                    health  = health + TotalHealingPotions.getPotion(y).totalHealingPower;
                                                    if(health <= CharacterStats.Character.MaxHP)
                                                    {
                                                        print("You gained " + TotalHealingPotions.getPotion(y).totalHealingPower + " health");
                                                        CharacterStats.Character.cHP = CharacterStats.Character.cHP + TotalHealingPotions.getPotion(y).totalHealingPower;
                                                        TotalHealingPotions.getPotion(y).amount--;
                                                        CharacterStats.Character.amountOfHealingPotions = TotalHealingPotions.getPotion(y).amount;
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
                                                        TotalHealingPotions.getPotion(y).amount--;
                                                        CharacterStats.Character.amountOfHealingPotions = TotalHealingPotions.getPotion(y).amount;
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
                        print("You have " + CharacterStats.Character.amountOfHealingPotions + " left");
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
                        if(PotionInventory.getPotionInInventory(i).equipped)
                        {
                            for(int x = 0; x < TotalHealingPotions.values().length; x++)
                            {
                                if(PotionInventory.getPotionInInventory(i).item == TotalHealingPotions.getPotion(x).name)
                                {
                                    CharacterStats.Character.amountOfHealingPotions = TotalHealingPotions.getPotion(x).amount;
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
