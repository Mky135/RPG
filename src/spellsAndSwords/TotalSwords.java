package spellsAndSwords;

public enum TotalSwords
{
    LongSword(3, 15, "Long Sword"),
    ShortSword(2, 10, "Short Sword");


    public int swordDamage;
    public int swordCost;
    public String name;

    TotalSwords(int damage , int cost, String name)
    {
        swordDamage = damage;
        swordCost = cost;
        this.name = name;
    }
    public static TotalSwords fromInteger(int x) {
        switch(x) {
            case 0:
                return ShortSword;
            case 1:
                return LongSword;
        }
        return null;
    }
    public static int returnDamage(int x)
    {
        if(TotalSwords.fromInteger(x) != null)
        {
            return TotalSwords.fromInteger(x).swordDamage;
        }
        return 0;
    }
    public TotalSwords getAllStrings()
    {
        for(int i = 0; i < 10; i++)
        {
            return fromInteger(i);
        }
        return null;
    }
}
