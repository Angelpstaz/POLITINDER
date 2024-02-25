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

import DataAccessComponent.DTO.PersonaSexoDTO;

public class PersonaSexoDAO extends SQLiteDataHelper implements IDAO<PersonaSexoDTO>{

    @Override
    public boolean create(PersonaSexoDTO entity) throws Exception {
        String query="INSERT INTO PersonaSexo(Nombre) VALUES(?)";
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
    public List<PersonaSexoDTO> readAll() throws Exception {
        List<PersonaSexoDTO> lst = new ArrayList<>();
        String query="SELECT IdPersonaSexo "
                        +",Nombre         "
                        +",Observacion    "
                        +",Estado         "
                        +",FechaCrea      "
                        +",FechaModifica  "
                        +"FROM PersonaSexo ";
        try {
            Connection conn=openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(); 
            while(rs.next()) {
                PersonaSexoDTO pdto = new PersonaSexoDTO(rs.getInt(1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6));
            lst.add(pdto);

            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    @Override
    public PersonaSexoDTO read(Integer id) throws Exception {
        PersonaSexoDTO psd= new PersonaSexoDTO();
        String  query="SELECT IdPersonaSexo"
                        +",Nombre        " 
                        +",Observacion   " 
                        +",Estado        " 
                        +",FechaCrea     " 
                        +",FechaModifica "     
                        +"FROM PersonaSexo "
                        +"WHERE Estado ='A' AND IdPersonaSexo= "+id.toString();
        try {
            Connection conn=openConnection();
            Statement   stm=conn.createStatement();
            ResultSet   rs=stm.executeQuery(query);
            while (rs.next()) {
                psd = new PersonaSexoDTO(rs.getInt(1)
                                     ,rs.getString(2)
                                     ,rs.getString(3)
                                     ,rs.getString(4)
                                     ,rs.getString(5)
                                     ,rs.getString(6));
                                                }            
            } catch (Exception e) {
                throw e;
            }
            return psd;
    }

    @Override
    public boolean update(PersonaSexoDTO entity) throws Exception {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query= "UPDATE PersonaSexo SET Nombre = ?, FechaModifica = ? WHERE IdPersonaSexo = ?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,entity.getNombre());
            ps.setString(2,dtf.format(now));
            ps.setInt(3,entity.getIdPersonaSexo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE PersonaSexo SET Estado=? WHERE IdPersonaSexo=?";
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
        String query= "SELECT COUNT(IdPersonaSexo) TotalReg FROM PersonaSexo"
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