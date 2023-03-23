package com.transperfect.movieapplicationdb.services;

import com.transperfect.movieapplicationdb.domains.Movie;
import com.transperfect.movieapplicationdb.repositories.MovieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{
    private MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void initiateProject(){
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = Movie
                .builder()
                .id(1L)
                .title("The Shawshank Redemption")
                .genre("Drama")
                .releaseYear(1994)
                .director("Frank Darabont")
                .build();
        Movie movie2 = Movie
                .builder()
                .id(2L)
                .title("The Godfather")
                .genre("Drama")
                .releaseYear(1972)
                .director("Francis Ford Coppola")
                .build();

        Movie movie3 = Movie
                .builder()
                .id(3L)
                .title("The Dark Knight")
                .genre("Action")
                .releaseYear(2008)
                .director("Christopher Nolan")
                .build();

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        movieRepository.saveAll(movies);
    }
    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getAllMoviesByGenre(String genre) {
        return movieRepository.findAllByGenreOrderByReleaseYearDesc(genre);
    }
}
