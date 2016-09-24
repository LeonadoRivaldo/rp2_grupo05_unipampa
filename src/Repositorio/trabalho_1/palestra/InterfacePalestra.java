/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.palestra;

import Repositorio.trabalho_1.InterfaceSistema;
import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.PreencheSubmissao;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luh-l
 */
public class InterfacePalestra extends InterfaceSistema {
    private ListaSubmissao palestras = new ListaSubmissao();
    @Override
    public void principal() {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> autores = new ArrayList();
        autores.add("Colega Amanda");
        palestras.incluir(new Palestra("CC", "doce", "jdhk", 35, "Palestra2", Situacao.sobAvaliacao, autores, 1));
        palestras.incluir(new Palestra("ES", "comida", "gfgjjk", 50, "Palestra1", Situacao.sobAvaliacao, autores, 1));

        int opcao = 0;
        do {
            opcao = this.menu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    this.criarSubmissao();
                    exibeMensagem("PALETRA INCLUIDA");
                    break;
                case 2:
                    System.out.println("Qual titulo da palestra voce quer pesquisar: ");
                    String titulo = entrada.nextLine();
                    Palestra p = (Palestra) palestras.consultarTitulo(titulo);
                    if (p != null) {
                        exibirSubmissao(p);
                    } else {
                        exibeMensagem("NAO FOI ENCONTRADA NENHUMA PALESTRA");
                    }
                    break;
                case 3:
                    List<Submissao> submissoesAutor = consultarListaSubmissoesAutor(palestras);
                    if (submissoesAutor != null) {
                        Palestra p1 = (Palestra) this.listaPorAutor(submissoesAutor, palestras, "palestra");
                        if (p1 != null) {
                            this.exibirSubmissao(p1);
                        }

                    }
                    break;
                case 4:
                    
                    System.out.println("Qual titulo da palestra voce quer excluir: ");
                    String t = entrada.nextLine();
                    if (palestras.excluir(t)) {
                        exibeMensagem("PALESTRA EXCLUIDA");
                    } else {
                        exibeMensagem("NAO FOI ENCONTRADA NENHUMA PALESTRA");
                    }
                    break;
                case 5:
                    editarSubmissao();
                    break;
            }

        } while (opcao != 0);

    }
    @Override
    protected int menu() {
        System.out.println("################################");
        System.out.println("Gerenciamento de palestras");
        System.out.println("1- incluir");
        System.out.println("2- consultar");
        System.out.println("3- consultar por autor");
        System.out.println("4- excluir");
        System.out.println("5- editar");
        System.out.println("0- sair");
        System.out.println("Opcao: ");
        return entrada.nextInt();
    }
    @Override
    protected int escolherAtributo(Submissao submissao) {
        Palestra palestra = (Palestra) submissao;
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
    @Override
    protected void criarSubmissao() {
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
        this.palestras.incluir(palestra);
    }
    @Override
    protected void editarSubmissao() {
        System.out.println("Qual titulo da palestra voce quer pesquisar: ");
        entrada.nextLine();
        String ti = entrada.nextLine();
        Palestra palestra = (Palestra) palestras.consultarTitulo(ti);
        if (palestra != null) {
            int atributo = this.escolherAtributo(palestra);
            Scanner entrada = new Scanner(System.in);
            /* String titulo,
             String situacao,
             String autor, 
             String resumo,
             String Abstract,
             int duracao,
             String curriculo*/

            String oldTitulo = palestra.getTituloSubmissao();
            switch (atributo) {
                case 1:
                    palestra.setTituloSubmissao(PreencheSubmissao.preencheTitulo());
                    break;
                case 2:
                    Situacao situacao = null;
                    situacao = Submissao.verificaSituacao(PreencheSubmissao.preencheSituacao());
                    while (situacao == null) {
                        System.out.println("Situacao da Palestra: Aprovado/Reprovado/SobA valiacao");
                        situacao = Submissao.verificaSituacao(entrada.nextLine());
                    }
                    palestra.setSituacaoSubmissao(situacao);
                    break;
                case 3:
                    List<String> autor = PreencheSubmissao.preencheAutor(1);
                    palestra.setAutor(autor);
                    break;
                case 4:
                    palestra.setResumo(PreencheSubmissao.preencheResumo());
                    break;
                case 5:
                    palestra.setAbstrac(PreencheSubmissao.preencheAbstract());
                    break;
                case 6:
                    System.out.println("Digite a duração da palestra: ");
                    palestra.setDuracao(entrada.nextInt());
                    break;
                case 7:
                    System.out.println("Digite o seu curriculo: ");
                    palestra.setCurriculo(entrada.nextLine());
                    break;

            }
            this.palestras.editar(oldTitulo, palestra);
        } else {
            this.exibeMensagem("NAO FOI ENCONTRADA NENHUMA PALESTRA");
        }
    }
    public static void main(String[] args) {
        InterfacePalestra i = new InterfacePalestra();
        i.principal();
    }

}
