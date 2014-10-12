/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufra.dao.testaBanco;

import br.com.ufra.entidades.Bairro;
import br.com.ufra.rn.BairroRN;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo Sousa
 */
public class testaInserirComerciante {

    public static void main(String[] args) {

        Bairro bairro = new Bairro();
        
        BairroRN rn = new BairroRN();
        
        List<Bairro> bairros = new ArrayList<>();
        
        bairros = rn.obterTodosOrdenado();
        
        for (Bairro b : bairros) {
            System.out.println(b.getNome()+"\n");
        }
        
        
        
//        rnA.excluir(a);
//
//        System.out.println(a.getId() + " , " + a.getNome());

//        BatedorRN rnB = new BatedorRN();
//        Batedor b = rnB.obter(1);
//        System.out.println(b.getId() + " , " + b.getNome());

//        CestoAcaiRN rnC = new CestoAcaiRN();
//        CestoAcai ca = rnC.obter(1);
//        System.out.println(ca.getId() + " , " + ca.getQuantidade());
        
//        Compra c = new Compra();

//        c.setData(Calendar.getInstance());
//        c.setQuantidade(18);
//        c.setAtravessador(a);
//        c.setBatedor(b);
//        c.setCestoAcai(ca);

//        CompraRN cRN = new CompraRN();
//        Compra c = cRN.obter(2);
//        
//        CategoriaRN catRN = new CategoriaRN();
//        Categoria cat = catRN.obter(2);
//        
//        Processamento proc = new Processamento();
//        ProcessamentoRN procRN = new ProcessamentoRN();
//        proc.setBatedor(b);
//        proc.setCategoria(cat);
//        proc.setCompra(c);
//        proc.setData(Calendar.getInstance());
//        proc.setQuantidade(10);
//        
//        procRN.salvar(proc);
        
//        ProcessamentoRN procRN = new ProcessamentoRN();
//        Processamento proc = procRN.obter(1);
//        
//        Produto p = new Produto();
//        p.setQuantidade(10);
//        p.setProcessar(proc);
//        
//        ProdutoRN pRN = new ProdutoRN();
//        pRN.salvar(p);
    }

}
