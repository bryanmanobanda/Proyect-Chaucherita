package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Balance extends Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	private double monto;
	
	public Balance() {}
	

	public Balance(double monto,int id, String nombre, String descripcion) {
		super(id, nombre,descripcion);
		this.monto = monto;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(monto);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balance other = (Balance) obj;
		return Double.doubleToLongBits(monto) == Double.doubleToLongBits(other.monto);
	}


	@Override
	public String toString() {
		return "Balance [monto=" + monto + "]";
	}
	
	
}
