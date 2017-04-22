package stats;

public enum CharacterStats
{
    Character(10, 5, 2, 3, 2, 1, 2, 1, "" , 0, 0, 0, "Level 1");
    public int cHP = 0;
    public int cMP = 0;
    public int cMDamage = 0;
    public int cDamage = 0;
    public int cSpeed = 0;
    public int cMSpeed = 0;
    public int cSpell  = 0;
    public int magicRest = 0;
    public int meleeRest = 0;
    public int intelligence = 0;
    public String cName = "";
    public int currentXp = 0;
    public String currentLevel = "Level 1";
    public int level1 = 10; //Xp need to pass the level
    public int level2 = 25;
    public int level3 = 60;
    public int level4 = 110;
    public int level5 = 187;
    public int level6 = 225;
    public int level7 = 300;
    public int level8 = 375;
    public int level9 = 450;
    public int level10 = 750;

    CharacterStats(int Hp, int Mp, int damage, int mDamage, int Speed, int mSpeed, int intelligence, int spell, String name , int magicRest, int meleeRest , int currentXp, String currentLevel)
    {
        cHP = Hp;
        cMP = Mp;
        cDamage = damage;
        cMDamage = mDamage;
        cSpeed = Speed;
        cMSpeed = mSpeed;
        this.intelligence = intelligence;
        cSpell = spell;
        cName = name;
        this.magicRest = magicRest;
        this.meleeRest = meleeRest;
        this.currentXp = currentXp;
        this.currentLevel = currentLevel;
    }
}
