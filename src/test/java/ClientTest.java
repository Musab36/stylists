import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Test
  public void client_instantiatesCorrectly_true() {
    Client myClient = new Client("Ashley", "Best client");
    assertEquals(true, myClient instanceof Client);
  }
      

  @Test
  public void all_returnsAllInstancesOfClients_true() {
      Client firstClient = new Client("Ashley", "Best client");
      Client secondClient = new Client("Zahra", "Good client");
      assertEquals(true, Client.all().contains(firstClient));
      assertEquals(true, Client.all().contains(secondClient));
    }
 
  @Test
  public void getId_clientsInstantiateWithId_1() {
  	Client.clear();
  	Client myClient = new Client("Ashley", "Best client");
  	assertEquals(1, myClient.getId());
  }

 @Test
  public void find_returnClientWithSameId_secondClient() {
      Client firstClient = new Client("Ashley", "Best client");
      Client secondClient = new Client("Zahra", "Good client");
      assertEquals(Client.find(secondClient.getId()),secondClient);
      }

}	