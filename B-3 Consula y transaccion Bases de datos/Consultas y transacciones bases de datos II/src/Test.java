import java.sql.*;

public class Test {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " APELLIDO varchar(100) NOT NULL, "
            + " MATRICULA varchar(100) NOT NULL"
            + " )";

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO "
            + "(ID, NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGO SET MATRICULA = ? WHERE ID = ?";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        Odontologo odontologo = new Odontologo("Martinez", "Arnold", "ASD123");

        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, 1);
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.setString(4, odontologo.getMatricula());
            ps.execute();

            PreparedStatement ps1 = connection.prepareStatement(SQL_UPDATE);
            String nuevaMatricula = "XYZ987";
            ps1.setString(1, nuevaMatricula);
            ps1.setInt(2, 1);
            ps1.execute();

            String sql = "SELECT * FROM ODONTOLOGO";
            Statement sqlSmt = connection.createStatement();
            ResultSet rs = sqlSmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
            }

        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }

    }
}