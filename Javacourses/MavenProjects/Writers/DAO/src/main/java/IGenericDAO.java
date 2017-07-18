

import java.util.List;

public interface IGenericDAO<E,K> {
    void delete(K id);
    void insert(E entity);
    void update(E entity);
    List<E> getAllEntity();
    E getEntityById(K id);

}
