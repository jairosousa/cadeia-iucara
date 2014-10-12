/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.rn;

import br.com.ufra.dao.BairroDAOImpl;
import br.com.ufra.entidades.Bairro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class BairroRN {

    private BairroDAOImpl dao = new BairroDAOImpl();

    public Bairro obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Bairro.class, id);
        }
    }

    public List<Bairro> obterTodos() {
        return dao.obterTodos(Bairro.class);
    }

    public List<Bairro> obterTodosOrdenado() {
        return dao.obterTodosOrdenado("nome");
    }

    public Bairro obterNome(String nome) {
        return dao.obterNome(nome);
    }

    public List<Bairro> obterBairro(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Bairro> resposta = new ArrayList<Bairro>();
            for (Bairro bairro : obterTodos()) {
                if (bairro.getNome().toUpperCase().indexOf(busca.toUpperCase()) >= 0) {
                    resposta.add(bairro);
                }
            }
            return resposta;
        }
    }

    public boolean salvar(Bairro bairro) {
        if (bairro.getNome().equals("")) {
            return false;
        } else {
            if (bairro.getId() == null) {
                return dao.criar(bairro);
            } else {
                return dao.atualizar(bairro);
            }
        }
    }

    public boolean excluir(Bairro bairro) {
        if (bairro.getId() == null) {
            return false;
        } else {
            return dao.excluir(bairro);
        }
    }
}
