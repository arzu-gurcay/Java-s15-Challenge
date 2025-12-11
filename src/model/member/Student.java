package model.member;

public class Student extends MemberRecord{
    public Student(int memberId, String name, String type) {
        super(memberId, name, "Student");
    }
}
