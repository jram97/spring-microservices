package sv.com.stjacks.sjpos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sv.com.stjacks.sjpos.entities.Pais;
import sv.com.stjacks.sjpos.entities.Parametro;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "pais_parametro", schema = "pos")
public class PaisParametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_pais_parametro")
    private Integer idPaisParametro;

    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pais idPais;

    @JoinColumn(name = "id_parametro", referencedColumnName = "id_parametro")
    @ManyToOne(fetch = FetchType.EAGER)
    private Parametro idParametro;

	public PaisParametro(Integer idPaisParametro, Pais idPais, Parametro idParametro) {
		this.idPaisParametro = idPaisParametro;
		this.idPais = idPais;
		this.idParametro = idParametro;
	}

	public PaisParametro(Pais idPais, Parametro idParametro) {
		this.idPais = idPais;
		this.idParametro = idParametro;
	}

	public PaisParametro() {
    }

    public PaisParametro(Integer idPaisParametro) {
        this.idPaisParametro = idPaisParametro;
    }

    public Integer getIdPaisParametro() {
        return idPaisParametro;
    }

    public void setIdPaisParametro(Integer idPaisParametro) {
        this.idPaisParametro = idPaisParametro;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Parametro getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Parametro idParametro) {
        this.idParametro = idParametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaisParametro != null ? idPaisParametro.hashCode() : 0);
        return hash;
    }

	@Override
	public String toString() {
		return "PaisParametro [idPaisParametro=" + idPaisParametro + ", idPais=" + idPais + ", idParametro="
				+ idParametro + "]";
	}
    
    
}
