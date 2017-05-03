package Inventory;

import functions.Functions;
import spellsAndSwords.TotalSpells;
import spellsAndSwords.TotalSwords;
import stats.CharacterStats;

import java.util.*;

public class CheckInventory
{
    static InputMismatchException e = new InputMismatchException();
    public static void main(String[] args) throws InterruptedException
    {
        equipSpell();
//        tryToEnterInventroy();
//        CheckWhichSpellsAreInInventory();
//        checkWhichSpellIsEquiped();

    }

    public static void tryToEnterInventroy() throws InterruptedException
    {
        boolean exit = false;
        while(exit == false)
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
                }
                else if(inventory.toUpperCase().hashCode() == Swords.hashCode())
                {
                    CheckWhichSwordsAreInInventory();
                    checkWhichSwordIsEquiped();
                    break;
                }
//
            }
            catch(InputMismatchException e){System.out.print(e);}

        }
    }
    public static void CheckWhichSwordsAreInInventory()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.print(SwordsInventory.fromInteger(i) + ": ");
            for(int x = 0; x < SwordsInventory.SWORDS.getAllStrings().length(); x++)
            {
                if(SwordsInventory.fromInteger(x) == TotalSwords.ShortSword.getAllStrings().name)
                {
                    System.out.print(TotalSwords.returnDamage(i));
                }
            }
            System.out.println();
        }

    }
    public static void checkWhichSwordIsEquiped()
    {
       for(int i = 0; i < TotalSwords.values().length;  i++ )
        if(SwordsInventory.SWORDS.space0 == TotalSwords.fromInteger(i).name)
        {
            System.out.println(TotalSwords.fromInteger(i).name);
            CharacterStats.Character.cDamage = TotalSwords.fromInteger(i).swordDamage;
            System.out.println(CharacterStats.Character.cDamage);
            break;
        }
        else
        {
            System.out.println("false");
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
                if(SpellsInventory.getSpellInInvetory(i).equiped == true)
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

}
