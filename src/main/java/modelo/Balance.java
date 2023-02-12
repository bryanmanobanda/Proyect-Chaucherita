package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balance extends Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	private double monto;

	private static List<Balance> cuentas = null;
	
	public Balance() {}
	

	public Balance(double monto, int id, String nombre, String descripcion) {
		super(id, nombre,descripcion);
		this.monto = monto;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public void crearCuenta(Balance cuenta) {
		int max = 0;
		for (Balance c : cuentas) {
			/*if (max < Integer.parseInt(c.getId().substring(1))) {
				max = Integer.parseInt(c.getId().substring(1));
			}*/
			if(max < c.getId()) {
				max = c.getId();
			}
		}
		cuenta.setId(max + 1);
		cuentas.add(cuenta);
	}

	public void eliminarCuenta(int id) {
		for (int i = 0; i < cuentas.size(); i++) {
			if (id ==(cuentas.get(i).getId())) {
				cuentas.remove(i);
			}
		}
	}

	public void actualizarCuenta(int id, String nombre, String descripcion) {
		for (int i = 0; i < cuentas.size(); i++) {
			if(id == (cuentas.get(i).getId())) {
				cuentas.get(i).setNombre(nombre);
				cuentas.get(i).setDescripcion(descripcion);
			}
		}
	}
	
	public List<Balance> getCuentas() {
		if(cuentas == null) {
			cuentas = new ArrayList<Balance>();
			cuentas.add(new Balance(0, 10, "Banco", "Ta grave la situación"));
		}
		return cuentas;
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
