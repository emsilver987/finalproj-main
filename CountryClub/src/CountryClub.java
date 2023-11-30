import Models.Gym;
import Models.Member;
import Models.Pool;
import Models.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class CountryClub implements Serializable {
    public Gym gym;
    public Pool pool;
    public Restaurant restaurant;
    public List<Member> Members = new ArrayList<Member>();
    public Object Restaurant;
    private static final long serialVersionUID = 0;
    public CountryClub(){
        gym = new Gym(10);
        pool = new Pool(20);
        restaurant = new Restaurant(30);
    }
    public void Serialize() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CountryClubCheckinState"));
        out.writeObject(this);
        out.flush();
        out.close();
    }

    public static CountryClub Deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("CountryClubCheckinState");
        if (f.exists() && !f.isDirectory()) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("CountryClubCheckinState"));
            final CountryClub restored = (CountryClub) in.readObject();
            in.close();
            return restored;
        }
        return null;

    }
}
