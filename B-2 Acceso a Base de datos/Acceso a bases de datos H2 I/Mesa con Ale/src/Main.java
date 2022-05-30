import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS FIGURA; CREATE TABLE FIGURA "
            + "("
            + " ID INT PRIMARY KEY,"
            + " FIGURA VARCHAR(50) NOT NULL, "
            + " COLOR VARCHAR(25) NOT NULL "
            + " );";

    private static final String SQL_INSERT = "INSERT INTO FIGURA (ID, FIGURA, COLOR) VALUES (1,'Circulo','Rojo')";
    private static final String SQL_INSERT2 = "INSERT INTO FIGURA (ID, FIGURA, COLOR) VALUES (2,'Circulo','Azul')";
    private static final String SQL_INSERT3 = "INSERT INTO FIGURA (ID, FIGURA, COLOR) VALUES (3,'Cuadrado','Rosa')";
    private static final String SQL_INSERT4 = "INSERT INTO FIGURA (ID, FIGURA, COLOR) VALUES (4,'Cuadrado','Verde')";
    private static final String SQL_INSERT5 = "INSERT INTO FIGURA (ID, FIGURA, COLOR) VALUES (5,'Cuadrado','Dorado')";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
    }

    public static void main(String[] args) throws Exception {

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            Statement statement2 = connection.createStatement();
            statement2.execute(SQL_INSERT);
            Statement statement3 = connection.createStatement();
            statement3.execute(SQL_INSERT2);
            Statement statement4 = connection.createStatement();
            statement4.execute(SQL_INSERT3);
            Statement statement5 = connection.createStatement();
            statement5.execute(SQL_INSERT4);
            Statement statement6 = connection.createStatement();
            statement6.execute(SQL_INSERT5);

            String sql = "SELECT * FROM FIGURA\n" +
                    "WHERE COLOR = 'Rojo';";
            Statement statement7 = connection.createStatement();
            ResultSet rd = statement7.executeQuery(sql);

            while (rd.next()) {
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}