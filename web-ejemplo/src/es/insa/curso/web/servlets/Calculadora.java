package es.insa.curso.web.servlets;

public class Calculadora {
	
	private double suma;
	private double resta;
	private double producto;
	private double cociente;
	
	public Calculadora() {
	}

	public Calculadora(String a, String b) {
		double x = Double.valueOf(a);
		double y = Double.valueOf(b);
		
		this.suma = x+y;
		this.resta = x-y;
		this.cociente = x/y;
		this.producto = x*y;
		
	}

	public double getSuma() {
		return suma;
	}

	public double getResta() {
		return resta;
	}

	public double getProducto() {
		return producto;
	}

	public double getCociente() {
		return cociente;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public void setResta(double resta) {
		this.resta = resta;
	}

	public void setProducto(double producto) {
		this.producto = producto;
	}

	public void setCociente(double cociente) {
		this.cociente = cociente;
	}

}
