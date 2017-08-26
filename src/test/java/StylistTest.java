import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Stylists");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_s() {
    Stylist testStylist = new Stylist("Stylists");
    assertEquals("Stylists", testStylist.getName());
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Stylists");
    Stylist secondStylist = new Stylist("Stylist");
    assertEquals(true, Stylist.all().contains(firstStylist));
    assertEquals(true, Stylist.all().contains(secondStylist));
  }

  @Test
  public void clear_emptiesAllStylistsFromList_0() {
    Stylist testStylist = new Stylist("stylist");
    Stylist.clear();
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void getId_stylistsInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Stylists");
    assertEquals(1, testStylist.getId());
  }

  @Test
  public void find_returnsStylistsWithSameId_secondStylist() {
    Stylist.clear();
    Stylist firstStylist = new Stylist("Stylists");
    Category secondStylist = new Stylist("Stylists");
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
public void getClients_initiallyReturnsEmptyList_ArrayList() {
  Stylist.clear();
  Stylist testStylist = new Stylist("Stylists");
  assertEquals(0, testStylist.getClients().size());
}

@Test
public void addClient_addsClientToList_true() {
  Stylist testStylist = new Stylist("Stylists");
  Client testClient = new Client("Clients", "Best clients");
  testStylist.addClient(testClient);
  assertTrue(testStylist.getClients().contains(testClient));
}
}