package ecos.org;

import ecos.org.objectMother.CustomerObjectMother;
import org.ecos.Customer;
import org.ecos.Movie;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class CustomerStatementTests {
    @Test
    public void statementForASingleRegularMovieAndASingleDay() {
        //Arrange
        String movieName = "The Wizard of Oz";
        int daysRented = 1;

        Customer customer = CustomerObjectMother.
            initializeTo("Martin").
                addRental(daysRented, movieName, Movie.REGULAR).
            generate();

        //Act
        String result = customer.statement();

        //Asserts
        assertThat(result, containsString(String.format("%s\t%s", movieName, 2.0)));
        assertThat(result, containsString(String.format("%s %s %s", "You earned", 1, "frequent renter points")));
        assertThat(result, containsString(String.format("%s %s", "Amounts owed is", 2.0)));
    }

    @Test
    public void statementForASingleChildren9MovieAndASingleDay() {
        //Arrange
        String movieName = "Teen beach movie";
        int daysRented = 1;
        Customer customer = CustomerObjectMother.
            initializeTo("Martin").
                addRental(daysRented, movieName, Movie.CHILDRENS).
            generate();

        //Act
        String result = customer.statement();

        assertThat(result, containsString(String.format("%s\t%s", movieName, 1.5)));
        assertThat(result, containsString(String.format("%s %s %s", "You earned", 1, "frequent renter points")));
        assertThat(result, containsString(String.format("%s %s", "Amounts owed is", 1.5)));
    }

    @Test
    public void statementForASingleNewReleaseMovieAndASingleDay() {
        //Arrange
        String movieName = "Inside out";
        int daysRented = 1;
        Customer customer = CustomerObjectMother.
            initializeTo("Martin").
                addRental(daysRented,movieName,Movie.NEW_RELEASE).
            generate();

        //Act
        String result = customer.statement();

        assertThat(result, containsString(String.format("%s\t%s", movieName, 3)));
        assertThat(result, containsString(String.format("%s %s %s", "You earned", 1, "frequent renter points")));
        assertThat(result, containsString(String.format("%s %s", "Amounts owed is", 3)));
    }
}