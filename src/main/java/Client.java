import java.util.ArrayList;
public class Client {
private String mName;
private String mDescription;
private static ArrayList<Client> instances = new ArrayList<Client>();
private int mId;

  public Client(String name, String description) {
  	mName = name;
    mDescription = description;
  	instances.add(this);
  	mId = instances.size();
  }

  public String getName() {
  	return mName;
  }

  public String getDescription() {
    return mDescription;
  }

  public static ArrayList<Client> all() {
  	return instances;
  }

  public static void clear() {
  	instances.clear();
  }

  public int getId() {
  	return mId;
  }

  public static Client find(int id) {
  	return instances.get(id - 1);
  }

}