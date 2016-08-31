/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias;

import java.util.Scanner;

/**
 *
 * @author leona_000
 */
public class PreencheMonografia {

    private static Scanner entrada = new Scanner(System.in);

    public static String preencheTitulo() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o titulo da sua monografia? ");
        return entrada.nextLine();
    }

    public static String preencheAutor() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o autor da sua monografia? ");
        return entrada.nextLine();
    }

    public static String preencheTipo() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o tipo da sua monografia: ");
        System.out.println("Graduação, Especialização, Mestrado, Doutorado");
        System.out.print("Digite: ");
        return entrada.nextLine();
    }

    public static String preencheInstituicao() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o nome da sua instituição? ");
        return entrada.nextLine();
    }

    public static String preencheOrientador() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o nome do seu orientador? ");
        return entrada.nextLine();
    }

    public static String preencheCurso() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o nome do seu curso? ");
        return entrada.nextLine();
    }

    public static String preencheAno() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o Ano da publicação? ");
        return entrada.nextLine();
    }

    public static String preencheNroPaginas() {
        System.out.println("----------------------------------------------------");
        System.out.println("Quantidade de paginas?");
        return entrada.nextLine();
    }

    public static String[] preenchePalavrasChaves() {
        System.out.println("----------------------------------------------------");
        System.out.println("Quantidade de palavras chaves? 1 até 4");
        int x = entrada.nextInt();
        entrada.nextLine();
        String[] palavras = new String[x];
        for (int i = 0; i < x; i++) {
            System.out.printf("Digite a %dº palavra-chave: ", (i + 1));
            palavras[i] = entrada.nextLine();
            System.out.println("*************************************");
        }
        return palavras;
    }

    public static String preencheResumo() {
        System.out.println("----------------------------------------------------");
        System.out.println("Digite o resumo da sua monografia?");
        return entrada.nextLine();
    }

    public static String preencheAbstract() {
        System.out.println("----------------------------------------------------");
        System.out.println("Digite o abstract da sua monografia?");
        return entrada.nextLine();
    }

}
