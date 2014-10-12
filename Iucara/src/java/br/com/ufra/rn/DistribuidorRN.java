/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.rn;

import br.com.ufra.entidades.Distribuidor;
import br.com.ufra.dao.DistribuidorDAOImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class DistribuidorRN {

    private DistribuidorDAOImpl dao = new DistribuidorDAOImpl();

    public Distribuidor obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Distribuidor.class, id);
        }
    }

    public List<Distribuidor> obterTodos() {
        return dao.obterTodos(Distribuidor.class);
    }

    public List<Distribuidor> obterTodosOrdenado() {
        return dao.obterTodosOrdenado("nome");
    }

    public Distribuidor obterNome(String nome) {
        return dao.obterNome(nome);
    }

    public List<Distribuidor> obterDistribuidor(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Distribuidor> resposta = new ArrayList<Distribuidor>();
            for (Distribuidor distribuidor : obterTodos()) {
                if (distribuidor.getNome().toUpperCase().indexOf(busca.toUpperCase()) >= 0) {
                    resposta.add(distribuidor);
                }
            }
            return resposta;
        }
    }

    public boolean salvar(Distribuidor distribuidor) {
        if (distribuidor.getNome().equals("")) {
            return false;
        } else {
            if (distribuidor.getId() == null) {
                return dao.criar(distribuidor);
            } else {
                return dao.atualizar(distribuidor);
            }
        }
    }

    public boolean excluir(Distribuidor distribuidor) {
        if (distribuidor.getId() == null) {
            return false;
        } else {
            return dao.excluir(distribuidor);
        }
    }
}
