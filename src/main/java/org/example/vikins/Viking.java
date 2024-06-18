package org.example.vikins;

import org.example.soldier.Soldier;

public class Viking extends Soldier {
    String name = "Harald";
    private String msg = "";

    public Viking( String name, int strength, int health, String msg) {
        super(health, strength);
        this.name = name;
    }

    public void receiveDamage(int damage){
        this.health -= damage;
        if (this.health >=1){
            this.msg = this.name + " has received " +damage+ " points of damage";
        }else {
            this.msg = this.name + " has died in act of combat";
        }

    }
    public String battleCry(){
        return "Odin Owns You All!";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStrength() {
    return this.strength;}

    public String getName() {
        return name;
    }
}
