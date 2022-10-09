//Connecting to the database.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection getConexion() {

        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                String user = "root";
                String password = "123456Lp";
                String base = "score";
                String url = "jdbc:mysql://localhost:3306/" + base;
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }     catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
        }
        return con;
    }

}
