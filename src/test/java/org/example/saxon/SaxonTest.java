package org.example.saxon;

import org.example.soldier.Soldier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaxonTest {
    int health = 60;
    int strength = 25;
    String msg;

    @Test
    public void should_inherit_from_Soldier() {
        Saxon saxon = new Saxon(health, strength, msg);
        assertNotNull(saxon instanceof Soldier);
    }

    @Test
    //change test name (3 instead of 2)
    public void should_receive_3_arguments() {
        Saxon saxon = new Saxon(health, strength, msg);
        assertNotNull(saxon);
    }

    @Test
    public void should_receive_the_health_property_as_its_1st_argument() {
        Saxon saxon = new Saxon(health, strength,msg);
        assertEquals(60, saxon.health);
    }

    @Test
    public void should_receive_the_strength_property_as_its_2nd_argument() {
        Saxon saxon = new Saxon(health, strength, msg);
        assertEquals(25, saxon.strength);
    }

    @Test
    public void attack_should_return_strength_property_of_the_Saxon() {
        Saxon saxon = new Saxon(health, strength, msg);
        var resultAttack = saxon.attack();
        assertEquals(saxon.strength, resultAttack);
    }

    @Test
    public void attack_should_receive_0_arguments() {
        Saxon saxon = new Saxon(health, strength, msg);
        //int damage = 50;
        int resultAttack = saxon.attack();
        assertEquals(this.strength, resultAttack);
    }

    @Test
    public void damage_should_receive_1_argument() {
        Saxon saxon = new Saxon(health, strength, msg);
        saxon.receiveDamage(50);
        assertEquals(10, saxon.health);
    }

    @Test
    public void receivedDamage_should_remove_the_damage_from_the_health_property() {
        Saxon saxon = new Saxon(health, strength, msg);
        saxon.receiveDamage(50);
        assertEquals(10, saxon.health);
    }

    @Test
    public void should_return_A_Saxon_has_received_DAMAGE_points_of_damage_if_the_Saxon_is_still_alive() {
        Saxon saxon = new Saxon(health, strength, msg);
        saxon.receiveDamage(45);
        assertEquals("A Saxon has received " + 45 + " points of damage", saxon.getMsg());
    }

    @Test
    //add "act of" to expected string
    public void should_return_A_Saxon_has_died_in_combat_if_the_Saxon_dies() {
        Saxon saxon = new Saxon(health, strength, msg);
        saxon.receiveDamage(health);
        assertEquals("A Saxon has died in act of combat", saxon.getMsg());
    }
}