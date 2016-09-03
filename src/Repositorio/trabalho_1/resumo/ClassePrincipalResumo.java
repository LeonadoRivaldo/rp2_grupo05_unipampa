package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import Repositorio.trabalho_1.resumo.ControladorResumo;
import Repositorio.trabalho_1.resumo.ClassePrincipalResumo;
import Repositorio.trabalho_1.SubmissaoCientificia;
import Repositorio.trabalho_1.resumo.Resumo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassePrincipalResumo {

    private static ControladorResumo resumo = new ControladorResumo();

    public static void main(String[] args) {
        principal();
    }

    public static void criar() {

        String titulo = null;
        String situacao;
        String autor;
        String instituicao;
        String palavrachave;
        Situacao s = null;
        Scanner e = new Scanner(System.in);

        System.out.println("Titulo do resumo :");
        titulo = e.nextLine();
        System.out.println("Situação do resumo: Aprovado/Reprovado/sob avaliação: ");
        situacao = e.nextLine();
        if (Submissao.verificaSituacao(situacao) != null) {
            s = Submissao.verificaSituacao(situacao);
        }

        int o;
        ArrayList<String> autores = new ArrayList();
        do {
            System.out.println("Autores do resumo");
            autor = e.nextLine();
            System.out.println("Deseja adicionar mais um autor? (1-SIM 2-NÃO)");
            o = e.nextInt();
            autores.add(autor);
            e.nextLine();1
        } while (o != 2);

        int op;
        ArrayList<String> instituicoes = new ArrayList();

        do {
            System.out.println("Insttituições do resumo");
            instituicao = e.nextLine();
            System.out.println("Deseja adicionar mais uma ? (1- SIM , 2-NÃO)");
            op = e.nextInt();
            instituicoes.add(instituicao);
        } while (op != 2);

        int opcao;
        ArrayList<String> palavraschave = new ArrayList();
        do {
            System.out.println("Palavras-chaves do resumo: ");
            palavrachave = e.next();
            System.out.println("Deseja digitar outras palavras-chave?(1-SIM 2-NÃO)");
            opcao = e.nextInt();
            palavraschave.add(palavrachave);
        } while (opcao != 2);
        resumo.incluir(titulo, s, autor, instituicao, palavraschave);
    }

    public static void consulta(String titulo) {
        Scanner e = new Scanner(System.in);
        boolean naoAcho = true;
        for (Resumo resumo : resumo.getResumos()) {

            if (resumo.getTituloSubmissao().trim().equalsIgnoreCase(titulo)) {

                System.out.println("DADOS");
                System.out.println("Titulo: " + resumo.getTituloSubmissao());
                System.out.print("Autor: ");
                for (String autor : resumo.getAutor()) {
                    System.out.print(autor + " ");
                }

                System.out.print("Instituição:");
                for (String instituicao : resumo.getInstituicao()) {
                    System.out.print(instituicao + " ,");
                }
                System.out.println("Situação: " + resumo.getSituacaoSubmissao());
                System.out.print("palavra chave: ");
                for (String palavrachave : resumo.getPalavrasChave()) {
                    System.out.print(palavrachave + ", ");
                }
                naoAcho = false;
                break;
            }
        }

        if (naoAcho == true) {
            System.out.println("Nenhum resumo ");
        }
    }

    public static int pegarAtributo(Resumo resumo) {
        Scanner e = new Scanner(System.in);

        System.out.println("DADOS");
        System.out.println("1-Titulo: " + resumo.getTituloSubmissao());
        System.out.println("2-Autor: ");
        for (String autor : resumo.getAutor()) {
            System.out.println(autor + " ,");
        }
        System.out.println("3-Instituição: ");
        for (String instituicao : resumo.getInstituicao()) {
            System.out.println(instituicao + " ,");
        }
        System.out.println("4-Situação: " + resumo.getSituacaoSubmissao());
        System.out.print("5-palavra chave: ");
        for (String palavrachave : resumo.getPalavrasChave()) {
            System.out.print(palavrachave + ", ");
        }

        return e.nextInt();
    }

    public static void editarResumo(int atributo, Resumo resumo) {

        String titulo = null;
        int situacao;
        String autor;
        String instituicao;
        String palavrachave;
        Scanner e = new Scanner(System.in);
        switch (atributo) {
            case 1:
                System.out.println("Titulo do resumo :");
                titulo = e.nextLine();
                break;
            case 2:
                System.out.println("Situação do resumo: 1-Aprovado/2-Reprovado/3-sob avaliação: ");
                situacao = e.nextInt();
                e.nextLine();
                break;
            case 3:
                int o;
                ArrayList<String> autores = new ArrayList();

                do {
                    System.out.println("Autores do resumo");
                    autor = e.nextLine();
                    System.out.println("Deseja adicionar mais um autor? (1-SIM 2-NÃO)");
                    o = e.nextInt();
                    autores.add(autor);

                } while (o != 2);

                break;
            case 4:

                int op;
                ArrayList<String> instituicoes = new ArrayList();

                do {
                    System.out.println("Insttituições do resumo");
                    instituicao = e.nextLine();
                    System.out.println("Deseja adicionar mais uma ? (1- SIM , 2-NÃO)");
                    op = e.nextInt();
                    instituicoes.add(instituicao);
                } while (op != 2);
                break;
            case 5:
                System.out.println("Voce quer adicionar ou refazer a lista de palavras chaves?");
                if (e.nextLine().equalsIgnoreCase("adicionar")) {
                    resumo.addPalavraChave(e.nextLine());
                } else {
                    int opcao;
                    ArrayList<String> palavraschave = new ArrayList();
                    do {
                        System.out.println("Palavras-chaves do resumo: ");
                        palavrachave = e.next();
                        System.out.println("Deseja digitar outras palavras-chave?(1-SIM 2-NÃO)");
                        opcao = e.nextInt();
                        palavraschave.add(palavrachave);
                    } while (opcao != 2);
                    resumo.setPalavrasChave(palavraschave);
                }
                break;
        }

    }

    public static void principal() {

        String titulo = null;
        int situacao;
        String autor;
        String instituicao;
        String palavrachave;
        Scanner e = new Scanner(System.in);

        int n = 0;
        do {
            System.out.println("===============================================");
            System.out.println("Índice  de resumos");
            System.out.println("===============================================");
            System.out.println("1)Cadastrar resumo:");
            System.out.println("2)Pesquisar resumo");
            System.out.println("3)deletar resumo");
            System.out.println("4)editar resumo");
            System.out.println("0)sair do programa");
            n = e.nextInt();
            e.nextLine();
            switch (n) {
                case 1:
                    criar();
                    break;
                case 2:
                    System.out.println("Titulo do resumo que deseja pesquisar: ");
                    ControladorResumo.consulta(e.nextLine());
                    break;
                case 3:
                    System.out.println("Digite o titulo do resumo  a ser deletado:");
                    titulo = e.nextLine();
                    if (resumo.excluir(titulo)) {
                        System.out.println("Excluido com sucesso!");
                    } else {
                        System.out.println("Resumo não encontrado");
                    }
                    break;
                case 4:

                case 0:
                    break;
            }
        } while (n != 0);
    }
}
