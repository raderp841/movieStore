package com.interviewprep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

/**
 * Unit test for simple App.
 */
class MovieStoreTest {

    private Movie harryPotter = new Movie("harry potter", "Bob", 2000);
    private Movie starWars = new Movie("star wars", "Shwimmer", 1999);
    private Movie starTrek = new Movie("STAR TREK", "Shwimmer",2002);
    private Movie shawShank = new Movie("Shawshank", "tony",2001);
    private Movie takeThat = new Movie("Take That", "Shwimmer",2010);
    private MovieStore movieStore = new MovieStore();

    @Test
    void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() {
        MovieStore movieStore = new MovieStore();
        List<Movie> results = movieStore.findByPartialTitle("abc");
        assertEquals(0 , results.size());
    }

    @BeforeEach
    public void setUp() throws Exception{
        movieStore.add(harryPotter);
        movieStore.add(starTrek);
        movieStore.add(starWars);
        movieStore.add(shawShank);
        movieStore.add(takeThat);
    }

    @Test
    void findsAMoviesWhenTitleIsPartiallyMatchedCaseInsensitive() {
        List<Movie> results = movieStore.findByPartialTitle("star");
        assertEquals(2, results.size());
        assertTrue(results.contains(starTrek));
        assertTrue(results.contains(starWars));
    }

    @Test
    void findMoviesWhenDirectorExactlyMatches() {
        List<Movie> results = movieStore.findByDirector("Shwimmer");
        assertEquals(3, results.size());
        assertTrue(results.contains(starTrek));
        assertTrue(results.contains(starWars));
        assertTrue(results.contains(takeThat));
    }

    @Test
    void findMoviesWhenReleaseYearIsBetweenTwoValues() {
        List<Movie> results = movieStore.findByReleaseYear(1999, 2002);
        assertEquals(2, results.size());
        assertTrue(results.contains(harryPotter));
        assertTrue(results.contains(shawShank));
    }
}
