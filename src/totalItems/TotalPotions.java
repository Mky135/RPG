package totalItems;

public enum TotalPotions
{
    simplePotion("Simple Potion", 20, 2,5),
    bread("Bread", 50, 1, 1);

    public String name;
    public int amount;
    public int cost;
    public int totalHealingPower;
    TotalPotions(String name, int amount, int cost, int totalHealingPower)
    {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.totalHealingPower = totalHealingPower;
    }
    public static TotalPotions getPotion(int index) {return TotalPotions.values()[index];}

}
