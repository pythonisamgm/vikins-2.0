package org.example.soldier;

public class Soldier {
    public int strength = 150;
    public int health = 300;
    public int damage;


    public Soldier(int health,int strength) {
        this.strength = strength;
        this.health = health;
        this.damage = strength;

    }

    public int attack(){
        return this.strength;
    }
    public void receiveDamage(int damage){
        this.health -= damage;

    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
