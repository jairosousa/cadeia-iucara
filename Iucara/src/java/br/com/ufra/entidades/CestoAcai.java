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
import javax.persistence.ManyToMany;
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
@Table(name = "cesto_acai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CestoAcai.findAll", query = "SELECT c FROM CestoAcai c"),
    @NamedQuery(name = "CestoAcai.findById", query = "SELECT c FROM CestoAcai c WHERE c.id = :id"),
    @NamedQuery(name = "CestoAcai.findByData", query = "SELECT c FROM CestoAcai c WHERE c.data = :data"),
    @NamedQuery(name = "CestoAcai.findByOrigem", query = "SELECT c FROM CestoAcai c WHERE c.origem = :origem"),
    @NamedQuery(name = "CestoAcai.findByQuantidade", query = "SELECT c FROM CestoAcai c WHERE c.quantidade = :quantidade"),
    @NamedQuery(name = "CestoAcai.findByTipo", query = "SELECT c FROM CestoAcai c WHERE c.tipo = :tipo")})
public class CestoAcai implements Serializable {
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
    @Column(name = "origem")
    private String origem;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private double quantidade;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @ManyToMany(mappedBy = "cestoAcaiList")
    private List<Armazenamento> armazenamentoList;

    public CestoAcai() {
    }

    public CestoAcai(Integer id) {
        this.id = id;
    }

    public CestoAcai(Integer id, Date data, String origem, double quantidade, String tipo) {
        this.id = id;
        this.data = data;
        this.origem = origem;
        this.quantidade = quantidade;
        this.tipo = tipo;
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Armazenamento> getArmazenamentoList() {
        return armazenamentoList;
    }

    public void setArmazenamentoList(List<Armazenamento> armazenamentoList) {
        this.armazenamentoList = armazenamentoList;
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
        if (!(object instanceof CestoAcai)) {
            return false;
        }
        CestoAcai other = (CestoAcai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.CestoAcai[ id=" + id + " ]";
    }
    
}
