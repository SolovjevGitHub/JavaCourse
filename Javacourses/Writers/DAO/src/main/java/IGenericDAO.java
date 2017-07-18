

import java.sql.Connection;
import java.util.List;

public interface IGenericDAO<E,K> {
    void delete(K id,Connection connection);
    void insert(E entity, Connection connection);
    void update(E entity,Connection connection);
    List<E> getAllEntity(Connection connection);
    E getEntityById(K id,Connection connection);

}
