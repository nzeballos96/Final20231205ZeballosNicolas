package Modelo;

public class Mesa extends Restaurant implements Estado {

    int idmesa;
    int nroMesa;
    int capacidad;
    double consumo;
    private Estado estado = Estado.LIBRE;
    int restoid;

    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public int getRestoid() {
        return restoid;
    }

    public void setRestoid(int restoid) {
        this.restoid = restoid;
    }

    public Mesa() {

    }

    public Mesa(int nroMesa, int capacidad, double consumo, Estado estado, int restoid) {
        super();
        this.nroMesa = nroMesa;
        this.capacidad = capacidad;
        this.consumo = consumo;
        this.estado = estado;
        this.restoid = restoid;
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public void setNroMesa(int nroMesa) {
        this.nroMesa = nroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public void ocupar() {
        this.estado = Estado.OCUPADA;
    }

    @Override
    public void liberar() {
        this.estado = Estado.LIBRE;
    }

    @Override
    public void reservar() {
        this.estado = Estado.RESERVADA;
    }

    @Override
    public String SetState() {
        return this.estado.toString();
    }
}