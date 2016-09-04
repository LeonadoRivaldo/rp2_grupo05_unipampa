package Repositorio.trabalho_1.palestra;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luh-l
 */
public class Executor {

    ControleDePalestras c = new ControleDePalestras();

    /**
     * Metodo para criar uma palestra
     *
     * @return retorno é um objeto palestra
     */
    public static Palestra criar() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Qual o titulo da sua Palestra: ");
        String tituloSubmissao;
        tituloSubmissao = (entrada.nextLine());
        Situacao situacao = null;
        do {
            System.out.println("Situacao da Palestra: Aprovado/Reprovado/SobAvaliacao");
            situacao = Submissao.verificaSituacao(entrada.nextLine());
        } while (situacao == null);
        System.out.println("Qual o nome do Autor: ");
        ArrayList<String> autores = new ArrayList();
        autores.add(entrada.nextLine());
        System.out.println("Escreva um resumo: ");
        String resumo;
        resumo = (entrada.nextLine());
        System.out.println("escreva seu abstract: ");
        String abstrac;
        abstrac = (entrada.nextLine());
        System.out.println("Digite seu curriculo: ");
        String curriculo;
        curriculo = (entrada.nextLine());
        System.out.println("Qual o tempo de duracao da palestra em minutos: ");
        int duracao;
        duracao = (entrada.nextInt());
        Palestra palestra = new Palestra(curriculo, resumo, abstrac, duracao, tituloSubmissao, situacao, autores, 1);
        return palestra;

    }

    /**
     * Metodo para consultar uma palestra
     */
    public static int consultarP(ControleDePalestras controle, String frase) {
        System.out.println("==================================");
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < controle.palestras.size(); i++) {
            System.out.println((i + 1) + "-" + controle.palestras.get(i).getTituloSubmissao());
        }
        System.out.println("----------------------------------");
        System.out.print(frase);
        return (entrada.nextInt() - 1);
    }

    public static int consultarAutor(ControleDePalestras controle, String frase, String autor) {
        System.out.println("==================================");
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < controle.palestras.size(); i++) {
            Palestra p = controle.palestras.get(i);
            for (int o = 0; o < p.getAutor().size(); o++) {
                if (autor.contains(p.getAutor().get(o))) {
                    System.out.println((i + 1) + "-" + controle.palestras.get(i).getTituloSubmissao());
                }
            }

        }
        System.out.println("----------------------------------");
        System.out.print(frase);
        return (entrada.nextInt() - 1);
    }

    /**
     * Metodo para exibir uma Palestra
     *
     * @param palestra
     */
    private static void exibir(Palestra palestra) {
        System.out.println("==================================");
        System.out.println("titulo: " + palestra.getTituloSubmissao());
        System.out.println("situacao: " + palestra.getSituacaoSubmissao());
        System.out.println("autor: " + palestra.getAutor().get(0));
        System.out.println("resumo: " + palestra.getResumo());
        System.out.println("Abstract: " + palestra.getAbstrac());
        System.out.println("duracao: " + palestra.getDuracao());
        System.out.println("curriculo: " + palestra.getCurriculo());
        System.out.println("==================================");
    }

    private static int editarpalestra(Palestra palestra) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("1-titulo: " + palestra.getTituloSubmissao());
        System.out.println("2-situacao: " + palestra.getSituacaoSubmissao());
        System.out.println("3-autor: " + palestra.getAutor().get(0));
        System.out.println("4-resumo: " + palestra.getResumo());
        System.out.println("5-Abstract: " + palestra.getAbstrac());
        System.out.println("6-duracao: " + palestra.getDuracao());
        System.out.println("7-curriculo: " + palestra.getCurriculo());
        System.out.println("==================================");
        return (entrada.nextInt());
    }

    public static String pegarvalor(int indice) {
        Scanner entrada = new Scanner(System.in);

        /* String titulo,
         String situacao,
         String autor, 
         String resumo,
         String Abstract,
         int duracao,
         String curriculo*/
        switch (indice) {
            case 1:
                System.out.println("Qual é o novo titulo: ");
                return entrada.nextLine();
            case 2:
                System.out.println("Situacao da Palestra: Aprovado/Reprovado/SobAvaliacao");
                return entrada.nextLine();
            case 3:
                System.out.println("Qual é o novo autor: ");
                return entrada.nextLine();
            case 4:
                System.out.println("Qual é o novo resumo: ");
                return entrada.nextLine();
            case 5:
                System.out.println("Qual é o novo Abstract: ");
                return entrada.nextLine();
            case 6:
                System.out.println("Qual é a nova duraçao: ");
                return entrada.nextLine();
            case 7:
                System.out.println("Qual é o novo curriculo: ");
                return entrada.nextLine();

        }
        return null;
    }

    public static void msg(String s) {
        System.out.println("\n=============================\n" + s + "\n=============================\n");
    }

    public void principal() {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> autores = new ArrayList();
        autores.add("Colega Amanda");
        c.incluir(new Palestra("CC", "doce", "jdhk", 35, "Palestra2", Situacao.sobAvaliacao, autores, 1));
        c.incluir(new Palestra("ES", "comida", "gfgjjk", 50, "Palestra1", Situacao.sobAvaliacao, autores, 1));

        int opcao = 0;
        do {
            System.out.println("################################");
            System.out.println("Gerenciamento de palestras");
            System.out.println("1- incluir");
            System.out.println("2- consultar");
            System.out.println("3- excluir");
            System.out.println("4- editar");
            System.out.println("0- sair");
            System.out.println("Opcao: ");
            opcao = entrada.nextInt();

            entrada.nextLine();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    c.incluir(criar());
                    msg("PALETRA INCLUIDA");
                    break;
                case 2:
                    /* System.out.println("Autor:");
                    String autor = entrada.nextLine();
                     */
                    exibir(c.consultar(consultarP(c, "Qual palestra voce quer visualizar: ")));
                    break;
                case 3:
                    c.excluir(consultarP(c, "Qual palestra voce quer excluir: "));
                    msg("PALESTRA EXCLUIDA");
                    break;
                case 4:
                    int indice = consultarP(c, "Qual palestra voce quer editar: ");
                    Palestra palestra = c.consultar(indice);
                    int atributo = editarpalestra(palestra);
                    c.editar(atributo, pegarvalor(atributo), palestra);
                    msg("PALESTRA EDITADA");
                    break;
            }

        } while (opcao != 0);

    }

    public static void main(String[] args) {
        Executor e = new Executor();
        e.principal();
    }
}
