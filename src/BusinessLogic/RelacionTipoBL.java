package BusinessLogic;

import java.util.List;

import DataAccessComponent.RelacionTipoDAO;
import DataAccessComponent.DTO.RelacionTipoDTO;

public class RelacionTipoBL {
    private RelacionTipoDTO oRelacionTipoDTO;
    private RelacionTipoDAO oRelacionTipoDAO;

    public List<RelacionTipoDTO> readAll()throws Exception{
        return oRelacionTipoDAO.readAll();
    }
    public RelacionTipoDTO read (int IdRelacionTipo) throws Exception{
        oRelacionTipoDTO= oRelacionTipoDAO.read(IdRelacionTipo);
        return  oRelacionTipoDTO;
    }
    public boolean create(RelacionTipoDTO oRelacionTipoDTO)throws Exception{
        return oRelacionTipoDAO.create(oRelacionTipoDTO);
    }
    public boolean update(RelacionTipoDTO oRelacionTipoDTO) throws Exception{
        return oRelacionTipoDAO.update(oRelacionTipoDTO);
    }
    public boolean delete(int IdRelacionTipo)throws Exception{
        return oRelacionTipoDAO.delete(IdRelacionTipo);
    }
    public Integer getMaxRow() throws Exception{
        return oRelacionTipoDAO.getMaxRow();
    }
}