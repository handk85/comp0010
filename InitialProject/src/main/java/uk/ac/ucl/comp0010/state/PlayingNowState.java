package uk.ac.ucl.comp0010.state;

import uk.ac.ucl.comp0010.exception.EmptyRateException;
import uk.ac.ucl.comp0010.model.Movie;

public class PlayingNowState extends MovieState {

  public PlayingNowState(Movie movie) {
    super(movie);
  }

  @Override
  public void printAverageRate() {
    try {
      System.out.println(
          "Current average rate of the movie is " + String.valueOf(this.movie.getAverageRate()));
    } catch (EmptyRateException e) {
      e.printStackTrace();
    }
  }
}
