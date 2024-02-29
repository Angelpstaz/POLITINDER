package BusinessLogic;

import java.util.List;

import DataAccessComponent.PersonaSexoDAO;
import DataAccessComponent.DTO.PersonaSexoDTO;

public class PersonaSexoBL {
    private PersonaSexoDTO psdt;
    private PersonaSexoDAO psda = new PersonaSexoDAO();
    
    public List<PersonaSexoDTO> getAll()throws Exception{
        return psda.readAll();
    }
    public PersonaSexoDTO readByIdPersonaSexo (int IdPersonaSexo) throws Exception{
        psdt= psda.readBy(IdPersonaSexo);
        return  psdt;
    }
    public boolean create(PersonaSexoDTO psdto)throws Exception{
        return psda.create(psdto);
    }
    public boolean update(PersonaSexoDTO psdto) throws Exception{
        return psda.update(psdto);
    }
    public boolean delete(int IdPesonaSexo)throws Exception{
        return psda.delete(IdPesonaSexo);
    }
    public Integer getMaxRow() throws Exception{
        return psda.getMaxRow();
    }
}
