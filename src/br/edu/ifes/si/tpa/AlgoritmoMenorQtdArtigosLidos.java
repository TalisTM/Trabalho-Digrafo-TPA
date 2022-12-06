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
    
    public void menorQuantidadeArtigosLidos(Digrafo D, int artigoOrigem, int artigoDestino) {
        marcado = new boolean[D.V()];
        arestaPara = new int[D.V()];
        distanciaPara = new int[D.V()];
        
        Fila<Integer> f = new Fila<Integer>();
        
        f.enfileira(artigoOrigem);
        marcado[artigoOrigem] = true;
        distanciaPara[artigoOrigem] = 0;
        while(!f.isEmpty()) {
            int v = f.desenfileira();
            
            for(Aresta a : D.adj(v)) {
                int x = a.getV2().getArtigo();
                if(!marcado[x]) {
                    arestaPara[x] = v;
                    distanciaPara[x] = distanciaPara[v] + 1;
                    marcado[x] = true;
                    f.enfileira(x);
                }
            }
        }
        
        System.out.printf("O menor caminho entre %d e %d é de (%d): ", artigoOrigem, artigoDestino, distanciaPara[artigoDestino]);
        
        int proximoCaminho = arestaPara[artigoDestino];
        System.out.printf("%d", proximoCaminho);
        for(int i = 0; i < distanciaPara[artigoDestino]; i++) {
            
            proximoCaminho = arestaPara[proximoCaminho];
            System.out.printf("->%d", proximoCaminho);
            
        }
    }
}
