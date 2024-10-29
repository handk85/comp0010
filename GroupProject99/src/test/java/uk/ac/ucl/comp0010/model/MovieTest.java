package uk.ac.ucl.comp0010.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.ucl.comp0010.exception.EmptyRateException;

public class MovieTest {

  private static final String MOVIE_TITLE = "Deadpool";
  Movie movie;

  @BeforeEach
  void beforeEach() {
    movie = new Movie();
    movie.setTitle(MOVIE_TITLE);
  }


  @Test
  void getAverageRateTest() throws EmptyRateException {
    movie.addRate(new Rate(5));
    Rate rate = new Rate();
    rate.setScore(3);
    movie.addRate(new Rate(3));
    assertEquals(MOVIE_TITLE, movie.getTitle());
    assertEquals(4.0, movie.computeAverageRate());
    assertEquals(2, movie.getRates().size());
  }

  @Test
  void getAverageRateTestWithEmptyRates() {
    assertThrows(EmptyRateException.class, () -> {
      movie.computeAverageRate();
    });
  }
}
