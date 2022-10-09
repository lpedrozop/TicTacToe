//The above code is a Tic Tac Toe game.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Game extends JFrame implements ActionListener {

    //Declaring the variables that will be used in the program.
    private final Random random = new Random();
    private final JFrame frame = new JFrame();
    private final JLabel textfield = new JLabel();
    private final JButton[] buttons = new JButton[9];
    private final JButton buttonR, buttonB;
    private boolean player1_turn;
    public int puntajeG = 100;
    public int partida = 1;
    String Player1;
    String Player2;

    Date date = new Date();
    DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Game(){

        final JPanel title_panel = new JPanel();
        final JPanel button_panel = new JPanel();

        //Setting the layout, title, background and icon of the window.
        setLayout(null);
        setTitle("TIC-TAC-TOE");
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Imagen/I_T.png"))).getImage());

        //Calling the class start and registro
        new start();
        new registro();

        Player1 = start.texto2;
        Player2 = start.texto3;


        //The code is setting the default close operation, the bounds of the frame,
        // the layout of the frame, and making the frame visible.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,800,800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);

        //Create a Text Field and set its font, color and position.
        textfield.setBackground(new Color(41,18,47));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Arcadia",Font.BOLD,60));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        //Create a Button and set its font, color and position.
        buttonR = new JButton();
        ImageIcon icono = new ImageIcon("C:\\Users\\luksp\\IdeaProjects\\TicTacToe\\src\\Imagen\\refreshb.png");
        setSize(60,60);
        buttonR.setIcon(icono);
        buttonR.setBackground(new Color(41,18,47));
        buttonR.setBounds(700,10,60,60);
        buttonR.addActionListener(this);

        buttonB = new JButton();
        ImageIcon iconob = new ImageIcon("C:\\Users\\luksp\\IdeaProjects\\TicTacToe\\src\\Imagen\\home.png");
        setSize(60,60);
        buttonB.setIcon(iconob);
        buttonB.setBackground(new Color(41,18,47));
        buttonB.setBounds(20,10,60,60);
        buttonB.addActionListener(this);

        //Setting the layout of the title panel
        // to BorderLayout and setting the bounds of the title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,40,800,100);

        // Setting the layout of the button_panel to GridLayout and setting
        // the bounds of the button_panel.
        button_panel.setLayout(new GridLayout(3,3));

//Creating a for loop that will create 9 buttons and add them to the button_panel. It will also set
// the font, background, focusable, and add an action listener to each button.
        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setBackground(new Color(68,23,79));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();


    }
    public void actionPerformed(ActionEvent e){

        //Checking if the button is clicked and if it is, it will check if the button is empty.
        //If it is empty, it will set the text to X or O depending on the player's turn.
        // It will also change the textfield to the other player's turn.
        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(25,255,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText(Player2+"'s Turn (O)");
                        check();
                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(213, 215, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText(Player1+"'s Turn (X)");
                        check();
                    }
                }
            }
        }

        //It checks if the R button is clicked if so it will set the buttons text to nothing,
        //it will set the buttons to enabled, and it will set the buttons background to a color.
        //It will also call the firstTurn and check methods.
       if(e.getSource() == buttonR){

           for (int i = 0; i < 9; i++) {
               buttons[i].setText("");
               buttons[i].setEnabled(true);
               buttons[i].setBackground(new Color(68,23,79));

           }
           firstTurn();
           check();
       }

       //Creating a new JFrame and setting it to visible.
       if(e.getSource() == buttonB){

           Welcome WelcomeW = new Welcome();
           WelcomeW.setBounds(0,0,450 ,570);
           WelcomeW.setVisible(true);
           WelcomeW.setResizable(false);
           WelcomeW.setLocationRelativeTo(null);
           WelcomeW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(false);


       }
    }

