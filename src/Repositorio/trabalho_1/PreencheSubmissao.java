/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

import java.util.ArrayList;
import java.util.List;
import static Repositorio.trabalho_1.EntradasTeclado.*;

/**
 *
 * @author leona_000
 */
public class PreencheSubmissao {

    public static String preencheSituacao() {
        int nSituacao = 0;

        EntradasTeclado.div();
        while (nSituacao < 1 || nSituacao > 3) {
            nSituacao = EntradasTeclado.inInt("Digite a situação da submissao:"
                    + "\n 1 - Sob Avaliação"
                    + "\n 2 - Aprovado"
                    + "\n 3 - Não aprovado");
        }
        String pSituacao = situacaoToString(nSituacao);
        return pSituacao;
    }

    public static String preencheTitulo() {
        div();
        System.out.println();
        return inString("Qual é o titulo da sua submissao? ");
    }

    public static List<String> preencheAutor(int nroAutores) {
        List<String> autores = new ArrayList();
        div();
        for (int i = 0; i < nroAutores; i++) {
            autores.add(inString("Digite o nome do autor " + (i + 1) + ": "));
        }
        return autores;
    }

    public static String preencheTipo() {
        div();
        return inString("Qual é o tipo da sua submissao:"
                + "\nGraduação, Especialização, Mestrado, Doutorado"
                + "\nDigite:");
    }

    public static String preencheInstituicao() {
        div();
        return inString("Qual é o nome da sua instituição? ");
    }

    public static String preencheOrientador() {
        div();
        return inString("Qual é o nome do seu orientador? ");
    }

    public static String preencheCurso() {
        div();
        return inString("Qual é o nome do seu curso? ");
    }

    public static int preencheAno() {
        div();
        return inInt("Qual é o Ano da publicação? ");
    }

    public static int preencheNroPaginas() {
        div();
        System.out.println("Quantidade de paginas?");
        return inInt("Quantidade de paginas?");
    }

    public static List<String> preenchePalavrasChaves() {
        div();
        List<String> palavras = new ArrayList();
        boolean parar = false;
        int x = 0;
        for (x = 0; x < 4; x++) {
            String palavra = inString("Digite a palavra-chave: ");
            if (!palavra.equalsIgnoreCase("sair") && x < 4) {
                System.out.println("========== (digite sair para parar) ==========");
                palavras.add(palavra);
            } else {
                break;
            }
        }
        if (x >= 4) {
            System.out.println("nº limite de palavras chave foi atingido!");
        }
        return palavras;
    }

    public static String preencheResumo() {
        div();
        return inString("Qual o resumo da sua submissao?");
    }

    public static String preencheAbstract() {
        div();
        return inString("Qual o abstract da sua submissao?");
    }

    /**
     *
     * @return String contendo o que foi inserido pelo usuario
     */
    public static String preencheMetodologia() {
        div();
        return EntradasTeclado.inString("Qual a metodologia da sua submissao? ");
    }

    /**
     *
     * @return String contendo o que foi inserido pelo usuario
     */
    public static String preencheRecursos() {
        div();
        return EntradasTeclado.inString("Quais são os recursos da sua submissao?");
    }

    /**
     *
     * @return int contendo o que foi inserido pelo usuario, transformando o
     * total em MINUTOS Ex: caso o usuario insira 1:30, o metodo retornara 90
     */
    public static int preencheDuracao() {
        int h = -1, m = -1;
        div();
        System.out.println("Digite a duração a seguir, seguindo conforme exigido:");
        while (h < 0 || h > 24) {
            h = inInt("Digite o numero de horas:");
        }
        while (m < 0 || m > 60) {
            m = inInt("Digite os minutos:");
        }
        return h * 60 + m;
    }

    public static String situacaoToString(int situacao) {
        String pSituacao;
        switch (situacao) {
            case 1:
                pSituacao = "sob avaliacao";
                break;
            case 2:
                pSituacao = "aprovado";
                break;
            case 3:
                pSituacao = "reprovado";
                break;
            default:
                pSituacao = "sob avaliacao";
        }
        return pSituacao;
    }

}
