package Inventory;

import functions.Functions;
import spellsAndSwords.TotalSpells;
import spellsAndSwords.TotalSwords;
import stats.CharacterStats;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckInventory
{
    static ArrayList<String> arraylist = new ArrayList<String>();
    public static void main(String[] args) throws InterruptedException
    {
//        tryToEnterInventroy();
        CheckWhichSpellsAreInInventory();

    }

    public static void tryToEnterInventroy() throws InterruptedException
    {
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
                }
                else if(inventory.toUpperCase().hashCode() == Swords.hashCode())
                {
                    CheckWhichSwordsAreInInventory();
                    checkWhichSwordIsEquiped();
                    break;
                }


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
    public static void checkWhichSpellIsEquiped()
    {
        for(int i = 0; i < TotalSpells.values().length;  i++ )
            if(SpellsInventory.Spells.space0 == TotalSpells.getSpells(i).name)
            {
                System.out.println(TotalSpells.getSpells(i).name);
                CharacterStats.Character.cMDamage = TotalSpells.getSpells(i).spellDamage;
                System.out.println(CharacterStats.Character.cMDamage);
                break;
            }
            else
            {
                System.out.println("false");
            }
    }
     public static void CheckWhichSpellsAreInInventory()
    {
//        for(int q = 0; q < TotalSpells.values().length; q++)
//        {
//            arraylist.add(TotalSpells.getSpells(q).name);
//        }
//        System.out.println(arraylist);
        for(int i = 0; i < 10; i++ )
        if(isSpellInInventory(i))
        {
//            arraylist.remove(i);

//            for(int x = 0; x < TotalSpells.values().length; x++)
//            {
            int spell = 0;
            if(TotalSpells.getSpell(i).spellDamage != 0)
            {

//                arraylist.remove(x);
                System.out.println(TotalSpells.checkAllSpells() + ", damage: " + TotalSpells.getSpell(spell).spellDamage + ", mana cost: " + TotalSpells.getSpell(spell).manaCost);
                spell = spell + 1;
            }
            else
            {
                System.out.println(TotalSpells.checkAllSpells());
            }
//            }
        }
        else
        {
            System.out.println(SpellsInventory.Spells.getAllStrings());
        }
    }

    public static boolean isSpellInInventory(int i)
    {
        return SpellsInventory.fromInteger(i).toString() == TotalSpells.checkAllSpells().name;
    }


}
