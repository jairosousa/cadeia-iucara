/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.rn;

import br.com.ufra.dao.BatedorDAOImpl;
import br.com.ufra.entidades.Batedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class BatedorRN {

    private BatedorDAOImpl dao = new BatedorDAOImpl();

    public Batedor obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Batedor.class, id);
        }
    }

    public List<Batedor> obterTodos() {
        return dao.obterTodos(Batedor.class);
    }

    public List<Batedor> obterTodosOrdenado() {
        return dao.obterTodosOrdenado("nome");
    }

    public Batedor obterNome(String nome) {
        return dao.obterNome(nome);
    }

    public boolean salvar(Batedor batedor) {
        if (batedor.getNome().equals("")) {
            return false;
        } else {
            if (batedor.getId() == null) {
                return dao.criar(batedor);
            } else {
                return dao.atualizar(batedor);
            }
        }
    }

    public boolean excluir(Batedor batedor) {
        if (batedor.getId() == null) {
            return false;
        } else {
            return dao.excluir(batedor);
        }
    }

}
