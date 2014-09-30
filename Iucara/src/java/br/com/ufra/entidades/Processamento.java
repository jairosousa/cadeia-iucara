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
@Table(name = "processamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processamento.findAll", query = "SELECT p FROM Processamento p"),
    @NamedQuery(name = "Processamento.findById", query = "SELECT p FROM Processamento p WHERE p.id = :id"),
    @NamedQuery(name = "Processamento.findByData", query = "SELECT p FROM Processamento p WHERE p.data = :data"),
    @NamedQuery(name = "Processamento.findByQuantidade", query = "SELECT p FROM Processamento p WHERE p.quantidade = :quantidade")})
public class Processamento implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processar")
    private List<Produto> produtoList;
    @JoinColumn(name = "compra", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compra compra;
    @JoinColumn(name = "batedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batedor batedor;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoria;

    public Processamento() {
    }

    public Processamento(Integer id) {
        this.id = id;
    }

    public Processamento(Integer id, Date data, double quantidade) {
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
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Batedor getBatedor() {
        return batedor;
    }

    public void setBatedor(Batedor batedor) {
        this.batedor = batedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof Processamento)) {
            return false;
        }
        Processamento other = (Processamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.Processamento[ id=" + id + " ]";
    }

}
