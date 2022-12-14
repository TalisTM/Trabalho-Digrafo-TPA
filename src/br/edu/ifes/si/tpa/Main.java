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
public class Main {
    private static Digrafo D;

    public static void main(String[] args) {
        processDigraph(args);
        menu();
    }

    public static void processDigraph(String[] args) {
        System.out.println("\n--------------------------------");
        System.out.println("Digite o nome do arquivo txt: \nExemplo: digrafo1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------------");

        String arquivo = scanner.next();

        In in = new In("./_dados/" + arquivo + ".txt");
        D = new Digrafo(in);
    }

    public static void menu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Algoritmo de Menor Caminho");
            System.out.println("2 - Algoritmo de Todos os Caminhos");
            System.out.println("3 - Algoritmo de Top Artigos");
            System.out.println("4 - Algoritmo de Top Autores");
            System.out.println("0 - Sair");
            System.out.print("Digite uma opção: ");
            try {
                option = scanner.nextInt();
            }
            catch (Exception e) {
                option = -1;
            }
            finally {
                processOption(scanner, option);
            }
        } while (option != 0);
    }

    public static void processOption(Scanner scanner, int option) {
        switch (option) {
            case 0:
                System.out.println("Até breve...");
                break;
            case 1:
                AlgoritmoMenorQtdArtigosLidos algoritmoMenorQtdArtigosLidos = new AlgoritmoMenorQtdArtigosLidos();
                algoritmoMenorQtdArtigosLidos.execute(scanner, D);
                break;
            case 2:
                AlgoritmoTodosCaminhos.execute(scanner, D);
                break;
            case 3:
                AlgoritmoTopArtigos.execute(scanner, D);
                break;
            case 4:
                AlgoritmoTopAutores.execute(scanner, D);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
