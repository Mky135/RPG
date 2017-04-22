package story;

import functions.Functions;
import story.intro;
import stats.MonsterStats;

public class FirstBattle
{
    static Functions functions;
    static intro intro;
    @SuppressWarnings("static-access")
    public static void main(String[] args)
    {
        MonsterStats monster;
        monster = MonsterStats.Boss;
        intro.main(args);
        while (monster.mHP >= 0)
        {
            functions.tryToEnterCombatOption(monster);
            if (functions.Choice.toUpperCase().hashCode() == functions.Fight.toUpperCase().hashCode())
            {
                functions.fight(monster);
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Magic.toUpperCase().hashCode())
            {
                functions.Magic(monster);
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Flee.toUpperCase().hashCode())
            {
                if(functions.flee(monster) == true)
                {
                    break;
                }
            }
            
        }
        System.out.println("You won");
    }
}
