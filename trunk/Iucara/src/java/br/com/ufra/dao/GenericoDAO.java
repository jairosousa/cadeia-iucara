/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jairo Sousa
 */
public class GenericoDAO<T> implements InterfaceDao<T> {

    private EntityManager em = FabricaConexao.obterFabrica().createEntityManager();

    public boolean iniciarTransacao() {
        try {
            if (em.getTransaction().isActive()) {
                return true;
            }
            em.getTransaction().begin();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean confirmarTransacao() {
        try {
            em.getTransaction().commit();
            return true;
        } catch (EntityExistsException e) {
            return false;
        }
    }

    public boolean desfazerTransacao() {
        try {
            em.getTransaction().rollback();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean criar(T o) {
        try {
            this.iniciarTransacao();
            em.persist(o);
            this.confirmarTransacao();
            return true;
        } catch (EntityExistsException e) {
            if (em.isOpen()) {
                this.desfazerTransacao();
            }
            return false;
        } catch (Exception e) {
            if (em.isOpen()) {
                this.desfazerTransacao();
            }
            return false;
        }
    }

    @Override
    public boolean atualizar(T o) {
        try {
            this.iniciarTransacao();
            em.merge(o);
            this.confirmarTransacao();
            return true;
        } catch (Exception e) {
            if (em.isOpen()) {
                this.desfazerTransacao();
            }
            return false;
        }
    }

    @Override
    public boolean excluir(T o) {
        try {
            this.iniciarTransacao();
            em.remove(o);
            this.confirmarTransacao();
            return true;
        } catch (Exception e) {
            if (em.isOpen()) {
                this.desfazerTransacao();
            }
            return false;
        }
    }

    @Override
    public T obter(Class<T> classe, Object id) {
        if (id == null) {
            return null;
        }
        String query = classe.getSimpleName() + ".findById";
        final Query q = em.createNamedQuery(query);
        try {
            return (T) q.setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<T> obterTodos(Class<T> classe) {
        String query = classe.getSimpleName() + ".findAll";
        Query q = em.createNamedQuery(query);
        return (List<T>) q.getResultList();
    }

}
