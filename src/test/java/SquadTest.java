import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class SquadTest {

  @Test
    public void all_returnsAllInstancesOfSquad_true() {
     Squad firstSquad = new Squad("Avengers");
     Squad secondSquad = new Squad("Defenders");
     assertEquals(true, Squad.all().contains(firstSquad));
     assertEquals(true, Squad.all().contains(secondSquad));
   }

    @Test
    public void clear_emptiesAllCategoriesFromList_0() {
      Squad testSquad = new Squad("Avengers");
      Squad.clear();
      assertEquals(Squad.all().size(), 0);
    }

    @Test
    public void getId_squadsInstantiateWithAnId_1() {
    Squad.clear();
    Squad testSquad = new Squad("Avengers");
    assertEquals(1, testSquad.getId());
   }

   @Test
   public void find_returnsSquadWithSameId_secondSquad() {
     Squad.clear();
     Squad firstSquad = new Squad("Avengers");
     Squad secondSquad = new Squad("Defenders");
     assertEquals(Squad.find(secondSquad.getId()), secondSquad);
   }

   @Test
   public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
    Squad.clear();
    Squad testSquad = new Squad("Avengers");
    assertEquals(0, testSquad.getHeroes().size());
  }

  @Test
  public void addHero_addsHeroToList_true() {
    Squad testSquad = new Squad("Avengers");
    Hero testHero = new Hero("HumanTorch", 39, "Ignitefire", "Girls");
    testSquad.addHero(testHero);
    assertTrue(testSquad.getHeroes().contains(testHero));
  }
}
