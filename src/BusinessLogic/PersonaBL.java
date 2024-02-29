package BusinessLogic;

import java.util.List;

import DataAccessComponent.PersonaDAO;
import DataAccessComponent.DTO.PersonaDTO;
public class PersonaBL {
    
    private PersonaDAO pDa;
    private PersonaDTO pDt;
    
    public List<PersonaDTO> readAll()throws Exception{
        return pDa.readAll();
    }
    public PersonaDTO read (int IdRelacion) throws Exception{
        pDt= pDa.read(IdRelacion);
        return  pDt;
    }
    // public PersonaDTO getByIdPersona(int idPersona) throws Exception{
    //     pDt = pDa.readBy(idPersona);
    //     return pDt;
    // }
    public boolean create(PersonaDTO pDto)throws Exception{
        return pDa.create(pDt);
    }
    public boolean update(PersonaDTO pDto) throws Exception{
        return pDa.update(pDto);
    }
    public boolean delete(int IdPesona)throws Exception{
        return pDa.delete(IdPesona);
    }
    public Integer getMaxRow() throws Exception{
        return pDa.getMaxRow();
    }
}
