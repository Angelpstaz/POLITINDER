package UserInterface.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import BusinessLogic.RegaloTipoBL;
import DataAccessComponent.DTO.RegaloTipoDTO;

public class RegaloTipoPanel extends JPanel {
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

    public RegaloTipoPanel() {
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
        btnCreate.addActionListener(e -> createRegaloTipo());
        btnUpdate.addActionListener(e -> updateRegaloTipo());
        btnDelete.addActionListener(e -> deleteRegaloTipo());
        btnRefresh.addActionListener(e -> refreshTable());
    }

    private void loadTableData() {
        try {
            // Obtener datos de la base de datos
            RegaloTipoBL regaloTipoBL = new RegaloTipoBL();
            List<RegaloTipoDTO> regalos = regaloTipoBL.getAll();

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Observación");
            model.addColumn("Estado");
            model.addColumn("Fecha de Creación");
            model.addColumn("Fecha de Modificación");

            // Agregar datos al modelo de tabla
            for (RegaloTipoDTO regalo : regalos) {
                model.addRow(new Object[]{
                        regalo.getIdRegaloTipo(),
                        regalo.getNombre(),
                        regalo.getObservacion(),
                        regalo.getEstado(),
                        regalo.getFechaCrea(),
                        regalo.getFechaModifica()
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
            RegaloTipoBL regaloTipoBL = new RegaloTipoBL();
            List<RegaloTipoDTO> regalos = regaloTipoBL.getAll();

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Observación");
            model.addColumn("Estado");
            model.addColumn("Fecha de Creación");
            model.addColumn("Fecha de Modificación");

            // Agregar datos al modelo de tabla
            for (RegaloTipoDTO regalo : regalos) {
                model.addRow(new Object[]{
                        regalo.getIdRegaloTipo(),
                        regalo.getNombre(),
                        regalo.getObservacion(),
                        regalo.getEstado(),
                        regalo.getFechaCrea(),
                        regalo.getFechaModifica()
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
            RegaloTipoBL regaloTipoBL = new RegaloTipoBL();
            return regaloTipoBL.getMaxRow();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener el número total de registros: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    private void createRegaloTipo() {
       // Implementar lógica para crear un nuevo registro
    String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo regalo:", "Crear Regalo Tipo", JOptionPane.QUESTION_MESSAGE);
    if (nombre != null && !nombre.isEmpty()) {
        try {
            RegaloTipoDTO nuevoRegalo = new RegaloTipoDTO();
            nuevoRegalo.setNombre(nombre);

            RegaloTipoBL regaloTipoBL = new RegaloTipoBL();
            boolean creado = regaloTipoBL.create(nuevoRegalo);

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

    private void updateRegaloTipo() {
        // Obtener el índice de la fila seleccionada
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) {
        // Obtener el ID del regalo seleccionado
        int regaloID = (int) table.getValueAt(selectedRow, 0);
        // Obtener el nombre actual del regalo seleccionado
        String nombreActual = (String) table.getValueAt(selectedRow, 1);

        // Solicitar al usuario el nuevo nombre del regalo
        String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre para el regalo:", nombreActual);
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            try {
                RegaloTipoDTO regaloActualizado = new RegaloTipoDTO();
                regaloActualizado.setIdRegaloTipo(regaloID);
                regaloActualizado.setNombre(nuevoNombre);

                RegaloTipoBL regaloTipoBL = new RegaloTipoBL();
                boolean actualizado = regaloTipoBL.update(regaloActualizado);

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
        JOptionPane.showMessageDialog(this, "Seleccione un regalo para actualizar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    private void deleteRegaloTipo() {
        // Obtener el índice de la fila seleccionada
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) {
        // Confirmar si el usuario desea eliminar el regalo seleccionado
        int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este regalo?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Obtener el ID del regalo seleccionado
            int regaloID = (int) table.getValueAt(selectedRow, 0);

            try {
                RegaloTipoBL regaloTipoBL = new RegaloTipoBL();
                boolean eliminado = regaloTipoBL.delete(regaloID);

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
        JOptionPane.showMessageDialog(this, "Seleccione un regalo para eliminar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    private void refreshTable() {
        loadTableData();
    }
}
