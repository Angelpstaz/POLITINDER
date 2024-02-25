package DataAccessComponent.DTO;

public class RegaloTipoDTO {
    private int IdRegaloTipo ;
    private String Nombre       ;
    private String Observacion  ;
    private String Estado       ;
    private String FechaCrea    ;
    private String FechaModifica;
    public RegaloTipoDTO(int idRegaloTipo
                        ,String nombre 
                        ,String observacion 
                        ,String estado 
                        ,String fechaCrea
                        ,String fechaModifica) {
        IdRegaloTipo = idRegaloTipo;
        Nombre = nombre;
        Observacion = observacion;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    public RegaloTipoDTO() {
        //TODO Auto-generated constructor stub
    }
    public int getIdRegaloTipo() {
        return IdRegaloTipo;
    }
    public void setIdRegaloTipo(int idRegaloTipo) {
        IdRegaloTipo = idRegaloTipo;
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




}
