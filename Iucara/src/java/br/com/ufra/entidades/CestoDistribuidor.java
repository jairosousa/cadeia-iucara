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
 * @author bpmlab
 */
@Entity
@Table(name = "cesto_distribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CestoDistribuidor.findAll", query = "SELECT c FROM CestoDistribuidor c"),
    @NamedQuery(name = "CestoDistribuidor.findById", query = "SELECT c FROM CestoDistribuidor c WHERE c.id = :id"),
    @NamedQuery(name = "CestoDistribuidor.findByTipo", query = "SELECT c FROM CestoDistribuidor c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CestoDistribuidor.findByCapacidade", query = "SELECT c FROM CestoDistribuidor c WHERE c.capacidade = :capacidade")})
public class CestoDistribuidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "capacidade")
    private double capacidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cestoDistribuidor")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cestodistribuidor")
    private List<Armazenamento> armazenamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cestodistribuidor")
    private List<Processamento> processamentoList;

    public CestoDistribuidor() {
    }

    public CestoDistribuidor(Integer id) {
        this.id = id;
    }

    public CestoDistribuidor(Integer id, String tipo, double capacidade) {
        this.id = id;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Armazenamento> getArmazenamentoList() {
        return armazenamentoList;
    }

    public void setArmazenamentoList(List<Armazenamento> armazenamentoList) {
        this.armazenamentoList = armazenamentoList;
    }

    @XmlTransient
    public List<Processamento> getProcessamentoList() {
        return processamentoList;
    }

    public void setProcessamentoList(List<Processamento> processamentoList) {
        this.processamentoList = processamentoList;
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
        if (!(object instanceof CestoDistribuidor)) {
            return false;
        }
        CestoDistribuidor other = (CestoDistribuidor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.CestoDistribuidor[ id=" + id + " ]";
    }
    
}
