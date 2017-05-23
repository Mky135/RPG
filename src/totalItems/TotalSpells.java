package totalItems;

import java.util.ArrayList;
import java.util.List;

public enum TotalSpells
{

    FireSpell(3, 10, "Fire Spell", 1 ),
    IceSpell(4,15, "Ice Spell",2),
    DarkSpell(7, 25, "Dark Spell",3);

    static String [] arrayList;
    public int spellDamage;
    public int spellCost;
    public int manaCost;

    public String name;

    TotalSpells(int damage , int cost, String name, int manaCost)
    {
        spellDamage = damage;
        spellCost = cost;
        this.name = name;
        this.manaCost = manaCost;
    }
    public static TotalSpells getSpells(int i) {
        if(i == 0)
        {

            return FireSpell;
        }
        if(i == 1)
        {
            return IceSpell;
        }
        if(i == 2)
        {
            return DarkSpell;
        }
        return null;
    }
    public static int returnDamage(int x)
    {

        if(TotalSpells.getSpells(x) != null)
        {
            return TotalSpells.getSpells(x).spellDamage;
        }
        return 0;
    }
    public static TotalSpells checkAllSpells()
    {
        for(int i = 0; i < TotalSpells.values().length; i++)
        {

            return getSpells(i);
        }
        return null;
    }
    public static List<String> getAllSpells()
    {
        List<String> spells = new ArrayList<String>();

        for(int i = 0; i < TotalSpells.values().length; i++)
        {
            spells.add(getSpell(i).name);
        }
        return spells;
    }
    public static TotalSpells getSpell(int i)
    {
        return TotalSpells.values()[i];
    }
}
