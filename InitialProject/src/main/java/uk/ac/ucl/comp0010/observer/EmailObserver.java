package uk.ac.ucl.comp0010.observer;

public class EmailObserver implements Observer {

  @Override
  public void update(String message) {
    System.out.println("Email message:" + message);

  }

}
