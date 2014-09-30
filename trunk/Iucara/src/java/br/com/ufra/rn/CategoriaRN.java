/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.rn;

import br.com.ufra.dao.GenericoDAO;
import br.com.ufra.entidades.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class CategoriaRN {
    
    private GenericoDAO<Categoria> dao = new GenericoDAO<Categoria>();
    
    public Categoria obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Categoria.class, id);
        }
    }
    
    public List<Categoria> obterTodos() {
        return dao.obterTodos(Categoria.class);
    }
    
    public List<Categoria> obterAtravessador(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Categoria> resposta = new ArrayList<Categoria>();
            for (Categoria categoria : obterTodos()) {
                if (categoria.getNome().toUpperCase().indexOf(busca.toUpperCase()) >= 0) {
                    resposta.add(categoria);
                }
            }
            return resposta;
        }
    }
    
    public boolean salvar(Categoria categoria) {
        if (categoria.getNome().equals("")) {
            return false;
        } else {
            if (categoria.getId() == null) {
                return dao.criar(categoria);
            } else {
                return dao.atualizar(categoria);
            }
        }
    }
    public boolean excluir(Categoria categoria) {
        if (categoria.getId() == null) {
            return false;
        } else {
            return dao.excluir(categoria);
        }
    }
    
}
