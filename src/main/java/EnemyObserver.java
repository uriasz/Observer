public class EnemyObserver implements Observer {
    private String lastAction;

    @Override
    public void update(Character character) {
        if (character.getHealth() < 30) {
            lastAction = "Inimigo foge! Personagem está fraco.";
        } else {
            lastAction = "Inimigo ataca normalmente.";
        }
    }

    public String getLastAction() {
        return lastAction;
    }
}
