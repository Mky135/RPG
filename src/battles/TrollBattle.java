package battles;

import functions.Functions;
import story.intro;
import functions.Battle;
import stats.MonsterStats;

public class TrollBattle
{
    static Functions functions;
    static  Battle battle;
    static intro intro;
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException
    {
        MonsterStats monster;
        monster = MonsterStats.Troll;
        battle.battle(monster);
    }
}
