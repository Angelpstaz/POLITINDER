package DataAccessComponent.DTO;

public class RegaloDTO {
    private int IdRegalo;
    private String Nombre;
    private String Stock;
    private int Precio;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    public RegaloDTO(String nombre) {
        this.Nombre = nombre;
    }
    public RegaloDTO() {
    }
    public RegaloDTO(int idRegalo, String nombre, String stock, int precio, String estado, String fechaCrea,
            String fechaModifica) {
        this.IdRegalo = idRegalo;
        this.Nombre = nombre;
        this.Stock = stock;
        this.Precio = precio;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    public int getIdRegalo() {
        return IdRegalo;
    }
    public void setIdRegalo(int idRegalo) {
        IdRegalo = idRegalo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getStock() {
        return Stock;
    }
    public void setStock(String stock) {
        Stock = stock;
    }
    public int getPrecio() {
        return Precio;
    }
    public void setPrecio(int precio) {
        Precio = precio;
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
                    +"\nIdRegalo   : "+ getIdRegalo()
                    +"\nNombre          : "+ getNombre()
                    +"\nStock     : "+ getStock()
                    +"\nPrecio     : "+ getPrecio()
                    +"\nEstado          : "+ getEstado()
                    +"\nFechaCrea       : "+ getFechaCrea()
                    +"\nFechaModifica   : "+ getFechaModifica();
    }
}
