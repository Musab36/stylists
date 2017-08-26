import java.util.List;
import java.util.ArrayList;

public class Stylist {
  private String mName;
  private String mDescription;
  private static List<Stylist> instances = new ArrayList<Stylist>();
  private int mId;
  private List<Stylist> mStylist;

  public Stylist(String name, String description) {
    mName = name;
    mDescription = description;
    instances.add(this);
    mId = instances.size();
    mStylist = new ArrayList<Stylist>();
  }

  public String getName() {
    return mName;
  }

  public String getDescription() {
    return mDescription;
  }

  public static List<Stylist> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Stylist find(int id) {
    return instances.get(id - 1);
  }

  public List<Stylist> getClients() {
    return mStylist;
  }

  public void addClient(Stylist stylist) {
  mStylist.add(stylist);
}
}