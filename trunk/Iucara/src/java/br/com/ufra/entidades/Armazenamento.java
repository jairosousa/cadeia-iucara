/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
 * @author bpmlab
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @JoinTable(name = "itens_armazenamento", joinColumns = {
        @JoinColumn(name = "armazenamento", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "cesto_acai", referencedColumnName = "id")})
    @ManyToMany
    private List<CestoAcai> cestoAcaiList;
    @JoinColumn(name = "distribuidor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Distribuidor distribuidor;
    @JoinColumn(name = "Cesto_distribuidor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CestoDistribuidor cestodistribuidor;

    public Armazenamento() {
    }

    public Armazenamento(Integer id) {
        this.id = id;
    }

    public Armazenamento(Integer id, Date data) {
        this.id = id;
        this.data = data;
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

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public List<CestoAcai> getCestoAcaiList() {
        if (cestoAcaiList == null) {
            cestoAcaiList = new ArrayList<>();
        }
        return cestoAcaiList;
    }

    public void setCestoAcaiList(List<CestoAcai> cestoAcaiList) {
        this.cestoAcaiList = cestoAcaiList;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public CestoDistribuidor getCestodistribuidor() {
        return cestodistribuidor;
    }

    public void setCestodistribuidor(CestoDistribuidor cestodistribuidor) {
        this.cestodistribuidor = cestodistribuidor;
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
