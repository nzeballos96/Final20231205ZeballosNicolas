package Modelo;

	public interface Estado {

	 //   Object ocupado = "ocupado";
	   // Object libre = "libre";
	    //Object reservado = "reservado";

		public void liberar(Mesa m);

		public  void reservar(Mesa m);

	    public  void ocupar(Mesa m);

	    boolean setSate(Estado state);
	}