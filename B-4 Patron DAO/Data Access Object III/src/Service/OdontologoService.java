package Service;

import Dao.IDao;
import Model.Odontologo;

import java.util.List;


public class OdontologoService {

    private static IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIdao) {
        this.odontologoIDao = odontologoIdao;
    }

    public Odontologo guardar(Odontologo odontologo){
        return this.odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        return this.odontologoIDao.buscarTodos();
    }
}
