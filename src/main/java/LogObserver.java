public class LogObserver implements Observer {
    private String lastLog;

    @Override
    public void update(Character character) {
        lastLog = "Log: Personagem atualizou status - Vida: " + character.getHealth() +
                ", Mana: " + character.getMana() +
                ", Envenenado: " + character.isPoisoned();
    }

    public String getLastLog() {
        return lastLog;
    }
}
