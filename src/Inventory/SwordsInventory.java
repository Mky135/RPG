package Inventory;


import totalItems.TotalSwords;

public enum SwordsInventory
{
    Space0(0, "empty", false),
    Space1(1, TotalSwords.ShortSword.name, true),
    Space2(2, "empty",false),
    Space3(3, "empty", false),
    Space4(4, "empty", false),
    Space5(5, "empty", false),
    Space6(6, "empty", false),
    Space7(7, "empty", false),
    Space8(8, "empty", false),
    Space9(9, "empty", false);
    public String item;
    public String space0;
    public String space1;
    public String space2;
    public String space3;
    public String space4;
    public String space5;
    public String space6;
    public String space7;
    public String space8;
    public String space9;
    boolean equiped;
    SwordsInventory(int x, String item, boolean equiped)
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
    public static SwordsInventory getSwordInInvetory(int i)
    {
        return SwordsInventory.values()[i];
    }
}