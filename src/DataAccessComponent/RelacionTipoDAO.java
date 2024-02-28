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

import DataAccessComponent.DTO.RelacionTipoDTO;

public class RelacionTipoDAO extends SQLiteDataHelper implements IDAO<RelacionTipoDTO> {

    @Override
    public boolean create(RelacionTipoDTO entity) throws Exception {
        String query = " INSERT INTO RelacionTipo (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRelacionTipo",e);
        }
    }

    @Override
    public List<RelacionTipoDTO> readAll() throws Exception {
        List<RelacionTipoDTO> lst = new ArrayList<>() ;//VACIA
        String query = "SELECT  IdRelacionTipo"
                        +", Nombre        "
                        +", Observacion   "
                        +", Estado        "
                        +", FechaCrea     "
                        +", FechaModifica " //DTO
                        +" FROM     RelacionTipo ";
                  //LEEMOS LA TABLA
    try{
        Connection conn = openConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
         //return stmt.executeQuery(query);  // RESULTADO DE LO QUE VIENE DE LA CLASE, ENTONCES USAREMOS:

        while (rs.next()) {
            RelacionTipoDTO oRelacionTipoDTO = new RelacionTipoDTO (rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5),
                                                rs.getString(6));
            lst.add(oRelacionTipoDTO);//cada vez que traemos una fila agregamos a una lista.
        }
    }catch(SQLException e){
        throw new Exception(getClass()+"getMaxIdRelacionTipo",e);
    }
    return lst;
    }

    @Override
    public RelacionTipoDTO read(Integer id) throws Exception {
        RelacionTipoDTO oRelacionTipoDTO = new RelacionTipoDTO();
        String query =" SELECT IdRelacionTipo  "
                        +",Nombre            "
                        +",Observacion"
                        +",Estado            "
                        +",FechaCrea         "
                        +",FechaModifica     "
                        +"FROM    RelacionTipo       "
                        +"WHERE   Estado ='A' AND IdRelacionTipo =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oRelacionTipoDTO = new RelacionTipoDTO(rs.getInt(1)
                                    ,rs.getString(2)
                                    ,rs.getString(3)
                                    ,rs.getString(4)
                                    ,rs.getString(5)
                                    ,rs.getString(6));
            }
        }
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRelacionTipo",e);
        }
        return oRelacionTipoDTO;
    }

    @Override
    public boolean update(RelacionTipoDTO entity) throws Exception {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE RelacionTipo SET Nombre = ?, FechaModifica = ? WHERE IdRelacionTipo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdRelacionTipo());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRelacionTipo",e);
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE RelacionTipo SET Estado = ? WHERE IdRelacionTipo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdRelacionTipo",e);
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
