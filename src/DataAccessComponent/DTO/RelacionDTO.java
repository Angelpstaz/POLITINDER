package DataAccessComponent.DTO;

public class RelacionDTO {
    private int     IdRelacion;            
    private int     IdRelacionTipo;       
    private int     IdPersona1;           
    private int     IdPersona2;           
    private String  Observacion;          
    private String  Estado;               
    private String  FechaInicioRelacion;  
    private String  FechaCrea;            
    private String  FechaModifica;              
    public RelacionDTO(int idRelacionTipo, int idPersona1, int idPersona2) {
        this.IdRelacionTipo = idRelacionTipo;
        this.IdPersona1 = idPersona1;
        this.IdPersona2 = idPersona2;
    }

    public RelacionDTO() {
    }
    
    public RelacionDTO(int idRelacion, int idRelacionTipo, int idPersona1, int idPersona2, String observacion,
            String estado, String fechaInicioRelacion, String fechaCrea, String fechaModifica) {
        this.IdRelacion = idRelacion;
        this.IdRelacionTipo = idRelacionTipo;
        this.IdPersona1 = idPersona1;
        this.IdPersona2 = idPersona2;
        this.Observacion = observacion;
        this.Estado = estado;
        this.FechaInicioRelacion = fechaInicioRelacion;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    public int getIdRelacion() {
        return IdRelacion;
    }
    public void setIdRelacion(int idRelacion) {
        IdRelacion = idRelacion;
    }
    public int getIdRelacionTipo() {
        return IdRelacionTipo;
    }
    public void setIdRelacionTipo(int idRelacionTipo) {
        IdRelacionTipo = idRelacionTipo;
    }
    public int getIdPersona1() {
        return IdPersona1;
    }
    public void setIdPersona1(int idPersona1) {
        IdPersona1 = idPersona1;
    }
    public int getIdPersona2() {
        return IdPersona2;
    }
    public void setIdPersona2(int idPersona2) {
        IdPersona2 = idPersona2;
    }
    public String getObservacion() {
        return Observacion;
    }
    public void setObservacion(String observacion) {
        Observacion = observacion;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaInicioRelacion() {
        return FechaInicioRelacion;
    }
    public void setFechaInicioRelacion(String fechaInicioRelacion) {
        FechaInicioRelacion = fechaInicioRelacion;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }
    @Override
    public String toString() {
        
        return "\n"+getClass().getName()
                    +"\nIdRelacion          : "+getIdRelacion()         
                    +"\nIdRelacionTipo      : "+getIdRelacionTipo ()   
                    +"\nIdPersona1          : "+getIdPersona1()         
                    +"\nIdPersona2          : "+getIdPersona2()         
                    +"\nObservacion         : "+getObservacion()        
                    +"\nEstado              : "+getEstado()             
                    +"\nFechaInicioRelacion : "+getFechaInicioRelacion()
                    +"\nFechaCrea           : "+getFechaCrea()          
                    +"\nFechaModifica       : "+getFechaModifica();      
    }
            
}
;