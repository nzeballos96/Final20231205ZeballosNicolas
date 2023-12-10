package Modelo;

public interface Estado {
    
	public static final Estado LIBRE = new Liberar();
    public static final Estado OCUPADA = new Ocupar();
    public static final Estado RESERVADA = new Reservar();

	void ocupar();
    void liberar();
    void reservar();
    String SetState();
}