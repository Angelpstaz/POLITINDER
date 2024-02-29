package DataAccessComponent;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccessComponent.DTO.CitaDTO;

public class CitaDAO extends SQLiteDataHelper implements IDAO<CitaDTO>{

    @Override
    public boolean create(CitaDTO entity) throws Exception {
        String query="INSERT INTO Cita(Nombre) VALUES(?)";
        try {
            Connection conn=openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getFechaCita());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<CitaDTO> readAll() throws Exception {
        List<CitaDTO> lst = new ArrayList<>();
        String query="SELECT IdCita "
                        +",IdPersona1         "
                        +",IdPersona2         "
                        +",FechaCita         "
                        +",Estado         "
                        +",FechaCrea      "
                        +",FechaModifica  "
                        +"FROM Cita ";
        try {
            Connection conn=openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                CitaDTO oCitaDTO = new CitaDTO(rs.getInt(1)
                                        ,rs.getInt(2)
                                        ,rs.getInt(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7));
            lst.add(oCitaDTO);

            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    @Override
    public CitaDTO readBy(Integer id) throws Exception {
        CitaDTO oCitaDTO= new CitaDTO();
        String  query="SELECT IdCita"
                        +",IdPersona1        "
                        +",IdPersona2        "
                        +",FechaCita        "
                        +",Estado        "
                        +",FechaCrea     "
                        +",FechaModifica "
                        +"FROM Cita "
                        +"WHERE Estado ='A' AND IdCita= "+id.toString();
        try {
            Connection conn=openConnection();
            Statement   stm=conn.createStatement();
            ResultSet   rs=stm.executeQuery(query);
            while (rs.next()) {
                oCitaDTO = new CitaDTO(rs.getInt(1)
                        ,rs.getInt(2)
                        ,rs.getInt(3)
                        ,rs.getString(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                        ,rs.getString(7));
                        }
            } catch (Exception e) {
                throw e;
            }
            return oCitaDTO;
    }

    @Override
    public boolean update(CitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query= "UPDATE Cita SET Nombre = ?, FechaModifica = ? WHERE IdCita = ?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,entity.getFechaCita());
            ps.setString(2,dtf.format(now));
            ps.setInt(3,entity.getIdCita());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE Cita SET Estado=? WHERE IdCita=?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,"X");
            ps.setInt(2,id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query= "SELECT COUNT(IdCita) TotalReg FROM Cita"
        + "WHERE Estado='A'";
        try {
            Connection conn= openConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        }
        return  0 ;
    }


}