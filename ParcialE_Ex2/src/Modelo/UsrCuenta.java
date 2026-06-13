package Modelo;

public class UsrCuenta {
  
    protected String nombre; 
    protected String email;
    protected String telefono;
    protected String password;
    protected int codCuenta;
    protected double calificacionPromedio; 
    
    
    public UsrCuenta(String nombre, String email, String telefono, String password, int codCuenta) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.codCuenta = codCuenta;
        this.calificacionPromedio = 5.0; 
    }
}
