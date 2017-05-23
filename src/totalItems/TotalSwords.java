package totalItems;

import java.util.ArrayList;
import java.util.List;

public enum TotalSwords
{

    LongSword(3, 15, "Long Sword"),
    ShortSword(2, 10, "Short Sword");

    ArrayList<String> arraylist = new ArrayList<String>();
    public int swordDamage;
    public int swordCost;
    public String name;

    TotalSwords(int damage , int cost, String name)
    {
        swordDamage = damage;
        swordCost = cost;
        this.name = name;
    }
    public static int returnDamage(int x)
    {
        if(TotalSwords.getSword(x) != null)
        {
            return TotalSpells.getSpells(x).spellDamage;
        }
        return 0;
    }

    public static List<String> getAllSwords()
    {
        List<String> sword = new ArrayList<String>();

        for(int i = 0; i < TotalSwords.values().length; i++)
        {
            sword.add(getSword(i).name);
        }
        return sword;
    }
    public static TotalSwords getSword(int i)
    {
        return TotalSwords.values()[i];
    }
}
