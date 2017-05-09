package battles;

import functions.Battle;
import functions.Functions;
import stats.MonsterStats;

public class GoblinBattle
{
    static Functions functions;
    static Battle battle;
    static story.intro intro;
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException
    {
        goblinBattle();
    }
    public static void goblinBattle()throws InterruptedException
    {
        MonsterStats monster;
        monster = MonsterStats.Goblin;
        battle.battle(monster);
    }
}
