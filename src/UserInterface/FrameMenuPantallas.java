package UserInterface;

import javax.swing.*;

import UserInterface.Form.FramePersona;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenuPantallas extends JFrame {
    public JFrame frame;
    private JButton regaloTipoButton;
    private JButton personaRolButton;
    private JButton personaSexoButton;
    private JButton personaButton;
    private JButton regaloButton;
    private JButton relacionTipoButton;
    private JButton relacionButton;
    private JButton citaButton;
    private JButton regaloEnvioButton;



    public FrameMenuPantallas() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Database Menu");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        regaloTipoButton = new JButton("RegaloTipo");
        regaloTipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegaloTipo();
            }
        });
        
        frame.getContentPane().add(regaloTipoButton);

        personaRolButton = new JButton("PersonaRol");
        personaRolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePersonaRol();
            }
        });
        frame.getContentPane().add(personaRolButton);

        personaSexoButton = new JButton("PersonaSexo");
        personaSexoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePersonaSexo();
            }
        });
        frame.getContentPane().add(personaSexoButton);

        personaButton = new JButton("Persona");
        /////////////////////
        personaButton.addActionListener( e -> new FramePersona().createAndShowGUI());
        frame.getContentPane().add(personaButton);

        regaloButton = new JButton("Regalo");
        regaloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegalo();
            }
        });
        frame.getContentPane().add(regaloButton);

        relacionTipoButton = new JButton("RelacionTipo");
        relacionTipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRelacionTipo();
            }
        });
        frame.getContentPane().add(relacionTipoButton);

        relacionButton = new JButton("Relacion");
        relacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRelacion();
            }
        });
        frame.getContentPane().add(relacionButton);

        citaButton = new JButton("Cita");
        citaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCita();
            }
        });
        frame.getContentPane().add(citaButton);

        regaloEnvioButton = new JButton("RegaloEnvio");
        regaloEnvioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegaloEnvio();
            }
        });
        frame.getContentPane().add(regaloEnvioButton);
    }

    private void handleRegaloTipo() {
        // Implement interaction for RegaloTipo
    }

    private void handlePersonaRol() {
        // Implement interaction for PersonaRol
    }

    private void handlePersonaSexo() {
        // Implement interaction for PersonaSexo
    }

    private void handlePersona() {
        // Implement interaction for Persona
    }

    private void handleRegalo() {
        // Implement interaction for Regalo
    }

    private void handleRelacionTipo() {
        // Implement interaction for RelacionTipo
    }

    private void handleRelacion() {
        // Implement interaction for Relacion
    }

    private void handleCita() {
        // Implement interaction for Cita
    }

    private void handleRegaloEnvio() {
        // Implement interaction for RegaloEnvio
    }
    private void setFrame(JFrame formularioPanel) {
        Container container = getContentPane();
        container.remove(frame);
        frame = formularioPanel;
        container.add(frame, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
