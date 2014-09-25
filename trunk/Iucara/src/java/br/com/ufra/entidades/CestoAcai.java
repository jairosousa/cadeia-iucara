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
@Table(name = "cesto_acai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CestoAcai.findAll", query = "SELECT c FROM CestoAcai c"),
    @NamedQuery(name = "CestoAcai.findById", query = "SELECT c FROM CestoAcai c WHERE c.id = :id"),
    @NamedQuery(name = "CestoAcai.findByOrigem", query = "SELECT c FROM CestoAcai c WHERE c.origem = :origem"),
    @NamedQuery(name = "CestoAcai.findByQuantidade", query = "SELECT c FROM CestoAcai c WHERE c.quantidade = :quantidade")})
public class CestoAcai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "origem")
    private String origem;
    @Column(name = "quantidade")
    private Integer quantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acai")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acai")
    private List<Processamento> processamentoList;

    public CestoAcai() {
    }

    public CestoAcai(Integer id) {
        this.id = id;
    }

    public CestoAcai(Integer id, String origem) {
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
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
