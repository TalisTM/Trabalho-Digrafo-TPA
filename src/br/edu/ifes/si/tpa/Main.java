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
//    public static void main(String[] args) {
//        In in = new In("digrafo1.txt");
//
//        Digrafo D = new Digrafo(in);
//
//
//        AlgoritmoMenorQtdArtigosLidos algoritmoMenorQtdArtigosLidos = new AlgoritmoMenorQtdArtigosLidos();
//
//        algoritmoMenorQtdArtigosLidos.menorQuantidadeArtigosLidos(D, 13, 1);
//
////        AlgoritmoTopArtigos.topArtigos(D);
//    }

    private static Digrafo D;

    public static void main(String[] args) {
        processDigraph(args);
        menu();
    }

    public static void processDigraph(String[] args) {
        In in = new In("digrafo1.txt");
        D = new Digrafo(in);
        //G = new Digrafo(in);
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
                exitMenu(scanner);
                break;
            case 1:
                // Algoritmo de Menor Caminho
                break;
            case 2:
                AlgoritmoTodosCaminhos.run(scanner, D);
                break;
            case 3:
                // Algoritmo de Top Artigos
                break;
            case 4:
                AlgoritmoTopAutores.run(scanner, D);
                break;
            default:
                invalidOptionMenu();
                break;
        }
    }

    public static void exitMenu(Scanner scanner) {
        System.out.println("-".repeat(50));
        System.out.println("Obrigado por utilizar o CACD!");
        System.out.println("-".repeat(50));
        try (scanner) {
            Thread.sleep(1250);
        } catch (Exception e) {
            System.out.println("Erro ao aguardar!");
        } finally {
        }
    }

    public static void invalidOptionMenu() {
        System.out.println("-".repeat(50));
        System.out.println("Opção inválida!");
        System.out.println("-".repeat(50));
        try {
            Thread.sleep(1250);
        } catch (Exception e) {
            System.out.println("Erro ao aguardar!");
        }
    }
}

//}
