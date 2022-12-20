package GUI;

import java.awt.*;
import java.net.URL;

public class GUI_Utility {

    public static URL ImageNameToURL(String name) {
        String location = "GUI/Images/" + name + ".png";
        return Frame.class.getClassLoader().getResource(location);
    }

    public static void changeIcon(Frame frame, String imageName) {
        Taskbar taskBar = Taskbar.getTaskbar();
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Image ownIcon = defaultToolkit.getImage(ImageNameToURL(imageName));
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
