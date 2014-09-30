/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.rn;

import br.com.ufra.dao.GenericoDAO;
import br.com.ufra.entidades.CestoAcai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class CestoAcaiRN {
    
    private GenericoDAO<CestoAcai> dao = new GenericoDAO<CestoAcai>();
    
    public CestoAcai obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(CestoAcai.class, id);
        }
    }
    
    public List<CestoAcai> obterTodos() {
        return dao.obterTodos(CestoAcai.class);
    }
    
    public List<CestoAcai> obterAtravessador(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<CestoAcai> resposta = new ArrayList<CestoAcai>();
            for (CestoAcai cestoAcai : obterTodos()) {
                if (cestoAcai.getQuantidade()>= 0) {
                    resposta.add(cestoAcai);
                }
            }
            return resposta;
        }
    }
    
    public boolean salvar(CestoAcai cestoAcai) {
        if (cestoAcai.getOrigem().equals("")) {
            return false;
        } else {
            if (cestoAcai.getId() == null) {
                return dao.criar(cestoAcai);
            } else {
                return dao.atualizar(cestoAcai);
            }
        }
    }
    public boolean excluir(CestoAcai cestoAcai) {
        if (cestoAcai.getId() == null) {
            return false;
        } else {
            return dao.excluir(cestoAcai);
        }
    }
    
}
