/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.dao.service;

import br.com.ufra.entidades.Batedor;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public interface BatedorDAO extends GenericDAO<Batedor>{
    
    public List<Batedor> obterTodosOrdenado(String bairro);
    
    public Batedor obterNome(String nome);
    
}
