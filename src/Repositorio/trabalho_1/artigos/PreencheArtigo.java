/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;

import java.util.Scanner;

/**
 *
 * @author Amanda Gobus
 */
public class PreencheArtigo {

    private static Scanner entrada = new Scanner(System.in);

    public static String preencheTitulo() {
        System.out.println("Informe o titulo do artigo: ");
        return entrada.nextLine();
    }

    public static String[] preencheAutor() {
        System.out.println("Informe o número de autores:");
        int n = entrada.nextInt();
        entrada.nextLine();
        String[] autor = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Digite o autor :" + (i + 1));
            autor[i] = entrada.nextLine();
            System.out.println("=======================================");
        }
        return autor;
    }

    public static String[] preencheInstituicao() {
        System.out.println("Informe o número de instituições:");//adicionar até 8 instituições
        int n = entrada.nextInt();
        entrada.nextLine();
        String[] inst = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Digite a Instituição :" + (i + 1));
            inst[i] = entrada.nextLine();
            System.out.println("=======================================");
        }
        return inst;
    }

    public static String preencheResumo() {
        System.out.println("Digite o resumo do artigo: ");
        return (entrada.nextLine());
    }

    public static String preencheAbstract() {
        System.out.println("Digite o Abstract: ");
        return (entrada.nextLine());
    }

    public static String[] preenchePalavrachave() {
        System.out.println("Informe o número de palavras chave do artigo: ");// adicionar até 4 palavras
        int n = entrada.nextInt();
        entrada.nextLine();
        String[] palavras = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Digite a Palavra-Chave :" + (i + 1));
            palavras[i] = entrada.nextLine();
            System.out.println("=======================================");
        }
        return (palavras);
    }

}
