package sv.com.stjacks.sjpos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
@Table(name="tienda", schema = "pos")
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tienda", unique=true, nullable=false)
	private Integer idTienda;

	@Column(name="direccion_tda", nullable=false, length=200)
	private String direccionTda;

	@Column(name="email_tda", length=75)
	private String emailTda;

	@Column(name="estado_tda", nullable=false)
	private Boolean estadoTda;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro_tda", nullable=false)
	private Date fechaRegistroTda;

	@Column(name="latitud_tda", nullable=false)
	private double latitudTda;

	@Column(name="longitud_tda", nullable=false)
	private double longitudTda;

	@Column(name="nombre_tda", nullable=false, length=100)
	private String nombreTda;

	@Column(name="telefono_tda", nullable=false, length=15)
	private String telefonoTda;

    private int idPais;
	
	@PrePersist
	public void fechaTienda() {
		fechaRegistroTda = new Date();
	}

	public Tienda() {
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	public String getDireccionTda() {
		return direccionTda;
	}

	public void setDireccionTda(String direccionTda) {
		this.direccionTda = direccionTda;
	}

	public String getEmailTda() {
		return emailTda;
	}

	public void setEmailTda(String emailTda) {
		this.emailTda = emailTda;
	}

	public Boolean getEstadoTda() {
		return estadoTda;
	}

	public void setEstadoTda(Boolean estadoTda) {
		this.estadoTda = estadoTda;
	}

	public Date getFechaRegistroTda() {
		return fechaRegistroTda;
	}

	public void setFechaRegistroTda(Date fechaRegistroTda) {
		this.fechaRegistroTda = fechaRegistroTda;
	}

	public double getLatitudTda() {
		return latitudTda;
	}

	public void setLatitudTda(double latitudTda) {
		this.latitudTda = latitudTda;
	}

	public double getLongitudTda() {
		return longitudTda;
	}

	public void setLongitudTda(double longitudTda) {
		this.longitudTda = longitudTda;
	}

	public String getNombreTda() {
		return nombreTda;
	}

	public void setNombreTda(String nombreTda) {
		this.nombreTda = nombreTda;
	}

	public String getTelefonoTda() {
		return telefonoTda;
	}

	public void setTelefonoTda(String telefonoTda) {
		this.telefonoTda = telefonoTda;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

}