//This method is used to determine who goes first. The method is using a random number generator to determine who goes first.
// If the random number is 0, then player 1 goes first. If the random number is 1, then player 2 goes first
    public void firstTurn(){

        if(random.nextInt(2) == 0){
            player1_turn = true;
            textfield.setText(Player1+"'s Turn (X)");

        }
        else {
            player1_turn = false;
            textfield.setText(Player2+"'s Turn (O)");

        }
        textfield.add(buttonR);
        textfield.add(buttonB);
    }

    //This method  is checking if the buttons have the same text.
    //If they do, then it will call the xWins or oWins method.
    public void check() {



        if ((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[2].getText(), "X"))) {

            xWins(0, 1, 2);
        }

        if ((Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X"))) {

            xWins(3, 4, 5);
        }

        if ((Objects.equals(buttons[6].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))) {

            xWins(6, 7, 8);
        }

        if ((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))) {

            xWins(0, 3, 6);
        }

        if ((Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X"))) {

            xWins(1, 4, 7);
        }

        if ((Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))) {

            xWins(2, 5, 8);
        }

        if ((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))) {

            xWins(0, 4, 8);
        }

        if ((Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))) {

            xWins(2, 4, 6);
        }

        //O

        if ((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[2].getText(), "O"))) {

            oWins(0, 1, 2);
        }

        if ((Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O"))) {

            oWins(3, 4, 5);
        }

        if ((Objects.equals(buttons[6].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))) {

            oWins(6, 7, 8);
        }

        if ((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))) {

            oWins(0, 3, 6);
        }

        if ((Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O"))) {

            oWins(1, 4, 7);
        }

        if ((Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))) {

            oWins(2, 5, 8);
        }

        if ((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))) {

            oWins(0, 4, 8);
        }

        if ((Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))) {

            oWins(2, 4, 6);

        }

        if((!Objects.equals(buttons[0].getText(), ""))&&
                    (!Objects.equals(buttons[1].getText(), ""))&&
                    (!Objects.equals(buttons[2].getText(), ""))&&
                    (!Objects.equals(buttons[3].getText(), ""))&&
                    (!Objects.equals(buttons[4].getText(), ""))&&
                    (!Objects.equals(buttons[5].getText(), ""))&&
                    (!Objects.equals(buttons[6].getText(), ""))&&
                    (!Objects.equals(buttons[7].getText(), ""))&&
                    (!Objects.equals(buttons[8].getText(), ""))) {

            equ();

    }}

    //This method receives as a parameter the three positions of the buttons that have the same value "X" and
    //Setting the background color of the buttons to green and deactivating them.
    public void xWins(int a, int b, int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText(Player1+" Winner");

        score mod = new score();
        SqlUsuarios modSql = new SqlUsuarios();
        mod.setUsuario(Player1);
        mod.setPuntaje(puntajeG);
        modSql.add(mod);

        score mod2 = new score();
        mod2.setUsuario(Player1);
        mod2.setPartidasg(partida);
        modSql.addpg(mod2);

        score mod3 = new score();
        mod3.setUsuario(Player2);
        mod3.setPartidasp(partida);
        modSql.addpp(mod3);

        score mod4 = new score();
        mod4.setUsuario(Player2);
        modSql.addpt(mod4);

        score mod5 = new score();
        mod5.setUsuario(Player1);
        modSql.addpt(mod5);

        score mod6 = new score();
        mod6.setUsuario(Player1);
        mod6.setUsuario2(Player2);
        mod6.setNa(Player1);
        mod6.setTime(fechaHora.format(date));
        modSql.detallest(mod6);





    }

    //This method receives as a parameter the three positions of the buttons that have the same value "O" and
    //Setting the background color of the buttons to green and deactivating them.
    public void oWins(int a, int b, int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText(Player2+" Winner");

        score mod = new score();
        SqlUsuarios modSql = new SqlUsuarios();
        mod.setUsuario(Player2);
        mod.setPuntaje(puntajeG);
        modSql.add(mod);

        score mod2 = new score();
        mod2.setUsuario(Player2);
        mod2.setPartidasg(partida);
        modSql.addpg(mod2);

        score mod3 = new score();
        mod3.setUsuario(Player1);
        mod3.setPartidasp(partida);
        modSql.addpp(mod3);

        score mod4 = new score();
        mod4.setUsuario(Player2);
        modSql.addpt(mod4);

        score mod5 = new score();
        mod5.setUsuario(Player1);
        modSql.addpt(mod5);

        score mod6 = new score();
        mod6.setUsuario(Player1);
        mod6.setUsuario2(Player2);
        mod6.setNa(Player2);
        mod6.setTime(fechaHora.format(date));
        modSql.detallest(mod6);
    }

    public void equ (){

        //Checking if the buttons are empty or not.

                textfield.setText("Ranked Match");

                SqlUsuarios modSql = new SqlUsuarios();
                score mod = new score();
                mod.setUsuario(Player1);
                mod.setPartidase(partida);
                modSql.addpe(mod);

                score mod2 = new score();
                mod2.setUsuario(Player2);
                mod2.setPartidase(partida);
                modSql.addpe(mod2);

                score mod3 = new score();
                mod3.setUsuario(Player2);
                modSql.addpt(mod3);

                score mod4 = new score();
                mod4.setUsuario(Player1);
                modSql.addpt(mod4);

                score mod5 = new score();
                mod5.setUsuario(Player1);
                mod5.setUsuario2(Player2);
                mod5.setNa("EMPATE");
                mod5.setTime(fechaHora.format(date));
                modSql.detallest(mod5);
            }



    public static void main(String[] args){

        new Game();

    }

}
