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

import DataAccessComponent.DTO.RegaloTipoDTO;

public class RegaloTipoDAO extends SQLiteDataHelper implements IDAO<RegaloTipoDTO> {

    @Override
    public boolean create(RegaloTipoDTO entity) throws Exception {
        String query = " INSERT INTO RegaloTipo (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRegaloTipo",e);
        }
    }

    @Override
    public List<RegaloTipoDTO> readAll() throws Exception {
        List<RegaloTipoDTO> lst = new ArrayList<>() ;//VACIA
     String query = "SELECT  IdRegaloTipo"
                  +", Nombre        "
                  +", Observacion   "
                  +", Estado        "
                  +", FechaCrea     "
                  +", FechaModifica " //DTO
                  +" FROM     RegaloTipo "
                  +" WHERE    Estado ='A'";;
                  //LEEMOS LA TABLA
     try{
         Connection conn = openConnection();  
         Statement stmt = conn.createStatement(); 
         ResultSet rs = stmt.executeQuery(query);
         //return stmt.executeQuery(query);  // RESULTADO DE LO QUE VIENE DE LA CLASE, ENTONCES USAREMOS:
         
         while (rs.next()) {
             RegaloTipoDTO oDTORegaloTipo = new RegaloTipoDTO (rs.getInt(1), 
                                             rs.getString(2), 
                                             rs.getString(3), 
                                             rs.getString(4), 
                                             rs.getString(5),
                                             rs.getString(6));
             lst.add(oDTORegaloTipo);//cada vez que traemos una fila agregamos a una lista.
         }
     }catch(SQLException e){
        throw new Exception(getClass()+"getMaxIdRegaloTipo",e);
     }
     return lst;
    }

    @Override
    public RegaloTipoDTO readBy(Integer id) throws Exception {
        RegaloTipoDTO oDTORegaloTipo = new RegaloTipoDTO();
        String query =" SELECT IdRegaloTipo  " 
                     +",Nombre            "    
                     +",Observacion"
                     +",Estado            "    
                     +",FechaCrea         "    
                     +",FechaModifica     "   
                     +"FROM    RegaloTipo       "   
                     +"WHERE   Estado ='A' AND IdRegaloTipo =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                RegaloTipoDTO oDTORegaloTipo1 = new RegaloTipoDTO (rs.getInt(1), 
                                             rs.getString(2), 
                                             rs.getString(3), 
                                             rs.getString(4), 
                                             rs.getString(5),
                                             rs.getString(6));    // FechaModifica
                oDTORegaloTipo=oDTORegaloTipo1;
            }
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRegaloTipo",e);
        }
        return oDTORegaloTipo;
    }

    @Override
    public boolean update(RegaloTipoDTO entity) throws Exception {
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE RegaloTipo SET Nombre = ?, FechaModifica = ? WHERE IdRegaloTipo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdRegaloTipo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRegaloTipo",e);
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE RegaloTipo SET Estado = ? WHERE IdRegaloTipo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRegaloTipo",e);
        }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxRow'");
    }
}
