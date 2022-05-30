import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Clase12 {

    private final static Logger logger = Logger.getLogger(Clase12.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE VARCHAR(50) NOT NULL, "
            + " APELLIDO VARCHAR(25) NOT NULL, "
            + " EMAIL VARCHAR(25) NOT NULL, "
            + " TELEFONO VARCHAR(20) NOT NULL "
            + " );";

    private static final String SQL_INSERT = "INSERT INTO EMPLEADO (ID, NOMBRE, APELLIDO, EMAIL, TELEFONO) VALUES (1,'Marcos','Perez','marcos@mail.com','123456')";
    private static final String SQL_INSERT2 = "INSERT INTO EMPLEADO (ID, NOMBRE, APELLIDO, EMAIL, TELEFONO) VALUES (2,'Ana Maria','Gonzalez','anamaria@mail.com','789456')";
    private static final String SQL_INSERT3 = "INSERT INTO EMPLEADO (ID, NOMBRE, APELLIDO, EMAIL, TELEFONO) VALUES (3,'Lily','Marin','lily@mail.com','123987')";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").componentType();
        return DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
    }

    public static void main(String[] args) throws Exception {

        File log4jfile = new File("./src/config/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            statement.execute(SQL_INSERT);
            statement.execute(SQL_INSERT2);
            statement.execute(SQL_INSERT3);

            String sql = "SELECT * FROM EMPLEADO";
            String sql2 = "UPDATE EMPLEADO SET NOMBRE = 'Laura' WHERE ID = 2";
            statement.execute(sql2);
            ResultSet rs = statement.executeQuery(sql);

            logger.debug("Modificaste al empleado");

            String sql3 = "DELETE FROM EMPLEADO WHERE ID = 1";
            statement.execute(sql3);

            logger.info("Eliminaste al empleado");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5));
            }
        } catch (Exception e) {
            logger.error("Estas insertando un registro con ID repetido");
        } finally {
            connection.close();
        }

    }
}