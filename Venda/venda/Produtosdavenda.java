/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda;

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
@Table(name = "PRODUTOSDAVENDA", catalog = "", schema = "SCHEMAJMARY")
@NamedQueries({
    @NamedQuery(name = "Produtosdavenda.findAll", query = "SELECT p FROM Produtosdavenda p"),
    @NamedQuery(name = "Produtosdavenda.findById", query = "SELECT p FROM Produtosdavenda p WHERE p.id = :id"),
    @NamedQuery(name = "Produtosdavenda.findByIdProdutos", query = "SELECT p FROM Produtosdavenda p WHERE p.idProdutos = :idProdutos"),
    @NamedQuery(name = "Produtosdavenda.findByIdVenda", query = "SELECT p FROM Produtosdavenda p WHERE p.idVenda = :idVenda")})
public class Produtosdavenda implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ID_PRODUTOS", nullable = false)
    private int idProdutos;
    @Basic(optional = false)
    @Column(name = "ID_VENDA", nullable = false)
    private int idVenda;

    public Produtosdavenda() {
    }

    public Produtosdavenda(Integer id) {
        this.id = id;
    }

    public Produtosdavenda(Integer id, int idProdutos, int idVenda) {
        this.id = id;
        this.idProdutos = idProdutos;
        this.idVenda = idVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        int oldIdProdutos = this.idProdutos;
        this.idProdutos = idProdutos;
        changeSupport.firePropertyChange("idProdutos", oldIdProdutos, idProdutos);
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        int oldIdVenda = this.idVenda;
        this.idVenda = idVenda;
        changeSupport.firePropertyChange("idVenda", oldIdVenda, idVenda);
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
        if (!(object instanceof Produtosdavenda)) {
            return false;
        }
        Produtosdavenda other = (Produtosdavenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste_1.Produtosdavenda[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
