package br.edu.ifes.si.tpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Talis
 */
public class AlgoritmoMenorQtdArtigosLidos {
    private boolean[] marcado;
    private int[] arestaPara;
    private int[] distanciaPara;
    
    private void menorQuantidadeArtigosLidos(Digrafo D, Vertice artigoOrigem, Vertice artigoDestino) {
        Fila<Vertice> f = new Fila<Vertice>();
        
        f.enfileira(artigoOrigem);
        marcado[artigoOrigem.getArtigo()] = true;
        distanciaPara[artigoOrigem.getArtigo()] = 0;
        
        while(!f.isEmpty()) {
            Vertice v = f.desenfileira();
            
            for(Aresta a : D.adj(v.getArtigo())) {
                Vertice x = a.getV2();
                if(!marcado[x.getArtigo()]) {
                    arestaPara[x.getArtigo()] = v.getArtigo();
                    distanciaPara[x.getArtigo()] = distanciaPara[v.getArtigo()] + 1;
                    marcado[x.getArtigo()] = true;
                    f.enfileira(x);
                }
            }
        }
        
        System.out.printf("O menor caminho entre %d e %d é de (%d): ", artigoOrigem.getArtigo(), artigoDestino.getArtigo(), distanciaPara[artigoDestino.getArtigo()]);
        
        int proximoCaminho = arestaPara[artigoDestino.getArtigo()];
        System.out.printf("%d", proximoCaminho);
        for(int i = 0; i < distanciaPara[artigoDestino.getArtigo()]; i++) {
            
            proximoCaminho = arestaPara[proximoCaminho];
            System.out.printf("->%d", proximoCaminho);
            
        }
    }
}
