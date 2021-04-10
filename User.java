package edu.tarleton.apartmentviewer;

import java.util.ArrayList;

public class User {
    private final String name;
    private final String email;
    private ArrayList<Property> favorites;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.favorites = new ArrayList<Property>();
    }
    
    public void addFavorite(Property p) {
        //once fully implemented, would need to check that a user is signed in and if not prompt a login/signup
        this.favorites.add(p);
    }
    
    public void printFavorites() {
        int size = this.favorites.size();
        for (int i= 0; i < size; i++) {
            Property p = this.favorites.get(i);
            System.out.println(p.getAddress());
        }
    }
}
