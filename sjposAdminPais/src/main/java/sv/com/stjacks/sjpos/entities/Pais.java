package sv.com.stjacks.sjpos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais", schema = "pos")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pais")
	private Integer idPais;

	@Column(name="estado_pais")
	private Boolean estadoPais = true;

	@Column(name="moneda_pais")
	private String monedaPais;

	@Column(name="nombre_pais")
	private String nombrePais;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idPais", cascade = CascadeType.ALL)
    private List<PaisParametro> paisParametroForpaisList;

	public Pais() {
		paisParametroForpaisList = new ArrayList<>();
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Boolean getEstadoPais() {
		return estadoPais;
	}

	public void setEstadoPais(Boolean estadoPais) {
		this.estadoPais = estadoPais;
	}

	public String getMonedaPais() {
		return monedaPais;
	}

	public void setMonedaPais(String monedaPais) {
		this.monedaPais = monedaPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public List<PaisParametro> getPaisParametroForpaisList() {
		return paisParametroForpaisList;
	}

	public void setPaisParametroForpaisList(List<PaisParametro> paisParametroForpaisList) {
		this.paisParametroForpaisList = paisParametroForpaisList;
	}

	
}