/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Amanda Gobus
 */
public class ExecutarArtigos {

    private ControleDeArtigos controller = new ControleDeArtigos();

    /**
     * função para exibir mensagens no sistema
     *
     * @param s mensagem que vai ser exibida para o usuário
     */
    public static void msg(String s) {
        System.out.println(
                "\n=============================================================\n"
                + s
                + "\n===========================================================\n"
        );
    }

    /**
     * Pesquisa pelo nome do autor 
     * O método que lista as submissões pelo nome do autor
     *
     * @param controller
     * @param submissoes
     * @return
     */
    private static Artigo listaPorAutor(ControleDeArtigos controller, List<Submissao> submissoes) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=================================================================");
        for (Submissao artigo : submissoes) {
            System.out.println(artigo.getTituloSubmissao());
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Digite o titulo do artigo a ser exibido: ");
        return controller.consultar(entrada.nextLine());
    }

    /**
     * Método que pega o valor do atributo a ser editado pelo usuário
     * @param atributo
     * @return 
     */
    public static String PegarValor(int atributo) {
        switch (atributo) {
            case 1:
                return PreencheArtigo.preencheTitulo();
            case 2:
                List<String> autor = PreencheArtigo.preencheAutor();
                String frase = "";
                for (String s : autor) {
                    frase += s + "-";

                }
                return frase;
            case 3:
                List<String> inst = PreencheArtigo.preencheInstituicao();
                String instituicoes = "";
                for (String i : inst) {
                    instituicoes += i + "-";

                }
                return instituicoes;

            case 4:
                List<String> palavra = PreencheArtigo.preenchePalavrachave();
                String p = "";
                for (String i : palavra) {
                    p += i + "-";

                }
                return p;
            case 5:
                return PreencheArtigo.preencheResumo();
            case 6:
                return PreencheArtigo.preencheAbstract();

            case 7:
                return PreencheArtigo.preencheSituacao();
        }
        return null;
    }

