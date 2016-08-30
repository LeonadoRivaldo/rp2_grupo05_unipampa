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
public class ExecutarArtigos {

    ControleDeArtigos x = new ControleDeArtigos();

    public static String PegarValor(int atributo) {
        switch (atributo) {
            case 1:
                return PreencheArtigo.preencheTitulo();
            case 2:
                String[] autor = PreencheArtigo.preencheAutor();
                String frase = "";
                for (String s : autor) {
                    frase += s + " ";

                }
                return frase;
            case 3:
                String[] inst = PreencheArtigo.preencheInstituicao();
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
                String[] palavra = PreencheArtigo.preenchePalavrachave();
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
        System.out.println("Titulo: " + artigo.getTitulo());
        System.out.print("Autor: ");
        String[] autores = artigo.getAutor();
        for (String autor : autores) {
            System.out.print(autor + ",");
        }
        System.out.println("");
        System.out.print("Instituição:");
        String[] inst = artigo.getInstituicao();
        for (String instituicao : inst) {
            System.out.print(instituicao + ",");

        }
        System.out.println("");
        System.out.print("Palavras-chave:");
        String[] palavra = artigo.getPalavrachave();
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
        System.out.println("1 - Titulo: " + artigo.getTitulo());
        System.out.print("2 - Autor: ");
        String[] autores = artigo.getAutor();
        for (String autor : autores) {
            System.out.print(autor + ",");
        }
        System.out.println("");

        System.out.print("3 - Instituição:");
        String[] inst = artigo.getInstituicao();
        for (String instituicao : inst) {
            System.out.print(instituicao + ",");

        }
        System.out.println("");
        System.out.print("4 - Palavras-chave:");
        String[] palavra = artigo.getPalavrachave();
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
            System.out.println((i + 1) + "  " + x.artigos.get(i).getTitulo());
        }

        System.out.print("Selecione o artigo : ");
        return (entrada.nextInt() - 1);

    }

    public static Artigo criaArtigo() {
        Artigo artigo = new Artigo();
        artigo.setTitulo(PreencheArtigo.preencheTitulo());
        artigo.setAutor(PreencheArtigo.preencheAutor());
        artigo.setInstituicao(PreencheArtigo.preencheInstituicao());
        artigo.setResumo(PreencheArtigo.preencheResumo());
        artigo.setAbstract(PreencheArtigo.preencheAbstract());
        artigo.setPalavrachave(PreencheArtigo.preenchePalavrachave());
        return artigo;

    }

    public void menu() {
        Scanner entrada = new Scanner(System.in);

        String[] autores = {"autor1", "autor2"};
        String[] instituicoes = {"Unipampa"};
        String[] palavrachave = {"ENGENHARIA DE SOFTWARE", "SEMESTRE2"};
        x.incluir(new Artigo("Algoritmos", autores, instituicoes, palavrachave, "DO-WHILE", "CLASSES E OBJETOS"));
        x.incluir(new Artigo("TEORIA DOS GRAFOS", autores, instituicoes, palavrachave, "HIPOTESE", "INDUCAO"));
        x.incluir(new Artigo("TIPOS DE DADOS ABSTRATOS", autores, instituicoes, palavrachave, "FILAS E PILHAS", "ESTRUTURAS DE DADOS"));
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
                    x.incluir(criaArtigo());

                    break;
                case 2:
                    exibir(x.consultar(consultarArtigo(x)));

                    break;
                case 3:
                    x.excluir(consultarArtigo(x));
                    break;
                case 4:
                    int index = consultarArtigo(x);
                    Artigo a = x.consultar(index);
                    int atributo = editar(a);
                    x.editar(atributo, PegarValor(atributo), a);

                    break;

            }
        } while (opcao != 0);

    }

    /*public static void main(String[] args) {
     menu();
     }*/
}
