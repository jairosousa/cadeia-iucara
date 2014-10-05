/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jairo Sousa
 */
@Entity
@Table(name = "vinho_embalado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VinhoEmbalado.findAll", query = "SELECT v FROM VinhoEmbalado v"),
    @NamedQuery(name = "VinhoEmbalado.findByProcessamento", query = "SELECT v FROM VinhoEmbalado v WHERE v.processamento = :processamento"),
    @NamedQuery(name = "VinhoEmbalado.findByQuantidade", query = "SELECT v FROM VinhoEmbalado v WHERE v.quantidade = :quantidade")})
public class VinhoEmbalado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "processamento")
    private Integer processamento;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private double quantidade;
    @JoinTable(name = "itens_venda", joinColumns = {
        @JoinColumn(name = "procesamento", referencedColumnName = "processamento")}, inverseJoinColumns = {
        @JoinColumn(name = "venda", referencedColumnName = "id")})
    @ManyToMany
    private List<Venda> vendaList;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "processamento", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Processamento processamento1;

    public VinhoEmbalado() {
    }

    public VinhoEmbalado(Integer processamento) {
        this.processamento = processamento;
    }

    public VinhoEmbalado(Integer processamento, double quantidade) {
        this.processamento = processamento;
        this.quantidade = quantidade;
    }

    public Integer getProcessamento() {
        return processamento;
    }

    public void setProcessamento(Integer processamento) {
        this.processamento = processamento;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Processamento getProcessamento1() {
        return processamento1;
    }

    public void setProcessamento1(Processamento processamento1) {
        this.processamento1 = processamento1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processamento != null ? processamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VinhoEmbalado)) {
            return false;
        }
        VinhoEmbalado other = (VinhoEmbalado) object;
        if ((this.processamento == null && other.processamento != null) || (this.processamento != null && !this.processamento.equals(other.processamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.VinhoEmbalado[ processamento=" + processamento + " ]";
    }
    
}
