package Inventory;

import functions.Functions;
import totalItems.TotalHealingPotions;
import totalItems.TotalSpells;
import totalItems.TotalSwords;
import stats.CharacterStats;

import java.util.*;

public class CheckInventory
{
    static InputMismatchException e;
    public static void main(String[] args) throws InterruptedException
    {
//        equipSpell();
//        equipSword();
//        tryToEnterInventroy();

//        CheckWhichSpellsAreInInventory();
//        CheckWhichSwordsAreInInventory();
        CheckWhichPotionsAreInventory();

//        checkWhichSpellIsEquiped();
//        checkWhichSwordIsEquiped();
//        checkWhichPotionsIsEquiped();


//        chooseWhichSwordToEquip();
//        chooseWhichSpellToEquip();
//        chooseWhichPotionToEquip();


    }

    public static void tryToEnterInventroy() throws InterruptedException
    {
        while(true)
        {
            try
            {
                System.out.println("Which inventory do you want to check: Spells, Swords, Potions, or Exit");
                final String Spells = "SPELLS";
                final String Swords = "SWORDS";
                String Potions = "POTIONS";
                String exit = "EXIT";
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
                else if(inventory.toUpperCase().hashCode() == Potions.hashCode())
                {
                    CheckWhichPotionsAreInventory();
                    checkWhichPotionsIsEquiped();
                }
                else if(inventory.toUpperCase().hashCode() == exit.hashCode())
                {
                    break;
                }
                else
                {
                    throw e;
                }
//
            } catch(InputMismatchException e) {System.out.print("Which inventory do you want to check: Spells, Swords, Potions, or Exit");}
        }
    }

    public static void checkWhichPotionsIsEquiped()
    {
        for(int i=0; i < PotionInventory.values().length; i++)
        {
            if(PotionInventory.getPotionInInventory(i).equipped)
            {
                System.out.println("Potion equipped: " + PotionInventory.getPotionInInventory(i).item);
                for(int x = 0; x < TotalHealingPotions.values().length; x++)
                {
                    if(PotionInventory.getPotionInInventory(i).item == TotalHealingPotions.getPotion(x).name)
                    {
                        System.out.println("Healing power: " + TotalHealingPotions.getPotion(x).totalHealingPower);
                        break;
                    }
                }
            }
        }
    }

