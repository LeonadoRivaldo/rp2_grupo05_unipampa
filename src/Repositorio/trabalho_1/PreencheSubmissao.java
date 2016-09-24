/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leona_000
 */
public class PreencheSubmissao {

    private static Scanner entrada = new Scanner(System.in);

    public static String preencheSituacao() {
        System.out.println("----------------------------------------------------");
        System.out.println("Informe a situação da monografia : Aprovado/Reprovado/SobAvaliação");
        return entrada.nextLine();
    }

    public static String preencheTitulo() {
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o titulo da sua monografia? ");
        return entrada.nextLine();
    }

    public static List<String> preencheAutor() {
        List<String> autor = new ArrayList();
        System.out.println("----------------------------------------------------");
        System.out.println("Qual é o autor da sua monografia? ");
        autor.add(entrada.nextLine());
        return autor;
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

    public static List<String> preenchePalavrasChaves() {
        System.out.println("----------------------------------------------------");
        List<String> palavras = new ArrayList();
        boolean parar = false;
        int x = 0;
        for (x = 0; x < 4; x++) {
            System.out.printf("Digite a palavra-chave: ");
            String palavra = entrada.nextLine();
            if (!palavra.equalsIgnoreCase("sair") && x < 4) {
                System.out.println("========== (digite sair para parar) ==========");
                palavras.add(palavra);
            } else {
                break;
            }
        }
        if ( x >= 4) {
            System.out.println("nº limite de palavras chave foi atingido!");
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
