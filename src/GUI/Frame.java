package GUI;

import GUI.Grid.Grid;
import GUI.SetUp.SetUp;
import GUI.SetUp.SetUpPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Frame extends JFrame {
    JPanel title;
    JPanel stats;
    JPanel information;
    JPanel aGrid;
    SetUpPanel setUpPanel;

    SetUp setUp;


    public Frame() {
        this.setTitle("Conway's Game of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.getContentPane().setBackground(Color.ORANGE);
        GUI_Utility.changeIcon(this, "ownLogo");

        setUpPanel = new SetUpPanel(this);

        this.add(setUpPanel, BorderLayout.CENTER);
        this.setVisible(true);

    }

    public void setUpFinished(java.util.List<Color> playerColors, java.util.List<String> playerNames,int width, int height) {
        setUpPanel.setVisible(false);
        this.remove(setUpPanel);

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
        JLabel cellsAlivePlayer1 = new JLabel();
        JLabel cellsAlivePlayer2 = new JLabel();
        JLabel numberGenerationPlayer1 = new JLabel();
        JLabel numberGenerationPlayer2 = new JLabel();
        label2.setText("Stats");
        cellsAlivePlayer1.setText("Cells Alive(Player1): ");
        cellsAlivePlayer2.setText("Cells Alive(Player2): ");
        numberGenerationPlayer1.setText("Generation(Player1): ");
        numberGenerationPlayer2.setText("Generation(Player2): ");
        label2.setFont(new Font("Arial", Font.PLAIN, 50));
        cellsAlivePlayer1.setFont(new Font("Arial", Font.PLAIN, 25));
        cellsAlivePlayer2.setFont(new Font("Arial", Font.PLAIN, 25));
        numberGenerationPlayer1.setFont(new Font("Arial", Font.PLAIN, 25));
        numberGenerationPlayer2.setFont(new Font("Arial", Font.PLAIN, 25));
        stats.add(label2);
        stats.add(cellsAlivePlayer1);
        stats.add(cellsAlivePlayer2);
        stats.add(numberGenerationPlayer1);
        stats.add(numberGenerationPlayer2);
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

        aGrid = new Grid(width, height);
        this.add(aGrid, BorderLayout.CENTER);
    }
}
