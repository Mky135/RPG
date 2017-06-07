package functions;

import Inventory.SpellsInventory;
import Inventory.SwordsInventory;
import stats.CharacterStats;
import totalItems.TotalHealingPotions;
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
        if(CharacterStats.Character.money != 0)
        {
            while(!left)
            {
                try
                {
                    if(CharacterStats.Character.money !=0)
                    {
                        System.out.println("What do you want to buy? Spells, Swords, or Potions. You can also leave.");
                        Scanner keyboard = new Scanner(System.in);
                        String input = keyboard.nextLine();
                        if(input.toLowerCase().hashCode() == "spells".hashCode())
                        {
                            sellSpells();
//                    CheckInventory.CheckWhichSpellsAreInInventory();
                        } else if(input.toLowerCase().hashCode() == "swords".hashCode())
                        {
                            sellSwords();
                        } else if(input.toLowerCase().hashCode() == "potions".hashCode())
                        {
                            tryToEnterWhichPotions();
                        } else if(input.toLowerCase().hashCode() == "leave".hashCode())
                        {
                            left = true;
                        } else
                        {
                            throw e;
                        }
                    }
                    else
                    {
                        System.out.println("You ran out of money, please come back later.");
                        left=true;
                    }
                } catch(NullPointerException e) { /*System.out.println("Please enter either: Spells, Swords, Potions, or leave.");*/ }
            }
        }
        else
        {
            System.out.println("You do not have enough money to buy anything right now, come back later.");
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
                                for(int i=0; i < SpellsInventory.values().length; i++)
                                {
                                    if(SpellsInventory.getSpellInInvetory(i).item.equals("empty"))
                                    {
                                        SpellsInventory.getSpellInInvetory(i).item = TotalSpells.getSpell(item).name;
                                        break;
                                    }
                                }
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
    private static void tryToEnterWhichPotions()
    {
        //try
        Scanner scanner = new Scanner(System.in);
        //if healing
        //if hp
        //catch
    }
    private static void sellHpPotions()
    {
        //todo: make it so you can buy HP potions
    }
    private static void sellHealingPotions()
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

                for(int i = 0; i < TotalHealingPotions.values().length; i++)
                {
                    System.out.println(TotalHealingPotions.getPotion(i).name + " cost: " + TotalHealingPotions.getPotion(i).cost + " index: " + i);
                }
                try
                {
                    System.out.println("Which do you want to buy?");
                    int item = scanner.nextInt();
                    System.out.println("How many? ");
                    int amount = scanner.nextInt();
                    if(amount == 1)
                    {
                        if(CharacterStats.Character.money >= TotalHealingPotions.getPotion(item).cost)
                        {
                            System.out.println("You bought " + TotalHealingPotions.getPotion(item).name);
                            CharacterStats.Character.money = CharacterStats.Character.money - TotalHealingPotions.getPotion(item).cost;
                            TotalHealingPotions.getPotion(item).amount++;
                        } else if(CharacterStats.Character.money <= TotalHealingPotions.getPotion(item).cost)
                        {
                            System.out.println("You don't have enough money to buy this.");
                            break;
                        }
                    } else
                    {
                        for(int i = 0; i < amount; i++)
                        {


                            if(CharacterStats.Character.money >= TotalHealingPotions.getPotion(item).cost)
                            {
                                CharacterStats.Character.money = CharacterStats.Character.money - TotalHealingPotions.getPotion(item).cost;
                                TotalHealingPotions.getPotion(item).amount++;
                            } else
                            {
                                toMany = true;
                                System.out.println("You don't have enough money to buy all of these, you only bought " + (amount - (amount - i)) + ".");
                                System.out.println("You have a total of " + TotalHealingPotions.getPotion(item).amount + " " + TotalHealingPotions.getPotion(item).name);
                                break;
                            }
                        }

                    }
                    if(!toMany)
                    {
                        System.out.println("You bought " + amount + " " + TotalHealingPotions.getPotion(item).name);
                        System.out.println("You have a total of " + TotalHealingPotions.getPotion(item).amount + " " + TotalHealingPotions.getPotion(item).name);
                    }

                }catch(InputMismatchException e){ System.out.println("Enter in the index of the potion you want to buy");
                }


            times++;
        }

    }

}
