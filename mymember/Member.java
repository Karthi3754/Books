package mymember;

public class Member {
    public String name, memberId;

    public Member(String n, String i) {
        name = n;
        memberId = i;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}

