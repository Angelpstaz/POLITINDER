package BusinessLogic;

import java.util.List;

import DataAccessComponent.PersonaSexoDAO;
import DataAccessComponent.DTO.PersonaSexoDTO;

public class PersonaSexoBL {
    private PersonaSexoDTO psdt;
    private PersonaSexoDAO psda;
    
    public List<PersonaSexoDTO> readAll()throws Exception{
        return psda.readAll();
    }
    public PersonaSexoDTO read (int IdRelacion) throws Exception{
        psdt= psda.read(IdRelacion);
        return  psdt;
    }
    public boolean create(PersonaSexoDTO psdto)throws Exception{
        return psda.create(psdt);
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
