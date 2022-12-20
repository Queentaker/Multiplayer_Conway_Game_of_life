package GUI;

import GUI.Grid.Grid;
import GUI.SetUp.SetUpPane;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Frame extends JFrame {
    JPanel title;
    JPanel stats;
    JPanel information;
    JPanel aGrid;
    SetUpPane setUpPane;


    public Frame() {
        this.setTitle("Conway's Game of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.getContentPane().setBackground(Color.ORANGE);
        GUI_Utility.changeIcon(this, "ownLogo");

        setUpPane = new SetUpPane(this);

        this.add(setUpPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void setUpFinished(int length, int height) {
        setUpPane.setVisible(false);
        this.remove(setUpPane);

        title = new JPanel();
        title.setBackground(Color.BLUE);
        title.setPreferredSize(new Dimension(100,100));
        JLabel label1 = new JLabel();
        label1.setText("Title");
        label1.setFont(new Font("Arial", Font.BOLD, 100));
        URL imageResource = (GUI_Utility.ImageNameToURL("ownLogo"));
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Image ownIcon = defaultToolkit.getImage(imageResource).getScaledInstance(120, 120,  Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(ownIcon);
        label1.setIcon(image);
        label1.setHorizontalTextPosition(SwingConstants.RIGHT);
        label1.setVerticalAlignment(SwingConstants.CENTER);
        title.add(label1);
        this.add(title, BorderLayout.NORTH);

        stats = new JPanel();
        JLabel label2 = new JLabel();
        label2.setText("Stats");
        label2.setFont(new Font("Arial", Font.PLAIN, 50));
        stats.add(label2);
        stats.setBackground(Color.GREEN);
        stats.setPreferredSize(new Dimension(400,100));
        this.add(stats, BorderLayout.EAST);

        information = new JPanel();
        information.setBackground(Color.CYAN);
        JLabel label3 = new JLabel();
        label3.setText("Player guiding");
        label3.setFont(new Font("Arial", Font.PLAIN, 50));
        information.add(label3);
        information.setPreferredSize(new Dimension(100,100));
        this.add(information, BorderLayout.SOUTH);

        aGrid = new Grid(length, height);
        this.add(aGrid, BorderLayout.CENTER);
    }
}
