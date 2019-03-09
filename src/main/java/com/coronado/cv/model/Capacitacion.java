package com.coronado.cv.model;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;

import com.coronado.cv.model.audit.DateAudit;

@Entity(name = "capacitaciones")
public class Capacitacion extends DateAudit {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(nullable = false, length = 50)
	private String nombre;
	@Column(nullable = false, length = 50)
	private String institucion;
	@Column(nullable = false, length = 2)
	private String tipo;
	@Column(name = "nro_horas", nullable = false, precision = 10)
	private int nroHoras;
	@Column(name = "fecha_inicio", nullable = false)
	private Date fechaInicio;
	@Column(name = "fecha_fin", nullable = false)
	private Date fechaFin;

	@CreatedBy
	@Column(name = "user_id")
	private int userId;

	/*
	 * @CreatedBy
	 * 
	 * @ManyToOne(optional = false)
	 * 
	 * @JoinColumn(name = "user_id", nullable = false)
	 */
	// private User user;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	/**
	 * Access method for nombre.
	 *
	 * @return the current value of nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter method for nombre.
	 *
	 * @param aNombre the new value for nombre
	 */
	public void setNombre(String aNombre) {
		nombre = aNombre;
	}

	/**
	 * Access method for institucion.
	 *
	 * @return the current value of institucion
	 */
	public String getInstitucion() {
		return institucion;
	}

	/**
	 * Setter method for institucion.
	 *
	 * @param aInstitucion the new value for institucion
	 */
	public void setInstitucion(String aInstitucion) {
		institucion = aInstitucion;
	}

	/**
	 * Access method for tipo.
	 *
	 * @return the current value of tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Setter method for tipo.
	 *
	 * @param aTipo the new value for tipo
	 */
	public void setTipo(String aTipo) {
		tipo = aTipo;
	}

	/**
	 * Access method for nroHoras.
	 *
	 * @return the current value of nroHoras
	 */
	public int getNroHoras() {
		return nroHoras;
	}

	/**
	 * Setter method for nroHoras.
	 *
	 * @param aNroHoras the new value for nroHoras
	 */
	public void setNroHoras(int aNroHoras) {
		nroHoras = aNroHoras;
	}

	/**
	 * Access method for fechaInicio.
	 *
	 * @return the current value of fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Setter method for fechaInicio.
	 *
	 * @param aFechaInicio the new value for fechaInicio
	 */
	public void setFechaInicio(Date aFechaInicio) {
		fechaInicio = aFechaInicio;
	}

	/**
	 * Access method for fechaFin.
	 *
	 * @return the current value of fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Setter method for fechaFin.
	 *
	 * @param aFechaFin the new value for fechaFin
	 */
	public void setFechaFin(Date aFechaFin) {
		fechaFin = aFechaFin;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User aUser) { user = aUser; }
	 */

	/**
	 * Compares the key for this instance with another Capacitacion.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Capacitacion and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Capacitacion)) {
			return false;
		}
		Capacitacion that = (Capacitacion) other;
		if (this.getId() != that.getId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another Capacitacion.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Capacitacion))
			return false;
		return this.equalKeys(other) && ((Capacitacion) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = getId();
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Capacitacion |");
		sb.append(" id=").append(getId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("id", Integer.valueOf(getId()));
		return ret;
	}

}
