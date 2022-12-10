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

    public static void execute(Scanner scanner, Digrafo D) {
        int option;
        do {
            System.out.println("Algoritmo Top Autores");
            System.out.println("-".repeat(50));

            Map<Integer, Integer> autoresPorQtdCitacoes  = new HashMap<>();

            for (int artigoLido = 0; artigoLido < D.V(); artigoLido++) {
                for (Aresta aresta : D.adj(artigoLido)) {
                    Vertice artigoCitado = aresta.getV2();
                    int autorCitado = D.vertices().get(artigoCitado.getArtigo()).getAutor();
                    if (!autoresPorQtdCitacoes.containsKey(autorCitado)) {
                        autoresPorQtdCitacoes.put(autorCitado, 1);
                    }
                    else {
                        int qtdCitacoes = autoresPorQtdCitacoes.get(autorCitado);
                        autoresPorQtdCitacoes.put(autorCitado, qtdCitacoes + 1);
                    }
                }
            }

            for (Map.Entry<Integer, Integer> autor : autoresPorQtdCitacoes.entrySet()) {
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
