package DataAccessComponent.DTO;

public class PersonaSexoDTO {
    private int IdPersonaSexo;  
    private String Nombre;         
    private String Observacion;    
    private String Estado;         
    private String FechaCrea;      
    private String FechaModifica;
    public PersonaSexoDTO(String nombre) {
        this.Nombre = nombre;
    }
    public PersonaSexoDTO() {
    }
    public PersonaSexoDTO(int idPersonaSexo, String nombre, String observacion, String estado, String fechaCrea,
            String fechaModifica) {
        this.IdPersonaSexo = idPersonaSexo;
        this.Nombre = nombre;
        this.Observacion = observacion;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    public int getIdPersonaSexo() {
        return IdPersonaSexo;
    }
    public void setIdPersonaSexo(int idPersonaSexo) {
        IdPersonaSexo = idPersonaSexo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
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
                    +"\nIdPersonaSexo   : "+ getIdPersonaSexo()    
                    +"\nNombre          : "+ getNombre()         
                    +"\nObservacion     : "+ getObservacion()    
                    +"\nEstado          : "+ getEstado()         
                    +"\nFechaCrea       : "+ getFechaCrea()      
                    +"\nFechaModifica   : "+ getFechaModifica();  
    }  
    
    
}
