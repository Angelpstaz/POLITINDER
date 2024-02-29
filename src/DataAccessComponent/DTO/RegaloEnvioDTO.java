package DataAccessComponent.DTO;

public class RegaloEnvioDTO {
    private int IdRegaloEnvio;
    private int IdRegalo;
    private int IdPersonaEnvia ;
    private int IdPersonaRecibe;
    private String Estado;
    private String FechaCrea;
    private String FechaEnvio;
    private String FechaModifica;


public RegaloEnvioDTO(){}

public RegaloEnvioDTO(String fechaEnvio) {
    FechaEnvio = fechaEnvio;
}

public RegaloEnvioDTO(int idRegaloEnvio, 
            int idRegalo, 
            int idPersonaEnvia, 
            int idPersonaRecibe, 
            //String observacion,
            String estado, 
            String fechaCrea, 
            String fechaEnvio, 
            String fechaModifica) {
        IdRegaloEnvio = idRegaloEnvio;
        IdRegalo = idRegalo;
        IdPersonaEnvia = idPersonaEnvia;
        IdPersonaRecibe = idPersonaRecibe;
        //Observacion = observacion;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaEnvio = fechaEnvio;
        FechaModifica = fechaModifica;
    }


public RegaloEnvioDTO(int regalo, int pe, int pr) {
    IdRegaloEnvio = regalo;
    IdPersonaEnvia=pe;
    IdPersonaRecibe=pr;
}

public int getIdRegaloEnvio() {
    return IdRegaloEnvio;
}

public void setIdRegaloEnvio(int idRegaloEnvio) {
    IdRegaloEnvio = idRegaloEnvio;
}

public int getIdRegalo() {
    return IdRegalo;
}

public void setIdRegalo(int idRegalo) {
    IdRegalo = idRegalo;
}

public int getIdPersonaEnvia() {
    return IdPersonaEnvia;
}

public void setIdPersonaEnvia(int idPersonaEnvia) {
    IdPersonaEnvia = idPersonaEnvia;
}

public int getIdPersonaRecibe() {
    return IdPersonaRecibe;
}

public void setIdPersonaRecibe(int idPersonaRecibe) {
    IdPersonaRecibe = idPersonaRecibe;
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

public String getFechaEnvio() {
    return FechaEnvio;
}

public void setFechaEnvio(String fechaEnvio) {
    FechaEnvio = fechaEnvio;
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
                +"\nIdRegaloEnvio    : "+getIdRegaloEnvio    ()
                +"\nIdRegalo : "+getIdRegalo ()
                +"\nIdPersonaEnvia: "+getIdPersonaEnvia()
                +"\nIdPersonaRecibe: "+getIdPersonaRecibe()
                +"\nEstado       : "+getEstado       ()
                +"\nFechaCrea    : "+getFechaCrea    ()
                +"\nFechaEnvio    : "+getFechaEnvio    ()
               +"\nFechaModifica : "+getFechaModifica();
}

}