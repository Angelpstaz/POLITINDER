package DataAccessComponent;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataAccessComponent.DTO.RelacionDTO;

public class RelacionDAO extends SQLiteDataHelper implements IDAO<RelacionDTO> {

    @Override
    public boolean create(RelacionDTO entity) throws Exception {
        String query = "INSERT INTO Relacion (IdRelacionTipo, IdPersona1, IdPersona2) VALUES(?,?,?)";
        try {
            Connection          conn    =   openConnection();
            PreparedStatement    pstmt   =   conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdRelacionTipo());
            pstmt.setInt(2, entity.getIdPersona1());
            pstmt.setInt(3, entity.getIdPersona2());
            return true;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<RelacionDTO> readAll() throws Exception {
        List <RelacionDTO> lst= new ArrayList<>();
        String  query = "SELECT  IdRelacion              "           
                                +",IdRelacionTipo;       "
                                +",IdPersona1;           "
                                +",IdPersona2;           "
                                +",Observacion;          "
                                +",Estado;               "
                                +",FechaInicioRelacion;  "
                                +",FechaCrea;            "
                                +",FechaModifica;        "
                                +"FROM  Relacion         ";
        try {
            Connection conn= openConnection();
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
                while(rs.next()){
                    RelacionDTO Rdto=new RelacionDTO(rs.getInt(1),
                                                      rs.getInt(2),
                                                      rs.getInt(3),
                                                      rs.getInt(4),
                                                      rs.getString(5),
                                                      rs.getString(6),
                                                      rs.getString(7),
                                                      rs.getString(8),
                                                      rs.getString(9));
                    lst.add(Rdto); 
                }          
            } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    @Override
    public RelacionDTO readBy(Integer id) throws Exception {
        RelacionDTO Rdto=new RelacionDTO();
        String query="SELECT  IdRelacion        "
                        +"IdRelacionTipo;       " 
                        +"IdPersona1;           " 
                        +"IdPersona2;           " 
                        +"Observacion;          " 
                        +"Estado;               " 
                        +"FechaInicioRelacion;  " 
                        +"FechaCrea;            " 
                        +"FechaModifica;        " 
                        +"FROM  Relacion        "
                        +"WHERE Estado='A' AND  IdRelacion = "+id.toString();
        try {
            Connection conn =   openConnection();
            Statement  stm  =   conn.createStatement();
            ResultSet  rs   = stm.executeQuery(query);
            while(rs.next()){
                Rdto=new RelacionDTO(rs.getInt(1),
                                     rs.getInt(2),
                                     rs.getInt(3),
                                     rs.getInt(4),
                                     rs.getString(5),
                                     rs.getString(6),
                                     rs.getString(7),
                                     rs.getString(8),
                                     rs.getString(9));
              
            }            
        } catch (Exception e) {
            throw e;
        }
        return Rdto; 
    }

    @Override
    public boolean update(RelacionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query=("UPDATE Relacion  SET  IdRelacionTipo=? ,IdPersona1=? ,IdPersona2=? ,FechaModifica=? WHERE IdRelacion=? ");
        try {
            Connection conn  = openConnection();
            PreparedStatement pstm =  conn.prepareStatement(query);
            pstm.setInt(1,entity.getIdRelacionTipo());
            pstm.setInt(2,entity.getIdPersona1());
            pstm.setInt(3,entity.getIdPersona2());
            pstm.setString(4,dtf.format(now).toString());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE Relacion SET Estado=?  WHERE IdRelacion=?";
        try{
            Connection conexion=openConnection();
            PreparedStatement ps=conexion.prepareStatement(query);
            ps.setString(1, "X");
            ps.setInt(2,id);
            ps.executeUpdate();
            return true;
            }catch(Exception e){
                throw e;
            }
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query= "SELECT COUNT(IdRelacion) TotalReg FROM Relacion"
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
