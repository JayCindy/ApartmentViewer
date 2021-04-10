package edu.tarleton.apartmentviewer;

import java.util.ArrayList;

public class Search {
    private String type;
    private int beds;
    private double bath;
    private String rentRange;
    private String location;
    private ArrayList<Property> matches;
    private ArrayList<Property> props;

    public Search(String type, int beds, double bath, String rentRange, String location, ArrayList<Property> props) {
        this.type = type;
        this.beds = beds;
        this.bath = bath;
        this.rentRange = rentRange;
        this.location = location;
        this.matches = new ArrayList<>();
        this.props = props;
    }
    
    //could have method modifySearch() whenever we make it to that stage
    
    //some method for searching the db...need to connect sql to java for that
    
    public ArrayList<Property> search() {
        int size = this.props.size();
        for (int i = 0; i < size; i++) {
            String t = props.get(i).getType();
            int b = props.get(i).getBeds();
            double bb = props.get(i).getBath();
            int r = props.get(i).getRent();
            String[] range = this.rentRange.split("-");
            int low = Integer.parseInt(range[0]);
            int high = Integer.parseInt(range[1]);

            if (this.beds == 3) {
                if (t.equals(this.type) && b >= this.beds && r < high && r > low) {
                    if (bb < this.bath + 1 && bb > this.bath -1) {
                        matches.add(props.get(i));
                    }
                }
            }
            else if (this.bath == 3) {
                if (t.equals(this.type) && b == this.beds && bb >= this.bath && r < high && r > low) {
                    matches.add(props.get(i));
                }
            }
            else if (this.beds == 3 && this.bath == 3) {
                if (t.equals(this.type) && b >= this.beds && bb >= this.bath && r < high && r > low) {
                    matches.add(props.get(i));
                }
            }
            else if (t.equals(this.type) && b == this.beds && bb == this.bath && r < high && r > low) {
                if (bb < this.bath + 1 || bb > this.bath -1) {
                        matches.add(props.get(i));
                    }
            }
        }
        return this.matches;
    }
    
    //for modified search might want to have a new class that has Search as an attr and then new attr.
    //have one method that is the modify search & it will call methods for modifyPet(), modifyRent() etc
    //maybe search will be a superclass that Modify and Narrow can implement?
    
    public void print() {
        int size = this.matches.size();
        for (int i= 0; i < size; i++) {
            Property p = this.matches.get(i);
            System.out.println(p.getAddress());
        }
    }
}
