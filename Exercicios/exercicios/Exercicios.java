/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "EXERCICIOS", catalog = "", schema = "SCHEMAJMARY")
@NamedQueries({
    @NamedQuery(name = "Exercicios.findAll", query = "SELECT e FROM Exercicios e"),
    @NamedQuery(name = "Exercicios.findById", query = "SELECT e FROM Exercicios e WHERE e.id = :id"),
    @NamedQuery(name = "Exercicios.findByPergunta", query = "SELECT e FROM Exercicios e WHERE e.pergunta = :pergunta"),
    @NamedQuery(name = "Exercicios.findByRespostacerta", query = "SELECT e FROM Exercicios e WHERE e.respostacerta = :respostacerta"),
    @NamedQuery(name = "Exercicios.findByRespostahtml", query = "SELECT e FROM Exercicios e WHERE e.respostahtml = :respostahtml"),
    @NamedQuery(name = "Exercicios.findByIdMateria", query = "SELECT e FROM Exercicios e WHERE e.idMateria = :idMateria"),
    @NamedQuery(name = "Exercicios.findByIdCategoria", query = "SELECT e FROM Exercicios e WHERE e.idCategoria = :idCategoria"),
    @NamedQuery(name = "Exercicios.findByIdSubcategoria", query = "SELECT e FROM Exercicios e WHERE e.idSubcategoria = :idSubcategoria"),
    @NamedQuery(name = "Exercicios.findByIdAssunto", query = "SELECT e FROM Exercicios e WHERE e.idAssunto = :idAssunto")})
public class Exercicios implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "PERGUNTA", length = 1000)
    private String pergunta;
    @Column(name = "RESPOSTACERTA", length = 1)
    private String respostacerta;
    @Column(name = "RESPOSTAHTML", length = 1000)
    private String respostahtml;
    @Basic(optional = false)
    @Column(name = "ID_MATERIA", nullable = false)
    private int idMateria;
    @Basic(optional = false)
    @Column(name = "ID_CATEGORIA", nullable = false)
    private int idCategoria;
    @Basic(optional = false)
    @Column(name = "ID_SUBCATEGORIA", nullable = false)
    private int idSubcategoria;
    @Basic(optional = false)
    @Column(name = "ID_ASSUNTO", nullable = false)
    private int idAssunto;

    public Exercicios() {
    }

    public Exercicios(Integer id) {
        this.id = id;
    }

    public Exercicios(Integer id, int idMateria, int idCategoria, int idSubcategoria, int idAssunto) {
        this.id = id;
        this.idMateria = idMateria;
        this.idCategoria = idCategoria;
        this.idSubcategoria = idSubcategoria;
        this.idAssunto = idAssunto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        String oldPergunta = this.pergunta;
        this.pergunta = pergunta;
        changeSupport.firePropertyChange("pergunta", oldPergunta, pergunta);
    }

    public String getRespostacerta() {
        return respostacerta;
    }

    public void setRespostacerta(String respostacerta) {
        String oldRespostacerta = this.respostacerta;
        this.respostacerta = respostacerta;
        changeSupport.firePropertyChange("respostacerta", oldRespostacerta, respostacerta);
    }

    public String getRespostahtml() {
        return respostahtml;
    }

    public void setRespostahtml(String respostahtml) {
        String oldRespostahtml = this.respostahtml;
        this.respostahtml = respostahtml;
        changeSupport.firePropertyChange("respostahtml", oldRespostahtml, respostahtml);
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        int oldIdMateria = this.idMateria;
        this.idMateria = idMateria;
        changeSupport.firePropertyChange("idMateria", oldIdMateria, idMateria);
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        int oldIdCategoria = this.idCategoria;
        this.idCategoria = idCategoria;
        changeSupport.firePropertyChange("idCategoria", oldIdCategoria, idCategoria);
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        int oldIdSubcategoria = this.idSubcategoria;
        this.idSubcategoria = idSubcategoria;
        changeSupport.firePropertyChange("idSubcategoria", oldIdSubcategoria, idSubcategoria);
    }

    public int getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(int idAssunto) {
        int oldIdAssunto = this.idAssunto;
        this.idAssunto = idAssunto;
        changeSupport.firePropertyChange("idAssunto", oldIdAssunto, idAssunto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exercicios)) {
            return false;
        }
        Exercicios other = (Exercicios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Exercicios[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
