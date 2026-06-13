package Modelo;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends UsrCuenta {
   
    private List<TarjetaCredito> tarjetas;
    private List<Viaje> historialViajes;
    
    public Pasajero(String nombre, String email, String telefono, String password, int codCuenta) {
        super(nombre, email, telefono, password, codCuenta);
        this.tarjetas = new ArrayList<>();
        this.historialViajes = new ArrayList<>();
    }
    
   
    public void addTarjeta(TarjetaCredito tarjeta) {
        this.tarjetas.add(tarjeta);
    }
    
    public void createViaje(Viaje nuevoViaje) {
        this.historialViajes.add(nuevoViaje);
    }
}
