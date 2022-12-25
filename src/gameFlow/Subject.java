package gameFlow;

public interface Subject {
    public void registerObserver(GridObserver o);
    public void removeObserver(GridObserver o);

    public void notifyObservers();
}
