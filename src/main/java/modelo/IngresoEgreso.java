package modelo;

import java.io.Serializable;
import java.util.Objects;

public class IngresoEgreso extends Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	//true -> Cuenta ded Ingresos, false -> Cuenta de Gastos
	private boolean tipoCuenta;
	
	public IngresoEgreso() {}

	public IngresoEgreso(boolean tipoCuenta,int id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
		this.tipoCuenta = tipoCuenta;
	}

	public boolean isTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(boolean tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tipoCuenta);
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
		IngresoEgreso other = (IngresoEgreso) obj;
		return tipoCuenta == other.tipoCuenta;
	}

	@Override
	public String toString() {
		return "IngresoEgreso [tipoCuenta=" + tipoCuenta + "]";
	}
	
	
	
}
