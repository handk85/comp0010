package uk.ac.ucl.comp0010;

import uk.ac.ucl.comp0010.model.Movie;
import uk.ac.ucl.comp0010.model.ObserverManager;
import uk.ac.ucl.comp0010.model.Rate;
import uk.ac.ucl.comp0010.observer.EmailObserver;
import uk.ac.ucl.comp0010.observer.Observer;
import uk.ac.ucl.comp0010.observer.SMSObserver;
import uk.ac.ucl.comp0010.state.ComingSoonState;
import uk.ac.ucl.comp0010.state.MovieState;

public class Main {

  public static void main(String[] args) {
    Observer emailObserver = new EmailObserver();
    Observer smsObserver = new SMSObserver();

    ObserverManager manager = ObserverManager.getInstance();
    manager.subscribe(emailObserver);
    manager.subscribe(smsObserver);

    Movie movie = new Movie();
    // MovieState state = new PlayingNowState(movie);
    MovieState state = new ComingSoonState(movie);
    movie.setState(state);

    movie.addRate(new Rate(3));
    movie.addRate(new Rate(5));

    movie.getState().printAverageRate();


  }
}
