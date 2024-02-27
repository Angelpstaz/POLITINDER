package DataAccessComponent.DTO;

public class RelacionTipoDTO {
    private int IdRelacionTipo ;
    private String Nombre       ;
    private String Observacion  ;
    private String Estado       ;
    private String FechaCrea    ;
    private String FechaModifica;
    public RelacionTipoDTO(int idRelacionTipo
                        ,String nombre
                        ,String observacion
                        ,String estado
                        ,String fechaCrea
                        ,String fechaModifica) {
        IdRelacionTipo = idRelacionTipo;
        Nombre = nombre;
        Observacion = observacion;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    public RelacionTipoDTO() {
        //TODO Auto-generated constructor stub
    }
    public int getIdRelacionTipo() {
        return IdRelacionTipo;
    }
    public void setIdRelacionTipo(int idRelacionTipo) {
        IdRelacionTipo = idRelacionTipo;
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
                    +"\nIdRelacionTipo   : "+ getIdRelacionTipo()
                    +"\nNombre          : "+ getNombre()
                    +"\nObservacion     : "+ getObservacion()
                    +"\nEstado          : "+ getEstado()
                    +"\nFechaCrea       : "+ getFechaCrea()
                    +"\nFechaModifica   : "+ getFechaModifica();
    }
}
