/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.rn;

import br.com.ufra.dao.GenericoDAOImpl;
import br.com.ufra.entidades.CestoDistribuidor;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class CestoDistribuidorRN {

    private GenericoDAOImpl<CestoDistribuidor> dao = new GenericoDAOImpl<CestoDistribuidor>();

    public CestoDistribuidor obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(CestoDistribuidor.class, id);
        }
    }

    public List<CestoDistribuidor> obterTodos() {
        return dao.obterTodos(CestoDistribuidor.class);
    }

    public boolean salvar(CestoDistribuidor cesto) {
        if (cesto.getTipo().equals("")) {
            return false;
        } else {
            if (cesto.getId() == null) {
                return dao.criar(cesto);
            } else {
                return dao.atualizar(cesto);
            }
        }
    }

    public boolean excluir(CestoDistribuidor cesto) {
        if (cesto.getId() == null) {
            return false;
        } else {
            return dao.excluir(cesto);
        }
    }
}
