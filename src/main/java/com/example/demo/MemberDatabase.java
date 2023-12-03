import java.io.*;
import java.util.HashMap;

public class MemberDatabase{

    private HashMap<String, Member> members;

    public MemberDatabase() {
        members = new HashMap<String, Member>();
    }

    public void addMember(Member member) {
        members.put(member.getNumber(), member);
    }

    public void removeMember(Member member) {
        members.remove(member.getNumber());
    }

    public Member getMember(String number) {
        return members.get(number);
    }

    public HashMap<String, Member> getMembers() {
            return members;
    }

    public void printMembers() {
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }

    public Member getMemberByName(String name) {
        for (Member member : members.values()) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void printMemberByName(String name) {
        Member member = getMemberByName(name);
        if (member == null) {
            System.out.println("Member not found");
        } else {
            System.out.println(member);
        }
    }

    public void printMemberByNumber(String number) {
        Member member = getMember(number);
        if (member == null) {
            System.out.println("Member not found");
        } else {
            System.out.println(member);
        }
    }

    public Member getMemberById(String memberId) {
        return members.get(memberId);
    }

    public void updateMember(Member member) {
        members.put(member.getNumber(), member);
    }

    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    public boolean containsMember(String number) {
        return members.containsKey(number);
    }

    public int getNumberOfMembers() {
        return members.size();
    }

    public void saveMembersData() {
        try {
            FileOutputStream fileOut = new FileOutputStream("members.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(members);
            out.close();
            fileOut.close();
        } 
        catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadMembersData() {
        try {
            FileInputStream fileIn = new FileInputStream("members.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            members = (HashMap) in.readObject();
            in.close();
            fileIn.close();
        } 
        catch (IOException i) {
            System.out.println("File not found");
            i.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
}
