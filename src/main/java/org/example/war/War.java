package org.example.war;

import org.example.saxon.Saxon;
import org.example.vikins.Viking;

import java.util.ArrayList;
import java.util.Random;

public class War {

    private ArrayList<Viking> vikingArmy;
    private ArrayList<Saxon> saxonArmy;
    private Random rand = new Random();


    public War() {
        this.vikingArmy = new ArrayList<Viking>();
        this.saxonArmy = new ArrayList<Saxon>();
    }

    public void addViking(Viking viking){
        this.vikingArmy.add(viking);
    }
    public void addSaxon(Saxon saxon){
        this.saxonArmy.add(saxon);
    };
    public String vikingAttack(){
//
        Viking oneRandomViking = vikingArmy.get(rand.nextInt(vikingArmy.size()));
        Saxon oneRandomSaxon = saxonArmy.get(rand.nextInt(saxonArmy.size()));
        int newDamage = oneRandomViking.getStrength();
        oneRandomSaxon.receiveDamage(newDamage);

        if (oneRandomSaxon.getHealth() <=0){
            saxonArmy.remove(oneRandomSaxon);
            return "A Saxon has died in combat";
        }

        return "";
    }
    public String saxonAttack(){
        Viking oneRandomViking = vikingArmy.get(rand.nextInt(vikingArmy.size()));
        Saxon oneRandomSaxon = saxonArmy.get(rand.nextInt(saxonArmy.size()));
        int newDamage = oneRandomSaxon.getStrength();
        oneRandomViking.receiveDamage(newDamage);

        if (oneRandomViking.getHealth() <=0){
            vikingArmy.remove(oneRandomViking);
            return oneRandomViking.getName() + " has died in act of combat";
        } return oneRandomViking.getName() + "has received" + oneRandomSaxon.getStrength() + "points of damage";
    }
    public void showStatus(){};

    public ArrayList<Viking> getVikingArmy() {
        return vikingArmy;
    }

    public void setVikingArmy(ArrayList<Viking> vikingArmy) {
        this.vikingArmy = vikingArmy;
    }

    public ArrayList<Saxon> getSaxonArmy() {
        return saxonArmy;
    }

    public void setSaxonArmy(ArrayList<Saxon> saxonArmy) {
        this.saxonArmy = saxonArmy;
    }
    public Saxon returnRandomSaxon() {
        Random rand = new Random();
        return saxonArmy.get(rand.nextInt(saxonArmy.size()));
    }
    public Viking returnRandomViking() {
        Random rand = new Random();
        return vikingArmy.get(rand.nextInt(vikingArmy.size()));
    }
}
