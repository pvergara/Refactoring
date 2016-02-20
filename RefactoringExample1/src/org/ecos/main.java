package org.ecos;

public class main {

    public static void main(String[] args) {
        Movie movie = new Movie("The hateful eights",Movie.NEW_RELEASE);
        Rental rental = new Rental(movie,3);

        Movie movie2 = new Movie("Cinderella",Movie.CHILDRENS);
        Rental rental2 = new Rental(movie2,6);

        Customer me = new Customer("Myself");

        me.addRentals(rental);
        me.addRentals(rental2);

        System.out.println(me.statement());
    }
    
}
