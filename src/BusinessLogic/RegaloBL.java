package BusinessLogic;

import java.util.List;

import DataAccessComponent.RegaloDAO;
import DataAccessComponent.DTO.RegaloDTO;

public class RegaloBL {
    private RegaloDTO oRegaloDTO;
    private RegaloDAO oRegaloDAO;

    public List<RegaloDTO> readAll()throws Exception{
        return oRegaloDAO.readAll();
    }
    public RegaloDTO read (int IdRegalo) throws Exception{
        oRegaloDTO= oRegaloDAO.read(IdRegalo);
        return  oRegaloDTO;
    }
    public boolean create(RegaloDTO oRegaloDTO)throws Exception{
        return oRegaloDAO.create(oRegaloDTO);
    }
    public boolean update(RegaloDTO oRegaloDTO) throws Exception{
        return oRegaloDAO.update(oRegaloDTO);
    }
    public boolean delete(int IdRegalo)throws Exception{
        return oRegaloDAO.delete(IdRegalo);
    }
    public Integer getMaxRow() throws Exception{
        return oRegaloDAO.getMaxRow();
    }
}