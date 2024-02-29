package BusinessLogic;

import java.util.List;

import DataAccessComponent.PersonaRolDAO;
import DataAccessComponent.DTO.PersonaRolDTO;
import Framework.PatException;

public class PersonaRolBL {
    private PersonaRolDTO personarol;
    private PersonaRolDAO prDAO = new PersonaRolDAO();

    public PersonaRolBL(){}

    public List<PersonaRolDTO> getAll() throws Exception{
         try {
            prDAO.readAll();
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getAll()");
        }
        return prDAO.readAll();
    }
    public PersonaRolDTO getByIdpersonarol(int idpersonarol) throws Exception{
        try {
            personarol = prDAO.readBy(idpersonarol);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getByIdregalotipo()");
        }
        return personarol;
    }
    public boolean create(PersonaRolDTO PersonaRolDTO) throws Exception{   
        boolean n;
        try {
            n=prDAO.create(PersonaRolDTO);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }   
        return n;   
    }
    public boolean update(PersonaRolDTO PersonaRolDTO) throws Exception{
        boolean n;
        try {
            n=prDAO.update(PersonaRolDTO);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }   
        return n;
    }
    public boolean delete(int idpersonarol) throws Exception{
        boolean n;
        try {
            n=prDAO.delete(idpersonarol);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }   
        return n;
    }
    public Integer getMaxRow() throws Exception{
        int n;
        try {
            n=prDAO.getMaxRow();
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }   
        return n;
    }
}
