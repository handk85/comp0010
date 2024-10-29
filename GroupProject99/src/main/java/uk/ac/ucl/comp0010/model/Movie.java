package uk.ac.ucl.comp0010.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import uk.ac.ucl.comp0010.exception.EmptyRateException;


/**
 * A class represents movie.
 */
@Entity
public class Movie {

  @Id
  @GeneratedValue
  Long id;

  String title;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie")
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
  public Double computeAverageRate() throws EmptyRateException {
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
