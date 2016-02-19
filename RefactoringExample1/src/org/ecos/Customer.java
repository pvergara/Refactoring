package org.ecos;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    
    public Customer(String name){
        _name = name;
    }
    
    public void addRentals(Rental rental){
        _rentals.addElement(rental);
    }
    
    public String getName(){
        return _name;
    }
}
