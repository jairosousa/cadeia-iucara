/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import br.com.ufra.dao.service.BatedorDAO;
import br.com.ufra.dao.service.GenericDAO;
import br.com.ufra.entidades.Batedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jairo Sousa
 */
public class BatedorDAOImpl extends GenericoDAOImpl<Batedor> implements BatedorDAO {

    private EntityManager em;
    private final GenericDAO<Batedor> dao = FabricaDAO.criarGenericDAO();

    public BatedorDAOImpl(EntityManager em) {
        this.em = em;
    }

    public BatedorDAOImpl() {
    }
    
    @Override
    public List<Batedor> obterTodosOrdenado(String batedor) {
        List<Batedor> resposta = null;
        String query = "SELECT c FROM Batedor c ORDER BY c." + batedor;
        Query q = this.getEntityManager().createQuery(query);
        resposta = (List<Batedor>) q.getResultList();
        return resposta;
    }

    @Override
    public Batedor obterNome(String nome) {
        TypedQuery<Batedor> query = em.createNamedQuery("Batedor.findByNome", Batedor.class)
                .setParameter("nome", nome);
        return query.getSingleResult();
    }

}
