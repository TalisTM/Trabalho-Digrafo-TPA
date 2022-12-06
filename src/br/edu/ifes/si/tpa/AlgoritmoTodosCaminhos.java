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
    private Pilha<Vertice> caminho;
    private static int qtdCaminhos;

    public AlgoritmoTodosCaminhos(Digrafo G, Vertice artigoOrigem, Vertice artigoDestino) {
        noCaminho = new boolean[G.V()];
        caminho = new Pilha<Vertice>();
        qtdCaminhos = 0;
        dfs(G, artigoOrigem, artigoDestino);
    }

    public void dfs(Digrafo G, Vertice artigoOrigem, Vertice artigoDestino) {
        caminho.empilha(artigoOrigem);
        noCaminho[artigoOrigem.getArtigo()] = true;
        if (artigoOrigem.getArtigo() == artigoDestino.getArtigo()) {
            imprimeCaminhoAtual();
            qtdCaminhos++;
        }
        else {
            for (Aresta a : G.adj(artigoOrigem.getArtigo())) {
                Vertice x = a.getV2();
                if (!noCaminho[x.getArtigo()]) {
                    dfs(G, x, artigoDestino);
                }
            }
        }
        caminho.desempilha();
        noCaminho[artigoOrigem.getArtigo()] = false;
    }

    public void imprimeCaminhoAtual() {
        Pilha<Vertice> pilhaInvertida = new Pilha<>();
        for (Vertice v : caminho) {
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

    public static void run(Scanner scanner, Digrafo G) {
        int option;
        do {
            System.out.print("Digite o vértice de origem: ");
            int origem = scanner.nextInt();
            
            Vertice artigoOrigem = null;
            artigoOrigem.setArtigo(origem);

            System.out.print("Digite o vértice de destino: ");
            int destino = scanner.nextInt();

            Vertice artigoDestino = null;
            artigoOrigem.setArtigo(destino);

            System.out.printf("\nb) Todos os caminhos entre %d e %d\n", artigoOrigem.getArtigo(), artigoDestino.getArtigo());

            AlgoritmoTodosCaminhos todosCaminhos = new AlgoritmoTodosCaminhos(G, artigoOrigem, artigoDestino);

            System.out.println("_".repeat(50));
            System.out.printf("# Caminhos  = %d\n", qtdCaminhos);
            System.out.println("-".repeat(50));
            System.out.println("\n1 - Continuar\t\t\t0 - Voltar");
            System.out.println("-".repeat(50));
            System.out.print("Opção: ");
            option = scanner.nextInt();
        } while (option != 0);
    }

}

