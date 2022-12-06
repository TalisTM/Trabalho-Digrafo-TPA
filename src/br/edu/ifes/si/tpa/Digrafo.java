/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.si.tpa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Talis
 */

/**
 * Esta classe implementa a representação do dígrafo com lista de adjacências.
 * Para documentação adicional, acesse:
 * <a href="http://algs4.cs.princeton.edu/42digraph">Section 4.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Digrafo {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;         // número de vértices no dígrafo
    private int A;               // número de arestas no dígrafo
    private List<Aresta>[] adj;  // adj[v1] = lista de adjacência do vértice v1
    private List<Vertice> listVertice;  // list com os vértices do grafo
    
    /**
     * Inicializa um dígrafo com V vertices e 0 arestas.
     * @param  V o número de vértices
     * @throws IllegalArgumentException se V < 0
     */
    public Digrafo(int V) {
        if (V < 0) throw new IllegalArgumentException("Número de vértices no dígrafo deve ser não negativo");
        this.V = V;
        this.A = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }


    /**  
     * Inicializa um dígrafo à partir de um arquivo de dados.
     * O formato é o número de vértices V e o número de arestas A
     * seguido por pares de pares de vértices.
     * @param  in o arquivo de entrada de dados
     * @throws IndexOutOfBoundsException se os pontos finais de qualquer borda estão fora da área prescrita
     * @throws IllegalArgumentException se o número de vértices ou arestas for negativo
     */
    public Digrafo(In in) {
        this.listVertice = new ArrayList<>();
        
        this.V = in.readInt();
        this.A = in.readInt();
        
        this.adj = new ArrayList[this.V];
        
        if (this.V < 0) {
            throw new IllegalArgumentException("Número de Vértices deve ser não negativo");
        }
        
        for (int v = 0; v < this.V; v++) {
            this.adj[v] = new ArrayList<>();
        }
        
        Vertice novoVertice;
        int artigo = 0, autor = 0;
        
        for (int i = 0; i < this.V; i++) {
            artigo = in.readInt();
            autor = in.readInt();
            novoVertice = new Vertice(artigo, autor);
            this.listVertice.add(novoVertice);
        }
        
        if (this.A < 0) {
            throw new IllegalArgumentException("Número de arestas deve ser não negativo");
        }
        for (int i = 0; i < A; i++) {
            int v1 = in.readInt();
            int v2 = in.readInt();
            Vertice vertice1 = this.listVertice.get(v1);
            Vertice vertice2 = this.listVertice.get(v2);
            if (v1 < 0 || v1 >= V) throw new IndexOutOfBoundsException("vértice " + vertice1 + " não está entre 0 e " + (V-1));;;
            if (v2 < 0 || v2 >= V) throw new IndexOutOfBoundsException("vértice " + vertice2 + " não está entre 0 e " + (V-1));
            addAresta(new Aresta(vertice1, vertice2));
        }
    }

    /**
     * Retorna o número de vértices do dígrafo.
     * @return o número de vértices do dígrafo
     */
    public int V() {
        return V;
    }

    /**
     * Retorna o número de arestas do dígrafo.
     * @return o número de arestas do dígrafo
     */
    public int A() {
        return A;
    }

    /**
     * Valida vértice do dígrafo.
     * @throws IndexOutOfBoundsException caso v não seja 0 <= v < V
     */
    private void validaVertice(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vértice " + v + " não está entre 0 e " + (V-1));
    }

    /**
     * Adiciona aresta direcionada a no dígrafo.
     * @param  a a aresta
     * @throws IndexOutOfBoundsException caso extremidades não estejam entre 0 e V-1
     */
    public void addAresta(Aresta a) {
        Vertice v1 = a.umVertice();
//        Vertice v2 = a.outroVertice(v1);
        ///validaVertice(v1.getArtigo());
        ///validaVertice(v2.getArtigo());
        adj[v1.getAutor()].add(0, a);
//        Aresta a2 = new Aresta(a.getV1(), a.getV2());;
//        adj[v2.getAutor()].add(0, a2);
    }


    /**
     * Retorna as arestas incidentes no vértice v1.
     * @param  v o vértice
     * @return as arestas incidentes no vértice v1 como um Iterable
     * @throws IndexOutOfBoundsException caso v não seja 0 <= v < V
     */
    public List<Aresta> adj(int v) {
        //validaVertice(v);
        System.out.printf("%d\n", adj[v]);
        return adj[v];
    }

    /**
     * Retorna todas as arestas neste dígrafo.
     * @return todas as arestas neste dígrafo, como um Iterable
     */
    public List<Aresta> arestas() {
        List<Aresta> lista = new ArrayList();
        for (int v = 0; v < V; v++) {
            for (Aresta a : adj(v)) {
                lista.add(a);
            }
        }
        return lista;
    }
    
    public List<Vertice> vertices() {
        return listVertice;
    }

    /**
     * Retorna uma representação String deste dígrafo.
     * @return uma representação String deste dígrafo
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + A + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Aresta a : adj[v]) {
                s.append(a + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    /**
     * Testa a classe Digrafo.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digrafo G = new Digrafo(in);
        System.out.println(G);
    }

}
