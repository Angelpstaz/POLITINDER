import DataAccessComponent.RegaloTipoDAO;
import DataAccessComponent.DTO.RegaloTipoDTO;
import UserInterface.FrameMenuPantallas;

public class App {
    public static void main(String[] args) throws Exception {
        RegaloTipoDAO n = new RegaloTipoDAO();
        RegaloTipoDTO q = new RegaloTipoDTO();
        RelacionTipoDAO rtdao = new RelacionTipoDAO();
        RelacionTipoDTO rtdto = new RelacionTipoDTO();
        q = n.read(1);
        rtdto = rtdao.read(1);
        System.out.println(q.getNombre());
        System.out.println(rtdto.getNombre());
        FrameMenuPantallas frameMenu = new FrameMenuPantallas();
        frameMenu.frame.setVisible(true);

    }
   
}

