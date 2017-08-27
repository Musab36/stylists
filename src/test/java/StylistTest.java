import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Stylists", "Best");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_s() {
    Stylist testStylist = new Stylist("Stylists", "Best");
    assertEquals("Stylists", testStylist.getName());
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Stylists", "Best");
    Stylist secondStylist = new Stylist("Stylist", "Best");
    assertEquals(true, Stylist.all().contains(firstStylist));
    assertEquals(true, Stylist.all().contains(secondStylist));
  }

  @Test
  public void clear_emptiesAllStylistsFromList_0() {
    Stylist testStylist = new Stylist("stylist", "Best");
    Stylist.clear();
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void getId_stylistsInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Stylists", "Best");
    assertEquals(1, testStylist.getId());
  }

  @Test
  public void find_returnsStylistsWithSameId_secondStylist() {
    Stylist.clear();
    Stylist firstStylist = new Stylist("Stylists", "Best");
    Stylist secondStylist = new Stylist("Stylists", "Best");
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
public void getClients_initiallyReturnsEmptyList_ArrayList() {
  Stylist.clear();
  Stylist testStylist = new Stylist("Stylists", "Best");
  assertEquals(0, testStylist.getClients().size());
}

@Test
public void addClient_addsClientToList_true() {
  Stylist testStylist = new Stylist("Stylists", "Best");
  Client testClient = new Client("Clients", "Best clients");
  testStylist.addClient(testStylist);
  assertTrue(testStylist.getClients().contains(testClient));
}
}