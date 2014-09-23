/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jairo Sousa
 */
@Entity
@Table(name = "acai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acai.findAll", query = "SELECT a FROM Acai a"),
    @NamedQuery(name = "Acai.findById", query = "SELECT a FROM Acai a WHERE a.id = :id"),
    @NamedQuery(name = "Acai.findByOrigem", query = "SELECT a FROM Acai a WHERE a.origem = :origem")})
public class Acai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "origem")
    private String origem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acai")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acai")
    private List<Processar> processarList;

    public Acai() {
    }

    public Acai(Integer id) {
        this.id = id;
    }

    public Acai(Integer id, String origem) {
        this.id = id;
        this.origem = origem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Processar> getProcessarList() {
        return processarList;
    }

    public void setProcessarList(List<Processar> processarList) {
        this.processarList = processarList;
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
        if (!(object instanceof Acai)) {
            return false;
        }
        Acai other = (Acai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.docs.BD.Acai[ id=" + id + " ]";
    }
    
}
