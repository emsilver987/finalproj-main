package Models;


import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    private int num;
    private String name;

    public Member(int num, String name){
        this.name = name;
        this.num = num;
    }
    
    public int getNumber() {
            return num;
    }
    
    public String getName() {
            return name;
    }
}

