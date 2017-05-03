package stats;

public enum MonsterStats
{
    Troll(5, 3, 1, 1 , "Melee" , 10, 20),
    Boss(9999, 1234, 123456, 123456 , "Magic" , 10, 98989898);

    public int mHP = 0;
    public int mStrength = 0;
    public int mSpeed = 0;
    public int intelligence = 0;
    public String typeOfDamage;
    public int maxXpDrop = 0;
    public int max$Drop = 0;

    MonsterStats(int Hp, int Strength, int Speed, int intelligence, String typeOfDamage, int maxXpDrop, int max$Drop)
    {
        mHP = Hp;
        mStrength = Strength;
        mSpeed = Speed;  
        this.intelligence = intelligence;
        this.typeOfDamage = typeOfDamage;
        this.maxXpDrop = maxXpDrop;
        this.max$Drop = max$Drop;
    }
}
