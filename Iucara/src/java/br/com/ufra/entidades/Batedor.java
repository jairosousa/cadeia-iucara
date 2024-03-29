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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "batedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Batedor.findAll", query = "SELECT b FROM Batedor b"),
    @NamedQuery(name = "Batedor.findById", query = "SELECT b FROM Batedor b WHERE b.id = :id"),
    @NamedQuery(name = "Batedor.findByNome", query = "SELECT b FROM Batedor b WHERE b.nome = :nome"),
    @NamedQuery(name = "Batedor.findByEndereco", query = "SELECT b FROM Batedor b WHERE b.endereco = :endereco"),
    @NamedQuery(name = "Batedor.findByTelefone", query = "SELECT b FROM Batedor b WHERE b.telefone = :telefone"),
    @NamedQuery(name = "Batedor.findByEmail", query = "SELECT b FROM Batedor b WHERE b.email = :email"),
    @NamedQuery(name = "Batedor.findByLoggin", query = "SELECT b FROM Batedor b WHERE b.loggin = :loggin"),
    @NamedQuery(name = "Batedor.findBySenha", query = "SELECT b FROM Batedor b WHERE b.senha = :senha")})
public class Batedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "loggin")
    private String loggin;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batedor")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batedor")
    private List<Processamento> processamentoList;
    @JoinColumn(name = "bairro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bairro bairro;

    public Batedor() {
    }

    public Batedor(Integer id) {
        this.id = id;
    }

    public Batedor(Integer id, String nome, String endereco, String telefone, String email, String loggin, String senha) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.loggin = loggin;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoggin() {
        return loggin;
    }

    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
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
        if (!(object instanceof Batedor)) {
            return false;
        }
        Batedor other = (Batedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufra.entidades.Batedor[ id=" + id + " ]";
    }
    
}
