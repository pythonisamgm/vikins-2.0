package org.example.saxon;

import org.example.soldier.Soldier;

public class Saxon extends Soldier {

    private String msg;

    public Saxon(int health, int strength, String msg) {
        super(health, strength);
    }

    public void receiveDamage(int damage){
        this.health -= damage;
        if (this.health >=1){
            this.msg = "A Saxon has received " +damage+ " points of damage";
        }else {
            this.msg = "A Saxon has died in act of combat";
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



}
