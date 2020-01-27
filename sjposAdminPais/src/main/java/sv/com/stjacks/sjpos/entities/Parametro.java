package sv.com.stjacks.sjpos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author jramirez
 */
@Entity
@Table(name = "parametro", schema = "pos")
public class Parametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Integer idParametro;

    @Column(name = "nombre_param")
    private String nombreParam;

    @Column(name = "valor_param")
    private String valorParam;

    @Column(name = "estado_param")
    private boolean estadoParam;

    @JsonIgnore
    @OneToMany(mappedBy = "idParametro", cascade = CascadeType.ALL)
    private List<PaisParametro> paisParametroList;

    public Parametro() {
    	paisParametroList = new ArrayList<>();
    }

    public Parametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Parametro(Integer idParametro, String nombreParam, String valorParam, boolean estadoParam) {
        this.idParametro = idParametro;
        this.nombreParam = nombreParam;
        this.valorParam = valorParam;
        this.estadoParam = estadoParam;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getNombreParam() {
        return nombreParam;
    }

    public void setNombreParam(String nombreParam) {
        this.nombreParam = nombreParam;
    }

    public String getValorParam() {
        return valorParam;
    }

    public void setValorParam(String valorParam) {
        this.valorParam = valorParam;
    }

    public boolean getEstadoParam() {
        return estadoParam;
    }

    public void setEstadoParam(boolean estadoParam) {
        this.estadoParam = estadoParam;
    }

    public List<PaisParametro> getPaisParametroList() {
        return paisParametroList;
    }

    public void setPaisParametroList(List<PaisParametro> paisParametroList) {
        this.paisParametroList = paisParametroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

}
