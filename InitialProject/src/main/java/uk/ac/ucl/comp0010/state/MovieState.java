package uk.ac.ucl.comp0010.state;

import uk.ac.ucl.comp0010.model.Movie;

public abstract class MovieState {

  protected Movie movie;

  public MovieState(Movie movie) {
    this.movie = movie;
  }

  public void printAverageRate() {

  }

}
