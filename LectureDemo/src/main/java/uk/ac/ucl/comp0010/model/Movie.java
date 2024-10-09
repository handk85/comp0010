package uk.ac.ucl.comp0010.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {

  List<Integer> rates;

  public Movie() {
    rates = new ArrayList<Integer>();
  }


  public void addRate(int rate) {
    this.rates.add(rate);
  }

  public Double getAverageRate() throws EmptyRateException {
    if (rates.size() < 1) {
      throw new EmptyRateException();
    }
    double sum = 0.0;
    for (Integer rate : rates) {
      sum += rate;
    }
    return sum / rates.size();
  }

}
