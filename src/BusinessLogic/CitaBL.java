package BusinessLogic;

import java.util.List;

import DataAccessComponent.CitaDAO;
import DataAccessComponent.DTO.CitaDTO;

public class CitaBL {
    private CitaDTO oCitaDTO;
    private CitaDAO oCitaDAO = new CitaDAO();

    public List<CitaDTO> readAll()throws Exception{
        return oCitaDAO.readAll();
    }
    public CitaDTO read (int IdCita) throws Exception{
        oCitaDTO= oCitaDAO.readBy(IdCita);
        return  oCitaDTO;
    }
    public boolean create(CitaDTO oCitaDTO)throws Exception{
        return oCitaDAO.create(oCitaDTO);
    }
    public boolean update(CitaDTO oCitaDTO) throws Exception{
        return oCitaDAO.update(oCitaDTO);
    }
    public boolean delete(int IdCita)throws Exception{
        return oCitaDAO.delete(IdCita);
    }
    public Integer getMaxRow() throws Exception{
        return oCitaDAO.getMaxRow();
    }
}