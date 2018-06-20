package Inheritance;

public abstract class Animal {
    private boolean dead = false;

    public void die() {
        this.dead = true;
    }

    public void act() {
        if (!dead) {
            performActions();
        }
    }

    protected abstract void performActions();
}
