package edu.tarleton.apartmentviewer;

public class Property {
    private String address;
    //private String city;
    //private String state;
    private String location;
    private int rent;
    private boolean allowsDogs;
    private boolean allowsCats;
    private double sqft;
    private String type;
    private int beds;
    private double bath;
    private int houseCounter = 0;
    private String html;

    public Property(String address, String location, int rent, boolean allowsDogs, boolean allowsCats, double sqft, String type, int beds, double bath, String html) {
        this.address = address;
        this.location = location;
        this.rent = rent;
        this.allowsDogs = allowsDogs;
        this.allowsCats = allowsCats;
        this.sqft = sqft;
        this.type = type;
        this.beds = beds;
        this.bath = bath;
        this.houseCounter = houseCounter++;
        this.html = html;
    }
    
    //when add a property for company use case, need to have method that checks to make sure it's not already there

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public int getRent() {
        return rent;
    }

    public boolean isAllowsDogs() {
        return allowsDogs;
    }

    public boolean isAllowsCats() {
        return allowsCats;
    }

    public double getSqft() {
        return sqft;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public double getBath() {
        return bath;
    }

    public int getHouseCounter() {
        return houseCounter;
    }
}
