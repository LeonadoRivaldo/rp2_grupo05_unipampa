package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import Repositorio.trabalho_1.resumo.ControladorResumo;
import Repositorio.trabalho_1.resumo.ClassePrincipalResumo;
import Repositorio.trabalho_1.SubmissaoCientifica;
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

        do {
            System.out.println("Situação do resumo (Aprovado/Reprovado/sob avaliacao): ");
            s = Submissao.verificaSituacao(e.nextLine());
        } while (s == null);

        int o;
        ArrayList<String> autores = new ArrayList();
        do {
            System.out.println("Autores do resumo");
            autor = e.nextLine();
            System.out.println("Deseja adicionar mais um autor? (1-SIM 2-NÃO)");
            o = e.nextInt();
            autores.add(autor);
            e.nextLine();
        } while (o != 2);

        int op;
        ArrayList<String> instituicoes = new ArrayList();

        do {
            System.out.println("Insttituições do resumo");
            instituicao = e.nextLine();
            System.out.println("Deseja adicionar mais uma ? (1- SIM , 2-NÃO)");
            op = e.nextInt();
            instituicoes.add(instituicao);
            e.nextLine();
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
        resumo.incluir(titulo, s, autores, instituicoes, palavraschave);
    }

    /**
     * Consulta pelo titulo
     *
     * @param titulo
     */
    public static void consulta(String titulo) {
        Scanner e = new Scanner(System.in);
        boolean naoAcho = true;
        for (Resumo resumo : resumo.getResumos()) {

            if (resumo.getTituloSubmissao().trim().equalsIgnoreCase(titulo)) {

                System.out.println("DADOS");
                System.out.println("Titulo: " + resumo.getTituloSubmissao());
                System.out.print("Autor: ");
                for (String autor : resumo.getAutor()) {
                    System.out.print(autor + ", ");
                }
                System.out.println("");
                System.out.print("Instituição:");
                for (String instituicao : resumo.getInstituicao()) {
                    System.out.print(instituicao + ", ");
                }
                System.out.println("");
                System.out.println("Situação: " + resumo.getSituacaoSubmissao());
                System.out.print("palavra chave: ");
                for (String palavrachave : resumo.getPalavrasChave()) {
                    System.out.print(palavrachave + ", ");
                }
                System.out.println("");
                naoAcho = false;
                break;
            }
        }
        if (naoAcho) {
            System.out.println("===============================================\nNenhum Resumo encontrado\n===============================================");
        }
    }

    /**
     *
     * @param autor
     */
    public static void consultaAutores(String autor) {
        Scanner e = new Scanner(System.in);
        boolean naoAcho = true;

        for (Resumo resumo : resumo.getResumos()) {
            List<String> listaAutores = resumo.getAutor();
            for (String aut : listaAutores) {
                if (aut.equalsIgnoreCase(autor)) {
                    System.out.println("DADOS");
                    System.out.println("Titulo: " + resumo.getTituloSubmissao());
                    System.out.println("Situação: " + resumo.getSituacaoSubmissao().getNome());
                    System.out.print("Autor: ");
                    for (String autor1 : resumo.getAutor()) {
                        System.out.print(autor1 + " ");
                    }
                    System.out.println("");
                    System.out.print("Instituição:");
                    for (String instituicao : resumo.getInstituicao()) {
                        System.out.print(instituicao + " ,");
                    }
                    System.out.println("");
                    System.out.print("palavra chave: ");
                    for (String palavrachave : resumo.getPalavrasChave()) {
                        System.out.print(palavrachave + ", ");
                    }

                }
                System.out.println("");
                naoAcho = false;
                break;
            }
        }
        if (naoAcho == true) {
            System.out.println("Nenhum resumo ");
        }
    }

    /**
     * pega um atributo do resumo
     *
     * @param resumo
     * @return
     */
    public static int pegarAtributo(Resumo resumo) {
        Scanner e = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("DADOS");
        System.out.println("1-Titulo: " + resumo.getTituloSubmissao());
        System.out.print("2-Autor: ");
        for (String autor : resumo.getAutor()) {
            System.out.print(autor + " ,");
        }
        System.out.println("");
        System.out.print("3-Instituição: ");
        for (String instituicao : resumo.getInstituicao()) {
            System.out.print(instituicao + " ,");
        }
        System.out.println("");
        System.out.println("4-Situação: " + resumo.getSituacaoSubmissao().getNome());
        System.out.print("5-palavra chave: ");
        for (String palavrachave : resumo.getPalavrasChave()) {
            System.out.print(palavrachave + ", ");
        }
        System.out.println("");
        System.out.println("Opcao: ");
        return e.nextInt();
    }

    /**
     * Funçao que edita o resumo!
     */
    public static void editarResumo() {
        Scanner e = new Scanner(System.in);
        System.out.println("Qual titulo vc quer editar ?");
        String titulo = e.nextLine();
        Resumo r = null;
        for (Resumo resumo : resumo.getResumos()) {
            if (resumo.getTituloSubmissao().trim().equalsIgnoreCase(titulo)) {
                r = resumo;
            }
        }

        int atributo = pegarAtributo(r);
        String situacao;
        String autor;
        String instituicao;
        String palavrachave;

        switch (atributo) {
            case 1:
                System.out.println("Titulo do resumo :");
                r.setTituloSubmissao(e.nextLine());
                break;
            case 2:
                int o;
                System.out.println("Voce quer adicionar ou refazer a lista de autores ?");

                if (e.nextLine().equalsIgnoreCase("adicionar")) {;
                    r.addAutor(e.nextLine());
                } else {
                    ArrayList<String> autores = new ArrayList();
                    do {
                        System.out.println("Autores do resumo");
                        autores.add(e.nextLine());
                        System.out.println("Deseja adicionar mais um autor? (1-SIM 2-NÃO)");
                        o = e.nextInt();
                    } while (o != 2);
                    r.setAutor(autores);
                }

                break;
            case 3:
                System.out.println("Voce quer adicionar ou refazer a lista de instituicoes?");
                if (e.nextLine().equalsIgnoreCase("adicionar")) {
                    r.addInstituicao(e.nextLine());
                } else {
                    int op;
                    ArrayList<String> instituicoes = new ArrayList();

                    do {
                        System.out.println("Insttituições do resumo");
                        instituicoes.add(e.nextLine());
                        System.out.println("Deseja adicionar mais uma ? (1- SIM , 2-NÃO)");
                        op = e.nextInt();
                    } while (op != 2);
                    r.setInstituicao(instituicoes);
                }
                break;
            case 4:
                Situacao s = null;
                do {
                    System.out.println("Situação do resumo (Aprovado/Reprovado/sob avaliacao): ");
                    situacao = e.nextLine();
                    s = Submissao.verificaSituacao(situacao);
                    r.setSituacaoSubmissao(s);
                } while (s == null);
                break;
            case 5:
                System.out.println("Voce quer adicionar ou refazer a lista de palavras chaves?");
                if (e.nextLine().equalsIgnoreCase("adicionar")) {
                    r.addPalavraChave(e.nextLine());
                } else {
                    int opcao;
                    ArrayList<String> palavraschave = new ArrayList();
                    do {
                        System.out.println("Palavras-chaves do resumo: ");
                        palavrachave = e.next();
                        System.out.println("Deseja digitar outras palavras-chave?(1-SIM 2-NÃO)");
                        opcao = e.nextInt();
                        palavraschave.add(e.nextLine());
                    } while (opcao != 2);
                    r.setPalavrasChave(palavraschave);
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
            System.out.println("1)Cadastrar resumo");
            System.out.println("2)Pesquisar resumo");
            System.out.println("3)pesquisar resumo por autor");
            System.out.println("4)deletar resumo");
            System.out.println("5)editar resumo");
            System.out.println("0)sair do programa");
            System.out.print("Opção: ");
            n = e.nextInt();
            e.nextLine();
            switch (n) {
                case 1:
                    criar();
                    break;
                case 2:
                    System.out.println("Titulo do resumo que deseja pesquisar: ");
                    consulta(e.nextLine());
                    break;
                case 3:
                    System.out.println("Digite o nome do autor");
                    consultaAutores(e.nextLine());

                    break;
                case 4:
                    System.out.println("Digite o titulo do resumo  a ser deletado:");
                    titulo = e.nextLine();
                    if (resumo.excluir(titulo)) {
                        System.out.println("Excluido com sucesso!");
                    } else {
                        System.out.println("Resumo não encontrado");
                    }
                    break;
                case 5:
                    editarResumo();
                case 0:
                    break;
            }
        } while (n != 0);
    }
}
