/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jairo Sousa
 */
public class FabricaConexao {

    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("IucaraPU");

    public FabricaConexao() {
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
    
    public static void closeEntityManagerFactory() {

        if (fabrica != null) {
            fabrica.close();
        }
    }
    
}
