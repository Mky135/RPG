package stats;

public enum MonsterStats
{
    Troll(5, 1, 1, 1 , "Melee" , 10),
    Boss(9999, 1234, 123456, 123456 , "Magic" , 10);

    public int mHP = 0;
    public int mStrength = 0;
    public int mSpeed = 0;
    public int intelligence = 0;
    public String typeOfDamage;
    public int maxXpDrop = 0;

    MonsterStats(int Hp, int Strength, int Speed, int intelligence, String typeOfDamage, int maxXpDrop)
    {
        mHP = Hp;
        mStrength = Strength;
        mSpeed = Speed;  
        this.intelligence = intelligence;
        this.typeOfDamage = typeOfDamage;
        this.maxXpDrop = maxXpDrop;
    }
}
