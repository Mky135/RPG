package battles;

import functions.Battle;
import functions.Functions;
import stats.MonsterStats;
import story.intro;

public class BossBattle
{

    static Functions functions;
    static Battle battle;
    static story.intro intro;
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException
    {
        MonsterStats monster;
        monster = MonsterStats.Boss;
        intro.intro();
        battle.battle(monster);
    }
}