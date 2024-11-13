package uk.ac.ucl.comp0010.model;

import java.util.ArrayList;
import java.util.List;
import uk.ac.ucl.comp0010.exception.EmptyRateException;


/**
 * A class represents a movie.
 */
public class Movie {

  List<Rate> rates;

  public Movie() {
    this.rates = new ArrayList<Rate>();
  }

  /**
   * It returns average rate of the movie.
   *
   * @return double typed value of average rate
   * @throws EmptyRateException it throws if there is no rate
   */
  public Double getAverageRate() throws EmptyRateException {
    if (rates.size() < 1) {
      throw new EmptyRateException();
    }

    Double sum = 0.0;
    for (Rate rate : rates) {
      sum += rate.getScore();
    }
    return sum / rates.size();
  }

  public void addRate(Rate rate) {
    this.rates.add(rate);

  }

}
