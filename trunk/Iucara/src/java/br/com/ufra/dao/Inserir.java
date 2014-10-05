/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao;

import br.com.ufra.entidades.Bairro;
import br.com.ufra.entidades.Batedor;
import br.com.ufra.rn.BairroRN;
import br.com.ufra.rn.BatedorRN;

/**
 *
 * @author Jairo Sousa
 */
public class Inserir {
    
    public static void main(String[] args) {

        Batedor a = new Batedor();
        
        BairroRN rnba = new BairroRN();
        
        Bairro bairro = rnba.obter(1);
        
        a.setNome("Sergio Valente");
        a.setEndereco("Rua 8 das Anfrafas, 1030 Icoaraci");
        a.setEmail("sergio@email.com");
        a.setTelefone("9127-4593");
        a.setLoggin("sergio");
        a.setSenha("12345");
        a.setBairro(bairro);
//        
//        AtravessadorRN rnA = new AtravessadorRN();
//        rnA.salvar(a);
//        
//        Batedor b = new Batedor();
//        b.setNome("João");
//        b.setEndereco("Rua das Mangueiras, 30, Outeiro");
//        b.setEmail("joao@email.com");
//        b.setTelefone("8922-6726");
//        
        BatedorRN rnB = new BatedorRN();
        rnB.salvar(a);
//        CestoAcai ca1 = new CestoAcai();
//        ca1.setOrigem("Ilha do Caratateua");
//        ca1.setQuantidade(50.00);
//        CestoAcai ca2 = new CestoAcai();
//        ca2.setOrigem("Ilha do Cumbú");
//        ca2.setQuantidade(50.00);
//        CestoAcaiRN rnCA = new CestoAcaiRN();
//        rnCA.salvar(ca1);
//        Categoria cat = new Categoria();
//        cat.setNome("Fino");
//        
//        CategoriaRN catRN = new CategoriaRN();
//        catRN.salvar(cat);
//        Bairro bairro = new Bairro();
//        bairro.setNome("Marambaia");
//        
//        BairroRN rn = new BairroRN();
//        rn.salvar(bairro);
    }
    
}
