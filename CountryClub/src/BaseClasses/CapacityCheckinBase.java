package BaseClasses;

import Models.Member;
import Interfaces.ICheckin;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CapacityCheckinBase implements ICheckin, Serializable {
    private int currentCapacity = 0;
    private int maxCapacity = 10;
    private List<Member> checkedInMembers = new ArrayList<>();

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        CapacityCheckinBase previousState = Deserialize();
        if (previousState != null) {
            this.checkedInMembers = previousState.checkedInMembers;
            this.currentCapacity = previousState.currentCapacity;
        }
    }

    @Override
    public void Checkin(Member member) {
        if (currentCapacity < maxCapacity) {
            checkedInMembers.add(member);
            currentCapacity++;
            Serialize();
        } else {
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
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CountryClub\\CountryClubCheckinState"))) {
            out.writeObject(this);
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static CapacityCheckinBase Deserialize() {
        File f = new File("CountryClub\\CountryClubCheckinState");
        if (f.exists() && !f.isDirectory()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                Object obj = in.readObject();
                if (obj instanceof CapacityCheckinBase) {
                    return (CapacityCheckinBase) obj;
                } else {
                    System.out.println("Deserialized object is not of type CapacityCheckinBase.");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
