/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.si.tpa;

import java.util.Scanner;

/**
 *
 * @author Talis
 */
public class AlgoritmoTopArtigos {
    
    public static void execute(Scanner scanner, Digrafo D) {
        int option;
        do {
            System.out.println("Algoritmo Top Artigos");
            System.out.println("--------------------------------");
            
            for(Vertice v : D.vertices()) {
                int qtdCaminho = 0;
                for(Aresta a : D.arestas()) {
                    if(a.getV2().equals(v)){
                        qtdCaminho++;
                    }
                }
                System.out.printf("%d: %d\n", v.getArtigo(), qtdCaminho);
            }

            System.out.println("--------------------------------");
            System.out.println("1 - Calcular Novamente\t\t0 - Voltar");
            System.out.println("--------------------------------");
            System.out.print("Opção: ");
            option = scanner.nextInt();
            
        } while (option != 0);
    }
}
