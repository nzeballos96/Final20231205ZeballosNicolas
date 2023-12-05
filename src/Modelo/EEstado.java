package Modelo;

public enum EEstado {
	Baja("baja"),
	Libre("LIBRE"),
	Reservado("RESERVADO"),
	Ocupado("OCUPADO");

	private String eestado;

	public String getEestado() {
		return eestado;
	}

	public void setEestado(String eestado) {
		this.eestado = eestado;
	}
	private EEstado(String eestado) {
        this.eestado = eestado;
    }
}
