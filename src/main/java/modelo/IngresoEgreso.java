package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class IngresoEgreso extends Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	// true -> Cuenta ded Ingresos, false -> Cuenta de Gastos
	private boolean tipoCuenta;

	private List<Flujo> flujo = null;

	private static List<IngresoEgreso> cuentas = null;

	public IngresoEgreso() {
	}

	public IngresoEgreso(boolean tipoCuenta, int id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
		this.tipoCuenta = tipoCuenta;
	}

	public boolean isTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(boolean tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public List<IngresoEgreso> getCuentas() {
		if(cuentas == null) {
			cuentas = new ArrayList<IngresoEgreso>();
			cuentas.add(new IngresoEgreso(false, 0, "Universidad", "Policuenta"));
			cuentas.add(new IngresoEgreso(true, 1, "Nómina", "Laburando"));
			cuentas.add(new IngresoEgreso(false, 2, "Regalos", "Gastando plata"));
		}
		return cuentas;
	}
	
	public void agregarFlujo(Flujo flujo) {
		if (this.flujo == null) {
			this.flujo = new ArrayList<Flujo>();
		}
		this.flujo.add(flujo);
	}

	public List<Flujo> getFlujos() {
		if (this.flujo == null) {
			this.flujo = new ArrayList<Flujo>();
			this.flujo.add(new Flujo(1, 27.48, new Date(2023, 4, 21)));
			this.flujo.add(new Flujo(2, 12.50, new Date(2023, 4, 23)));
			this.flujo.add(new Flujo(3, 3.56, new Date(2023, 4, 26)));
		}
		return this.flujo;
	}

	public void crearCuenta(IngresoEgreso cuenta) {
		int max = 0;
		for(IngresoEgreso c : cuentas) {
			if(max < c.getId()) {
				max = c.getId();
			}
		}
		
		cuenta.setId(max + 1);
		cuentas.add(cuenta);
	}

	public void eliminarCuenta(int id) {
		for (int i = 0; i < cuentas.size(); i++) {
			if (id == (cuentas.get(i).getId())) {
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
	
	public IngresoEgreso buscar(int id) {
		for(IngresoEgreso cuenta: cuentas) {
			if(cuenta.getId() == id) {
				return cuenta;
			}
		}
		return null;
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
