public class AchievementObserver implements Observer {
    private boolean achievementUnlocked = false;
    private String lastAchievement;

    @Override
    public void update(Character character) {
        if (character.getHealth() == 100 && character.getMana() == 50 && !achievementUnlocked) {
            achievementUnlocked = true;
            lastAchievement = "Achievement desbloqueado: Personagem perfeito!";
        }
    }

    public boolean isAchievementUnlocked() {
        return achievementUnlocked;
    }

    public String getLastAchievement() {
        return lastAchievement;
    }
}
