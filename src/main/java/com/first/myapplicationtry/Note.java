package com.first.myapplicationtry;

public class Note {

    private String title;
    private String date;
    private String description;
    private String address;
    private String phone;

    public Note(){
        //empty constructor
    }

    public Note( String t,String da, String d ,String a, String p ){
        this.title =t;
        this.date = da;
        this.description =d;
        this.address =a;
        this.phone =p;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
