package functions;

import stats.CharacterStats;
import stats.MonsterStats;

import java.util.Random;

public class Battle
{
    static Functions functions;

    public static void battle(MonsterStats monster) throws InterruptedException
    {
        functions.clearConsole();
        Thread.sleep(500);
        while (monster.mHP > 0 && functions.isCharacterDied() != true)
        {
            functions.tryToEnterCombatOption(monster);
            if(CharacterStats.Character.cHP <= 0)
            {
                functions.hitCharacter(monster);
                break;
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Fight.toUpperCase().hashCode())
            {
                functions.fight(monster);
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Magic.toUpperCase().hashCode())
            {
                functions.Magic(monster);
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Flee.toUpperCase().hashCode())
            {
                if(functions.flee(monster))
                {
                    break;
                }
            }
            Thread.sleep(2000);
            functions.clearConsole();

        }
        if(monster.mHP <= 0)
        {
            System.out.println("You won");
            dropXp(monster);
        }
    }
    public static void dropXp(MonsterStats monster)
    {
        Random random = new Random();
        int Xp = random.nextInt(monster.maxXpDrop);
        CharacterStats.Character.currentXp = CharacterStats.Character.currentXp + Xp;
        System.out.println("You gained " + Xp + " Xp");
        int cXP = CharacterStats.Character.currentXp;
        System.out.println("Your current Xp is: " + cXP + " Xp");
        if(cXP >= CharacterStats.Character.level1)
        {
            System.out.println("Your are now level 2");
            CharacterStats.Character.currentLevel = "Level 2";
        }
        if(cXP >= CharacterStats.Character.level2)
        {
            System.out.println("Your are now level 3");
            CharacterStats.Character.currentLevel = "Level 3";
        }
        if(cXP >= CharacterStats.Character.level3)
        {
            System.out.println("Your are now level 4");
            CharacterStats.Character.currentLevel = "Level 4";
        }
        if(cXP >= CharacterStats.Character.level4)
        {
            System.out.println("Your are now level 5");
            CharacterStats.Character.currentLevel = "Level 5";
        }
        if(cXP >= CharacterStats.Character.level5)
        {
            System.out.println("Your are now level 6");
            CharacterStats.Character.currentLevel = "Level 6";
        }
        if(cXP >= CharacterStats.Character.level6)
        {
            System.out.println("Your are now level 7");
            CharacterStats.Character.currentLevel = "Level 7";
        }
        if(cXP >= CharacterStats.Character.level7)
        {
            System.out.println("Your are now level 8");
            CharacterStats.Character.currentLevel = "Level 8";
        }
        if(cXP >= CharacterStats.Character.level8)
        {
            System.out.println("Your are now level 9");
            CharacterStats.Character.currentLevel = "Level 9";
        }
        if(cXP >= CharacterStats.Character.level9)
        {
            System.out.println("Your are now level 10");
            CharacterStats.Character.currentLevel = "Level 10";
        }
        if(cXP >= CharacterStats.Character.level10)
        {
            System.out.println("Your are now level 11");
            CharacterStats.Character.currentLevel = "Level 11";
        }
        System.out.println(CharacterStats.Character.cName + "'s level: " + CharacterStats.Character.currentLevel);

    }
}
