//A welcome screen for the game.

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
import java.awt.*;
import java.util.Objects;

public class Welcome extends JFrame implements ActionListener {

    private final JButton button1, button2, button3, button4;

    public Welcome(){

        final JLabel label1, label2, label3;

        // Setting the layout, title, background and icon of the window.
        setLayout(null);
        setTitle("TIC-TAC-TOE");
        getContentPane().setBackground(new ColorUIResource(68,23,79));
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Imagen/I_T.png"))).getImage());

        //Create a label and set its font, color and position.
        label2 = new JLabel("WELCOME TO THE GAME");
        label2.setBounds(74,260,300,30);
        label2.setFont(new Font("Arcadia", Font.BOLD | Font.ITALIC, 23));
        label2.setForeground(new Color(151,215,0));
        add(label2);

        //Create a button and set its font, color and position.
        button1 = new JButton("START");
        button1.setBounds(74,310,290,30);
        button1.setFont(new Font("Andale Mono", Font.BOLD, 30));
        button1.setForeground(new Color(151,215,0));
        button1.addActionListener(this);
        add(button1);

        //Create a button and set its font, color and position.
        button2 = new JButton("SIGN IN");
        button2.setBounds(74,355,290,30);
        button2.setFont(new Font("Andale Mono", Font.BOLD, 30));
        button2.setForeground(new Color(151,215,0));
        button2.addActionListener(this);
        add(button2);

        //Create a label and set its font, color and position.
        label3 =new JLabel("© 2022 Lucas M. Pedrozo P.");
        label3.setBounds(120,500,300,30);
        label3.setFont(new Font("Modeka", Font.BOLD, 15));
        label3.setForeground(new Color(151,215,0));
        add(label3);

        //Create a button and set its font, color and position.
        button3 = new JButton("SCORES");
        button3.setBounds(74,400,290,30);
        button3.setFont(new Font("Andale Mono", Font.BOLD, 30));
        button3.setForeground(new Color(151,215,0));
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("P DETALLADA");
        button4.setBounds(74,445,290,30);
        button4.setFont(new Font("Andale Mono", Font.BOLD, 30));
        button4.setForeground(new Color(151,215,0));
        button4.addActionListener(this);
        add(button4);

        //Creating a label with an image.
        ImageIcon imagen = new ImageIcon("C:\\Users\\luksp\\IdeaProjects\\TicTacToe\\src\\Imagen\\TTT.png");
        label1 = new JLabel(imagen);
        label1.setBounds(73,-50,281,350);
        add(label1);


    }

    public void actionPerformed(ActionEvent e){

        //Creating a new window and closing the current one.
        if (e.getSource() == button1){

            start sign = new start();
            sign.setBounds(0,0,320 ,300);
            sign.setVisible(true);
            sign.setResizable(false);
            sign.setLocationRelativeTo(null);
            sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
        }

        //Creating a new window and closing the current one.
        else if(e.getSource() == button2){

            registro sign = new registro();
            sign.setBounds(0,0,320 ,300);
            sign.setVisible(true);
            sign.setResizable(false);
            sign.setLocationRelativeTo(null);
            sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);

        }

        //Creating a new window and closing the current one.
        else if(e.getSource() == button3){
            JFrame frame = new JFrame("SCORE");
            frame.setIconImage(new ImageIcon(Objects.requireNonNull(RSCORE.class.getResource("Imagen/I_T.png"))).getImage());
            frame.setContentPane(new RSCORE().panel1);
            frame.pack();
            frame.setVisible(true);
            this.setVisible(false);

        }

        else if(e.getSource() == button4){
            JFrame frame = new JFrame("Detalle de Partida");
            frame.setIconImage(new ImageIcon(Objects.requireNonNull(RSCORE.class.getResource("Imagen/I_T.png"))).getImage());
            frame.setContentPane(new Detalle().panel1);
            frame.pack();
            frame.setVisible(true);
            this.setVisible(false);

        }
    }

    public static void main(String[] args){

        //Creating a new window and setting its size, visibility,
        // esizability, location and default close operation.
        Welcome WelcomeW = new Welcome();
        WelcomeW.setBounds(0,0,450 ,570);
        WelcomeW.setVisible(true);
        WelcomeW.setResizable(false);
        WelcomeW.setLocationRelativeTo(null);
        WelcomeW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
