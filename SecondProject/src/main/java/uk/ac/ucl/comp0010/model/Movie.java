package uk.ac.ucl.comp0010.model;

import java.util.ArrayList;
import java.util.List;
import uk.ac.ucl.comp0010.exception.EmptyRateException;


/**
 * A class represents movie.
 */
public class Movie {

  String title;

  List<Rate> rates;

  public Movie() {
    this.rates = new ArrayList<Rate>();
  }

  /**
   * Returns average rate of the movie.
   *
   * @return the average rate in double
   * @throws EmptyRateException if there is no rate in the movie
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Rate> getRates() {
    return rates;
  }

}
