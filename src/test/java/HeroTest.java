import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  @Test
   public void Hero_instantiatesCorrectly() {
   Hero myHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
   assertEquals(true, myHero instanceof Hero);
   }

   @Test
   public void Hero_instantiatesWithDescription_String() {
   Hero myHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
   assertEquals("HumanTorch", myHero.getName());
     }

    @Test
    public void isCompleted_isFalseAfterInstantiation_false() {
    Hero myHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
    assertEquals(false, myHero.isCompleted());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Hero myHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void all_returnsAllInstancesOfHero_true() {
    Hero firstHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
    Hero secondHero = new Hero("InvisibleWoman", 40, "visibility", "Men");
    assertEquals(true, Hero.all().contains(firstHero));
    assertEquals(true, Hero.all().contains(secondHero));
    }

    @Test
    public void clear_emptiesAllHeroesFromArrayList_0() {
    Hero myHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
    Hero.clear();
    assertEquals(Hero.all().size(), 0);
    }

    @Test
    public void getId_heroesInstantiateWithAnID_1() {
    Hero.clear();
    Hero myHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
    assertEquals(1, myHero.getId());
    }

    @Test
    public void find_returnsHeroWithSameId_secondTask() {
    Hero firstHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
    Hero secondHero = new Hero("InvisibleWoman", 40, "visibility", "Men");
    assertEquals(Hero.find(secondHero.getId()), secondHero);
   }
}
