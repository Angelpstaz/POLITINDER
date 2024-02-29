package UserInterface.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import BusinessLogic.RegaloBL;
import BusinessLogic.RegaloEnvioBL;
import BusinessLogic.RelacionTipoBL;
import DataAccessComponent.DTO.RegaloDTO;
import DataAccessComponent.DTO.RegaloEnvioDTO;
import DataAccessComponent.DTO.RegaloTipoDTO;
import DataAccessComponent.DTO.RelacionTipoDTO;

public class RegaloEnvioPanel extends JPanel {
    private JTable table;
    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnRefresh;
    private JButton btnFirstPage;
    private JButton btnPrevPage;
    private JButton btnNextPage;
    private JButton btnLastPage;
    private JLabel lblPageInfo;
    private int currentPage = 1;
    private int pageSize = 10;

    public RegaloEnvioPanel() {
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
        btnFirstPage = new JButton("<<");
        btnPrevPage = new JButton("<");
        lblPageInfo = new JLabel("Page: 1");
        btnNextPage = new JButton(">");
        btnLastPage = new JButton(">>");
        paginationPanel.add(btnFirstPage);
        paginationPanel.add(btnPrevPage);
        paginationPanel.add(lblPageInfo);
        paginationPanel.add(btnNextPage);
        paginationPanel.add(btnLastPage);
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

        // Asignar listeners a los botones de paginación
        btnFirstPage.addActionListener(e -> goToFirstPage());
        btnPrevPage.addActionListener(e -> goToPrevPage());
        btnNextPage.addActionListener(e -> goToNextPage());
        btnLastPage.addActionListener(e -> goToLastPage());

        // Asignar listeners a los botones del CRUD
        btnCreate.addActionListener(e -> createRegaloEnvio());
        btnUpdate.addActionListener(e -> updateRegaloEnvio());
        btnDelete.addActionListener(e -> deleteRelacionTipo());
        btnRefresh.addActionListener(e -> refreshTable());
    }

