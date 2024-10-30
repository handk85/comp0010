package uk.ac.ucl.comp0010.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.ucl.comp0010.model.Movie;

/**
 * A repository manages Movie.
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
