package observerexample.com.example.adrian.observerexample2;

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers();
}
