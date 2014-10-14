/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.rn;

import br.com.ufra.dao.GenericoDAOImpl;
import br.com.ufra.entidades.Processamento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class ProcessamentoRN {
    
    private GenericoDAOImpl<Processamento> dao = new GenericoDAOImpl<Processamento>();
    
    public Processamento obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Processamento.class, id);
        }
    }
    
    public List<Processamento> obterTodos() {
        return dao.obterTodos(Processamento.class);
    }
    
    public boolean salvar(Processamento processamento) {
        if (processamento.getQuantidade()==0) {
            return false;
        } else {
            if (processamento.getId() == null) {
                return dao.criar(processamento);
            } else {
                return dao.atualizar(processamento);
            }
        }
    }
    public boolean excluir(Processamento processamento) {
        if (processamento.getId() == null) {
            return false;
        } else {
            return dao.excluir(processamento);
        }
    }
    
}
