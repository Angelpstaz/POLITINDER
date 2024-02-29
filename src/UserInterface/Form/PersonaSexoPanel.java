package UserInterface.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import BusinessLogic.PersonaSexoBL;
import BusinessLogic.RegaloTipoBL;
import DataAccessComponent.DTO.PersonaSexoDTO;
import DataAccessComponent.DTO.RegaloTipoDTO;

public class PersonaSexoPanel extends JPanel {
    private JTable table;
    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnRefresh;
    private JLabel lblPageInfo;
    private int currentPage = 1;
    private int pageSize = 10;

    public PersonaSexoPanel() {
        initializeUI();
        loadTableData();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Crear tabla
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Crear controles de paginación
        JPanel paginationPanel = new JPanel();
        lblPageInfo = new JLabel("Page: 1");
        paginationPanel.add(lblPageInfo);
        add(paginationPanel, BorderLayout.SOUTH);

        // Crear botones de CRUD
        JPanel crudPanel = new JPanel();
        btnCreate = new JButton("Crear");
        btnUpdate = new JButton("Actualizar");
        btnDelete = new JButton("Eliminar");
        btnRefresh = new JButton("Refrescar");
        crudPanel.add(btnCreate);
        crudPanel.add(btnUpdate);
        crudPanel.add(btnDelete);
        crudPanel.add(btnRefresh);
        add(crudPanel, BorderLayout.NORTH);

        // Asignar listeners a los botones del CRUD
        btnCreate.addActionListener(e -> createPersonaSexo());
        btnUpdate.addActionListener(e -> updatePersonaSexo());
        btnDelete.addActionListener(e -> deletePersonaSexo());
        btnRefresh.addActionListener(e -> refreshTable());
    }

    private void loadTableData() {
        try {
            // Obtener datos de la base de datos
            PersonaSexoBL personaSexoBL = new PersonaSexoBL();
            List<PersonaSexoDTO> personasSexo = personaSexoBL.getAll();

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Observación");
            model.addColumn("Estado");
            model.addColumn("Fecha de Creación");
            model.addColumn("Fecha de Modificación");

            // Agregar datos al modelo de tabla
            for (PersonaSexoDTO ps : personasSexo) {
                model.addRow(new Object[]{
                        ps.getIdPersonaSexo(),
                        ps.getNombre(),
                        ps.getObservacion(),
                        ps.getEstado(),
                        ps.getFechaCrea(),
                        ps.getFechaModifica()
                });
            }

            // Establecer el modelo de tabla en la tabla
            table.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createPersonaSexo() {
        // Solicitar al usuario el nombre del nuevo tipo de persona sexo
        String nombresexo = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo tipo de persona sexo:", "Crear Tipo de Persona Sexo", JOptionPane.QUESTION_MESSAGE);
        if (nombresexo != null && !nombresexo.isEmpty()) {
            try {
                // Crear un nuevo objeto PersonaSexoDTO con el nombre proporcionado
                PersonaSexoDTO nuevoTipoPersonaSexo = new PersonaSexoDTO();
                nuevoTipoPersonaSexo.setNombre(nombresexo);

                // Llamar al método create de PersonaSexoBL para agregar el nuevo registro
                PersonaSexoBL personaSexoBL = new PersonaSexoBL();
                boolean creado = personaSexoBL.create(nuevoTipoPersonaSexo);

                // Mostrar un mensaje de éxito o error según el resultado de la operación
                if (creado) {
                    JOptionPane.showMessageDialog(this, "Tipo de persona sexo creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    refreshTable(); // Actualizar la tabla para mostrar el nuevo registro
                } else {
                    JOptionPane.showMessageDialog(this, "Error al crear el tipo de persona sexo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al crear el tipo de persona sexo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    private void updatePersonaSexo() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int tipoPersonaID = (int) table.getValueAt(selectedRow, 0);
            String nombreActual = (String) table.getValueAt(selectedRow, 1);
    
            String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre para el tipo de persona:", nombreActual);
            if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                try {
                    PersonaSexoDTO tipoPersonaActualizado = new PersonaSexoDTO();
                    tipoPersonaActualizado.setIdPersonaSexo(tipoPersonaID);
                    tipoPersonaActualizado.setNombre(nuevoNombre);
    
                    PersonaSexoBL personaSexoBL = new PersonaSexoBL();
                    boolean actualizado = personaSexoBL.update(tipoPersonaActualizado);
    
                    if (actualizado) {
                        JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al actualizar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de persona para actualizar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void deletePersonaSexo() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int tipoPersonaID = (int) table.getValueAt(selectedRow, 0);
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este tipo de persona?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    PersonaSexoBL personaSexoBL = new PersonaSexoBL();
                    boolean eliminado = personaSexoBL.delete(tipoPersonaID);
    
                    if (eliminado) {
                        JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al eliminar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de persona para eliminar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void refreshTable() {
        loadTableData();
    }
}
