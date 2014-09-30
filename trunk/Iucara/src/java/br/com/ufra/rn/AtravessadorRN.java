/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.rn;

import br.com.ufra.dao.GenericoDAO;
import br.com.ufra.entidades.Atravessador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class AtravessadorRN {
    
    private GenericoDAO<Atravessador> dao = new GenericoDAO<Atravessador>();
    
    public Atravessador obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Atravessador.class, id);
        }
    }
    
    public List<Atravessador> obterTodos() {
        return dao.obterTodos(Atravessador.class);
    }
    
    public List<Atravessador> obterAtravessador(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Atravessador> resposta = new ArrayList<Atravessador>();
            for (Atravessador atravessador : obterTodos()) {
                if (atravessador.getNome().toUpperCase().indexOf(busca.toUpperCase()) >= 0) {
                    resposta.add(atravessador);
                }
            }
            return resposta;
        }
    }
    
    public boolean salvar(Atravessador atravessador) {
        if (atravessador.getNome().equals("")) {
            return false;
        } else {
            if (atravessador.getId() == null) {
                return dao.criar(atravessador);
            } else {
                return dao.atualizar(atravessador);
            }
        }
    }
    public boolean excluir(Atravessador atravessador) {
        if (atravessador.getId() == null) {
            return false;
        } else {
            return dao.excluir(atravessador);
        }
    }
}
