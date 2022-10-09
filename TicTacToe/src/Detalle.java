//Creating a table with the data from the database.
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;


public class Detalle {
    private JTable table1;
    public JPanel panel1;

    private JButton RETURNButton;
    DefaultTableModel modelo;

    //The constructor of the class.
    public Detalle() {
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
        SqlUsuarios ctt = new SqlUsuarios();
        modelo = new DefaultTableModel();
        modelo = ctt.tdetalle();
        table1.setModel(modelo);
        table1.setEnabled(false);
    }
    //The main method of the class. It is creating a new JFrame and setting the properties of it.
    public static void main(String[] args) {
        JFrame frame = new JFrame("DETALLE");
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(Detalle.class.getResource("Imagen/I_T.png"))).getImage());
        frame.setContentPane(new Detalle().panel1);
        frame.pack();
        frame.setVisible(true);
    }
}

