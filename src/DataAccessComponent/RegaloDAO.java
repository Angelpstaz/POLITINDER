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

import DataAccessComponent.DTO.RegaloDTO;

public class RegaloDAO extends SQLiteDataHelper implements IDAO<RegaloDTO>{

    @Override
    public boolean create(RegaloDTO entity) throws Exception {
        String query="INSERT INTO Regalo(Nombre) VALUES(?)";
        try {
            Connection conn=openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<RegaloDTO> readAll() throws Exception {
        List<RegaloDTO> lst = new ArrayList<>();
        String query="SELECT IdRegalo "
                        +",Nombre         "
                        +",Stock    "
                        +",Precio    "
                        +",Estado         "
                        +",FechaCrea      "
                        +",FechaModifica  "
                        +"FROM Regalo ";
        try {
            Connection conn=openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                RegaloDTO oRegaloDTO = new RegaloDTO(rs.getInt(1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getInt(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7));
            lst.add(oRegaloDTO);

            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    @Override
    public RegaloDTO read(Integer id) throws Exception {
        RegaloDTO oRegaloDTO= new RegaloDTO();
        String  query="SELECT IdRegalo"
                        +",Nombre        "
                        +",Stock   "
                        +",Precio   "
                        +",Estado        "
                        +",FechaCrea     "
                        +",FechaModifica "
                        +"FROM Regalo "
                        +"WHERE Estado ='A' AND IdRegalo= "+id.toString();
        try {
            Connection conn=openConnection();
            Statement   stm=conn.createStatement();
            ResultSet   rs=stm.executeQuery(query);
            while (rs.next()) {
                oRegaloDTO = new RegaloDTO(rs.getInt(1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                        ,rs.getInt(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                        ,rs.getString(7));
                        }
            } catch (Exception e) {
                throw e;
            }
            return oRegaloDTO;
    }

    @Override
    public boolean update(RegaloDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query= "UPDATE Regalo SET Nombre = ?, FechaModifica = ? WHERE IdRegalo = ?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,entity.getNombre());
            ps.setString(2,dtf.format(now));
            ps.setInt(3,entity.getIdRegalo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE Regalo SET Estado=? WHERE IdRegalo=?";
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
        String query= "SELECT COUNT(IdRegalo) TotalReg FROM Regalo"
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