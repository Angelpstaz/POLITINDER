import DataAccessComponent.RegaloTipoDAO;
import DataAccessComponent.DTO.RegaloTipoDTO;

public class App {
    public static void main(String[] args) throws Exception {
        RegaloTipoDAO n = new RegaloTipoDAO();
        RegaloTipoDTO q = new RegaloTipoDTO();
        q = n.read(1);
        System.out.println(q.getNombre());
        
    }
}
