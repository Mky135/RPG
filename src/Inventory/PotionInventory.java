package Inventory;

import totalItems.TotalPotions;

public enum PotionInventory
{
    Space0(TotalPotions.simplePotion.name, 0, true),
    Space1("empty",1,false),
    Space2("empty",2,false),
    Space3("empty",3,false),
    Space4("empty",4,false),
    Space5("empty",5,false),
    Space6("empty",6,false),
    Space7("empty",7,false),
    Space8("empty",8,false),
    Space9(TotalPotions.bread.name,9,false);

    public String item;
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
    public boolean equiped;
    PotionInventory(String item, int x, boolean equiped)
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
    public static PotionInventory getPotionInInventory(int i)
    {
        return PotionInventory.values()[i];
    }


}
