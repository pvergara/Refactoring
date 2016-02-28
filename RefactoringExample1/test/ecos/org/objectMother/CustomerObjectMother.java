package ecos.org.objectMother;

import org.ecos.Customer;
import org.ecos.Movie;
import org.ecos.Rental;

public class CustomerObjectMother {
    private final Customer _customer;

    private CustomerObjectMother(String customerName) {
        _customer = new Customer(customerName);
    }

    public static CustomerObjectMother initializeTo(String customerName) {
        return new CustomerObjectMother(customerName);
    }

    public CustomerObjectMother addRental(int daysRented, String movieName, int movieType) {
        Movie movie = new Movie(movieName,movieType);
        Rental rental = new Rental(movie,daysRented);
        _customer.addRentals(rental);

        return this;
    }

    public Customer generate() {
        return _customer;
    }
}
