package ej_CRUD;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> obtener(String id);
    List<T> obtenerTodos();
    void guardar(T t);
    void actualizar(T t);
    void borrar(T t);
}
