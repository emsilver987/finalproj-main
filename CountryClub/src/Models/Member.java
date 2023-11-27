package Models;

import java.util.Date;

public class Member {
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

