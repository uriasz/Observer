public class UIObserver implements Observer {
    private String lastUpdate;

    @Override
    public void update(Character character) {
        lastUpdate = "UI Atualizada: Vida=" + character.getHealth() +
                ", Mana=" + character.getMana() +
                ", Envenenado=" + character.isPoisoned();
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
