package DataAccessComponent;

import java.util.List;

public interface IDAO <T> {
    public  boolean create(T entity) throws Exception;
    public List<T>  readAll() throws Exception;
    public T read(Integer id) throws Exception;
    public  boolean update(T entity) throws Exception;  // dame la entidad y actualizo eso en la base
    public  boolean delete(Integer id) throws Exception; // quiero borrar algo, dame un id y lo hago.
    public  Integer getMaxRow() throws Exception;
    
}
