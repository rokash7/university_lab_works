package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private final JPanel panel1;
    private final JPanel panel2;
    private final JPanel panel3;
    private JPanel panel4;
//    private JLabel label1, label2, label3;
    private final JButton buttonKnygos;
    private final JButton buttonSkaitytojai;
    private final JButton buttonDarbuotojai;

    private final ImageIcon icon = new ImageIcon("icon.png");


    public GUI(){
        //setup

        this.setSize(1216, 700);
        this.setTitle("Biblioteka");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setIconImage(icon.getImage());

        //layout
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 400, 50);
        this.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(400, 0, 400, 50);
        this.add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(800, 0, 400, 50);
        this.add(panel3);

        //features

/*        label1 = new JLabel();
        label1.setText("Knygos");
        label1.setForeground(new Color(170, 170, 170));
        label1.setFont(new Font("", Font.PLAIN, 30));
        panel1.add(label1);

        label2 = new JLabel();
        label2.setText("Skaitytojai");
        label2.setForeground(new Color(170, 170, 170));
        label2.setFont(new Font("", Font.PLAIN, 30));
        panel2.add(label2);

        label3 = new JLabel();
        label3.setText("Darbuotojai");
        label3.setForeground(new Color(170, 170, 170));
        label3.setFont(new Font("", Font.PLAIN, 30));
        panel3.add(label3);*/

        buttonKnygos = new JButton();
        buttonKnygos.setBounds(0, 0, 400, 50);
        buttonKnygos.addActionListener(e -> System.out.println("Knygos")); // (this)
        buttonKnygos.setText("Knygos");
        buttonKnygos.setFont(new Font("", Font.PLAIN, 30));
        buttonKnygos.setForeground(new Color(170, 170, 170));
        buttonKnygos.setBackground(new Color(50, 50, 75));
        buttonKnygos.setFocusable(false);
        panel1.add(buttonKnygos);

        buttonSkaitytojai = new JButton();
        buttonSkaitytojai.setBounds(0, 0, 400, 50);
        buttonSkaitytojai.addActionListener(e -> System.out.println("Skaitytojai")); // (this)
        buttonSkaitytojai.setText("Skaitytojai");
        buttonSkaitytojai.setFont(new Font("", Font.PLAIN, 30));
        buttonSkaitytojai.setForeground(new Color(170, 170, 170));
        buttonSkaitytojai.setBackground(new Color(70, 70, 75));
        buttonSkaitytojai.setFocusable(false);
        panel2.add(buttonSkaitytojai);

        buttonDarbuotojai = new JButton();
        buttonDarbuotojai.setBounds(0, 0, 400, 50);
        buttonDarbuotojai.addActionListener(e -> System.out.println("Darbuotojai")); // (this)
        buttonDarbuotojai.setText("Darbuotojai");
        buttonDarbuotojai.setFont(new Font("", Font.PLAIN, 30));
        buttonDarbuotojai.setForeground(new Color(170, 170, 170));
        buttonDarbuotojai.setBackground(new Color(90, 90, 75));
        buttonDarbuotojai.setFocusable(false);
        panel3.add(buttonDarbuotojai);

        //display
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonKnygos){

        }
    }
}

/*
        panel4 = new JPanel();
        panel4.setBackground(new Color(50, 50, 75));
        panel4.setBounds(0, 50, 1200, 650);
        this.add(panel4);*/
