package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Movimiento implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	private String concepto;
	private Date fecha;
	private double valor;
	
	public static List<Movimiento> movimientos = null;
	
	public Movimiento() {
		
	}

	public Movimiento(int id, Cuenta cuentaOrigen, Cuenta cuentaDestino, String concepto, Date fecha, double valor) {
		super();
		this.id = id;
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.concepto = concepto;
		this.fecha = fecha;
		this.valor = valor;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}


	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}


	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}


	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void agregarMovimiento(Movimiento movimiento) {
		if(movimientos == null) {
			movimientos = new ArrayList<Movimiento>();
		}
		movimientos.add(movimiento);
	}
	
	public List getMovimientos () {
		return movimientos;
	}
	
	public void crearMovimiento(Movimiento movimiento) {
		int max = 0;
		for (Movimiento c : movimientos) {
			if(max < c.getId()) {
				max = c.getId();
			}
		}
		movimiento.setId(max + 1);
		movimientos.add(movimiento);
	}


	@Override
	public int hashCode() {
		return Objects.hash(concepto, cuentaDestino, cuentaOrigen, fecha, id, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		return Objects.equals(concepto, other.concepto) && Objects.equals(cuentaDestino, other.cuentaDestino)
				&& Objects.equals(cuentaOrigen, other.cuentaOrigen) && Objects.equals(fecha, other.fecha)
				&& id == other.id && Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}


	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino=" + cuentaDestino
				+ ", concepto=" + concepto + ", fecha=" + fecha + ", valor=" + valor + "]";
	}
	
}
