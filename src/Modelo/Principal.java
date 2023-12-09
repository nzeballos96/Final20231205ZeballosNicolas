package Modelo;

import java.util.Scanner;

import Controlador.CMesa;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("BIENVENIDO ingrese id");
		final int idresto = new Scanner(System.in).nextInt();

		Instancias in = new Instancias();
		in.Menu(idresto);

	}
}
