package functions;

import Inventory.CheckInventory;
import Inventory.SwordsInventory;
import jdk.internal.util.xml.impl.Input;
import stats.CharacterStats;
import totalItems.TotalPotions;
import totalItems.TotalSpells;
import totalItems.TotalSwords;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Merchant
{
    static NullPointerException e;
    public static void main(String[] args)
    {
        tryToEnterStore();
    }
    public static void tryToEnterStore()
    {
        boolean left = false;
        while(!left)
        {
            try
            {

                System.out.println("What do you want to buy? Spells, Swords, or Potions. You can also leave.");
                Scanner keyboard = new Scanner(System.in);
                String input = keyboard.nextLine();
                if(input.toLowerCase().hashCode() == "spells".hashCode())
                {
                    sellSpells();
                }

                else if(input.toLowerCase().hashCode() == "swords".hashCode())
                {
                    sellSwords();
                }

                else if(input.toLowerCase().hashCode() == "potions".hashCode())
                {
                    sellPotions();
                }
                else if(input.toLowerCase().hashCode() == "leave".hashCode())
                {
                    left = true;
                }
                else
                {
                    throw e;
                }
            }
            catch(NullPointerException e){ /*System.out.println("Please enter either: Spells, Swords, Potions, or leave.");*/ }
        }
    }
    private static void sellSpells()
    {
        int times = 1;
        boolean left = false;
        while(!left)
        {

            Scanner scanner = new Scanner(System.in);
            if((times % 2) == 0)
            {
                System.out.println("Do you want to leave?");
                String leave = scanner.nextLine();

                if(leave.toLowerCase().hashCode() == "yes".hashCode())
                {
                    left=true;
                }
            }
            else
            {
                System.out.println("Total money: " + CharacterStats.Character.money);

                for(int i = 0; i < TotalSpells.values().length; i++)
                {
                    System.out.println(TotalSpells.getSpell(i).name + " cost: " + TotalSpells.getSpell(i).spellCost + " index: " + i);
                }
                try
                {
                    System.out.println("Which do you want to buy?");
                    int item = scanner.nextInt();

                            if(CharacterStats.Character.money >= TotalSpells.getSpell(item).spellCost)
                            {
                                System.out.println("You bought " + TotalSpells.getSpell(item).name);
                                CharacterStats.Character.money = CharacterStats.Character.money - TotalSpells.getSpell(item).spellCost;
                            } else
                            {
                                System.out.println("You don't have enough money to buy this.");
                                break;
                            }
                } catch(InputMismatchException e) { System.out.println("Enter in the index of the spell you want to buy"); }
            }
            times++;
        }
    }
    private static void sellSwords()
    {
        int times = 1;
        boolean left = false;
        while(!left)
        {


            Scanner scanner = new Scanner(System.in);
            if((times % 2) == 0)
            {
                System.out.println("Do you want to leave?");
                String leave = scanner.nextLine();

                if(leave.toLowerCase().hashCode() == "yes".hashCode())
                {
                    left=true;
                }
            }
            else
            {
                System.out.println("Total money: " + CharacterStats.Character.money);

                for(int i = 0; i < TotalSwords.values().length; i++)
                {
                    System.out.println(TotalSwords.getSword(i).name + " cost: " + TotalSwords.getSword(i).swordCost + " index: " + i);
                }
                try
                {
                    System.out.println("Which do you want to buy?");
                    int item = scanner.nextInt();

                            if(CharacterStats.Character.money >= TotalSwords.getSword(item).swordCost)
                            {
                                System.out.println("You bought " + TotalSwords.getSword(item).name);
                                CharacterStats.Character.money = CharacterStats.Character.money - TotalSwords.getSword(item).swordCost;
                                for(int i=0; i<SwordsInventory.values().length;i++)
                                {
                                    if(SwordsInventory.getSwordInInvetory(i).item.equals("empty"))
                                    {
                                        SwordsInventory.getSwordInInvetory(i).item = TotalSwords.getSword(item).name;
                                        break;
                                    }
                                }
                            } else
                            {
                                System.out.println("You don't have enough money to buy this.");
                                break;
                            }


                } catch(InputMismatchException e) { System.out.println("Enter in the index of the sword you want to buy"); }

            }times++;
        }
    }
    private static void sellPotions()
    {
        boolean toMany = false;
        int times = 1;
        while(true)
        {

            Scanner scanner = new Scanner(System.in);
            if(times%2==0)
            {
                System.out.println("Do you want to leave?");
                String leave = scanner.nextLine();

                if(leave.toLowerCase().hashCode() == "yes".hashCode())
                {
                    break;
                }
            }
                System.out.println("Total money: " + CharacterStats.Character.money);

                for(int i = 0; i < TotalPotions.values().length; i++)
                {
                    System.out.println(TotalPotions.getPotion(i).name + " cost: " + TotalPotions.getPotion(i).cost + " index: " + i);
                }
                try
                {
                    System.out.println("Which do you want to buy?");
                    int item = scanner.nextInt();
                    System.out.println("How many? ");
                    int amount = scanner.nextInt();
                    if(amount == 1)
                    {
                        if(CharacterStats.Character.money >= TotalPotions.getPotion(item).cost)
                        {
                            System.out.println("You bought " + TotalPotions.getPotion(item).name);
                            CharacterStats.Character.money = CharacterStats.Character.money - TotalPotions.getPotion(item).cost;
                            TotalPotions.getPotion(item).amount++;
                        } else if(CharacterStats.Character.money <= TotalPotions.getPotion(item).cost)
                        {
                            System.out.println("You don't have enough money to buy this.");
                            break;
                        }
                    } else
                    {
                        for(int i = 0; i < amount; i++)
                        {


                            if(CharacterStats.Character.money >= TotalPotions.getPotion(item).cost)
                            {
                                CharacterStats.Character.money = CharacterStats.Character.money - TotalPotions.getPotion(item).cost;
                                TotalPotions.getPotion(item).amount++;
                            } else
                            {
                                toMany = true;
                                System.out.println("You don't have enough money to buy all of these, you only bought " + (amount - (amount - i)) + ".");
                                System.out.println("You have a total of " + TotalPotions.getPotion(item).amount + " " + TotalPotions.getPotion(item).name);
                                break;
                            }
                        }

                    }
                    if(!toMany)
                    {
                        System.out.println("You bought " + amount + " " + TotalPotions.getPotion(item).name);
                        System.out.println("You have a total of " + TotalPotions.getPotion(item).amount + " " + TotalPotions.getPotion(item).name);
                    }

                }catch(InputMismatchException e){ System.out.println("Enter in the index of the potion you want to buy");
                }


            times++;
        }

    }

}