    /**
     * Método que passa por parâmetro um objeto artigo para a exibir o mesmo 
     * @param artigo 
     */
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
        System.out.println("Situação: " + artigo.getSituacaoSubmissao().getNome());
        System.out.println("");
        System.out.println("====================================");
    }
    /**
     * Método que passa um objeto artigo por parâmetro e pergunta qual atributo ele vai editar
     * @param artigo
     * @return 
     */

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
        System.out.println("7 - Situação: " + artigo.getSituacaoSubmissao().getNome());
        System.out.println("");
        System.out.println("====================================");
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();

    }

    /**
     * Método que recebe o controle e a partir do que  o usuário digitar ele faz uma pesquisa
     * @param controle
     * @param frase
     * @return 
     */
    public static Artigo consultarArtigo(ControleDeArtigos controle, String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(frase);
        return controle.consultar(entrada.nextLine());

    }

    /**
     * cria um artigo usando a classe que tem métodos para preencher o objeto
     *
     * @return um objeto do tipo artigo
     */
    public static Artigo criaArtigo() {
        //Artigo artigo = new Artigo();
        String tituloSubmissao = PreencheArtigo.preencheTitulo();
        List<String> autores = PreencheArtigo.preencheAutor();
        List<String> instituicoes = PreencheArtigo.preencheInstituicao();
        String resumo = PreencheArtigo.preencheResumo();
        String Abstract = PreencheArtigo.preencheAbstract();
        List<String> palavrasChave = PreencheArtigo.preenchePalavrachave();
        Situacao situacao = null;
        do {
            situacao = Submissao.verificaSituacao(PreencheArtigo.preencheSituacao());
        } while (situacao == null);
        Artigo artigo = new Artigo(resumo, Abstract, tituloSubmissao, situacao, autores, 8, instituicoes, palavrasChave, 4, 8);

        return artigo;

    }

    public void principal() {
        Scanner entrada = new Scanner(System.in);
        List<String> autores = new ArrayList();
        List<String> instituicoes = new ArrayList();
        List<String> palavrachave = new ArrayList();
        Artigo artigo;
        List<Submissao> submissoes;

        autores.add("Homem de ferro");
        autores.add("Popeye");
        autores.add("A Pantera Cor-de-Rosa");
        autores.add("Os Flinstones");
        autores.add("Zé Colmeia");
        instituicoes.add("Fenda Do Biquini");
        instituicoes.add("Disney");
        instituicoes.add("Pixar");
        palavrachave.add("Animações");
        palavrachave.add("Pokemon");
        controller.incluir(new Artigo("Mickey Mouse", "Minnie Mouse", "amanda", Situacao.aprovado, autores, 8, instituicoes, palavrachave, 4, 8));

        int opcao;
        do {
            System.out.println("                             ");
            System.out.println("Selecione uma opção : ");
            System.out.println("0 - Sair");
            System.out.println("1 - Incluir");
            System.out.println("2 - Consultar");
            System.out.println("3 - Consultar por Autor");
            System.out.println("4 - Excluir");
            System.out.println("5 - Editar");

            System.out.print("Opção :");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    controller.incluir(criaArtigo());

                    break;
                case 2:
                    artigo = consultarArtigo(controller, "Digite o titulo que você quer consultar:");
                    do {
                        if (artigo != null) {
                            exibir(artigo);
                        } else {
                            msg("O ARTIGO NÃO FOI ENCONTRADO");
                            System.out.println("Deseja pesquisar novamente?");

                            if (!entrada.nextLine().equalsIgnoreCase("Sim")) {
                                break;
                            }
                        }
                    } while (artigo == null);
                    break;
                case 3:
                    entrada.nextLine();
                    artigo = null;
                    do {
                        System.out.println("=================================================");
                        System.out.println("Digite o nome do autor que você deseja pesquisar:");
                        submissoes = controller.consultarAutor(entrada.nextLine());
                        if (submissoes != null) {
                            artigo = listaPorAutor(controller, submissoes);

                            if (artigo != null) {
                                exibir(artigo);
                            } else {
                                msg("O ARTIGO NÃO FOI ENCONTRADO");
                                if (!entrada.nextLine().equalsIgnoreCase("Sim")) {
                                    break;
                                }
                            }
                        }
                    } while (artigo == null);
                    break;
                case 4:
                    entrada.nextLine();
                    boolean excluido = false;
                    do {
                        System.out.println("================================================");
                        System.out.println("Qual é o titulo do artigo que você quer excluir: ");
                        excluido = controller.excluir(entrada.nextLine());
                        if (excluido) {
                            msg("Artigo excluido com sucesso");
                        } else {
                            msg("O ARTIGO NÃO FOI ENCONTRADO");
                            System.out.print("Pesquisar novamente?");
                            if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                excluido = true;
                            }
                        }
                    } while (!excluido);

                    break;
                case 5:
                    artigo = consultarArtigo(controller, "Qual artigo você quer editar:");
                    int fim = 0;
                    boolean editado = false;
                    do {
                        if (artigo != null) {
                            do {
                                int atributo = editar(artigo);
                                editado = controller.editar(atributo, PegarValor(atributo), artigo);
                                if (editado) {
                                    msg("ARTIGO EDITADO COM SUCESSO");
                                }
                                System.out.println("==============================================");
                                System.out.println("Deseja editar outro atributo? 1- sim | 2- não ");
                                fim = entrada.nextInt();
                            } while (fim != 2);
                        } else {
                            msg("ARTIGO NÃO ENCONTRADO");
                            if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                break;
                            }
                        }
                    } while (!editado);
                    break;
                default:
                    msg("Opção inválida");

                    break;

            }
        } while (opcao != 0);

    }

    public static void main(String[] args) {
        ExecutarArtigos e = new ExecutarArtigos();
        e.principal();
    }
}
