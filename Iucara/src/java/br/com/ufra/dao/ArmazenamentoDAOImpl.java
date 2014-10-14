/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import br.com.ufra.dao.service.ArmazenamentoDAO;
import br.com.ufra.dao.service.GenericDAO;
import br.com.ufra.entidades.Armazenamento;
import br.com.ufra.entidades.CestoAcai;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jairo Sousa
 */
public class ArmazenamentoDAOImpl extends GenericoDAOImpl<Armazenamento> implements ArmazenamentoDAO {

    private EntityManager em;
    private final GenericDAO<Armazenamento> dao = FabricaDAO.criarGenericDAO();

    public ArmazenamentoDAOImpl(EntityManager em) {
        this.em = em;
    }

    public ArmazenamentoDAOImpl() {
    }

    @Override
    public List<CestoAcai> obterCestoAcaiArmazenamento(Integer id) {
        List<CestoAcai> resposta = null;
        String query = "SELECT c FROM CestoAcai c, itens_armazenamento i, armazenamento a where"
                + " c.id=i.cesto_acai & i.armazenamento=" + id+" group by c.id";
        Query q = this.getEntityManager().createQuery(query);
        resposta = (List<CestoAcai>) q.getResultList();
        return resposta;
    }

}
