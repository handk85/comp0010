package uk.ac.ucl.comp0010.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * A class represents movie rate.
 */
@Entity
public class Rate {

  @Id
  @GeneratedValue
  Long id;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  Movie movie;

  Integer score;

  public Rate() {}

  public Rate(int score) {
    this.score = score;
  }


  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

}
