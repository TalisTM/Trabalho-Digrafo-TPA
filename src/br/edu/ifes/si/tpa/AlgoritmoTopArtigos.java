/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.si.tpa;

/**
 *
 * @author Talis
 */
public class AlgoritmoTopArtigos {
    private void topArtigos(Digrafo D) {
        System.out.println("Top artigos");
        for(Vertice v : D.vertices()) {
            int qtdCaminho = 0;
            for(Aresta a : D.arestas()) {
                if(a.getV2().equals(v)){
                    qtdCaminho++;
                }
            }
            System.out.printf("%d: %d", v.getArtigo(), qtdCaminho);
        }
    }
}
