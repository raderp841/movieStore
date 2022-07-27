package com.interviewprep;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieStore {
    List<Movie> movies = new LinkedList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByDirector(String director) {
        return filterMovies(m -> m.getDirector().equals(director));
    }

    public List<Movie> findByPartialTitle(String partialTitle) {
        return filterMovies(m -> m.getTitle().toUpperCase().contains(partialTitle.toUpperCase()));
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        return filterMovies(m -> m.getReleaseYear() > from && m.getReleaseYear() < to);
    }

    private List<Movie> filterMovies(Predicate<Movie> predicate){
        return movies.stream()
            .filter(predicate)
            .collect(Collectors.toList());
    }    
}
