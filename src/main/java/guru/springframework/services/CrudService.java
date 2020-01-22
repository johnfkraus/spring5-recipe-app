package guru.springframework.services;

import java.util.Set;

// 1. provides standard CRUD methods
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
