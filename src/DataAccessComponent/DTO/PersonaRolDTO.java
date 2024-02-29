package DataAccessComponent.DTO;

/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|isabellahq29@gmail.com       lalabell |
|______________________________________|
Autor: lalabell
Fecha: 16/02/1014
Script: Creacion del DTO: PersonaRol
*/
public class PersonaRolDTO {
    private int IdPersonaRol;  
    private int IdPersonaRolPadre;  
    private String Nombre;         
    private String Observacion;    
    private String Estado;         
    private String FechaCrea;      
    private String FechaModifica;

    public PersonaRolDTO(){
    }

    public PersonaRolDTO(String nombre){
        this.Nombre = nombre;
    }

    public PersonaRolDTO(int idPersonaRol, int idPersonaRolPadre, String nombre, String observacion, String estado,
    String fechaCrea, String fechaModifica) {
        IdPersonaRol = idPersonaRol;
        IdPersonaRolPadre = idPersonaRolPadre;
        Nombre = nombre;
        Observacion = observacion;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public int getIdPersonaRol() {
        return IdPersonaRol;
    }

    public void setIdPersonaRol(int idPersonaRol) {
        IdPersonaRol = idPersonaRol;
    }

    public int getIdPersonaRolPadre() {
        return IdPersonaRolPadre;
    }

    public void setIdPersonaRolPadre(int idPersonaRolPadre) {
        IdPersonaRolPadre = idPersonaRolPadre;
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
                    +"\nIdPersonaRol        : "+ getIdPersonaRol()    
                    +"\nIdPersonaRolPadre   : "+ getIdPersonaRolPadre()    
                    +"\nNombre              : "+ getNombre()         
                    +"\nObservacion         : "+ getObservacion()    
                    +"\nEstado              : "+ getEstado()         
                    +"\nFechaCrea           : "+ getFechaCrea()      
                    +"\nFechaModifica       : "+ getFechaModifica();  
    }  
    
}
