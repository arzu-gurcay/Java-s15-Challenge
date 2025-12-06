package model.member;

import java.time.LocalDate;

public class MemberRecord {
    private int id;
    private String type;
    private LocalDate dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit = 5 ;
    private String name;
    private String address;
    private String phoneNo;

    public MemberRecord(int id, String name, String type, LocalDate dateOfMembership, int noBooksIssued) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateOfMembership = LocalDate.now();
        this.noBooksIssued = 0;

    }

    public MemberRecord(int id, String name, String type) {
    }

    public String getMember(){
        return "[" + id + "] " + name + " (" + type + ")";
    }

    public void incBookIssued(){
        noBooksIssued++;
    }

    public void decBookIssued(){
        if(noBooksIssued>0){
            noBooksIssued--;
        }
    }

    public void payBill(){
        System.out.println(name + " paid.");
    }
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
