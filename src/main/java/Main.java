import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> runDemo() {
        List<String> logs = new ArrayList<>();

        Character hero = new Character();

        UIObserver ui = new UIObserver();
        LogObserver log = new LogObserver();
        EnemyObserver enemy = new EnemyObserver();
        AchievementObserver achievement = new AchievementObserver();

        hero.registerObserver(ui);
        hero.registerObserver(log);
        hero.registerObserver(enemy);
        hero.registerObserver(achievement);

        // Estado inicial
        hero.notifyObservers();
        logs.add(ui.getLastUpdate());
        logs.add(log.getLastLog());
        logs.add(enemy.getLastAction());
        if (achievement.isAchievementUnlocked()) {
            logs.add(achievement.getLastAchievement());
        }

        // Dano
        hero.takeDamage(75);
        logs.add(ui.getLastUpdate());
        logs.add(log.getLastLog());
        logs.add(enemy.getLastAction());
        if (achievement.isAchievementUnlocked()) {
            logs.add(achievement.getLastAchievement());
        }

        // Cura e mana
        hero.heal(30);
        hero.useMana(10);
        logs.add(ui.getLastUpdate());
        logs.add(log.getLastLog());
        logs.add(enemy.getLastAction());
        if (achievement.isAchievementUnlocked()) {
            logs.add(achievement.getLastAchievement());
        }

        // Envenenado
        hero.setPoisoned(true);
        logs.add(ui.getLastUpdate());
        logs.add(log.getLastLog());
        logs.add(enemy.getLastAction());
        if (achievement.isAchievementUnlocked()) {
            logs.add(achievement.getLastAchievement());
        }

        return logs;
    }
}
