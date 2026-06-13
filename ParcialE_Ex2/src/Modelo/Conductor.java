package Modelo;

public class Conductor extends UsrCuenta {
    private String nroLicencia;
    private double billetera; 
    private Vehiculo vehiculo; 
    private int cantidadViajes; 
    private int viajesMadrugada; 

    public Conductor(String nombre, String email, String telefono, String password, int codCuenta, String nroLicencia, Vehiculo vehiculo) {
        super(nombre, email, telefono, password, codCuenta);
        this.nroLicencia = nroLicencia;
        this.vehiculo = vehiculo;
        this.billetera = 0.0;
        this.cantidadViajes = 0;
        this.viajesMadrugada = 0;
    }

    public void aceptarViaje(Viaje viaje) {
        viaje.asignarConductor(this); 
    }

    public void finalizarViaje(Viaje viaje) {
        viaje.setEstado("concluido");
        
        
        this.billetera += viaje.getMontoAPagar();
        this.cantidadViajes++;

       
        if (this.cantidadViajes == 8) {
            this.billetera += 8000;
        } else if (this.cantidadViajes == 17) {
            this.billetera += 20000;
        } else if (this.cantidadViajes == 28) {
            this.billetera += 40000;
        }

       
        int horaPartida = viaje.getFechaHoraPartida().getHour();
        if (horaPartida >= 4 && horaPartida < 8) {
            this.viajesMadrugada++;
            if (this.viajesMadrugada == 4) {
                this.billetera += 8000;
                this.viajesMadrugada = 0; 
            }
        }
    }
}