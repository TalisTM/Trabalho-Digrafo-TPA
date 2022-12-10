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
public class AlgoritmoTodosCaminhos {
    private boolean[] noCaminho;
    private Pilha<Integer> caminho;
    private static int qtdCaminhos;

    public AlgoritmoTodosCaminhos(Digrafo G, Integer artigoOrigem, Integer artigoDestino) {
        noCaminho = new boolean[G.V()];
        caminho = new Pilha<Integer>();
        qtdCaminhos = 0;
        dfs(G, artigoOrigem, artigoDestino);
    }

    public void dfs(Digrafo D, int artigoOrigem, int artigoDestino) {
        caminho.empilha(artigoOrigem);
        noCaminho[artigoOrigem] = true;
        if (artigoOrigem == artigoDestino) {
            imprimeCaminhoAtual();
            qtdCaminhos++;
        }
        else {
            for (Aresta a : D.adj(artigoOrigem)) {
                Vertice x = a.getV2();
                if (!noCaminho[x.getArtigo()]) {
                    dfs(D, x.getArtigo(), artigoDestino);
                }
            }
        }
        caminho.desempilha();
        noCaminho[artigoOrigem] = false;
    }

    public void imprimeCaminhoAtual() {
        Pilha<Integer> pilhaInvertida = new Pilha<>();
        for (Integer v : caminho) {
            pilhaInvertida.empilha(v);
        }
        if (pilhaInvertida.tamanho() >= 1) {
            System.out.print(pilhaInvertida.desempilha());
        }
        while (!pilhaInvertida.isEmpty()) {
            System.out.print("->" + pilhaInvertida.desempilha());
        }
        System.out.println();
    }

    public static void execute(Scanner scanner, Digrafo D) {
        int option;
        do {
            System.out.print("Vértice de origem: ");
            int origem = scanner.nextInt();

            System.out.print("Vértice de destino: ");
            int destino = scanner.nextInt();

            System.out.printf("\nTodos os caminhos simples entre %d e %d\n", origem, destino);

            AlgoritmoTodosCaminhos todosCaminhos = new AlgoritmoTodosCaminhos(D, origem, destino);

            System.out.println("--------------------------------");
            System.out.printf("# Caminhos  = %d\n", qtdCaminhos);
            System.out.println("--------------------------------");
            System.out.println("\n1 - Continuar\t\t\t0 - Voltar");
            System.out.println("--------------------------------");
            System.out.print("Opção: ");
            option = scanner.nextInt();
        } while (option != 0);
    }

}

