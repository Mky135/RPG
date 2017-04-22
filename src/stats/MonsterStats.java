package stats;

public enum MonsterStats
{
    Troll(5, 1, 1, 1), 
    Boss(9999, 1234, 123456, 123456);

    public int mHP = 0;
    public int mStrength = 0;
    public int mSpeed = 0;
    public int intelligence = 0;

    MonsterStats(int Hp, int Strength, int Speed, int intelligence)
    {
        mHP = Hp;
        mStrength = Strength;
        mSpeed = Speed;  
        this.intelligence = intelligence;
    }
}
