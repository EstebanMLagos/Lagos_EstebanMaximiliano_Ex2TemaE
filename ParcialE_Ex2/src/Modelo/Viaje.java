package Modelo;
import java.time.LocalDateTime;

public class Viaje {
    private double puntoAx, puntoAy, puntoBx, puntoBy;
    private LocalDateTime fechaHoraPartida;
    private LocalDateTime fechaHoraLlegadaEstimada;
    private double distancia;
    private double duracion;
    private String estado; 
    private double montoAPagar; 
    
    private Pasajero pasajero;
    private Conductor conductor; 
    
    public Viaje(double ax, double ay, double bx, double by, LocalDateTime fechaPartida, Pasajero pasajero) {
        this.puntoAx = ax; this.puntoAy = ay;
        this.puntoBx = bx; this.puntoBy = by;
        this.fechaHoraPartida = fechaPartida;
        this.pasajero = pasajero;
        this.estado = "pendiente"; 
    }
    
    
    public void asignarConductor(Conductor conductor) {
        this.conductor = conductor;
        this.estado = "confirmado";
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaHoraPartida() {
        return this.fechaHoraPartida;
    }
    
    
    public void setDistanciaYDuracion(double distancia, double duracion) {
        this.distancia = distancia;
        this.duracion = duracion;
    }

    private double calcularCargoDemanda() {
        int hora = this.fechaHoraPartida.getHour();
        if (hora >= 7 && hora < 13) return 900.0;
        if (hora >= 13 && hora < 19) return 1300.0;
        if (hora >= 19 || hora < 1) return 700.0; 
        if (hora >= 1 && hora < 7) return 1250.0;
        return 0.0;
    }

    public void calcularPrecioTotal(double tarifaBase, double tarifaDistancia, double tarifaTiempo) {
        double cargoDemanda = calcularCargoDemanda();
        this.montoAPagar = tarifaBase + (tarifaDistancia * this.distancia) + (tarifaTiempo * this.duracion) + cargoDemanda;
    }
    
    public double getMontoAPagar() {
        return this.montoAPagar;
    }
}
