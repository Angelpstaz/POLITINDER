package BusinessLogic;

import java.util.List;

import DataAccessComponent.RelacionDAO;
import DataAccessComponent.DTO.RelacionDTO;

public class RelacionBL {
    private RelacionDTO rldt;
    private RelacionDAO rlda;
    public RelacionBL() {
    }
    public List<RelacionDTO> readAll()throws Exception{
        return rlda.readAll();
    }
    public RelacionDTO read (int IdRelacion) throws Exception{
        rldt= rlda.read(IdRelacion);
        return  rldt;
    }
    public boolean create(RelacionDTO rldto)throws Exception{
        return rlda.create(rldt);
    }
    public boolean update(RelacionDTO rldto) throws Exception{
        return rlda.update(rldto);
    }
    public boolean delete(int IdRelacion)throws Exception{
        return rlda.delete(IdRelacion);
    }
    public Integer getMaxRow() throws Exception{
        return rlda.getMaxRow();
    }
}
