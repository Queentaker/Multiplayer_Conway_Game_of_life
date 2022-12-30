package GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

public class GUI_Utility {
    static final private Toolkit defaultToolkit = Toolkit.getDefaultToolkit();

    private static URL ImageNameToURL(String name) {
        String location = "GUI/images/" + name + ".png";
        return GameFrame.class.getClassLoader().getResource(location);
    }

    public static Image ImageNameToImage(String name) {
        URL location = ImageNameToURL(name);
        return defaultToolkit.getImage(location);
    }

    public static ImageIcon ImageNameToImageIcon(String name, int length, int height) {
        URL location = ImageNameToURL(name);
        Image aImage = defaultToolkit.getImage(location).getScaledInstance(length, height,  Image.SCALE_SMOOTH);
        return new ImageIcon(aImage);
    }

    public static JLabel ImageNameToLabel(String name, int length, int height) {
        URL location = ImageNameToURL(name);
        Image aImage = defaultToolkit.getImage(location).getScaledInstance(length, height,  Image.SCALE_SMOOTH);
        ImageIcon aImageIcon = new ImageIcon(aImage);
        JLabel aLabel = new JLabel();
        aLabel.setOpaque(true);
        aLabel.setIcon(aImageIcon);
        return aLabel;
    }

    public static void changeIcon(GameFrame frame, String imageName) {
        Taskbar taskBar = Taskbar.getTaskbar();
        Image ownIcon = (ImageNameToImage(imageName));
        //MacOS
        try {
            taskBar.setIconImage(ownIcon);
        } catch (final UnsupportedOperationException e) {
            System.out.println("Can't change the Taskbar Icon on this OS");
        } catch (final SecurityException e) {
            System.out.println("Not possible to change the Taskbar Icon, because of security settings");
        }
        //Windows
        frame.setIconImage(ownIcon);
    }
    public static synchronized void soundNotification(String soundName) {
        new Thread(() -> {
            try {
                Clip soundClip = AudioSystem.getClip();
                AudioInputStream input = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                soundClip.open(input);
                soundClip.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }
}
