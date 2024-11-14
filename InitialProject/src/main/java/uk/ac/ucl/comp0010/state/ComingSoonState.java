package uk.ac.ucl.comp0010.state;

import uk.ac.ucl.comp0010.exception.EmptyRateException;
import uk.ac.ucl.comp0010.model.Movie;

public class ComingSoonState extends MovieState {

  public ComingSoonState(Movie movie) {
    super(movie);
  }

  @Override
  public void printAverageRate() {
    try {
      System.out.println(
          "Expected average rate of the movie is " + String.valueOf(this.movie.getAverageRate()));
    } catch (EmptyRateException e) {
      e.printStackTrace();
    }
  }
}
