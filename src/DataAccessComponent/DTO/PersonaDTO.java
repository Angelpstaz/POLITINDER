package DataAccessComponent.DTO;

public class PersonaDTO {
    private int     idPersona       ;      
    private int     idPersonaRol    ;
    private int     idPersonaSexo   ;
    private String  nombre          ;
    private String  observacion     ;
    private String  estado          ;
    private String  fechaCrea       ;
    private String  fechaModifica   ; 

    public PersonaDTO(){
    }

    public PersonaDTO(String nombre){
        this.nombre = nombre;
    }

    public PersonaDTO(   int    idPersona     
                        ,int    idPersonaRol 
                        ,int    idPersonaSexo
                        ,String nombre       
                        ,String observacion  
                        ,String estado       
                        ,String fechaCrea    
                        ,String fechaModifica) {

        this.idPersona       = idPersona    ;
        this.idPersonaRol    = idPersonaRol ;
        this.idPersonaSexo   = idPersonaSexo;
        this.nombre          = nombre       ;
        this.observacion     = observacion  ;
        this.estado          = estado       ;
        this.fechaCrea       = fechaCrea    ;
        this.fechaModifica   = fechaModifica;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersonaRol() {
        return idPersonaRol;
    }

    public void setIdPersonaRol(int idPersonaRol) {
        this.idPersonaRol = idPersonaRol;
    }

    public int getIdPersonaSexo() {
        return idPersonaSexo;
    }

    public void setIdPersonaSexo(int idPersonaSexo) {
        this.idPersonaSexo = idPersonaSexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    

    
    
    @Override
    public String toString() {
        return "\n"+getClass().getName()
                    +"\nIdPersona    : "+getIdPersona    ()
                    +"\nIdPersonaRol : "+getIdPersonaRol ()
                    +"\nIdPersonaSexo: "+getIdPersonaSexo()
                    +"\nNombre       : "+getNombre       ()
                    +"\nObservacion  : "+getObservacion  ()
                    +"\nEstado       : "+getEstado       ()
                    +"\nFechaCrea    : "+getFechaCrea    ()
                   +"\nFechaModifica : "+getFechaModifica();
    }
}
