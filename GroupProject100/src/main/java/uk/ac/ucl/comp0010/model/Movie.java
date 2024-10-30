package uk.ac.ucl.comp0010.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import uk.ac.ucl.comp0010.exception.EmptyRateException;


/**
 * A class represents a movie.
 */
@Entity
public class Movie {

  @Id
  @GeneratedValue
  Long id;

  String title;

  @OneToMany(mappedBy = "movie")
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


}
