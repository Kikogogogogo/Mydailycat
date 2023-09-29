package gui;

import api.NewCat;
import api.NewCat2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {

    private JFrame frame;
    private JButton getFactButton;
    private JButton getPicButton;
    private JTextArea factArea;
    private JLabel catImageLabel;
    private NewCat catFactService;
    private NewCat2 catPicService;

    public GUI() {
        catFactService = new NewCat();
        catPicService = new NewCat2();

        frame = new JFrame("Today‘s cat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        getFactButton = new JButton("Get Cat Fact");
        getFactButton.setBounds(50, 10, 200, 30);
        getFactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fact = catFactService.getRandomFact();
                factArea.setText(fact);
            }
        });
        frame.add(getFactButton);

        getPicButton = new JButton("Get Cat Picture");
        getPicButton.setBounds(300, 10, 200, 30);
        getPicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File catImage = catPicService.getPicture();
                if (catImage != null) {
                    ImageIcon imageIcon = new ImageIcon(catImage.getAbsolutePath());
                    catImageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT)));
                }
            }
        });
        frame.add(getPicButton);

        factArea = new JTextArea();
        factArea.setWrapStyleWord(true);
        factArea.setLineWrap(true);
        factArea.setBounds(50, 300, 500, 60);
        frame.add(factArea);

        catImageLabel = new JLabel();
        catImageLabel.setBounds(100, 50, 400, 200);
        frame.add(catImageLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
