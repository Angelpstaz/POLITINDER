package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UserInterface.Style;

public class MainForm extends JFrame {
    FrameMenuPrincipal pnlMenu = new FrameMenuPrincipal();
    JPanel pnlMain = new MainPanel();

    public MainForm(String titleApp) {
        customizeComponent(titleApp);
        pnlMenu.btnHome.addActionListener(e -> setPanel(new MainPanel()));
        pnlMenu.btnRegalo.addActionListener(e -> setPanel(new RegaloPanel()));
        pnlMenu.btnRegaloTipo.addActionListener(e -> setPanel(new RegaloTipoPanel()));
        pnlMenu.btnCita.addActionListener(e -> setPanel(new CitaPanel()));
        pnlMenu.btnRelacionTipo.addActionListener(e -> setPanel(new RelacionTipoPanel()));
        pnlMenu.btnPersona.addActionListener(e ->  setPanel(new PersonaPanel()));
        pnlMenu.btnPersonaSexo.addActionListener(e ->  setPanel(new PersonaSexoPanel()));
        pnlMenu.btnRegaloEnvio.addActionListener(e ->  setPanel(new RegaloEnvioPanel()));
    }

    private void setPanel(JPanel panel) {
        getContentPane().remove(pnlMain);
        pnlMain = panel;
        getContentPane().add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void customizeComponent(String titleApp) {
        setTitle(titleApp);
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}