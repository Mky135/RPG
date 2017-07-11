package totalItems;

public enum TotalMpPotions
{
    simpleHp("Simple HP Potion",20,2,1);

    public String name;
    public int amount;
    public int cost;
    public int totalMpPower;
    TotalMpPotions(String name,int amount, int cost, int totalMpPower)
    {
     this.name = name;
     this.amount = amount;
     this.cost = cost;
     this.totalMpPower = totalMpPower;
    }
    public static TotalMpPotions getPotion(int index)
    {
        return TotalMpPotions.values()[index];
    }

}
