/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufra.dao.service;

import br.com.ufra.entidades.Armazenamento;
import br.com.ufra.entidades.CestoAcai;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public interface ArmazenamentoDAO extends GenericDAO<Armazenamento>{
    
    public List<CestoAcai> obterCestoAcaiArmazenamento(Integer arm);
}
