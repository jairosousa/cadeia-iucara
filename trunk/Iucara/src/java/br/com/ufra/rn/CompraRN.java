/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.rn;

import br.com.ufra.dao.GenericoDAO;
import br.com.ufra.entidades.Compra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class CompraRN {
    
    private GenericoDAO<Compra> dao = new GenericoDAO<Compra>();
    
    public Compra obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Compra.class, id);
        }
    }
    
    public List<Compra> obterTodos() {
        return dao.obterTodos(Compra.class);
    }
    
    public List<Compra> obterAtravessador(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Compra> resposta = new ArrayList<Compra>();
            for (Compra compra : obterTodos()) {
                if (compra.getQuantidade() >= 0) {
                    resposta.add(compra);
                }
            }
            return resposta;
        }
    }
    
    public boolean salvar(Compra compra) {
        if (compra.getQuantidade()==0) {
            return false;
        } else {
            if (compra.getId() == null) {
                return dao.criar(compra);
            } else {
                return dao.atualizar(compra);
            }
        }
    }
    public boolean excluir(Compra compra) {
        if (compra.getId() == null) {
            return false;
        } else {
            return dao.excluir(compra);
        }
    }
    
}
