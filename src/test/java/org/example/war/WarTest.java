package org.example.war;

import org.example.saxon.Saxon;
import org.example.vikins.Viking;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static sun.print.ServiceDialog.getMsg;

class WarTest {

    String name = "Harald";
    int strength = 150;
    int health = 300;
    String msg = "";
    public ArrayList<Viking> vikingArmy=new ArrayList<Viking>();;
    public ArrayList<Saxon> saxonArmy=new ArrayList<Saxon>();;



    Saxon saxon = new Saxon(60, 25, "");
    Viking viking = new Viking("Harald", 300, 150, "");

    War war = new War();

    @Test
    public void should_receive_0_arguments() {
        assertNotNull(war);
    }

    @Test
    public void should_assign_an_empty_array_to_the_vikingArmy_property() {
        List<Viking> vikingArmy = war.getVikingArmy();
        assertTrue(vikingArmy.isEmpty());
    }

    @Test
    public void should_assign_an_empty_array_to_the_saxonArmy_property() {
        List<Saxon> saxonArmy = war.getSaxonArmy();
        assertTrue(saxonArmy.isEmpty());
    }

    @Test
    public void add_viking_should_receive_1_argument() {
        war.addViking(viking);
        assertNotNull(war.getVikingArmy());
    }

    @Test
    public void add_viking_should_add_the_received_Viking_to_the_army() {
        war.addViking(viking);
        assertNotNull(war.getVikingArmy());
    }

    @Test
    public void add_saxon_should_add_the_received_Saxon_to_the_army() {
        war.addSaxon(saxon);
        assertNotNull(war.getVikingArmy());
    }

    @Test
    public void vikingAttack_should_make_Saxon_receiveDamage_equal_to_the_strength_of_a_Viking() {
        war.addSaxon(saxon);
        war.addViking(viking);
        int oldHealth = saxon.getHealth();
        war.vikingAttack();
        int actualHealth = oldHealth - viking.getStrength();

        assertEquals(saxon.getHealth(), actualHealth);
    }

    @Test
    public void vikingAttack_should_remove_dead_saxons_from_the_army() {
        war.addSaxon(saxon);
        war.addViking(viking);
        saxon.setHealth(150);
        war.vikingAttack();
        assertTrue(war.getSaxonArmy().isEmpty());
    }

    @Test
    public void vikingAttack_should_return_result_of_calling_receiveDamage_of_a_Saxon_with_the_strength_of_a_Viking() {
        war.addSaxon(saxon);
        war.addViking(viking);
        saxon.setHealth(150);
        String response = war.vikingAttack();
        assertEquals("A Saxon has died in combat", response);
    }
//
    @Test
    public void saxonAttack_should_make_Viking_receiveDamage_equal_to_the_strength_of_a_Viking() {
        war.addSaxon(saxon);
        war.addViking(viking);
        int oldHealth = viking.getHealth();
        int actualHealth = oldHealth - saxon.getStrength();
        war.saxonAttack();
        assertEquals(viking.getHealth(), actualHealth);
    }

    @Test
    public void saxonAttack_should_remove_dead_viking_from_the_army() {
        war.addSaxon(saxon);
        war.addViking(viking);
        viking.setHealth(15);
        war.saxonAttack();
        assertTrue(war.getVikingArmy().isEmpty());
    }

    @Test
    public void saxonAttack_should_return_a_message_with_the_name_of_the_dead_viking() {
        war.addSaxon(saxon);
        war.addViking(viking);
        viking.setHealth(15);
        String response = war.saxonAttack();
        assertEquals(viking.getName() + " has died in act of combat", response);
    }

    @Test
    public void saxonAttack_should_return_result_of_calling_receiveDamage_of_a_Viking_with_the_strength_of_a_Saxon() {
        war.addSaxon(saxon);
        war.addViking(viking);
        String response = war.saxonAttack();
        assertEquals(viking.getName() + "has received" + saxon.getStrength() + "points of damage", response);
    }
}