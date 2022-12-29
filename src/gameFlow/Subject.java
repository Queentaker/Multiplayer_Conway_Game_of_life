package gameFlow;

import GUI.FrameObserver;

public interface Subject {
    public void registerObserver(FrameObserver o);
    public void removeObserver(FrameObserver o);

    public void notifyObserversGeneral(String message);

    public void notifyObserversMessage(String message);

    public void notifyObserversWinner(String message);
}
