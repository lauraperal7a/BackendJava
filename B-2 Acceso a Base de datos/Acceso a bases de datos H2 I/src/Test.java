import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws Exception{
        //para conectarnos necesitamos crear una nueva instancia del driver
        Class.forName("org.h2.Driver").newInstance();
        // creamos una nueva conexion utilizando el driverManager
        Connection con = DriverManager.getConnection("jdbc:h2:"+
                "./Database/my", "root", "myPassword");

        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        // Se crea una tabla llamada Test que lleva un nombre y un id
        String createSql = "DROP TABLE IF EXISTS TEST;\n" +
                "CREATE TABLE TEST(ID INT PRIMARY KEY, FIGURA VARCHAR(255), COLOR VARCHAR(255));\n" +
                "INSERT INTO TEST VALUES(1, 'Circulo', 'Rojo');\n" +
                "INSERT INTO TEST VALUES(2, 'Circulo', 'Azul');\n" +
                "INSERT INTO TEST VALUES(3, 'Cuadrado', 'Violeta');\n" +
                "INSERT INTO TEST VALUES(4, 'Cuadrado', 'Naranja');\n" +
                "INSERT INTO TEST VALUES(5, 'Circulo', 'Verde');\n";
        // usamos el objeto Statemnt y utilizamos el metodo execute, por parametro pasamos
        //la tabla creada anteriormente
        stmt.execute(createSql);

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from TEST";
        //nos devuelve un tipo de objeto ResultSet
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        // Itera mientras rd tenga un próximo elemento
        while(rd.next()) {
            // pasamos por parametro el índice de la columna
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getString(3));
        }
    }
}

