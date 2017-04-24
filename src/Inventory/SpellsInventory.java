package Inventory;

import spellsAndSwords.TotalSpells;

public enum SpellsInventory
{
    Spells( TotalSpells.FireSpell.name,"Empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty");
    String space0;
    String space1;
    String space2;
    String space3;
    String space4;
    String space5;
    String space6;
    String space7;
    String space8;
    String space9;

    SpellsInventory(String item0 ,String item1, String item2, String item3, String item4, String item5, String item6, String item7, String item8, String item9)
    {
        space0 = item0;
        space1 = item1;
        space2 = item2;
        space3 = item3;
        space4 = item4;
        space5 = item5;
        space6 = item6;
        space7 = item7;
        space8 = item8;
        space9 = item9;
    }
    public static String fromInteger(int x) {
        switch(x)
        {
            case 0:
                return Spells.space0;
            case 1:
                return Spells.space1;
            case 2:
                return Spells.space2;
            case 3:
                return Spells.space3;
            case 4:
                return Spells.space4;
            case 5:
                return Spells.space5;
            case 6:
                return Spells.space6;
            case 7:
                return Spells.space7;
            case 8:
                return Spells.space8;
            case 9:
                return Spells.space9;
        }
        return null;
    }


    public String getAllStrings()
    {
        for(int i = 0; i < SpellsInventory.values().length; i++)
        {
            return fromInteger(i).toString();
        }
        return null;
    }
    public static String checkAllSpells()
    {
        for(int i = 0; i < TotalSpells.values().length; i++)
        {
            return SpellsInventory.fromInteger(i);
        }
        return null;
    }
    public static String getSpace(int x)
    {
        if(x == 0)
        {
            return Spells.space0;
        }
        else if(x == 1)
        {
            return Spells.space1;
        }
        return null;
    }

    public String getSpace0()
    {
        return space0;
    }
}
