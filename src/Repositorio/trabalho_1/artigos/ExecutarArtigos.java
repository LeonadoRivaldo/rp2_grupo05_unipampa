/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;

import Repositorio.trabalho_1.Situacao;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Amanda Gobus
 */
public class ExecutarArtigos {

    private ControleDeArtigos controller = new ControleDeArtigos();

    public static String PegarValor(int atributo) {
        switch (atributo) {
            case 1:
                return PreencheArtigo.preencheTitulo();
            case 2:
                List<String> autor = PreencheArtigo.preencheAutor();
                String frase = "";
                for (String s : autor) {
                    frase += s + " ";

                }
                return frase;
            case 3:
                List<String> inst = PreencheArtigo.preencheInstituicao();
                String instituicoes = "";
                for (String i : inst) {
                    instituicoes += i + " ";

                }
                return instituicoes;

            case 4:
                return PreencheArtigo.preencheResumo();
            case 5:
                return PreencheArtigo.preencheAbstract();
            case 6:
                List<String> palavra = PreencheArtigo.preenchePalavrachave();
                String p = "";
                for (String i : palavra) {
                    p += i + " ";

                }
                return p;

        }
        return null;
    }

    public static void exibir(Artigo artigo) {
        System.out.println("====================================");
        System.out.println("");
        System.out.println("Titulo: " + artigo.getTituloSubmissao());
        System.out.print("Autor: ");
        List<String> autores = artigo.getAutor();
        for (String autor : autores) {
            System.out.print(autor + ",");
        }
        System.out.println("");
        System.out.print("Instituição:");
        List<String> inst = artigo.getInstituicao();
        for (String instituicao : inst) {
            System.out.print(instituicao + ",");

        }
        System.out.println("");
        System.out.print("Palavras-chave:");
        List<String> palavra = artigo.getPalavrasChave();
        for (String palavrachave : palavra) {
            System.out.print(palavrachave + ",");

        }
        System.out.println("");
        System.out.println("Resumo:" + artigo.getResumo());
        System.out.println("Abstract: " + artigo.getAbstract());
        System.out.println("");
        System.out.println("====================================");
    }

    public static int editar(Artigo artigo) {
        System.out.println("====================================");
        System.out.println("Digite o número do que você quer editar :");
        System.out.println("1 - Titulo: " + artigo.getTituloSubmissao());
        System.out.print("2 - Autor: ");
        List<String> autores = artigo.getAutor();
        for (String autor : autores) {
            System.out.print(autor + ",");
        }
        System.out.println("");

        System.out.print("3 - Instituição:");
        List<String> inst = artigo.getInstituicao();
        for (String instituicao : inst) {
            System.out.print(instituicao + ",");

        }
        System.out.println("");
        System.out.print("4 - Palavras-chave:");
        List<String> palavra = artigo.getPalavrasChave();
        for (String palavrachave : palavra) {
            System.out.print(palavrachave + ",");

        }
        System.out.println("");
        System.out.println("5 - Resumo:" + artigo.getResumo());
        System.out.println("6 - Abstract: " + artigo.getAbstract());
        System.out.println("");
        System.out.println("====================================");
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();

    }

    public static int consultarArtigo(ControleDeArtigos x) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("====================================");

        for (int i = 0; i < x.artigos.size(); i++) {
            System.out.println((i + 1) + "  " + x.artigos.get(i).getTituloSubmissao());
        }

        System.out.print("Selecione o artigo : ");
        return (entrada.nextInt() - 1);

    }

    public static Artigo criaArtigo() {
        //Artigo artigo = new Artigo();
        String tituloSubmissao = PreencheArtigo.preencheTitulo();
        List<String> autores = PreencheArtigo.preencheAutor();
        List<String> instituicoes = PreencheArtigo.preencheInstituicao();
        String resumo = PreencheArtigo.preencheResumo();
        String Abstract = PreencheArtigo.preencheAbstract();
        List<String> palavrasChave = PreencheArtigo.preenchePalavrachave();
        Artigo artigo = new Artigo(resumo, Abstract, tituloSubmissao, Situacao.sobAvaliacao, autores, 8, instituicoes, palavrasChave, 4, 8);
        return artigo;

    }

    public void menu() {
        Scanner entrada = new Scanner(System.in);

        String[] autores = {"autor1", "autor2"};
        String[] instituicoes = {"Unipampa"};
        String[] palavrachave = {"ENGENHARIA DE SOFTWARE", "SEMESTRE2"};
        int opcao;
        do {
            System.out.println("                             ");
            System.out.println("Selecione uma opção : ");
            System.out.println("0 - Sair");
            System.out.println("1 - Incluir");
            System.out.println("2 - Exibir");
            System.out.println("3 - Excluir");
            System.out.println("4 - Editar");

            System.out.print("Opção :");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    controller.incluir(criaArtigo());

                    break;
                case 2:
                    exibir(controller.consultar(consultarArtigo(controller)));

                    break;
                case 3:
                    controller.excluir(consultarArtigo(controller));
                    break;
                case 4:
                    int index = consultarArtigo(controller);
                    Artigo a = controller.consultar(index);
                    int atributo = editar(a);
                    controller.editar(atributo, PegarValor(atributo), a);

                    break;

            }
        } while (opcao != 0);

    }

    public static void main(String[] args) {
     ExecutarArtigos e = new ExecutarArtigos();
        e.menu();
     }
}
