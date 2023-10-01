package gui;

import api.AvgRating;
import api.NewCat;
import api.NewCat2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import api.Data;


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

        JLabel factavg = new JLabel("Fact avg: ");
        factavg.setBounds(380, 270, 100, 30);
        frame.add(factavg);
        AvgRating factavgnum1 = new AvgRating();
        double avg = factavgnum1.getAvgFact();
        JLabel factavgnum = new JLabel(String.valueOf(avg));
        factavgnum.setBounds(450, 270, 100, 30);
        frame.add(factavgnum);


        JButton factUsefulButton = new JButton("Useful");
        factUsefulButton.setBounds(50, 270, 150, 30);
        factUsefulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data d = new Data();
                d.setFactRating(1);
                DecimalFormat df = new DecimalFormat("#.####");
                String formatted = df.format(factavgnum1.getAvgFact());
                factavgnum.setText(String.valueOf(formatted));
            }
        });
        frame.add(factUsefulButton);

        JButton factUnusefulButton = new JButton("Unuseful");
        factUnusefulButton.setBounds(200, 270, 150, 30);
        factUnusefulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data d = new Data();
                d.setFactRating(0);
                DecimalFormat df = new DecimalFormat("#.####");
                String formatted = df.format(factavgnum1.getAvgFact());
                factavgnum.setText(String.valueOf(formatted));
            }
        });
        frame.add(factUnusefulButton);

        JButton fiveheart = new JButton("5❤");
        fiveheart.setBounds(525, 50, 30, 30);
        fiveheart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data d = new Data();
                d.setPictureRating(5);
            }
        });
        frame.add(fiveheart);

        JButton fourheart = new JButton("4❤");
        fourheart.setBounds(525, 100, 30, 30);
        fourheart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data d = new Data();
                d.setPictureRating(4);
            }
        });
        frame.add(fourheart);

        JButton threeheart = new JButton("3❤");
        threeheart.setBounds(525, 150, 30, 30);
        threeheart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data d = new Data();
                d.setPictureRating(3);
            }
        });
        frame.add(threeheart);

        JButton twoheart = new JButton("2❤");
        twoheart.setBounds(525, 200, 30, 30);
        twoheart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data d = new Data();
                d.setPictureRating(2);
            }
        });
        frame.add(twoheart);

        JButton oneheart = new JButton("1❤");
        oneheart.setBounds(525, 250, 30, 30);
        oneheart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data d = new Data();
                d.setPictureRating(1);
            }
        });
        frame.add(oneheart);



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
