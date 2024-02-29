package BusinessLogic;

import java.util.List;

import DataAccessComponent.PersonaRolDAO;
import DataAccessComponent.DTO.PersonaRolDTO;

public class PersonaRolBL {
    private PersonaRolDTO personarol;
    private PersonaRolDAO prDAO = new PersonaRolDAO();

    public PersonaRolBL(){}

    public List<PersonaRolDTO> getAll() throws Exception{
        return prDAO.readAll();
    }
    public PersonaRolDTO getByIdpersonarol(int idpersonarol) throws Exception{
        personarol = prDAO.readBy(idpersonarol);
        return personarol;
    }
    public boolean create(PersonaRolDTO PersonaRolDTO) throws Exception{   
        return prDAO.create(PersonaRolDTO);
    }
    public boolean update(PersonaRolDTO PersonaRolDTO) throws Exception{
        return prDAO.update(PersonaRolDTO);
    }
    public boolean delete(int idpersonarol) throws Exception{
        return prDAO.delete(idpersonarol);
    }
    public Integer getMaxRow() throws Exception{
        return prDAO.getMaxRow();
    }
}
