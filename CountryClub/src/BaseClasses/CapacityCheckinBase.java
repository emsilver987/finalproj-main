package BaseClasses;

import Models.Member;
import Interfaces.ICheckin;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CapacityCheckinBase implements ICheckin, Serializable {
    private static final long serialVersionUID = 1L;
    private int currentCapacity = 0;
    private int maxCapacity = 10;
    private List<Member> checkedInMembers = new ArrayList<>();

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void Checkin(Member member) {
        if (currentCapacity < maxCapacity) {
            checkedInMembers.add(member);
            currentCapacity++;
        } else {
            // Handle full capacity scenario
            System.out.println("Capacity is full. Cannot check in more members.");
        }
    }

    protected String ListCheckedInMembers() {
        StringBuilder result = new StringBuilder();
        for (Member member : checkedInMembers) {
            result.append(member.getName()).append("\n");
        }
        return result.toString();
    }

    public void Serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CountryClubCheckinState"))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CapacityCheckinBase Deserialize() {
        File f = new File("CountryClubCheckinState");
        if (f.exists() && !f.isDirectory()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                return (CapacityCheckinBase) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // getter for checkedInMembers if needed
}
