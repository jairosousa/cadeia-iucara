/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import br.com.ufra.dao.service.ArmazenamentoDAO;
import br.com.ufra.dao.service.BairroDAO;
import br.com.ufra.dao.service.BatedorDAO;
import br.com.ufra.dao.service.DistribuidorDAO;
import br.com.ufra.dao.service.GenericDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jairo Sousa
 */
public class FabricaDAO {

    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("IucaraPU");

    public FabricaDAO() {
    }

    public static EntityManagerFactory obterFabrica() {
        return fabrica;
    }

    public static EntityManagerFactory obterFabrica(String unidadePersistencia) {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
        fabrica = Persistence.createEntityManagerFactory(unidadePersistencia);
        return fabrica;
    }

    public static EntityManager criarEntityManager() {
        return fabrica.createEntityManager();
    }

    public static GenericDAO criarGenericDAO() {
        return new GenericoDAOImpl(fabrica.createEntityManager());
    }

    //Criar os Metodos DAO das classe que serão implementadas.
    public static BairroDAO criarBairroDAO() {
        return new BairroDAOImpl(fabrica.createEntityManager());
    }
    public static BatedorDAO criarBatedorDAO() {
        return new BatedorDAOImpl(fabrica.createEntityManager());
    }
    public static DistribuidorDAO criarDistribuidorDAO() {
        return new DistribuidorDAOImpl(fabrica.createEntityManager());
    }
    public static ArmazenamentoDAO criarArmazenamentoDAO() {
        return new ArmazenamentoDAOImpl(fabrica.createEntityManager());
    }

}
