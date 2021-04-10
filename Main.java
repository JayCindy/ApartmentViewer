package edu.tarleton.apartmentviewer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Property> prop = new ArrayList<>();
        Property p1 = new Property("791 W Long St", "Stephenville, TX", 2500, true, true, 7832, "House", 4, 4, "https://www.apartmentviewer.com/whatever");
        Property p2 = new Property("345 W Short St", "Stephenville, TX", 2500, false, false, 5678, "House", 5, 3, "https://whatever");
        prop.add(p1);
        prop.add(p2);
        
        int size = prop.size();
        for (int i = 0; i < size; i++) {
            System.out.println(prop.get(i).getAddress());
        }
        
        System.out.println("hard print of db:");
        System.out.println(p1.getAddress());
        System.out.println(p2.getAddress());
        
        //24-27
        Search s1 = new Search("House", 5, 3, "2000-4000", "Stephenville, TX", prop);
        
        ArrayList<Property> ans = s1.search();
        //s1.search();
        
        System.out.println("search results: ");
        s1.print();
        
        User u = new User("Jon Foreman", "jforeman@gmail.com");
        u.addFavorite(ans.get(0)); //might have to change this so it grabs it from the whole list of houses, not from the search list
        
        System.out.println("favorites list: ");
        u.printFavorites();
        
    }
}
