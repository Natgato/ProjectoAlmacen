package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    // Ruta a la base de datos
    private static final String URL = "jdbc:ucanaccess://C:\\Users\\Ramirez\\Music\\ProyectoAlmacen-20250619T221931Z-1-001\\ProyectoAlmacen\\BD\\BDAlmacen1.accdb"; 
    private static final String DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    private Connection conexion = null;
   

    // Método para obtener la conexión
    public Connection getConexion() {
        try {
            Class.forName(DRIVER); // Cargar el driver UcanAccess
            conexion = DriverManager.getConnection(URL); // Establecer la conexión
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos....falla");
        }
        return conexion; // Devuelve la conexión o null si falla    
}
    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
        }
    }
}