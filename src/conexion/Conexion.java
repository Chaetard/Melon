package conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
* @author Francisco Eduardo Oliva Ibarra
*/
public class Conexion  {
    //Datos necesarios que cambian de acuerdo a las necesidades de la aplicación
    
    private final String Servidor = "localhost"; //si es local = "localhost"
    private final String Database = "melondb";//
    private final String Usuario = "root"; //si el servidor es con localhost = root
    private final String Password = "";    //si el servidor es con localhost = ""
    
    
    
   /* private final String Servidor = "10.225.166.213"; //si es local = "localhost"
    private final String Database = "tiendita";//
    private final String Usuario = "chabelo"; //si el servidor es con localhost = root
    private final String Password = "cuate";    //si el servidor es con localhost = ""*/
    
    
    //REMOTA
   /* private final String Servidor = "10.136.226.104"; //si es local = "localhost"
    private final String Database = "4244598_melonbd";//
    private final String Usuario = "4244598_melonbd"; //si el servidor es con localhost = root
    private final String Password = "*bjfLvh]6R6a7^;3";    //si el servidor es con localhost = ""*/
    //Datos necesarios
    private final String Puerto = "3306"; //Es el puerto definido para MySQL
    private final String Url = "jdbc:mysql://"+Servidor+":"+Puerto+"/"+Database;    
    
    //Conexión
    private Connection Con;

    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = (Connection) DriverManager.getConnection(Url,Usuario,Password);
            System.out.println("Conexión estrablecida con la base de datos "+Database);
            //JOptionPane.showMessageDialog(null,"Conexión estrablecida con la base de datos "+Database);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        return Con; //retorna la conexion a la base de datos
    }
}

