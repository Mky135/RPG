package Inventory;

import totalItems.TotalSpells;

public enum SpellsInventory
{
    Space0(0, "empty", false),
    Space1(1, "empty", false),
    Space2(2, "empty", false),
    Space3(3, "empty", false),
    Space4(4, "empty", false),
    Space5(5, "empty", false),
    Space6(6, "empty", false),
    Space7(7, "empty", false),
    Space8(8, "empty", false),
    Space9(9, TotalSpells.FireSpell.name, true);
    String item;
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
    boolean equiped;
    SpellsInventory(int x, String item, boolean equiped)
    {
        this.item = item;
        if(x == 0)
        {
            space0 = item;
        } else if(x == 1)
        {
            space1 = item;
        } else if(x == 2)
        {
            space2 = item;
        } else if(x == 3)
        {
            space3 = item;
        } else if(x == 4)
        {
            space4 = item;
        } else if(x == 5)
        {
            space5 = item;
        } else if(x == 6)
        {
            space6 = item;
        } else if(x == 7)
        {
            space7 = item;
        } else if(x == 8)
        {
            space8 = item;
        } else
        {
            space9 = item;
        }
        this.equiped = equiped;
    }
    public static SpellsInventory getSpellInInvetory(int i)
    {
        return SpellsInventory.values()[i];
    }
}