/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jairo Sousa
 */
@Entity
@Table(name = "itens_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensProduto.findAll", query = "SELECT i FROM ItensProduto i"),
    @NamedQuery(name = "ItensProduto.findById", query = "SELECT i FROM ItensProduto i WHERE i.id = :id"),
    @NamedQuery(name = "ItensProduto.findByQuantidade", query = "SELECT i FROM ItensProduto i WHERE i.quantidade = :quantidade")})
public class ItensProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private double quantidade;
    @JoinColumn(name = "venda", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venda venda;
    @JoinColumn(name = "produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto produto;

    public ItensProduto() {
    }

    public ItensProduto(Integer id) {
        this.id = id;
    }

    public ItensProduto(Integer id, double quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        if (!(object instanceof ItensProduto)) {
            return false;
        }
        ItensProduto other = (ItensProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.ItensProduto[ id=" + id + " ]";
    }
    
}
