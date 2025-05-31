import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterObserverTest {

    private Character hero;
    private UIObserver ui;
    private LogObserver log;
    private EnemyObserver enemy;
    private AchievementObserver achievement;

    @BeforeEach
    public void setup() {
        hero = new Character();
        ui = new UIObserver();
        log = new LogObserver();
        enemy = new EnemyObserver();
        achievement = new AchievementObserver();

        hero.registerObserver(ui);
        hero.registerObserver(log);
        hero.registerObserver(enemy);
        hero.registerObserver(achievement);
    }

    @Test
    public void testInitialNotification() {
        hero.notifyObservers();

        assertEquals("UI Atualizada: Vida=100, Mana=50, Envenenado=false", ui.getLastUpdate());
        assertEquals("Log: Personagem atualizou status - Vida: 100, Mana: 50, Envenenado: false", log.getLastLog());
        assertEquals("Inimigo ataca normalmente.", enemy.getLastAction());
        assertFalse(achievement.isAchievementUnlocked());
    }

    @Test
    public void testDamageNotification() {
        hero.takeDamage(80);

        assertEquals(20, hero.getHealth());
        assertEquals("UI Atualizada: Vida=20, Mana=50, Envenenado=false", ui.getLastUpdate());
        assertEquals("Log: Personagem atualizou status - Vida: 20, Mana: 50, Envenenado: false", log.getLastLog());
        assertEquals("Inimigo foge! Personagem está fraco.", enemy.getLastAction());
        assertFalse(achievement.isAchievementUnlocked());
    }

    @Test
    public void testHealAndManaUsage() {
        hero.takeDamage(20);
        hero.heal(10);
        hero.useMana(5);

        assertEquals(90, hero.getHealth());
        assertEquals(45, hero.getMana());
        assertEquals("UI Atualizada: Vida=90, Mana=45, Envenenado=false", ui.getLastUpdate());
        assertEquals("Log: Personagem atualizou status - Vida: 90, Mana: 45, Envenenado: false", log.getLastLog());
        assertEquals("Inimigo ataca normalmente.", enemy.getLastAction());
    }

    @Test
    public void testPoisonedStatus() {
        hero.setPoisoned(true);

        assertTrue(hero.isPoisoned());
        assertEquals("UI Atualizada: Vida=100, Mana=50, Envenenado=true", ui.getLastUpdate());
        assertEquals("Log: Personagem atualizou status - Vida: 100, Mana: 50, Envenenado: true", log.getLastLog());
        assertEquals("Inimigo ataca normalmente.", enemy.getLastAction());
    }

    @Test
    public void testAchievementUnlock() {
        // Já começa com vida 100 e mana 50, então notifica e desbloqueia achievement
        hero.notifyObservers();
        assertTrue(achievement.isAchievementUnlocked());
        assertEquals("Achievement desbloqueado: Personagem perfeito!", achievement.getLastAchievement());
    }
}
