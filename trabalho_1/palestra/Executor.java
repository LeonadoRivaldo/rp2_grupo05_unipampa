package Repositorio.trabalho_1.palestra;

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
        Palestra palestra = new Palestra();
        System.out.println("Qual o titulo da sua Palestra: ");
        palestra.setTitulo(entrada.nextLine());
        System.out.println("Qual o nome do Autor: ");
        palestra.setAutor(entrada.nextLine());
        System.out.println("Escreva um resumo: ");
        palestra.setResumo(entrada.nextLine());
        System.out.println("escreva seu abstract: ");
        palestra.setabstract(entrada.nextLine());
        System.out.println("Digite seu curriculo: ");
        palestra.setCurriculo(entrada.nextLine());
        System.out.println("Qual o tempo de duracao da palestra em minutos: ");
        palestra.setDuracao(entrada.nextInt());
        return palestra;

    }

    /**
     * Metodo para consultar uma palestra
     */
    public static int consultarP(ControleDePalestras controle, String frase) {
        System.out.println("==================================");
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < controle.palestras.size(); i++) {
            System.out.println((i + 1) + "-" + controle.palestras.get(i).getTitulo());
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
        System.out.println("titulo: " + palestra.getTitulo());
        System.out.println("autor: " + palestra.getAutor());
        System.out.println("resumo: " + palestra.getResumo());
        System.out.println("Abstract: " + palestra.getabstract());
        System.out.println("duracao: " + palestra.getDuracao());
        System.out.println("curriculo: " + palestra.getCurriculo());
        System.out.println("==================================");
    }

    private static int editarpalestra(Palestra palestra) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("1-titulo: " + palestra.getTitulo());
        System.out.println("2-autor: " + palestra.getAutor());
        System.out.println("3-resumo: " + palestra.getResumo());
        System.out.println("4-Abstract: " + palestra.getabstract());
        System.out.println("5-duracao: " + palestra.getDuracao());
        System.out.println("6-curriculo: " + palestra.getCurriculo());
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
                System.out.println("Qual é o novo autor: ");
                return entrada.nextLine();
            case 3:
                System.out.println("Qual é o novo resumo: ");
                return entrada.nextLine();
            case 4:
                System.out.println("Qual é o novo Abstract: ");
                return entrada.nextLine();
            case 5:
                System.out.println("Qual é a nova duraçao: ");
                return entrada.nextLine();
            case 6:
                System.out.println("Qual é o novo curriculo: ");
                return entrada.nextLine();

        }
        return null;
    }

    public void menu() {
        Scanner entrada = new Scanner(System.in);
        c.incluir(new Palestra("arroz", "lucielee", "alheejds", "lalala", 46, "ES"));
        c.incluir(new Palestra("batata", "frita", "hahaha", "hyshys", 37, "es"));

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

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    c.incluir(criar());
                    break;
                case 2:
                    exibir(c.consultar(consultarP(c, "Qual palestra voce quer visualizar: ")));
                    break;
                case 3:
                    c.excluir(consultarP(c, "Qual palestra voce quer excluir: "));
                    break;
                case 4:
                    int indice = consultarP(c, "Qual palestra voce quer editar: ");
                    Palestra palestra = c.consultar(indice);
                    int atributo = editarpalestra(palestra);
                    c.editar(atributo, pegarvalor(atributo), palestra);
                    break;
            }

        } while (opcao != 0);

    }

    /* public static void main(String[] args) {
     menu();
     }*/
}
