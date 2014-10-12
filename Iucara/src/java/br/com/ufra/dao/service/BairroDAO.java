/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao.service;

import br.com.ufra.entidades.Bairro;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public interface BairroDAO extends GenericDAO<Bairro> {

    public List<Bairro> obterTodosOrdenado(String bairro);
    
    public Bairro obterNome(String nome);

}
