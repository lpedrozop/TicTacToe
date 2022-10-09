//Creating a table with the data from the database.
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;


public class RSCORE {
    private JTable table1;
    public JPanel panel1;

    private JButton RETURNButton;
    DefaultTableModel modelo;

    //The constructor of the class.
    public RSCORE() {
        llenarTabla();
    //Creating a new instance of the Welcome class and setting the properties of the JFrame.
        RETURNButton.addActionListener(e -> {
            Welcome WelcomeW = new Welcome();
            WelcomeW.setBounds(0,0,450 ,570);
            WelcomeW.setVisible(true);
            WelcomeW.setResizable(false);
            WelcomeW.setLocationRelativeTo(null);
            WelcomeW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        });
    }

    public void llenarTabla(){
        SqlUsuarios ct = new SqlUsuarios();
        modelo = new DefaultTableModel();
        modelo = ct.listar();
        table1.setModel(modelo);
        table1.setEnabled(false);
    }
//The main method of the class. It is creating a new JFrame and setting the properties of it.
    public static void main(String[] args) {
        JFrame frame = new JFrame("SCORE");
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(RSCORE.class.getResource("Imagen/I_T.png"))).getImage());
        frame.setContentPane(new RSCORE().panel1);
        frame.pack();
        frame.setVisible(true);
    }
}
