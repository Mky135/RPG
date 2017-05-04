package Inventory;

import functions.Functions;
import spellsAndSwords.TotalSpells;
import spellsAndSwords.TotalSwords;
import stats.CharacterStats;

import java.util.*;

public class CheckInventory
{
    public static void main(String[] args) throws InterruptedException
    {
        equipSpell();
        equipSword();
//        tryToEnterInventroy();

//        CheckWhichSpellsAreInInventory();
//        CheckWhichSwordsAreInInventory();

//        checkWhichSpellIsEquiped();
//        checkWhichSwordIsEquiped();

        chooseWhichSwordToEquip();
        chooseWhichSpellToEquip();


    }

    public static void tryToEnterInventroy() throws InterruptedException
    {
        boolean exit = false;
        while(true)
        {
            try
            {
                System.out.println("Which inventory do you want to check: Spells or Swords?");
                final String Spells = "SPELLS";
                final String Swords = "SWORDS";
                Scanner scanner = new Scanner(System.in);
                String inventory = scanner.nextLine();
                Functions.clearConsole();
                Thread.sleep(1000);
                if(inventory.toUpperCase().hashCode() == Spells.hashCode())
                {
                    CheckWhichSpellsAreInInventory();
                    checkWhichSpellIsEquiped();
                    break;
                } else if(inventory.toUpperCase().hashCode() == Swords.hashCode())
                {
                    CheckWhichSwordsAreInInventory();
                    checkWhichSwordIsEquiped();
                    break;
                }
//
            } catch(InputMismatchException e) {System.out.print(e);}
        }
    }
    public static void CheckWhichSwordsAreInInventory()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Space " + i + ": " + SwordsInventory.getSwordInInvetory(i).item);
            for(int x = 0; x < TotalSwords.values().length; x++)
            {
                if(SwordsInventory.getSwordInInvetory(i).item== TotalSwords.getSword(x).name) { System.out.println("Sword damage: " + TotalSwords.getSword(x).swordDamage); }
            }
        }

    }
    public static void checkWhichSwordIsEquiped()
    {
        for(int i = 0; i < SwordsInventory.values().length; i++)
        {
            if(SwordsInventory.getSwordInInvetory(i).equiped)
            {
                System.out.println("Sword equiped: " + SwordsInventory.getSwordInInvetory(i).item);
                for(int x = 0; x < TotalSwords.values().length; x++)
                {
                    if(SwordsInventory.getSwordInInvetory(i).item == TotalSwords.getSword(x).name)
                    {
                        System.out.println("Damage: " + TotalSwords.getSword(x).swordDamage);
                        CharacterStats.Character.cDamage = TotalSwords.getSword(x).swordDamage;
                        break;
                    }
                }
            }
        }
    }
    public static void equipSword()
    {
        for(int i = 0; i<TotalSwords.values().length; i++)
        {
            if(SwordsInventory.getSwordInInvetory(i).equiped)
            {
                for(int x = 0; x<TotalSwords.values().length; x++)
                {
                    if(SwordsInventory.getSwordInInvetory(i).item == TotalSwords.getSword(x).name)
                    {
                        CharacterStats.Character.cDamage = TotalSwords.getSword(x).swordDamage;
                    }
                }
            }
        }
    }
    public static void equipSpell()
    {
        for(int i = 0; i < SpellsInventory.values().length; i++)
        {
            if(SpellsInventory.getSpellInInvetory(i).equiped == true)
            {
                for(int x = 0; x < TotalSpells.values().length; x++)
                {
                    if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpells(x).name)
                    {
                        CharacterStats.Character.Spellcost = TotalSpells.getSpells(x).manaCost;
                        CharacterStats.Character.cMDamage = TotalSpells.getSpells(x).spellDamage;
                    }
                }
            }
        }
    }
    public static void checkWhichSpellIsEquiped()
    {

            for(int i = 0; i < SpellsInventory.values().length; i++)
            {
                if(SpellsInventory.getSpellInInvetory(i).equiped)
                {
                    System.out.println("Spell equiped: " + SpellsInventory.getSpellInInvetory(i).item);
                    for(int x = 0; x < TotalSpells.values().length; x++)
                    {
                        if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpells(x).name)
                        {
                            System.out.println("Damage: " + TotalSpells.getSpells(x).spellDamage);
                            System.out.println("Mana cost: " + TotalSpells.getSpells(x).manaCost);
                            CharacterStats.Character.cMDamage = TotalSpells.getSpells(x).spellDamage;
                            CharacterStats.Character.Spellcost = TotalSpells.getSpells(x).manaCost;
                            break;
                        }
                    }
                }
            }

    }
     public static void CheckWhichSpellsAreInInventory()
    {

        for(int i = 0; i < 10; i++)
        {
            System.out.println("Space " + i + ": " + SpellsInventory.getSpellInInvetory(i).item);
            for(int x = 0; x < TotalSpells.values().length; x++)
            {
                if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpells(x).name)
                {
                    System.out.println("Spell damage: " + TotalSpells.getSpells(x).spellDamage + "\nMana cost: " + TotalSpells.getSpells(x).manaCost+"\n");
                }
            }
        }
    }
    public static TotalSpells returnSpellEquiped()
    {
        for(int i = 0; i < SpellsInventory.values().length; i++)
        {
            if(SpellsInventory.getSpellInInvetory(i).equiped == true)
            {
                for(int x = 0; x < TotalSpells.values().length; x++)
                {
                    if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpells(x).name)
                    {
                        return TotalSpells.getSpell(x);
                    }
                }
            }
        }
        return null;
    }
    public static TotalSwords returnSwordEquiped()
    {
        for(int i = 0; i<TotalSwords.values().length; i++)
        {
            if(SwordsInventory.getSwordInInvetory(i).equiped)
            {
                for(int x = 0; x<TotalSwords.values().length; x++)
                {
                    if(SwordsInventory.getSwordInInvetory(i).item == TotalSwords.getSword(x).name)
                    {
                        return TotalSwords.getSword(x);
                    }
                }
            }
        }
        return null;
    }
    public static void returnWhatIsEquiped()
    {
        System.out.println("Spell equiped: " + returnSpellEquiped().name + " | Sword equiped: " + returnSwordEquiped().name);
        System.out.println("Spell damage: " + returnSpellEquiped().spellDamage + " | Sword damage: " + returnSwordEquiped().swordDamage);
        System.out.println("Mana cost: " + returnSpellEquiped().manaCost);
    }
    public static void chooseWhichSpellToEquip() throws InterruptedException
    {
        for(int i = 0; i < SpellsInventory.values().length; i++)
        {
            if(SpellsInventory.getSpellInInvetory(i).item != "empty")
            {
                if(SpellsInventory.getSpellInInvetory(i).equiped)
                {
                    for(int x = 0; x < TotalSpells.values().length; x++)
                    {
                        if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpell(x).name)
                        {
                            System.out.println(SpellsInventory.getSpellInInvetory(i).item + "(" + i + ")" + " Damage: " + TotalSpells.getSpell(x).spellDamage +" :equipped");
                        }
                    }
                }
                else
                {
                    for(int x = 0; x < TotalSpells.values().length; x++)
                    {
                        if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpell(x).name)
                        {
                            System.out.println(SpellsInventory.getSpellInInvetory(i).item + "(" + i + ")" + " Damage: " + TotalSpells.getSpell(x).spellDamage +" :not equipped");
                        }
                    }
                }
            }
        }

            try
            {
                System.out.println("Choose spell to equip! ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                for(int i = 0; i < SpellsInventory.values().length; i++)
                {
                    if(SpellsInventory.getSpellInInvetory(i).equiped == true)
                    {
                        SpellsInventory.getSpellInInvetory(i).equiped = false;

                    }
                }

                SpellsInventory.getSpellInInvetory(choice).equiped = true;
                System.out.println("Spell: " + SpellsInventory.getSpellInInvetory(choice).item + " equipped");
            } catch(InputMismatchException e) {System.out.println("Please enter the number of the spell you want to equip");}
            Thread.sleep(1500);
            Functions.clearConsole();

    }
    public static void chooseWhichSwordToEquip() throws InterruptedException
    {
        for(int i = 0; i < SwordsInventory.values().length; i++)
        {
            if(SwordsInventory.getSwordInInvetory(i).item != "empty")
            {
                if(SwordsInventory.getSwordInInvetory(i).equiped)
                {
                    for(int x = 0; x < TotalSwords.values().length; x++)
                    {
                        if(SwordsInventory.getSwordInInvetory(i).item == TotalSwords.getSword(x).name)
                        {
                            System.out.println(SwordsInventory.getSwordInInvetory(i).item + "(" + i + ")" + " Damage: " + TotalSwords.getSword(x).swordDamage +" :equipped");
                        }
                    }
                }
                else
                {
                    for(int x = 0; x < TotalSwords.values().length; x++)
                    {
                        if(SwordsInventory.getSwordInInvetory(i).item == TotalSwords.getSword(x).name)
                        {
                            System.out.println(SwordsInventory.getSwordInInvetory(i).item + "(" + i + ")" + " Damage: " + TotalSwords.getSword(x).swordDamage +" :not equipped");
                        }
                    }
                }
            }
        }

            try
            {
                System.out.println("Choose sword to equip! ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                for(int i = 0; i < SwordsInventory.values().length; i++)
                {
                    if(SwordsInventory.getSwordInInvetory(i).equiped == true)
                    {
                        SwordsInventory.getSwordInInvetory(i).equiped = false;
                    }
                }

                SwordsInventory.getSwordInInvetory(choice).equiped = true;
                System.out.println("Sword: " + SwordsInventory.getSwordInInvetory(choice).item + " equipped");
            } catch(InputMismatchException e) {System.out.println("Please enter the number of the sword you want to equip");}
            Thread.sleep(1500);
            Functions.clearConsole();
        }

}

