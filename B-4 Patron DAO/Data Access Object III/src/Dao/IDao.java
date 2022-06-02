package Dao;

import java.util.List;

public interface IDao<T> {
    public T guardar(T t);
    public T buscar(int id);
    public List<T> buscarTodos();
}
