package Dao.implementa;

import Dao.IDao;
import Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO odontologos(matricula,nombre,apellido) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next())
                odontologo.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("error: ", throwables);
        }
        logger.debug("ODONTOLOGO GUARDADO: " + "ID: " + odontologo.getId() + " MATRICULA: " + odontologo.getMatricula() +
                " NOMBRE: " + odontologo.getNombre() + " APELLIDO: " + odontologo.getApellido());
        return odontologo;
    }

    @Override
    public Odontologo buscar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT id,matricula,nombre,apellido FROM odontologos where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int idOdontologo = result.getInt("id");
                String matricula = result.getString("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                odontologo = new Odontologo(idOdontologo, matricula, nombre, apellido);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("error: ", throwables);
        }
        logger.debug("ODONTOLOGO ENCONTRADO: " + "ID: " + odontologo.getId() + " MATRICULA: " + odontologo.getMatricula() +
                " NOMBRE: " + odontologo.getNombre() + " APELLIDO: " + odontologo.getApellido());
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT *  FROM odontologos");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int idOdontologo = result.getInt("id");
                String matricula = result.getString("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                Odontologo odontologo = new Odontologo(idOdontologo, matricula, nombre, apellido);

                odontologos.add(odontologo);

            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error("error: ", throwables);
        }

        return odontologos;

    }
}
