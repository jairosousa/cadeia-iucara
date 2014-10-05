/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jairo Sousa
 */
@Entity
@Table(name = "armazenamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armazenamento.findAll", query = "SELECT a FROM Armazenamento a"),
    @NamedQuery(name = "Armazenamento.findById", query = "SELECT a FROM Armazenamento a WHERE a.id = :id"),
    @NamedQuery(name = "Armazenamento.findByData", query = "SELECT a FROM Armazenamento a WHERE a.data = :data"),
    @NamedQuery(name = "Armazenamento.findByQuantidade", query = "SELECT a FROM Armazenamento a WHERE a.quantidade = :quantidade")})
public class Armazenamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private double quantidade;
    @JoinTable(name = "itens_armazenamento", joinColumns = {
        @JoinColumn(name = "armazenamento", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "cesto_acai", referencedColumnName = "id")})
    @ManyToMany
    private List<CestoAcai> cestoAcaiList;
    @JoinColumn(name = "Cesto_distribuidor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CestoDistribuidor cestodistribuidor;
    @JoinColumn(name = "distribuidor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Distribuidor distribuidor;

    public Armazenamento() {
    }

    public Armazenamento(Integer id) {
        this.id = id;
    }

    public Armazenamento(Integer id, Date data, double quantidade) {
        this.id = id;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public List<CestoAcai> getCestoAcaiList() {
        return cestoAcaiList;
    }

    public void setCestoAcaiList(List<CestoAcai> cestoAcaiList) {
        this.cestoAcaiList = cestoAcaiList;
    }

    public CestoDistribuidor getCestodistribuidor() {
        return cestodistribuidor;
    }

    public void setCestodistribuidor(CestoDistribuidor cestodistribuidor) {
        this.cestodistribuidor = cestodistribuidor;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
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
        if (!(object instanceof Armazenamento)) {
            return false;
        }
        Armazenamento other = (Armazenamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.Armazenamento[ id=" + id + " ]";
    }
    
}
