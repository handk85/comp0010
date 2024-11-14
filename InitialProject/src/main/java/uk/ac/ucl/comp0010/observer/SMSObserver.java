package uk.ac.ucl.comp0010.observer;

public class SMSObserver implements Observer {

  @Override
  public void update(String message) {
    System.out.println("SMS message: " + message);

  }

}
