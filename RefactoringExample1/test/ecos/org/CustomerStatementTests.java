package ecos.org;

import ecos.org.objectMother.CustomerObjectMother;
import org.ecos.Customer;
import org.ecos.Movie;
import org.ecos.Rental;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class CustomerStatementTests {
    @Test
    public void statementForASingleRegularMovieAndASingleDay(){
        //Arrange
        String movieName = "The Wizard of Oz";

        Customer customer = CustomerObjectMother.
            initializeTo("Martin").
                addRental(1,movieName,Movie.REGULAR).
            generate();

        //Act
        String result = customer.statement();

        //Asserts
        assertThat(result, containsString(String.format("%s\t%s",movieName,2.0)));
        assertThat(result, containsString(String.format("%s %s %s","You earned",1,"frequent renter points")));
        assertThat(result, containsString(String.format("%s %s","Amounts owed is",2.0)));
    }

    @Test
    public void statementForASingleChildren9MovieAndASingleDay(){
        Customer customer = new Customer("Martin");
        String movieName = "Teen beach movie";
        Movie movie = new Movie(movieName,Movie.CHILDRENS);
        Rental rental = new Rental(movie,1);
        customer.addRentals(rental);
        String result = customer.statement();

        assertThat(result, containsString(String.format("%s\t%s",movieName,1.5)));
        assertThat(result, containsString(String.format("%s %s %s","You earned",1,"frequent renter points")));
        assertThat(result, containsString(String.format("%s %s","Amounts owed is",1.5)));
    }

    @Test
    public void statementForASingleNewReleaseMovieAndASingleDay(){
        Customer customer = new Customer("Martin");
        String movieName = "Teen beach movie";
        Movie movie = new Movie(movieName,Movie.NEW_RELEASE);
        Rental rental = new Rental(movie,1);
        customer.addRentals(rental);
        String result = customer.statement();

        assertThat(result, containsString(String.format("%s\t%s",movieName,3)));
        assertThat(result, containsString(String.format("%s %s %s","You earned",1,"frequent renter points")));
        assertThat(result, containsString(String.format("%s %s","Amounts owed is",3)));
    }

}
