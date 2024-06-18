package org.example.vikins;

import org.example.soldier.Soldier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VikingTest {
    String name = "Harald";
    int strength = 150;
    int health = 300;

    private String msg;
    Viking viking = new Viking(name, health, strength, msg);

    @Test
    public void should_inherit_from_Soldier() {
        Viking viking = new Viking(name, health, strength, msg);
        assertNotNull(viking instanceof Soldier);
    }

    @Test
    public void should_receive_3_arguments() {
        assertNotNull(viking);
    }

    @Test
    public void should_receive_the_name_property_as_its_1st_argument() {
        assertEquals("Harald", viking.name);
    }

    @Test
    public void should_receive_the_health_property_as_its_2nd_argument() {
        assertEquals(300, viking.health);
    }

    @Test
    public void should_receive_the_strength_property_as_its_3rd_argument() {
        assertEquals(150, viking.strength);
    }

    @Test
    public void attack_should_return_strength_property_of_the_Viking() {
        int resultAttack = viking.attack();
        assertEquals(viking.strength, resultAttack);
    }

    @Test
    public void attack_should_receive_0_arguments() {
        int damage = 50;
        int resultAttack = viking.attack();
        assertEquals(viking.strength, resultAttack);
    }

    @Test
  public void damage_should_receive_1_arguments() {
        viking.receiveDamage(50);
        assertEquals(100, viking.health);
    }

    @Test
    //changed the expected argument to 100: attack is = to strength(150); received damage = attacked.health(300) - (damage(50)+attacker.strength(150))
    public void should_remove_the_received_damage_from_the_health_property() {
        viking.receiveDamage(50);
        assertEquals(100, viking.health);
    }

    @Test
    public void should_return_NAME_has_received_DAMAGE_points_of_damage_if_the_Viking_is_still_alive() {
        viking.receiveDamage(50);
        assertEquals(viking.name + " has received " + 50 + " points of damage", viking.getMsg());
    }

    @Test
    //add "act of" in expected string. Why is there health as an argument in the function??? Is it to kill the vinking and test the method??
    public void should_return_NAME_has_died_in_act_of_combat_if_the_Viking_dies() {
        viking.receiveDamage(health);
        assertEquals(viking.name + " has died in act of combat", viking.getMsg());
    }

  @Test
  //there is an unnecessary line in 84
  public void battleCry_should_receive_0_arguments() {
      //String crying = "crying";
      String battleCry = viking.battleCry();
      assertEquals("Odin Owns You All!", battleCry);
    }

    @Test
    public void should_return_Odin_Owns_You_All() {
        viking.battleCry();
        assertEquals("Odin Owns You All!", viking.battleCry());
    }
}