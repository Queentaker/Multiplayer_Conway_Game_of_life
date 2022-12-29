package grid;

import gameFlow.GameManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface GridObservable {
    public void addObserver(GameManager gameManager);
    public void notifyObserver(List<Integer> aliveCells, ArrayList<ArrayList<Color>> colors);
}
