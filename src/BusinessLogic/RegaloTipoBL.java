package BusinessLogic;

import java.util.List;

import DataAccessComponent.RegaloTipoDAO;
import DataAccessComponent.DTO.RegaloTipoDTO;
import Framework.PatException;

public class RegaloTipoBL {
    private RegaloTipoDTO oDTORegaloTipo;
    private RegaloTipoDAO rtdao = new RegaloTipoDAO();
    
    public List<RegaloTipoDTO> getAll() throws Exception{
        try {
            rtdao.readAll();
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getAll()");
        }
        return rtdao.readAll();
    }
    public RegaloTipoDTO getByIdregalotipo(int idregalotipo) throws Exception{
        try {
            oDTORegaloTipo = rtdao.readBy(idregalotipo);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getByIdregalotipo()");
        }
        return oDTORegaloTipo;
    }
    public boolean create(RegaloTipoDTO RegaloTipoDTO) throws Exception{
        boolean n;
        try {
            n=rtdao.create(RegaloTipoDTO);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }   
        return n;   
    }
    public boolean update(RegaloTipoDTO RegaloTipoDTO) throws Exception{
        boolean n;
        try {
            n=rtdao.update(RegaloTipoDTO);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }   
        return n;
    }
    public boolean delete(int idregalotipo) throws Exception{
        boolean n;
        try {
            n=rtdao.delete(idregalotipo);
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }   
        return n;
    }
    public Integer getMaxRow() throws Exception{
        int n;
        try {
            n=rtdao.getMaxRow();
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }   
        return n;
    }
}
