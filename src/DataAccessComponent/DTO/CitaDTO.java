package DataAccessComponent.DTO;

public class CitaDTO {
    private int IdCita;
    private int IdPersona1;
    private int IdPersona2;
    private String FechaCita;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    public CitaDTO(String FechaCita) {
        this.FechaCita = FechaCita;
    }
    public CitaDTO() {
    }
    public CitaDTO(int idCita, int idPersona1, int idPersona2, String fechaCita, String estado, String fechaCrea, String fechaModifica) {
        this.IdCita = idCita;
        this.IdPersona1 = idPersona1;
        this.IdPersona2 = idPersona2;
        this.FechaCita = fechaCita;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    public int getIdCita() {
        return IdCita;
    }
    public void setIdCita(int idCita) {
        IdCita = idCita;
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
    public String getFechaCita() {
        return FechaCita;
    }
    public void setFechaCita(String fechaCita) {
        FechaCita = fechaCita;
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
                    +"\nIdCita   : "+ getIdCita()
                    +"\nIdPersona1   : "+ getIdPersona1()
                    +"\nIdPersona2   : "+ getIdPersona2()
                    +"\nFechaCita          : "+ getFechaCita()
                    +"\nEstado          : "+ getEstado()
                    +"\nFechaCrea       : "+ getFechaCrea()
                    +"\nFechaModifica   : "+ getFechaModifica();
    }
}
