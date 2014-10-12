/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import br.com.ufra.dao.service.DistribuidorDAO;
import br.com.ufra.dao.service.GenericDAO;
import br.com.ufra.entidades.Distribuidor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jairo Sousa
 */
public class DistribuidorDAOImpl extends GenericoDAOImpl<Distribuidor> implements DistribuidorDAO {

    private EntityManager em;
    private final GenericDAO<Distribuidor> dao = FabricaDAO.criarGenericDAO();

    public DistribuidorDAOImpl(EntityManager em) {
        this.em = em;
    }

    public DistribuidorDAOImpl() {
    }

    @Override
    public List<Distribuidor> obterTodosOrdenado(String distribuidor) {
        List<Distribuidor> resposta = null;
        String query = "SELECT c FROM Distribuidor c ORDER BY c." + distribuidor;
        Query q = this.getEntityManager().createQuery(query);
        resposta = (List<Distribuidor>) q.getResultList();
        return resposta;
    }

    @Override
    public Distribuidor obterNome(String nome) {
        TypedQuery<Distribuidor> query = em.createNamedQuery("Distribuidor.findByNome", Distribuidor.class)
                .setParameter("nome", nome);
        return query.getSingleResult();
    }

}
