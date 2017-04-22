package stats;

public enum CharacterStats
{
    Character(10, 5, 3, 2, 2, 1, 2, "");
    public int cHP = 0;
    public int cMP = 0;
    public int cMDamage = 0;
    public int cDamage = 0;
    public int cSpeed = 0;
    public int cMSpeed = 0;
    public int intelligence = 0;
    public String cName = "";

    CharacterStats(int Hp, int Mp, int damage, int mDamage, int Speed, int mSpeed, int intelligence, String name)
    {
        cHP = Hp;
        cMP = Mp;
        cDamage = damage;
        cDamage = mDamage;
        cSpeed = Speed;
        cMSpeed = mSpeed;
        this.intelligence = intelligence;
        cName = name;
    }
}
