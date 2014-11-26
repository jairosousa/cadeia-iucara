/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.bean;

import br.com.ufra.entidades.Armazenamento;
import br.com.ufra.entidades.CestoAcai;
import br.com.ufra.rn.ArmazenamentoRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jairo Sousa
 */
@ManagedBean
@ViewScoped
public class ArmazenamentoBean implements Serializable {

    private Armazenamento armazenamento = new Armazenamento();
    private ArmazenamentoRN rn = new ArmazenamentoRN();
    private CestoAcai cestoAcai;
    private List<Armazenamento> armazenamentos = new ArrayList<>();
    private double quant;

    public double getQuant(List<CestoAcai> cestos) {
        quant = rn.quantidadeTotal(cestos);
        return quant;
    }
    
    public Armazenamento getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public CestoAcai getCestoAcai() {
        return cestoAcai;
    }

    public void setCestoAcai(CestoAcai cestoAcai) {
        this.cestoAcai = cestoAcai;
    }

    public List<Armazenamento> getArmazenamentos() {
        armazenamentos = rn.obterTodos();
        return armazenamentos;
    }

    public void addCesto() {
        List<CestoAcai> cestos = armazenamento.getCestoAcaiList();
        if (cestos == null) {
            cestos = new ArrayList<>();
        }
        cestoAcai.getArmazenamentoList().add(armazenamento);
        cestos.add(cestoAcai);
    }
    
    public String salvar() {
        if (rn.salvar(armazenamento)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastro feito com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "lista.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ", "Erro no Cadastro!");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "lista.xhtml";

        }
    }

    public String excluir() {
        if (rn.excluir(armazenamento)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastro foi excluído com exito");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "lista.xhtml";
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ", "O cadastro não foi excluído!!!");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "lista.xhtml";
        }
    }

    public String editar() {
        return "formulario.xhtml";
    }

    public String incluir() {
        return "formulario.xhtml";
    }

    public String cancelar() {
        return "lista.xhtml";
    }

}