    public static void checkWhichSwordIsEquiped()
    {
        for(int i = 0; i < SwordsInventory.values().length; i++)
        {
            if(SwordsInventory.getSwordInInvetory(i).equiped)
            {
                System.out.println("Sword equipped: " + SwordsInventory.getSwordInInvetory(i).item);
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

    public static void equipHealingPotions()
    {
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
    }

    public static void equipSpell()
    {
        for(int i = 0; i < SpellsInventory.values().length; i++)
        {
            if(SpellsInventory.getSpellInInvetory(i).equiped)
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
                    System.out.println("Spell equipped: " + SpellsInventory.getSpellInInvetory(i).item);
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

        for(int i = 0; i < SpellsInventory.values().length; i++)
        {
            if(!SpellsInventory.getSpellInInvetory(i).item.equals("empty"))
            {
                System.out.println("Space " + i + ": " + SpellsInventory.getSpellInInvetory(i).item);
                for(int x = 0; x < TotalSpells.values().length; x++)
                {
                    if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpells(x).name)
                    {
                        System.out.println("Spell damage: " + TotalSpells.getSpells(x).spellDamage + "\nMana cost: " + TotalSpells.getSpells(x).manaCost + "\n");
                    }
                }
            }
        }
    }

    public static void CheckWhichSwordsAreInInventory()
    {
        for(int i = 0; i < 10; i++)
        {
            if(!SwordsInventory.getSwordInInvetory(i).item.equals("empty"))
            {
                System.out.println("Space " + i + ": " + SwordsInventory.getSwordInInvetory(i).item);
                for(int x = 0; x < TotalSwords.values().length; x++)
                {
                    if(SwordsInventory.getSwordInInvetory(i).item == TotalSwords.getSword(x).name) { System.out.println("Sword damage: " + TotalSwords.getSword(x).swordDamage); }
                }
            }
        }
    }
    public static void CheckWhichPotionsAreInventory()
    {
        for(int i = 0; i < 10; i++)
        {
            if(!PotionInventory.getPotionInInventory(i).item.equals("empty"))
            {
                System.out.println("Space " + i + ": " + PotionInventory.getPotionInInventory(i).item);
                for(int x = 0; x < TotalHealingPotions.values().length; x++)
                {
                    if(PotionInventory.getPotionInInventory(i).item == TotalHealingPotions.getPotion(x).name) { System.out.println("Healing power: " + TotalHealingPotions.getPotion(x).totalHealingPower + "\nPotions amount: " + TotalHealingPotions.getPotion(x).amount + "\n"); }
                }
            }
        }
    }
    public static TotalSpells returnSpellEquiped()
    {
        for(int i = 0; i < SpellsInventory.values().length; i++)
        {
            if(SpellsInventory.getSpellInInvetory(i).equiped)
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
    public static TotalHealingPotions returnPotionEquiped()
    {
        for(int i = 0; i < PotionInventory.values().length; i++)
        {
            if(PotionInventory.getPotionInInventory(i).equipped)
            {
                for(int x = 0; x < TotalHealingPotions.values().length; x++)
                {
                    if(PotionInventory.getPotionInInventory(i).item == TotalHealingPotions.getPotion(x).name)
                    {
                        return TotalHealingPotions.getPotion(x);
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
        System.out.println("Spell equipped: " + returnSpellEquiped().name + " | Sword equipped: " + returnSwordEquiped().name);
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
                            System.out.println(SpellsInventory.getSpellInInvetory(i).item + "(" + i + ")" + " Damage: " + TotalSpells.getSpell(x).spellDamage + " :equipped");
                        }
                    }
                } else
                {
                    for(int x = 0; x < TotalSpells.values().length; x++)
                    {
                        if(SpellsInventory.getSpellInInvetory(i).item == TotalSpells.getSpell(x).name)
                        {
                            System.out.println(SpellsInventory.getSpellInInvetory(i).item + "(" + i + ")" + " Damage: " + TotalSpells.getSpell(x).spellDamage + " :not equipped");
                        }
                    }
                }
            }
        }
        tryToEquipItem("spell");
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
         tryToEquipItem("sword");

        }
    public static void chooseWhichPotionToEquip() throws InterruptedException
    {
        for(int i = 0; i < PotionInventory.values().length; i++)
        {
            if(PotionInventory.getPotionInInventory(i).item != "empty")
            {
                if(PotionInventory.getPotionInInventory(i).equipped)
                {
                    for(int x = 0; x < TotalHealingPotions.values().length; x++)
                    {
                        if(PotionInventory.getPotionInInventory(i).item == TotalHealingPotions.getPotion(x).name)
                        {
                            System.out.println(PotionInventory.getPotionInInventory(i).item + "(" + i + ")" + " Healing power: " + TotalHealingPotions.getPotion(x).totalHealingPower + " Amount: " + TotalHealingPotions.getPotion(x).amount + " :equipped");
                        }
                    }
                }
                else
                {
                    for(int x = 0; x < TotalHealingPotions.values().length; x++)
                    {
                        if(PotionInventory.getPotionInInventory(i).item == TotalHealingPotions.getPotion(x).name)
                        {
                            System.out.println(PotionInventory.getPotionInInventory(i).item + "(" + i + ")" + " Healing power: " + TotalHealingPotions.getPotion(x).totalHealingPower + " Amount: " + TotalHealingPotions.getPotion(x).amount + " :not equipped");
                        }
                    }
                }
            }
        }
        tryToEquipItem("potion");
    }

    public static void tryToEquipItem(String item) throws InterruptedException
    {
        try
        {
            System.out.println("Choose " + item  + " to equip! ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(item == "sword")
            {
                for(int i = 0; i < SwordsInventory.values().length; i++)
                {
                    if(SwordsInventory.getSwordInInvetory(i).equiped == true)
                    {
                        SwordsInventory.getSwordInInvetory(i).equiped = false;
                    }
                } SwordsInventory.getSwordInInvetory(choice).equiped = true;
                System.out.println("Sword: " + SwordsInventory.getSwordInInvetory(choice).item + " equipped");

            }
            else if(item == "potion")
            {
                for(int i = 0; i < PotionInventory.values().length; i++)
                {
                    if(PotionInventory.getPotionInInventory(i).equipped)
                    {
                        PotionInventory.getPotionInInventory(i).equipped = false;
                    }
                } PotionInventory.getPotionInInventory(choice).equipped = true;
                System.out.println("Potion: " + PotionInventory.getPotionInInventory(choice).item + " equipped");
            }
            else
            {
                for(int i = 0; i < SpellsInventory.values().length; i++)
                {
                    if(SpellsInventory.getSpellInInvetory(i).equiped == true)
                    {
                        SpellsInventory.getSpellInInvetory(i).equiped = false;

                    }
                }

                SpellsInventory.getSpellInInvetory(choice).equiped = true;
                System.out.println("Spell: " + SpellsInventory.getSpellInInvetory(choice).item + " equipped");
            }
        } catch(InputMismatchException e) {System.out.println("Please enter the number of the " + item + " you want to equip");}
        Thread.sleep(1500);
        Functions.clearConsole();
    }
}

