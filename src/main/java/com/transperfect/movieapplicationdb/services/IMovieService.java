package com.transperfect.movieapplicationdb.services;

import com.transperfect.movieapplicationdb.domains.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getAllMovies();
    List<Movie> getAllMoviesByGenre(String genre);
}