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

import DataAccessComponent.DTO.PersonaDTO;

public class PersonaDAO extends SQLiteDataHelper implements IDAO<PersonaDTO>  {
    
    @Override
    public boolean create(PersonaDTO entity) throws Exception {
        String query="INSERT INTO PersonaRol(Nombre) VALUES(?)";
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
    public List<PersonaDTO> readAll() throws Exception {
        List<PersonaDTO> lst = new ArrayList<>();
        String query="SELECT IdPersona"
                        +",IdPersona    "
                        +",IdPersonaRol "
                        +",IdPersonaSexo"
                        +",Nombre       "
                        +",Observacion  "
                        +",Estado       "
                        +",FechaCrea    "
                        +",FechaModifica "
                        +"FROM Persona ";
        try {
            Connection conn=openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(); 
            while(rs.next()) {
                PersonaDTO pdto = new PersonaDTO(rs.getInt(1)
                                                ,rs.getInt(2)
                                                ,rs.getInt(3)
                                                ,rs.getString(4)
                                                ,rs.getString(5)
                                                ,rs.getString(6)
                                                ,rs.getString(7)
                                                ,rs.getString(8));                     
                                   
            lst.add(pdto);

            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    @Override
    public PersonaDTO read(Integer id) throws Exception {
        PersonaDTO pd= new PersonaDTO();
        String query="SELECT IdPersona"
                        +",IdPersona    "
                        +",IdPersonaRol "
                        +",IdPersonaSexo"
                        +",Nombre       "
                        +",Observacion  "
                        +",Estado       "
                        +",FechaCrea    "
                        +",FechaModifica "
                        +"FROM Persona "
                        +"WHERE Estado ='A' AND IdPersona= "+id.toString();
        try {
            Connection conn=openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
                pd = new PersonaDTO( rs.getInt(1)
                                    ,rs.getInt(2)
                                    ,rs.getInt(3)
                                    ,rs.getString(4)
                                    ,rs.getString(5)
                                    ,rs.getString(6)
                                    ,rs.getString(7)
                                    ,rs.getString(8));
            }            
        } catch (Exception e) {
            throw e;
        }
        return pd;
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query= "UPDATE Persona SET Nombre = ?, FechaModifica = ? WHERE IdPersona = ?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,entity.getNombre());
            ps.setString(2,dtf.format(now));
            ps.setInt(3,entity.getIdPersona());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE Persona SET Estado=? WHERE IdPersona=?";
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
        String query= "SELECT COUNT(IdPersona) TotalReg FROM Persona"
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
