package uk.ac.ucl.comp0010.model;

import java.util.ArrayList;
import java.util.List;
import uk.ac.ucl.comp0010.observer.Observer;

public class ObserverManager {

  private static ObserverManager manager;

  private List<Observer> observers;

  private ObserverManager() {
    this.observers = new ArrayList<Observer>();
  }

  public static ObserverManager getInstance() {
    if (manager == null) {
      manager = new ObserverManager();
    }
    return manager;
  }

  public void subscribe(Observer observer) {
    this.observers.add(observer);
  }

  public void notify(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }
}
