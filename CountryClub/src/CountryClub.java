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
    private static final long serialVersionUID = 1L;
    
    public Gym gym;
    public Pool pool;
    public Restaurant restaurant;
    public List<Member> Members = new ArrayList<Member>();
    public CountryClub(){
        gym = new Gym(10);
        pool = new Pool(20);
        restaurant = new Restaurant(30);
    }
    public void Serialize() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CountryClubState"));
        out.writeObject(this);
        out.flush();
        out.close();
    }

    public static CountryClub DeserializeOwner() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("CountryClubState");
        if (f.exists() && !f.isDirectory()) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("CountryClubState"));
            final CountryClub restoredOwner = (CountryClub) in.readObject();
            in.close();
            return restoredOwner;
        }
        return null;

    }
}
