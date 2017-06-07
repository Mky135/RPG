package totalItems;

public enum TotalMpPotions
{
    simpleHp("Simple HP Potion",20,2,1);

    public String name;
    public int amount;
    public int cost;
    public int totalHpPower;
    TotalMpPotions(String name,int amount, int cost, int totalHpPower)
    {
     this.name = name;
     this.amount = amount;
     this.cost = cost;
     this.totalHpPower = totalHpPower;
    }

}
