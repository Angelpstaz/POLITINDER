package BusinessLogic;

import java.util.List;

import DataAccessComponent.RegaloTipoDAO;
import DataAccessComponent.DTO.RegaloTipoDTO;

public class RegaloTipoBL {
    private RegaloTipoDTO oDTORegaloTipo;
    private RegaloTipoDAO rtdao = new RegaloTipoDAO();
    
    public List<RegaloTipoDTO> getAll() throws Exception{
        return rtdao.readAll();
    }
    public RegaloTipoDTO getByIdregalotipo(int idregalotipo) throws Exception{
        oDTORegaloTipo = rtdao.readBy(idregalotipo);
        return oDTORegaloTipo;
    }
    public boolean create(RegaloTipoDTO RegaloTipoDTO) throws Exception{   
        return rtdao.create(RegaloTipoDTO);
    }
    public boolean update(RegaloTipoDTO RegaloTipoDTO) throws Exception{
        return rtdao.update(RegaloTipoDTO);
    }
    public boolean delete(int idregalotipo) throws Exception{
        return rtdao.delete(idregalotipo);
    }
    public Integer getMaxRow() throws Exception{
        return rtdao.getMaxRow();
    }
}
