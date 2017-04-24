package Inventory;

import spellsAndSwords.TotalSwords;

import java.util.stream.Stream;

public enum SwordsInventory
{
    SWORDS(TotalSwords.ShortSword.name, "", "", "", "", "", "", "","", "");
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
    public static SwordsInventory[] value;
    public static String blank = "";

    SwordsInventory(String item0 ,String item1, String item2, String item3, String item4, String item5, String item6, String item7, String item8, String item9)
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
//                if(SWORDS.space0.hashCode() != blank.hashCode())
//                {
                    return SWORDS.space0;
//                }
            case 1:
                return SWORDS.space1;
            case 2:
                return SWORDS.space2;
            case 3:
                return SWORDS.space3;
            case 4:
                return SWORDS.space4;
            case 5:
                return SWORDS.space5;
            case 6:
                return SWORDS.space6;
            case 7:
                return SWORDS.space7;
            case 8:
                return SWORDS.space8;
            case 9:
                return SWORDS.space9;
        }
        return null;
    }


    public String getAllStrings()
    {
        for(int i = 0; i < 10; i++)
        {
            return fromInteger(i).toString();
        }
        return null;
    }
}
