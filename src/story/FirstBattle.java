package story;

import functions.Functions;
import stats.CharacterStats;
import story.intro;
import stats.MonsterStats;

public class FirstBattle
{
    static Functions functions;
    static intro intro;
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException
    {
        MonsterStats monster;
        monster = MonsterStats.Troll;
        intro.intro();
        functions.battle(monster);
    }
}
