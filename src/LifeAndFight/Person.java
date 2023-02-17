package LifeAndFight;

public class Person {
    private int health;
    private int exp;
    private int damage;

    public Person(int health, int exp, int damage) {
        this.health = health;
        this.exp = exp;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getExp() {
        return exp;
    }

    public void fight(int damage) {
        this.health -= damage;
        if (this.health > 0) {
            this.exp += 10;
        }
    }

    public void treat() {
        this.health += 100;
        System.out.println("Uleczono! Aktualne życie: " + this.health);
    }

    public void viewStatistics() {
        System.out.println("Statystyki:");
        System.out.println("Życie: " + this.health);
        System.out.println("Exp: " + this.exp);
        System.out.println("Obrażenia: " + this.damage);
    }
}
