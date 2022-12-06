/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.si.tpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Talis
 */
public class AlgoritmoTopAutores {

    public static void run(Scanner scanner, Digrafo G) {
        int option;
        do {
            System.out.println("d) Top Autores");
            System.out.println("-".repeat(50));

            Map<Vertice, Integer> autoresPorQtdCitacoes = new HashMap<>();

            for (int artigoLido = 0; artigoLido < G.V(); artigoLido++) {
                for (Aresta aresta : G.adj(artigoLido)) {
                    Vertice artigoCitado = aresta.getV2();
                    Vertice autorCitado = G.vertices().get(artigoCitado.getArtigo());
                    if (!autoresPorQtdCitacoes.containsKey(autorCitado)) {
                        autoresPorQtdCitacoes.put(artigoCitado, 1);
                    } else {
                        int qtdCitacoes = autoresPorQtdCitacoes.get(autorCitado);
                        autoresPorQtdCitacoes.put(artigoCitado, qtdCitacoes + 1);
                    }
                }
            }
            for (Map.Entry<Vertice, Integer> autor : autoresPorQtdCitacoes.entrySet()) {
                System.out.println(autor.getKey() + " : " + autor.getValue());
            }

            System.out.println("-".repeat(50));
            System.out.println("1 - Calcular Novamente\t\t0 - Voltar");
            System.out.println("-".repeat(50));
            System.out.print("Opção: ");
            option = scanner.nextInt();
        } while (option != 0);
    }

}
