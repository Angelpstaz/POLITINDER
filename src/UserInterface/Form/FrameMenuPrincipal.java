package UserInterface.Form;

import UserInterface.Style;
import UserInterface.CustomerControl.PatButton;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameMenuPrincipal extends JPanel {
    public  PatButton   
            btnHome   = new PatButton("HOME"),
            btnRegalo           = new PatButton("REGALO"),
            btnRegaloTipo       = new PatButton("REGALO TIPO"),
            btnCita             = new PatButton("CITA"),
            btnRelacionTipo     = new PatButton("RELACION TIPO"),
            btnPersonaRol       = new PatButton("PERSONA ROL"),
            btnPersonaSexo      = new PatButton("PERSONA SEXO"),
            btnPersona          = new PatButton("PERSONA");

    public FrameMenuPrincipal(){
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight())); 

        // add-logo
        try {
            Image logo = ImageIO.read(Style.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add-botones
        add(btnHome);
        add(btnRegalo);
        add(btnRegaloTipo);
        add(btnCita);
        add(btnRelacionTipo);
        add(btnPersonaRol);
        add(btnPersonaSexo);
        add(btnPersona);

        // add-copyright
        add(new JLabel("\u00A9 2024 POLITINDER"));
    }
}
