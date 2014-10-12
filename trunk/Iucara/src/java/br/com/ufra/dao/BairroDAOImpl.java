/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import br.com.ufra.dao.service.GenericDAO;
import br.com.ufra.dao.service.BairroDAO;
import br.com.ufra.entidades.Bairro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jairo Sousa
 */
public class BairroDAOImpl extends GenericoDAOImpl<Bairro> implements BairroDAO {

    private EntityManager em;
    private final GenericDAO<Bairro> dao = FabricaDAO.criarGenericDAO();

    public BairroDAOImpl(EntityManager em) {
        this.em = em;
    }

    public BairroDAOImpl() {
    }

    @Override
    public List<Bairro> obterTodosOrdenado(String bairro) {
        List<Bairro> resposta = null;
        String query = "SELECT c FROM Bairro c ORDER BY c." + bairro;
        Query q = this.getEntityManager().createQuery(query);
        resposta = (List<Bairro>) q.getResultList();
        return resposta;
    }
    
    public Bairro obterNome(String nome) {
        TypedQuery<Bairro> query = em.createNamedQuery("Bairro.findByNome", Bairro.class)
                .setParameter("nome", nome);
        return query.getSingleResult();
    }

}
