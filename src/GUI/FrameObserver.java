package GUI;

import jdk.internal.org.jline.utils.Colors;

public interface FrameObserver {
    public void updateGeneral(int cellsAlivePlayer1, int cellsAlivePlayer2, int generationPlayer1, int generationPlayer2);

    public void updateMessage(String message);
}
