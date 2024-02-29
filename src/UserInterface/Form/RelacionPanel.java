package UserInterface.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import BusinessLogic.RelacionBL;
import DataAccessComponent.RelacionDAO;
import DataAccessComponent.DTO.RelacionDTO;

public class RelacionPanel extends JPanel {

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

    public RelacionPanel() {
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
    }

    private void loadTableData() {
        try {
            // Obtener datos de la base de datos
            RelacionBL relacionBL = new RelacionBL();
            List<RelacionDTO> relaciones = relacionBL.getAll();

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("IdRelacion");
            model.addColumn("IdRelacionTipo");
            model.addColumn("IdPersona1");
            model.addColumn("IdPersona2");
            model.addColumn("Observacion");
            model.addColumn("Estado");
            model.addColumn("FechaInicioRelacion");
            model.addColumn("FechaCrea");
            model.addColumn("FechaModifica");

            // Agregar datos al modelo de tabla
            for (RelacionDTO relacion : relaciones) {
                model.addRow(new Object[]{
                        relacion.getIdRelacion(),
                        relacion.getIdRelacionTipo(),
                        relacion.getIdPersona1(),
                        relacion.getIdPersona2(),
                        relacion.getObservacion(),
                        relacion.getEstado(),
                        relacion.getFechaInicioRelacion(),
                        relacion.getFechaCrea(),
                        relacion.getFechaModifica()
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
            RelacionBL RelacionBL = new RelacionBL();
            List<RelacionDTO> relacions = RelacionBL.getAll();

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("IdRelacion         "  ); 
            model.addColumn("IdRelacionTipo     "  );
            model.addColumn("IdPersona1         "  );
            model.addColumn("IdPersona2         "  );
            model.addColumn("Observacion        "  );
            model.addColumn("Estado             "  );
            model.addColumn("FechaInicioRelacion"  );
            model.addColumn("FechaCrea          "  );
            model.addColumn("FechaModifica      "  );

            // Agregar datos al modelo de tabla
            for (RelacionDTO relacion : relacions) {
                model.addRow(new Object[]{
                    relacion.getIdRelacion(),            
                    relacion.getIdRelacionTipo(),       
                    relacion.getIdPersona1(),           
                    relacion.getIdPersona2(),           
                    relacion.getObservacion(),          
                    relacion.getEstado(),               
                    relacion.getFechaInicioRelacion(),  
                    relacion.getFechaCrea(),            
                    relacion.getFechaModifica()       
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
            RelacionBL RelacionBL = new RelacionBL();
            return RelacionBL.getMaxRow();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener el número total de registros: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    private void createRelacion() {
        
    }

    private void updaterelacion() {
        
    }

    private void deleterelacion() {
        
    }

    private void refreshTable() {
        loadTableData();
    }
}
