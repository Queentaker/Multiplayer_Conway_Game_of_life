package setUp;

import GUI.FrameObserver;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MockObserver implements FrameObserver {
    private String message;
    private Boolean setUpFinished;
    private Boolean winnerDeclared;

    public MockObserver() {
        message = "";
        setUpFinished = false;
        winnerDeclared = false;
    }

    @Override
    public void updateGeneral(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message, ArrayList<ArrayList<Color>> gridColors) {
        updateMessage(message);
    }

    @Override
    public void updateMessage(String message) {
        this.message = message;
    }

    @Override
    public void declareWinner(int cellsAlivePlayer1, int cellsAlivePlayer2, int generation, String message, ArrayList<ArrayList<Color>> gridColors) {
        winnerDeclared = true;
    }

    @Override
    public void setUpFinished(int length, int height, Color player1Color, String player1Name, Color player2Color, String player2Name, int livingCells) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        setUpFinished = true;
    }

    public String getMessage() {
        return message;
    }

    public Boolean isSetUpFinished() {
        return setUpFinished;
    }

    public Boolean isWinnerDeclared() {
        return winnerDeclared;
    }
}
