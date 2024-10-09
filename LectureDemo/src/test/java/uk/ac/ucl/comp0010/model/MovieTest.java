package uk.ac.ucl.comp0010.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MovieTest {

  @Test
  void getAverageRateTest() throws EmptyRateException {
    Movie movie = new Movie();
    movie.addRate(5);
    movie.addRate(3);
    assertEquals(4.0, movie.getAverageRate());
  }

  @Test
  void getAverageRateTest2() throws EmptyRateException {
    Movie movie = new Movie();
    movie.addRate(4);
    movie.addRate(2);
    assertEquals(3.0, movie.getAverageRate());
  }

  @Test
  void getAverageRateTestWithEmptyRates() {
    assertThrows(EmptyRateException.class, () -> {
      Movie movie = new Movie();
      movie.getAverageRate();
    });
  }
}
