import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
import java.awt.*;
import java.util.Objects;

public class start extends JFrame implements ActionListener {

    //Declaring the variables that will be used in the class.
    private final JButton button;

    private final JTextField textField2, textField3;
    public static String texto3 = "";
    public static String texto2 = "";

    // The constructor of the class.
    public start(){

        final JLabel label1, label2, label3;

        //Setting the layout of the frame to null, setting the title of the frame, setting the background color of the frame, and setting the icon of the frame.
        setLayout(null);
        setTitle("TIC-TAC-TOE");
        getContentPane().setBackground(new ColorUIResource(68,23,79));
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Imagen/I_T.png"))).getImage());

        //Creating a button and setting its properties.
        button = new JButton("PLAY");
        button.setBounds(70,200,150,45);
        button.setFont(new Font("Andale Mono", Font.BOLD, 15));
        button.setForeground(new Color(151,215,0));
        button.addActionListener(this);
        add(button);

        //Creating a Label and setting its properties.
        label1 = new JLabel("PLAYER NAME");
        label1.setBounds(85,15,250,15);
        label1.setFont(new Font("Arcadia", Font.BOLD, 18));
        label1.setForeground(new Color(151,215,0));
        add(label1);

        label2 =new JLabel("Player (X)");
        label2.setBounds(20,60,100,20);
        label2.setFont(new Font("Modeka", Font.BOLD | Font.ITALIC, 15));
        label2.setForeground(new Color(151,215,0));
        add(label2);

        //Creating a Text Field and setting its properties.
        textField2 = new JTextField();
        textField2.setBounds(20,85,200,25);
        textField2.setBackground(new Color(68,23,79));
        textField2.setFont(new Font("Andale Mono", Font.BOLD, 16));
        textField2.setForeground(new Color(151,215,0));
        add(textField2);


        label3 =new JLabel("Player (O)");
        label3.setBounds(20,135,100,20);
        label3.setFont(new Font("Modeka", Font.BOLD | Font.ITALIC, 15));
        label3.setForeground(new Color(151,215,0));
        add(label3);

        textField3 = new JTextField();
        textField3.setBounds(20,160,200,25);
        textField3.setBackground(new Color(68,23,79));
        textField3.setFont(new Font("Andale Mono", Font.BOLD, 16));
        textField3.setForeground(new Color(151,215,0));
        add(textField3);

    }

    //The action performed when the button is pressed.
    public void actionPerformed(ActionEvent e){

        //Checking if the button is pressed and if the text fields are empty.
        if (e.getSource() == button){

            texto2 = textField2.getText().trim();
            texto3 = textField3.getText().trim();

            // Checking if the text fields are empty and if they are not empty it is checking if the players exist in the database.
            if(texto2.equals("") || texto3.equals("")){
                JOptionPane.showMessageDialog(textField2, "Empty text box, type the name of player 1 or player 2","Warning", JOptionPane.ERROR_MESSAGE);
            }

            else {

                SqlUsuarios modSql = new SqlUsuarios();

                if((modSql.consulta(texto2) == 1) && (modSql.consulta(texto3) == 1)) {
                    new Game();
                    this.setVisible(false);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Player 1 or 2 Does Not Exist.");
                }


            }


        }


    }

//The main method of the class.
    public static void main(String[] args){

        //Setting the properties of the frame.
        start sign = new start();
        sign.setBounds(0,0,320 ,300);
        sign.setVisible(true);
        sign.setResizable(false);
        sign.setLocationRelativeTo(null);
        sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}