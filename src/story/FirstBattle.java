package story;

import functions.Functions;
import stats.CharacterStats;
import story.intro;
import functions.Battle;
import stats.MonsterStats;

public class FirstBattle
{
    static Functions functions;
    static  Battle battle;
    static intro intro;
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException
    {
        MonsterStats monster;
        monster = MonsterStats.Troll;
        intro.intro();
        battle.battle(monster);
    }
}
