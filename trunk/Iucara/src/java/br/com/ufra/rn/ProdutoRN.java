/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.rn;

import br.com.ufra.dao.GenericoDAO;
import br.com.ufra.entidades.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class ProdutoRN {
    
    private GenericoDAO<Produto> dao = new GenericoDAO<Produto>();
    
    public Produto obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Produto.class, id);
        }
    }
    
    public List<Produto> obterTodos() {
        return dao.obterTodos(Produto.class);
    }
    
    public List<Produto> obterAtravessador(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Produto> resposta = new ArrayList<Produto>();
            for (Produto produto : obterTodos()) {
                if (produto.getQuantidade() >= 0) {
                    resposta.add(produto);
                }
            }
            return resposta;
        }
    }
    
    public boolean salvar(Produto produto) {
        if (produto.getQuantidade()==0) {
            return false;
        } else {
            if (produto.getId() == null) {
                return dao.criar(produto);
            } else {
                return dao.atualizar(produto);
            }
        }
    }
    public boolean excluir(Produto produto) {
        if (produto.getId() == null) {
            return false;
        } else {
            return dao.excluir(produto);
        }
    }
    
}
