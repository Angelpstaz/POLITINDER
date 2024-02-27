
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import DataAccessComponent.RegaloTipoDAO;
import DataAccessComponent.RelacionTipoDAO;
import DataAccessComponent.DTO.RegaloTipoDTO;
import DataAccessComponent.DTO.RelacionTipoDTO;
import UserInterface.FrameMenuPantallas;
import UserInterface.Form.SplashScreenForm;

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
        
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } 
        SplashScreenForm.show();

        frameMenu.frame.setVisible(true);

    }
   
}

