/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.dao.service;

import br.com.ufra.entidades.Distribuidor;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public interface DistribuidorDAO extends GenericDAO<Distribuidor>{
    
    public List<Distribuidor> obterTodosOrdenado(String distribuidor);
    
    public Distribuidor obterNome(String nome);
    
}