    private void loadTableData() {
        try {
            // Obtener datos de la base de datos
            RegaloEnvioBL RegaloEnvioBL = new RegaloEnvioBL();
            List<RegaloEnvioDTO> RE = RegaloEnvioBL.readAll();

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("ID REGALO");
            model.addColumn("ID PERSONA ENVIA");
            model.addColumn("ID PERSONA RECIBE");
            model.addColumn("Observación");
            model.addColumn("Estado");
            model.addColumn("Fecha de Creación");
            model.addColumn("Fecha de Envio");
            model.addColumn("Fecha de Modificación");

            // Agregar datos al modelo de tabla
            for (RegaloEnvioDTO RegaloEnvio : RE) {
                model.addRow(new Object[]{
                        RegaloEnvio.getIdRegaloEnvio(),
                        RegaloEnvio.getIdRegalo(),
                        RegaloEnvio.getIdPersonaEnvia(),
                        RegaloEnvio.getIdPersonaRecibe(),
                        RegaloEnvio.getEstado(),
                        RegaloEnvio.getFechaCrea(),
                        RegaloEnvio.getFechaEnvio(),
                        RegaloEnvio.getFechaModifica()
                });
            }

            // Establecer el modelo de tabla en la tabla
            table.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void goToFirstPage() {
        currentPage = 1;
        updateTableData();
    }

    private void goToPrevPage() {
        if (currentPage > 1) {
            currentPage--;
            updateTableData();
        }
    }

    private void goToNextPage() {
        int totalRecords = getTotalRecords();
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
        if (currentPage < totalPages) {
            currentPage++;
            updateTableData();
        }
    }

    private void goToLastPage() {
        int totalRecords = getTotalRecords();
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
        currentPage = totalPages;
        updateTableData();
    }

    private void updateTableData() {
        int offset = (currentPage - 1) * pageSize;
        try {
            // Obtener datos de la base de datos con paginación
            RegaloEnvioBL RegaloEnvioBL = new RegaloEnvioBL();
            List<RegaloEnvioDTO> RE = RegaloEnvioBL.readAll();

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("ID REGALO");
            model.addColumn("ID PERSONA ENVIA");
            model.addColumn("ID PERSONA RECIBE");
            model.addColumn("Estado");
            model.addColumn("Fecha de Creación");
            model.addColumn("Fecha de Envio");
            model.addColumn("Fecha de Modificación");

            // Agregar datos al modelo de tabla
            for (RegaloEnvioDTO RegaloEnvio : RE) {
                model.addRow(new Object[]{
                    RegaloEnvio.getIdRegaloEnvio(),
                    RegaloEnvio.getIdRegalo(),
                    RegaloEnvio.getIdPersonaEnvia(),
                    RegaloEnvio.getIdPersonaRecibe(),
                    RegaloEnvio.getEstado(),
                    RegaloEnvio.getFechaCrea(),
                    RegaloEnvio.getFechaEnvio(),
                    RegaloEnvio.getFechaModifica()
                });
            }

            // Establecer el modelo de tabla en la tabla
            table.setModel(model);
            lblPageInfo.setText("Page: " + currentPage);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getTotalRecords() {
        try {
            RegaloEnvioBL RegaloEnvioBL = new RegaloEnvioBL();
            return RegaloEnvioBL.getMaxRow();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener el número total de registros: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

      private void createRegaloEnvio() {
        String regalo = JOptionPane.showInputDialog(this, "Ingrese el regalo del nuevo envio:", "Crear Regalo Tipo", JOptionPane.QUESTION_MESSAGE);
        String personaunoenvia = JOptionPane.showInputDialog(this, "Ingrese la persona que envia del nuevo envio:", "Crear Regalo Tipo", JOptionPane.QUESTION_MESSAGE);
        String personadosrecibe = JOptionPane.showInputDialog(this, "Ingrese la persona que recibe del nuevo envio:", "Crear Regalo Tipo", JOptionPane.QUESTION_MESSAGE);

        int numeroregalo = Integer.parseInt(regalo);
        int numerope = Integer.parseInt(personaunoenvia);
        int numeropr = Integer.parseInt(personadosrecibe);

        RegaloEnvioDTO nuevoregalo = new RegaloEnvioDTO(numeroregalo, numerope, numeropr);

    if (regalo != null && !regalo.isEmpty()) {
         try {
             RegaloEnvioBL bl = new RegaloEnvioBL();
             boolean creado = bl.create(nuevoregalo);
             if (creado) {
                 JOptionPane.showMessageDialog(this, "Registro creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 refreshTable();
             } else {
                 JOptionPane.showMessageDialog(this, "Error al crear el registro", "Error", JOptionPane.ERROR_MESSAGE);
             }
         } catch (Exception ex) {
             ex.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al crear el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
     }
    


    private void updateRegaloEnvio() {
        // Obtener el índice de la fila seleccionada
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) {
        // Obtener el ID del RegaloEnvio seleccionado
        int RegaloEnvioID = (int) table.getValueAt(selectedRow, 0);
        // Obtener el nombre actual del RegaloEnvio seleccionado
        String nombreActual = (String) table.getValueAt(selectedRow, 1);

        // Solicitar al usuario el nuevo nombre del RegaloEnvio
        String nuevaFecha = JOptionPane.showInputDialog(this, "Ingrese la nueva fecha para el RegaloEnvio:", nombreActual);
        if (nuevaFecha != null && !nuevaFecha.isEmpty()) {
            try {
                RegaloEnvioDTO RelacionActualizado = new RegaloEnvioDTO();
                RelacionActualizado.setIdRegaloEnvio(RegaloEnvioID);
                RelacionActualizado.setFechaEnvio(nuevaFecha);

                RegaloEnvioBL RegaloEnvioBL = new RegaloEnvioBL();
                boolean actualizado = RegaloEnvioBL.update(RelacionActualizado);

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
        JOptionPane.showMessageDialog(this, "Seleccione un RegaloEnvio para actualizar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    private void deleteRelacionTipo() {
        // Obtener el índice de la fila seleccionada
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) {
        // Confirmar si el usuario desea eliminar el RegaloEnvio seleccionado
        int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este RegaloEnvio?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Obtener el ID del RegaloEnvio seleccionado
            int RegaloEnvioID = (int) table.getValueAt(selectedRow, 0);

            try {
                RegaloEnvioBL RegaloEnvioBL = new RegaloEnvioBL();
                boolean eliminado = RegaloEnvioBL.delete(RegaloEnvioID);

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
        JOptionPane.showMessageDialog(this, "Seleccione un RegaloEnvio para eliminar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    private void refreshTable() {
        loadTableData();
    }
}
