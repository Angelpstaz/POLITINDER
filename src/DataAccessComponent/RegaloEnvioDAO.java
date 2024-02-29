package DataAccessComponent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccessComponent.DTO.RegaloEnvioDTO;

public class RegaloEnvioDAO extends SQLiteDataHelper implements IDAO<RegaloEnvioDTO> {

    @Override
    public boolean create(RegaloEnvioDTO entity) throws Exception {
        String query = "INSERT INTO RegaloEnvio (IdRegalo, IdPersonaEnvia, IdPersonaRecibe) VALUES (?, ?, ?)";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, entity.getIdRegalo());
            pstmt.setInt(2, entity.getIdPersonaEnvia());
            pstmt.setInt(3, entity.getIdPersonaRecibe());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception(getClass() + ".create", e);
        }
    }

    @Override
    public List<RegaloEnvioDTO> readAll() throws Exception {
                List<RegaloEnvioDTO> lst = new ArrayList<>();
        String query="SELECT IdRegaloEnvio"
                        +",IdRegalo    "
                        +",IdPersonaEnvia "
                        +",IdPersonaRecibe"
                        +",Estado       "
                        +",FechaCrea    "
                        +",FechaEnvio    "
                        +",FechaModifica "
                        +"FROM RegaloEnvio ";
        try {
            Connection conn=openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(); 
            while(rs.next()) {
                RegaloEnvioDTO oDTORegaloEnvio = new RegaloEnvioDTO(rs.getInt(1)
                                                ,rs.getInt(2)
                                                ,rs.getInt(3)
                                                ,rs.getInt(3)
                                                ,rs.getString(4)
                                                ,rs.getString(5)
                                                ,rs.getString(6)
                                                ,rs.getString(7)
                                                );                     
                                   
            lst.add(oDTORegaloEnvio);

            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    @Override
    public RegaloEnvioDTO readBy(Integer id) throws Exception {
        RegaloEnvioDTO oDTORegaloEnvio = new RegaloEnvioDTO();
        String query = "SELECT IdRegaloEnvio, IdRegalo, IdPersonaEnvia, IdPersonaRecibe, Estado, FechaCrea, FechaEnvio, FechaModifica " +
                "FROM RegaloEnvio " +
                "WHERE Estado = 'A' AND IdRegaloEnvio = " + id.toString();
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                oDTORegaloEnvio = new RegaloEnvioDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                        );
            }
        } catch (SQLException e) {
            throw new Exception(getClass() + ".read", e);
        }
        return oDTORegaloEnvio;
    }

    @Override
    public boolean update(RegaloEnvioDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE RegaloEnvio SET IdRegalo = ?, IdPersonaEnvia = ?, IdPersonaRecibe = ?, FechaModifica = ? WHERE IdRegaloEnvio = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, entity.getIdRegalo());
            pstmt.setInt(2, entity.getIdPersonaEnvia());
            pstmt.setInt(3, entity.getIdPersonaRecibe());
            pstmt.setString(4, dtf.format(now));
            pstmt.setInt(5, entity.getIdRegaloEnvio());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception(getClass() + ".update", e);
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE RegaloEnvio SET Estado = ? WHERE IdRegaloEnvio = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception(getClass() + ".delete", e);
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxRow'");
    }
}
