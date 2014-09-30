/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.bean;

import br.com.ufra.entidades.CestoAcai;
import br.com.ufra.rn.CestoAcaiRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jairo Sousa
 */
@ManagedBean
@RequestScoped
public class CestoAcaiBean implements Serializable{
    
    private CestoAcai cestoAcai = new CestoAcai();
    private CestoAcaiRN rn = new CestoAcaiRN();
    private List<CestoAcai> cestosAcai;
    
    public CestoAcai getCestoAcai() {
        return cestoAcai;
    }

    public void setCestoAcai(CestoAcai cestoAcai) {
        this.cestoAcai = cestoAcai;
    }
    
    public List<CestoAcai> getCestosAcai() {
        cestosAcai = rn.obterTodos();
        return cestosAcai;
    }
    
    public String salvar() {
        if (rn.salvar(cestoAcai)) {
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
        if (rn.excluir(cestoAcai)) {
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
