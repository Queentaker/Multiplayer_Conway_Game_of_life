package gameFlow;

public interface GridObserver {
    public void update(int cellsAlivePlayer1, int cellsAlivePlayer2, int generationPlayer1, int generationPlayer2);
}
