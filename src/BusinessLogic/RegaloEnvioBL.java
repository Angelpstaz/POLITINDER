package BusinessLogic;

import java.util.List;

import DataAccessComponent.RegaloEnvioDAO;
import DataAccessComponent.DTO.RegaloEnvioDTO;

public class RegaloEnvioBL {
    private RegaloEnvioDTO redto = new RegaloEnvioDTO();
    private RegaloEnvioDAO redao = new RegaloEnvioDAO();
    
    public List<RegaloEnvioDTO> readAll()throws Exception{
        return redao.readAll();
    }
    public RegaloEnvioDTO read (int IdRegaloEnvio) throws Exception{
        redto= redao.readBy(IdRegaloEnvio);
        return  redto;
    }
    public boolean create(RegaloEnvioDTO redto)throws Exception{
        return redao.create(redto);
    }
    public boolean update(RegaloEnvioDTO redto) throws Exception{
        return redao.update(redto);
    }
    public boolean delete(int IdRegaloEnvio)throws Exception{
        return redao.delete(IdRegaloEnvio);
    }
    public Integer getMaxRow() throws Exception{
        return redao.getMaxRow();
    }
}
