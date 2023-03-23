package com.transperfect.movieapplicationdb.repositories;

import com.transperfect.movieapplicationdb.domains.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findAllByGenreOrderByReleaseYearDesc(String genre);
}
