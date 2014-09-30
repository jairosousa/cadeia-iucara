/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findById", query = "SELECT c FROM Compra c WHERE c.id = :id"),
    @NamedQuery(name = "Compra.findByData", query = "SELECT c FROM Compra c WHERE c.data = :data"),
    @NamedQuery(name = "Compra.findByQuantidade", query = "SELECT c FROM Compra c WHERE c.quantidade = :quantidade")})
public class Compra implements Serializable {
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
    @JoinColumn(name = "cestoAcai", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CestoAcai cestoAcai;
    @JoinColumn(name = "batedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batedor batedor;
    @JoinColumn(name = "atravessador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Atravessador atravessador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<Processamento> processamentoList;

    public Compra() {
    }

    public Compra(Integer id) {
        this.id = id;
    }

    public Compra(Integer id, Date data, double quantidade) {
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

    public CestoAcai getCestoAcai() {
        return cestoAcai;
    }

    public void setCestoAcai(CestoAcai cestoAcai) {
        this.cestoAcai = cestoAcai;
    }

    public Batedor getBatedor() {
        return batedor;
    }

    public void setBatedor(Batedor batedor) {
        this.batedor = batedor;
    }

    public Atravessador getAtravessador() {
        return atravessador;
    }

    public void setAtravessador(Atravessador atravessador) {
        this.atravessador = atravessador;
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
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.Compra[ id=" + id + " ]";
    }
    
}
