package Repositorio.trabalho_1.palestra;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.List;
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
     * Metodo para criar uma palestra Onde uma mensagem é mostrada ao usuario e
     * ele escreve a entrada do valor desejado.
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
     * Metodo para consultar uma palestra, onde é percorrido o tamanho da lista
     * e depois mostra a lista de palestras pelo titulo.
     *
     *
     *
     * public static int consultarP(ControleDePalestras controle, String frase)
     * { System.out.println("=================================="); Scanner
     * entrada = new Scanner(System.in); for (int i = 0; i <
     * controle.palestras.size(); i++) { System.out.println((i + 1) + "-" +
     * controle.palestras.get(i).getTituloSubmissao()); }
     * System.out.println("----------------------------------");
     * System.out.print(frase); return (entrada.nextInt() - 1); }
     */
    public static void consultarAutor(String frase, ControleDePalestras c) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o autor que você quer pesquisar: ");
        List<Submissao> lista = c.consultarAutor(entrada.nextLine());
        if(lista != null){
        System.out.println("==================================");
        for (int i = 0; i < lista.size(); i++) {
            Palestra p = (Palestra) lista.get(i);
            System.out.println((i + 1) + "-" + p.getTituloSubmissao());
        }
        System.out.println("----------------------------------");
        System.out.print(frase);
        Palestra pa = c.consultar(entrada.nextLine());
        if(pa != null){
        exibir(pa);
        }else{
            msg("NAO FOI ENCONRADA A PALESTRA");
        }
        }else{
            msg("AUTOR NAO ENCONTRADO");
        }
    }

    /**
     * Metodo para exibir uma Palestra, onde mostra os atributos para o usuario
     * com os valores que ele tem
     *
     * @param palestra
     */
    private static void exibir(Palestra palestra) {
        System.out.println("==================================");
        System.out.println("titulo: " + palestra.getTituloSubmissao());
        System.out.println("situacao: " + palestra.getSituacaoSubmissao().getNome());
        System.out.println("autor: " + palestra.getAutor().get(0));
        System.out.println("resumo: " + palestra.getResumo());
        System.out.println("Abstract: " + palestra.getAbstrac());
        System.out.println("duracao: " + palestra.getDuracao());
        System.out.println("curriculo: " + palestra.getCurriculo());
        System.out.println("==================================");
    }

    /**
     * Mostra os atributos para o usuario com os valores que ele tem, para que
     * ele possa editar!
     *
     * @param palestra
     * @return um inteiro com o indice do atributo
     */
    private static int editarpalestra(Palestra palestra) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("1-titulo: " + palestra.getTituloSubmissao());
        System.out.println("2-situacao: " + palestra.getSituacaoSubmissao().getNome());
        System.out.println("3-autor: " + palestra.getAutor().get(0));
        System.out.println("4-resumo: " + palestra.getResumo());
        System.out.println("5-Abstract: " + palestra.getAbstrac());
        System.out.println("6-duracao: " + palestra.getDuracao());
        System.out.println("7-curriculo: " + palestra.getCurriculo());
        System.out.println("==================================");
        return (entrada.nextInt());
    }

    /**
     * recebe uma entrada do usuario, com base no indice do atributo digitado
     * anteriormente, metodo que é usado para edição de palestras
     *
     * @param indice
     * @return String com o que o usuario digitou no console
     */
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
                System.out.println("Situacao da Palestra: Aprovado/Reprovado/Sob Avaliacao");
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
            System.out.println("3- consultar por autor");
            System.out.println("4- excluir");
            System.out.println("5- editar");
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
                    System.out.println("Qual titulo da palestra voce quer pesquisar: ");
                    String titulo = entrada.nextLine();
                    Palestra p = c.consultar(titulo);
                    if (p != null) {
                        exibir(p);
                    } else {
                        msg("NAO FOI ENCONTRADA NENHUMA PALESTRA");
                    }
                    break;
                case 3:
                    consultarAutor("Digite o titulo para ser consultado: ", c);
                    break;
                case 4:
                    System.out.println("Qual titulo da palestra voce quer excluir: ");
                    String t = entrada.nextLine();
                    if (c.excluir(t)) {
                        msg("PALESTRA EXCLUIDA");
                    } else {
                        msg("NAO FOI ENCONTRADA NENHUMA PALESTRA");
                    }
                    break;
                case 5:
                    System.out.println("Qual titulo da palestra voce quer pesquisar: ");
                    String ti = entrada.nextLine();
                    Palestra p1 = c.consultar(ti);
                    if (p1 != null) {
                        int atributo = editarpalestra(p1);
                        if (c.editar(atributo, pegarvalor(atributo), p1)) {
                            msg("EDITADO");
                        } else {
                            msg("FALHA AO EDITAR");
                        }
                    } else {
                        msg("NAO FOI ENCONTRADA NENHUMA PALESTRA");
                    }
                    break;
            }

        } while (opcao != 0);

    }

    public static void main(String[] args) {
        Executor e = new Executor();
        e.principal();
    }
}
