import java.util.ArrayList;
import java.util.List;

public class Character implements Subject {
    private int health;
    private int mana;
    private boolean poisoned;

    private List<Observer> observers;

    public Character() {
        this.health = 100;
        this.mana = 50;
        this.poisoned = false;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    // Métodos que modificam estado e notificam

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        notifyObservers();
    }

    public void heal(int amount) {
        health += amount;
        if (health > 100) health = 100;
        notifyObservers();
    }

    public void useMana(int amount) {
        mana -= amount;
        if (mana < 0) mana = 0;
        notifyObservers();
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
        notifyObservers();
    }

    // Getters

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public boolean isPoisoned() {
        return poisoned;
    }
}
