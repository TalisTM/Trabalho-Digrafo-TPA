package br.edu.ifes.si.tpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    
    private List<Integer> AlgoritmoMenorQtdArtigosLidos(Digrafo D, int artigoOrigem, int artigoDestino) {
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
        
        List<Integer> caminho = new ArrayList<Integer>();
        
        int proximoCaminho = artigoDestino;
        caminho.add(0, proximoCaminho);
        for(int i = 0; i < distanciaPara[artigoDestino]; i++) {
            proximoCaminho = arestaPara[proximoCaminho];
            caminho.add(0, proximoCaminho);

        }
        
        return caminho;
    }
    
    public void execute(Scanner scanner, Digrafo D) {
        int option;
        do {
            System.out.print("Vértice de origem: ");
            int origem = scanner.nextInt();
            
            System.out.print("Vértice de destino: ");
            int destino = scanner.nextInt();
            
            List<Integer> caminho = AlgoritmoMenorQtdArtigosLidos(D, origem, destino);
            
            System.out.printf("O menor caminho entre %d e %d é de (%d): ", origem, destino, distanciaPara[destino]);
        
            for(int c : caminho) {
               System.out.printf("%d->", c);
            }
        
//            System.out.println("-".repeat(50));
            System.out.println("\n--------------------------------");
            System.out.println("\n1 - Continuar\t\t\t0 - Voltar");
//            System.out.println("-".repeat(50));
            System.out.println("--------------------------------");
            System.out.print("Opção: ");
            option = scanner.nextInt();
        } while (option != 0);
    }
}
