package functions;

import Inventory.CheckInventory;
import stats.CharacterStats;
import stats.MonsterStats;

import java.util.Random;

public class Battle
{
    static Functions functions;
    static CheckInventory checkInventory;

    public static void battle(MonsterStats monster) throws InterruptedException
    {
        functions.clearConsole();
        Thread.sleep(1000);


        while (monster.mHP > 0 && functions.isCharacterDied() != true)
        {
            checkInventory.returnWhatIsEquiped();
            functions.tryToEnterCombatOption(monster);
            if(CharacterStats.Character.cHP <= 0)
            {
                functions.hitCharacter(monster);
                Thread.sleep(2000);
                functions.clearConsole();
                break;
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Fight.toUpperCase().hashCode())
            {
                functions.fight(monster);
                Thread.sleep(2000);
                functions.clearConsole();
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Magic.toUpperCase().hashCode())
            {
                functions.Magic(monster);
                Thread.sleep(2000);
                functions.clearConsole();
            }
            else if (functions.Choice.toUpperCase().hashCode() == functions.Flee.toUpperCase().hashCode())
            {
                if(functions.flee(monster))
                {
                    Thread.sleep(2000);
                    functions.clearConsole();
                    break;
                }
            }
            else if(functions.Choice.toUpperCase().hashCode() == functions.Inventory.toUpperCase().hashCode())
            {
                functions.checkInventory();
            }
            else if(functions.Choice.toUpperCase().hashCode() == functions.Equip.toUpperCase().hashCode())
            {
                functions.tryToEquip();
            }



        }
        if(monster.mHP <= 0)
        {
            System.out.println("You won");
            dropXp(monster);
            drop$(monster);
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
        checkIfLevelUp(Xp);
        System.out.println(CharacterStats.Character.cName + "'s level: " + CharacterStats.Character.currentLevel);

    }
    public static void drop$(MonsterStats monster)
    {
        Random random = new Random();
        int cashDroped = random.nextInt(monster.max$Drop);
        CharacterStats.Character.money = CharacterStats.Character.money + cashDroped;
        System.out.println("You gained " + cashDroped + " cash");
        System.out.println("Your current cash: $" + CharacterStats.Character.money);
    }
    public static void levelUp(int level)
    {
        System.out.println("Your are now level " + level);
        CharacterStats.Character.currentLevel = "Level " + level;
        System.out.println("You gained " + level/2 + " upgrade points");
        CharacterStats.Character.upgradePoint = CharacterStats.Character.upgradePoint + level/2;
    }
    public static void checkIfLevelUp(int XP)
    {
        int Level = 0;
        for(int value = 1; value <= 11; value ++)
        {
            if(value == 1) { Level = CharacterStats.Character.level1; } else if(value == 2) { Level = CharacterStats.Character.level2; } else if(value == 3) { Level = CharacterStats.Character.level3; } else if(value == 4) { Level = CharacterStats.Character.level4; } else if(value == 5) { Level = CharacterStats.Character.level5; } else if(value == 6) { Level = CharacterStats.Character.level6; } else if(value == 7) { Level = CharacterStats.Character.level7; } else if(value == 8) { Level = CharacterStats.Character.level8; } else if(value == 9) { Level = CharacterStats.Character.level9; } else if(value == 10) { Level = CharacterStats.Character.level10; } else {levelUp(11);}
            if(XP >= Level)
            {
                levelUp(value);

            } else if(XP <= Level)
            {
                System.out.println("Xp left to level up: " + (Level - XP));
                break;
            }
        }
    }
}
