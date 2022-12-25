package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GUI_Utility {
    static final private Toolkit defaultToolkit = Toolkit.getDefaultToolkit();

    private static URL ImageNameToURL(String name) {
        String location = "GUI/images/" + name + ".png";
        return Frame.class.getClassLoader().getResource(location);
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

    public static void changeIcon(Frame frame, String imageName) {
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
}
