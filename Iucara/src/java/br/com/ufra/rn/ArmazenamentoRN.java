/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.rn;

import br.com.ufra.dao.ArmazenamentoDAOImpl;
import br.com.ufra.entidades.Armazenamento;
import br.com.ufra.entidades.CestoAcai;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class ArmazenamentoRN {
    
    private ArmazenamentoDAOImpl dao = new ArmazenamentoDAOImpl();
    
    public Armazenamento obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Armazenamento.class, id);
        }
    }
    
    public double quantidadeTotal(List<CestoAcai> cestos) {
        double soma = 0;
        for (CestoAcai cesto : cestos) {
            soma += cesto.getQuantidade();
        }
        return soma;
    }
    
    public List<Armazenamento> obterTodos() {
        return dao.obterTodos(Armazenamento.class);
    }
    public List<CestoAcai> obterCestoAcaiArmazenamento() {
        return dao.obterCestoAcaiArmazenamento(Integer.SIZE);
    }
    
    public List<Armazenamento> obterArmazenamento(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Armazenamento> resposta = new ArrayList<Armazenamento>();
            for (Armazenamento armazenamento : obterTodos()) {
                if (armazenamento.getQuantidade() >= 0) {
                    resposta.add(armazenamento);
                }
            }
            return resposta;
        }
    }
    
    public boolean salvar(Armazenamento armazenamento) {
        if (armazenamento.getCestodistribuidor().equals("")) {
            return false;
        } else {
            if (armazenamento.getId() == null) {
                return dao.criar(armazenamento);
            } else {
                return dao.atualizar(armazenamento);
            }
        }
    }
    public boolean excluir(Armazenamento armazenamento) {
        if (armazenamento.getId() == null) {
            return false;
        } else {
            return dao.excluir(armazenamento);
        }
    }
}
