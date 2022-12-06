/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.si.tpa;

/**
 *
 * @author Talis
 */
public class Main {
    public static void main(String[] args) {
        In in = new In("digrafo1.txt");
        
        Digrafo D = new Digrafo(in);
        
        
        AlgoritmoMenorQtdArtigosLidos algoritmoMenorQtdArtigosLidos = new AlgoritmoMenorQtdArtigosLidos();;;
        
        algoritmoMenorQtdArtigosLidos.menorQuantidadeArtigosLidos(D, 13, 1);
        
//        AlgoritmoTopArtigos.topArtigos(D);
    }
}
